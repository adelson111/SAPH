from django.contrib.messages.views import SuccessMessageMixin
from django.shortcuts import render, redirect, get_object_or_404
from django.http import JsonResponse

# Create your views here.
from django.urls import reverse_lazy
from django.views.generic import CreateView, ListView, UpdateView, DeleteView

from apps.solicitacao.form import SolicitacaoForm, CreateSolicitacao
from apps.solicitacao.models import Item, Solicitacao


class CadastrarSolicitacao(SuccessMessageMixin, CreateView):
    model = Solicitacao
    # fields = ['tipo', 'descricao', 'itens', 'nivel']
    form_class = CreateSolicitacao
    success_message = "%(nome)s foi Cadastrada com sucesso"

    def get_success_message(self, cleaned_data):
        return self.success_message % dict(
            cleaned_data,
            nome=self.object.tipo
        )



class ListarSolicitacao(ListView):
    model = Solicitacao

    def get_queryset(self):
        return Solicitacao.objects.all()

class AtualizarSolicitacao(SuccessMessageMixin, UpdateView):
    model = Solicitacao
    # fields = ['tipo','descricao','itens']
    form_class = CreateSolicitacao
    success_message = "A Solicitação %(nome)s foi alterada com Sucesso"

    def get_queryset(self):
        return Solicitacao.objects.filter(pk=self.kwargs['pk'])

    def get_success_message(self, cleaned_data):
        return self.success_message % dict(
            cleaned_data,
            nome=self.object.tipo
        )

    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listar_solicitacao')


class ApagarSolicitacao(DeleteView):
    model = Solicitacao
    success_url = reverse_lazy('listar_solicitacao')


