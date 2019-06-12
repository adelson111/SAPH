import json

from django.contrib.auth.mixins import LoginRequiredMixin
from django.forms import model_to_dict
from django.http import HttpResponse
from django.shortcuts import render, get_object_or_404

# Create your views here.
from django.views import View
from django.views.generic import CreateView, UpdateView, ListView
from pip._vendor import requests

from apps.funcionario.models import Funcionario
from apps.organizacao.forms import OrganizacaoCadastra
from .models import Organizacao

class CadastrarOrganizacao(LoginRequiredMixin, CreateView):
    model = Organizacao
    #fields = ['nome', 'cnpj', 'endereco', 'telefone']
    form_class = OrganizacaoCadastra

    def form_valid(self, form):
        organizacao = form.save(commit=False)
        organizacao.save()
        # identificador = organizacao.pk
        # funcionario = Funcionario.objects.filter(pk=self.request.user.funcionario.pk)
        funcionario = get_object_or_404(Funcionario, pk=self.request.user.funcionario.pk)
        funcionario.organizacao = organizacao

        funcionario.save()

        return super(CadastrarOrganizacao, self).form_valid(form)


class AtualizarOrganizacao(LoginRequiredMixin, UpdateView):
    model = Organizacao
    fields = ['nome', 'cnpj', 'endereco', 'telefone']

    def get_queryset(self):
        return Organizacao.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarOrganizacao(LoginRequiredMixin, ListView):
    model = Organizacao

    def get_queryset(self):
        return Organizacao.objects.all()


class SubirOrganizacao(LoginRequiredMixin, View):

    def get(self, request):
        o = Organizacao.objects.filter(pk=request.user.funcionario.organizacao.pk)
        lorganizacao = []
        lorganizacao.append(model_to_dict(o[0]))
        resp = requests.post(url='http://localhost:8080/SAPH/saph/organizacao/',
                             # data=lorganizacao[0],
                             data=json.dumps(lorganizacao[0]),
                             headers={'content-type': 'application/json'})
        if (resp.status_code == 200 or resp.status_code == 201):
            return HttpResponse("ESSA MIZERA DEU CERTO")
        else:
            return HttpResponse("ESSA MIZERA DEU ERRADO")