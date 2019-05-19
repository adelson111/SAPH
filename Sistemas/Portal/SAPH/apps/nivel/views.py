from gc import get_objects

from django.shortcuts import render, get_object_or_404

# Create your views here.
from django.urls import reverse_lazy, reverse
from django.views.generic import CreateView, ListView, UpdateView, DeleteView

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