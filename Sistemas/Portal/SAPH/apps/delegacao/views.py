import json

from django.contrib.auth.mixins import LoginRequiredMixin
from django.forms import model_to_dict
from django.http import HttpResponse
from django.urls import reverse_lazy
from django.views import View
from django.views.generic import CreateView, ListView, UpdateView, DeleteView


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


