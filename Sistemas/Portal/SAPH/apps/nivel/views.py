import json
from gc import get_objects

from django.http import HttpResponse
from django.shortcuts import render, get_object_or_404

# Create your views here.
from django.urls import reverse_lazy, reverse
from django.views import View
from django.views.generic import CreateView, ListView, UpdateView, DeleteView, TemplateView

from apps.nivel.models import Nivel

from apps.nivel.forms import NivelEdit, NivelCreate
from apps.organizacao.models import Organizacao


class CadastrarNivel(CreateView):
    model = Nivel
    # fields = ['nome','nivelSuperior', 'nivelInferior', 'funcionario', 'organizacao']
    form_class = NivelCreate
    def get_form_kwargs(self):
        kwargs = super(CadastrarNivel, self).get_form_kwargs()
        kwargs.update({'organizacao': self.kwargs['pk_organizacao']})
        return kwargs

    def get_success_url(self):
        return reverse('cadastrar_nivel', args=[self.request.user.funcionario.organizacao.pk])

    def form_valid(self, form):
        nivel = form.save()
        if(nivel.nivelSuperior.pk!=""):
            nivelSuperior = get_object_or_404(Nivel, pk=nivel.nivelSuperior.pk)
            nivelSuperior.nivelInferior = nivel
            nivelSuperior.save()
        if(nivel.nivelInferior.pk!=""):
            nivelInferior = get_object_or_404(Nivel, pk=nivel.nivelInferior.pk)
            nivelInferior.nivelSuperior = nivel
            nivelInferior.save()
        form.save()
        return super(CadastrarNivel, self).form_valid(form)



class ListarNivel(ListView):
    model = Nivel

    def get_queryset(self):
        return Nivel.objects.filter(organizacao=self.request.user.funcionario.organizacao)


class AtualizarNivel(UpdateView):
    model = Nivel
    form_class = NivelEdit

    def get_queryset(self):
        return Nivel.objects.filter(pk=self.kwargs['pk'])

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
        response = json.dumps({'nivelInf': nivelI, 'nivelSup':nivelS })
        return HttpResponse(response, content_type='application/json')


class Organograma(ListView):
    model = Nivel

    def get_queryset(self):
        return Nivel.objects.filter(organizacao=self.request.user.funcionario.organizacao)
    template_name_suffix = "_organograma"
