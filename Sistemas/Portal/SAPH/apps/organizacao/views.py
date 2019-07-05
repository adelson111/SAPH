import json

from django.contrib.auth.mixins import LoginRequiredMixin
from django.db.models import Prefetch
from django.forms import model_to_dict
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render, get_object_or_404

# Create your views here.
from django.urls import reverse, reverse_lazy
from django.views import View
from django.views.generic import CreateView, UpdateView, ListView
from pip._vendor import requests

from apps.funcionario.models import Funcionario
from apps.nivel.models import Nivel
from apps.organizacao.forms import OrganizacaoCadastra
from apps.setor.models import Setor
from apps.item.models import Item
from apps.solicitacao.models import Solicitacao
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


class SolicitarReabertura(LoginRequiredMixin, View):

    def get(self, request):
        organizacoes = Organizacao.objects.filter(pk=request.user.funcionario.organizacao.pk).values()
        lOrganizacao = []

        for organizacao in organizacoes:
            organizacaoDic = {
                'id': organizacao['id'],
                'nome': organizacao['nome'],
                'cnpj': organizacao['cnpj'],
                'endereco': organizacao['endereco'],
                'telefone': organizacao['telefone'],
                'situacao': organizacao['situacao'],
                'enviado': organizacao['enviado'],
                'pedido': True
            }
            lOrganizacao.append(organizacaoDic)

        # Envio da request
        resp = requests.post(url='http://127.0.0.1:8080/SAPH/saph/organizacao/configuracao/',
                             data=json.dumps(organizacaoDic),
                             headers={'content-type': 'application/json'})
        if (resp.status_code == 200 or resp.status_code == 201):
            org = get_object_or_404(Organizacao, pk=organizacoes[0]['id'])
            org.pedido = True
            org.save()
            return HttpResponseRedirect(reverse("page_home"))
        else:
            return HttpResponseRedirect(reverse("page_home"))

class CancelarReabertura(LoginRequiredMixin, View):

    def get(self, request):
        organizacoes = Organizacao.objects.filter(pk=request.user.funcionario.organizacao.pk).values()
        lOrganizacao = []

        for organizacao in organizacoes:
            organizacaoDic = {
                'id': organizacao['id'],
                'nome': organizacao['nome'],
                'cnpj': organizacao['cnpj'],
                'endereco': organizacao['endereco'],
                'telefone': organizacao['telefone'],
                'situacao': organizacao['situacao'],
                'enviado': organizacao['enviado'],
                'pedido': False
            }
            lOrganizacao.append(organizacaoDic)

        # Envio da request
        resp = requests.post(url='http://127.0.0.1:8080/SAPH/saph/organizacao/configuracao/',
                             data=json.dumps(organizacaoDic),
                             headers={'content-type': 'application/json'})
        if (resp.status_code == 200 or resp.status_code == 201):
            org = get_object_or_404(Organizacao, pk=organizacoes[0]['id'])
            org.pedido = False
            org.save()
            return HttpResponseRedirect(reverse("page_home"))
        else:
            return HttpResponseRedirect(reverse("page_home"))