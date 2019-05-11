
from django.views.generic import CreateView,UpdateView,ListView,DeleteView
from django.urls import reverse_lazy

from .models import Setor

class CadastrarSetor(CreateView):
    model = Setor
    fields = ['nome','funcionario', 'nivel', 'gerente']

class AtualizarSetor(UpdateView):
    model = Setor
    fields = ['nome','funcionario', 'nivel', 'gerente']
    def get_queryset(self):
        return Setor.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarSetor(ListView):
    model = Setor
    def get_queryset(self):
        return Setor.objects.all()

class ApagarSetor(DeleteView):
    model = Setor
    success_url = reverse_lazy('listar_funcionarios')