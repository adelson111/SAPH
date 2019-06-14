import json

from django.contrib.auth.mixins import LoginRequiredMixin
from django.forms import model_to_dict
from django.http import HttpResponse
from django.urls import reverse_lazy
from django.views import View
from django.views.generic import CreateView, ListView, UpdateView, DeleteView
from pip._vendor import requests

from apps.delegacao.models import Delegacao


class CadastrarDelegacao(LoginRequiredMixin, CreateView):
    model = Delegacao
    fields = ['tipo', 'descricao', 'itens']

class ListarDelegacao(LoginRequiredMixin, ListView):
    model = Delegacao
    def get_queryset(self):
        return Delegacao.objects.all()

class AtualizarDelegacao(LoginRequiredMixin, UpdateView):
    model = Delegacao
    fields = ['tipo','descricao','itens']
    def get_queryset(self):
        return Delegacao.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listar_delegacao')

class ApagarDelegacao(LoginRequiredMixin, DeleteView):
    model = Delegacao
    success_url = reverse_lazy('listar_delegacao')


class SubirDelegacao(LoginRequiredMixin, View):

    def get(self, request):
        delegacoes = Delegacao.objects.all()
        lDelegacoes = []

        for delegacao in delegacoes:
            lDelegacoes.append(model_to_dict(delegacao))

        resp = requests.post(url='http://localhost:8080/SAPH/saph/organizacao/',
                             data=json.dumps(lDelegacoes),
                             headers={'content-type': 'application/json'})

        if(resp.status_code==200 or resp.status_code==201):
            return HttpResponse("ESSA MIZERA DEU CERTO")
        else:
            return HttpResponse("ESSA MIZERA DEU ERRADO")
