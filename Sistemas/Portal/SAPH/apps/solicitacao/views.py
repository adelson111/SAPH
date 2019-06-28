import json

from django.contrib.auth.mixins import LoginRequiredMixin
from django.contrib.messages.views import SuccessMessageMixin
from django.forms import model_to_dict
from django.shortcuts import render, redirect, get_object_or_404
from django.http import JsonResponse, HttpResponse

# Create your views here.
from django.urls import reverse_lazy
from django.views import View
from django.views.generic import CreateView, ListView, UpdateView, DeleteView

from apps.solicitacao.form import SolicitacaoForm, CreateSolicitacao
from apps.solicitacao.models import Item, Solicitacao


class CadastrarSolicitacao(LoginRequiredMixin, SuccessMessageMixin, CreateView):
    model = Solicitacao
    # fields = ['tipo', 'descricao', 'itens', 'nivel']
    form_class = CreateSolicitacao
    success_message = "%(nome)s foi Cadastrada com sucesso"

    def form_valid(self, form):
        solicitacao = form.save(commit=False)
        solicitacao.solicitacaoDelegacao = 'SOLICITACAO'
        solicitacao.save()
        return super(CadastrarSolicitacao, self).form_valid(form)

    def get_success_message(self, cleaned_data):
        return self.success_message % dict(
            cleaned_data,
            nome=self.object.tipo
        )


class CadastrarDelegacao(LoginRequiredMixin, SuccessMessageMixin, CreateView):
    model = Solicitacao
    # fields = ['tipo', 'descricao', 'itens', 'nivel']
    form_class = CreateSolicitacao
    success_message = "%(nome)s foi Cadastrada com sucesso"

    def form_valid(self, form):
        solicitacao = form.save(commit=False)
        solicitacao.solicitacaoDelegacao = 'DELEGACAO'
        solicitacao.save()
        return super(CadastrarDelegacao, self).form_valid(form)

    def get_success_message(self, cleaned_data):
        return self.success_message % dict(
            cleaned_data,
            nome=self.object.tipo
        )
    template_name = 'solicitacao/delegacao_form.html'


class ListarSolicitacao(LoginRequiredMixin, ListView):
    model = Solicitacao

    def get_queryset(self):
        return Solicitacao.objects.filter(solicitacaoDelegacao='SOLICITACAO')

class ListarDelegacao(LoginRequiredMixin, ListView):
    model = Solicitacao

    def get_queryset(self):
        return Solicitacao.objects.filter(solicitacaoDelegacao='DELEGACAO')

    template_name = 'solicitacao/delegacao_list.html'


class AtualizarSolicitacao(LoginRequiredMixin, SuccessMessageMixin, UpdateView):
    model = Solicitacao
    # fields = ['tipo','descricao','itens']
    form_class = CreateSolicitacao
    success_message = "A Solicitação %(nome)s foi alterada com Sucesso"

    def get_queryset(self):
        return Solicitacao.objects.filter(pk=self.kwargs['pk'], solicitacaoDelegacao='SOLICITACAO')

    def get_success_message(self, cleaned_data):
        return self.success_message % dict(
            cleaned_data,
            nome=self.object.tipo
        )

    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listar_solicitacao')


class AtualizarDelegacao(LoginRequiredMixin, SuccessMessageMixin, UpdateView):
    model = Solicitacao
    # fields = ['tipo','descricao','itens']
    form_class = CreateSolicitacao
    success_message = "A Delegação %(nome)s foi alterada com Sucesso"

    def get_queryset(self):
        return Solicitacao.objects.filter(pk=self.kwargs['pk'], solicitacaoDelegacao='DELEGACAO')

    def get_success_message(self, cleaned_data):
        return self.success_message % dict(
            cleaned_data,
            nome=self.object.tipo
        )

    template_name = 'solicitacao/delegacao_update_form.html'
    success_url = reverse_lazy('listar_solicitacao')



class ApagarSolicitacao(LoginRequiredMixin, DeleteView):
    model = Solicitacao
    success_url = reverse_lazy('listar_solicitacao')

class ApagarDelegacao(LoginRequiredMixin, DeleteView):
    model = Solicitacao
    template_name = 'solicitacao/delegacao_confirm_delete.html'
    success_url = reverse_lazy('listar_solicitacao')