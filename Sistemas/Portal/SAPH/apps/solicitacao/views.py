
from django.shortcuts import render, redirect, get_object_or_404
from django.http import JsonResponse

# Create your views here.
from django.urls import reverse_lazy
from django.views.generic import CreateView, ListView, UpdateView, DeleteView

from apps.solicitacao.form import SolicitacaoForm
from apps.solicitacao.models import Item, Solicitacao


class CadastrarSolicitacao(CreateView):
    model = Solicitacao
    fields = ['tipo', 'descricao', 'itens']

class ListarSolicitacao(ListView):
    model = Solicitacao

    def get_queryset(self):
        return Solicitacao.objects.all()

class AtualizarSolicitacao(UpdateView):
    model = Solicitacao
    fields = ['tipo','descricao','itens']

    def get_queryset(self):
        return Solicitacao.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listar_solicitacao')

class ApagarSolicitacao(DeleteView):
    model = Solicitacao
    success_url = reverse_lazy('listar_solicitacao')


