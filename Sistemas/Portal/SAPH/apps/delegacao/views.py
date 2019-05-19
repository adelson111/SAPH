from django.shortcuts import render

# Create your views here.
from django.urls import reverse_lazy
from django.views.generic import CreateView, ListView, UpdateView, DeleteView

from apps.delegacao.models import Delegacao


class CadastrarDelegacao(CreateView):
    model = Delegacao
    fields = ['tipo', 'descricao', 'itens']

class ListarDelegacao(ListView):
    model = Delegacao
    def get_queryset(self):
        return Delegacao.objects.all()

class AtualizarDelegacao(UpdateView):
    model = Delegacao
    fields = ['tipo','descricao','itens']
    def get_queryset(self):
        return Delegacao.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listar_delegacao')

class ApagarDelegacao(DeleteView):
    model = Delegacao
    success_url = reverse_lazy('listar_delegacao')
