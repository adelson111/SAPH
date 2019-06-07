import json
from gc import get_objects

from django.contrib.messages.views import SuccessMessageMixin
from django.http import HttpResponse
from django.shortcuts import render, get_object_or_404

# Create your views here.
from django.urls import reverse_lazy, reverse
from django.views import View
from django.views.generic import CreateView, ListView, UpdateView, DeleteView, DetailView

from apps.nivel.models import Nivel

from apps.nivel.forms import NivelEdit, NivelCreate
from apps.organizacao.models import Organizacao
from apps.setor.models import Setor


class CadastrarNivel(SuccessMessageMixin, CreateView):
    model = Nivel
    # fields = ['nome','nivelSuperior', 'nivelInferior', 'funcionario', 'organizacao']
    form_class = NivelCreate
    success_message = "%(nome)s Cadastrado com sucesso"

    def get_form_kwargs(self):
        kwargs = super(CadastrarNivel, self).get_form_kwargs()
        kwargs.update({'organizacao': self.kwargs['pk_organizacao']})
        return kwargs

    def form_valid(self, form):
        nivel = form.save()
        if(nivel.nivelSuperior and nivel.nivelSuperior.pk!=None):
        # if(nivel.nivelSuperior.pk!=None):
            nivelSuperior = get_object_or_404(Nivel, pk=nivel.nivelSuperior.pk)
            nivelSuperior.nivelInferior = nivel
            nivelSuperior.save()
        if(nivel.nivelInferior and nivel.nivelInferior.pk!=None):
        # if(nivel.nivelInferior.pk!=None):
            nivelInferior = get_object_or_404(Nivel, pk=nivel.nivelInferior.pk)
            nivelInferior.nivelSuperior = nivel
            nivelInferior.save()
        form.save()
        return super(CadastrarNivel, self).form_valid(form)


    def get_success_message(self, cleaned_data):
        # return messages.add_message(self.request, messages.SUCCESS, self.message_data)
        return self.success_message % dict(
            cleaned_data,
            nome=self.object.nome
        )

    def get_success_url(self):
        return reverse('cadastrar_nivel', args=[self.request.user.funcionario.organizacao.pk])


class ListarNivel(ListView):
    model = Nivel

    def get_queryset(self):
        return Nivel.objects.filter(organizacao=self.request.user.funcionario.organizacao)

class Organograma(View):
    model = Nivel

    def get(self, request):
        nivelall = Nivel.objects.filter(organizacao=self.request.user.funcionario.organizacao)
        data = {}
        lista = []
        superior = ''
        for nivel in nivelall:
            if(nivel.nivelSuperior == None):
                superior = nivel
            lista.append(nivel)
        inferior = False
        i = 0
        listaSaida = {}
        # listaSaida1 = {}
        pos = 0
        tam = len(lista)
        o = 0
        if(tam>0):
            while (inferior == False):

                if(i == len(lista)):
                    i = 0
                    pos+=1

                if (superior.nivelSuperior==None):
                    s = Setor.objects.filter(nivel_id=superior.pk)
                    listaSaida[pos] = []
                    listaSaida[pos].append(superior)
                    listaSaida[pos].append(s)
                    superior = superior.nivelInferior
                    i = 0
                    pos += 1
                o += 1
                #print(listaSaida)
                #print(lista[i])
                if (superior.nivelInferior == lista[i] and listaSaida.get(0)[0].nivelSuperior == None):
                    # listaSaida.append(superior)
                    s = Setor.objects.filter(nivel_id=superior.pk)
                    listaSaida[pos] = []
                    listaSaida[pos].append(superior)
                    listaSaida[pos].append(s)
                    superior = superior.nivelInferior
                    i = 0
                    pos += 1
                if (superior.nivelInferior == None):
                    # listaSaida.insert(len(lista), superior)
                    s = Setor.objects.filter(nivel_id=superior.pk)
                    tam1 = len(lista)
                    listaSaida[tam1] = []
                    listaSaida[tam1].append(superior)
                    listaSaida[tam1].append(s)
                    inferior = True
                    pos += 1
                i+=1

            a = 1
            return render(request, 'nivel/nivel_organograma.html', {'listaSaida':listaSaida})
        else:
            return render(request, 'nivel/nivel_organograma.html', {'listaSaida': listaSaida})
    # template_name_suffix = '_organograma'

class AtualizarNivel(UpdateView):
    model = Nivel
    form_class = NivelEdit
    success_message = "%(nome)s Atualizado com sucesso"

    def get_queryset(self):
        return Nivel.objects.filter(pk=self.kwargs['pk'])

    def get_success_message(self, cleaned_data):
        # return messages.add_message(self.request, messages.SUCCESS, self.message_data)
        return self.success_message % dict(
            cleaned_data,
            nome=self.object.nome
        )

    template_name_suffix = '_update_form'

class DeletaNivel(DeleteView):
    model =Nivel
    success_url = reverse_lazy('listar_nivel')

class PesquisaNivel(View):
    def post(self, *args, **kwargs):
        # Nivel.objects.filter(pk=kwargs['pk'])
        nivel = get_object_or_404(Nivel, pk=kwargs['pk'])
        # nivelS = 'FUDEUSUPERIOR'


        if(nivel.nivelSuperior != None):
            nivelS = nivel.nivelSuperior.pk
        if(nivel.nivelSuperior == None):
            nivelS = ""

        # nivelI = 'FUDEUINFERIOR'
        # nivelI = nivel.nivelInferior.pk
        if (nivel.nivelInferior!= None):
            nivelI = nivel.nivelInferior.pk
        if (nivel.nivelInferior== None):
            nivelI = ""
        response = json.dumps({'nivelInf': nivelI, 'nivelSup': nivelS })
        return HttpResponse(response, content_type='application/json')

class DetalharNivel(View):
    def get(self, request, nivel_id):
        setores = Setor.objects.filter(nivel_id=nivel_id)
        return render(request, 'nivel/setores_nivel.html', {'setores': setores} )



