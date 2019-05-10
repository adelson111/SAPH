from django.shortcuts import render

# Create your views here.
from django.urls import reverse_lazy
from django.views.generic import CreateView, ListView, UpdateView, DeleteView

from apps.nivel.models import Nivel

from apps.nivel.forms import NivelEdit


class CadastrarNivel(CreateView):
    model = Nivel
    fields = ['nivelSuperior', 'nivelInferior', 'funcionario']


class ListarNivel(ListView):
    model = Nivel


    def get_queryset(self):
        return Nivel.objects.all()


class AtualizarNivel(UpdateView):
    model = Nivel
    form_class = NivelEdit

    def get_queryset(self):
        return Nivel.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class DeletaNivel(DeleteView):
    model =Nivel
    success_url = reverse_lazy('listar_nivel')