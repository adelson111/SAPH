from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView, UpdateView, ListView

from .models import Organizacao


class CadastrarOrganizacao(CreateView):
    model = Organizacao
    fields = ['nome', 'cnpj', 'endereco', 'telefone']

class AtualizarOrganizacao(UpdateView):
    model = Organizacao
    fields = ['nome', 'cnpj', 'endereco', 'telefone',
              'situacao', 'numeroNivel']

    def get_queryset(self):
        return Organizacao.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarOrganizacao(ListView):
    model = Organizacao

    def get_queryset(self):
        return Organizacao.objects.all()
