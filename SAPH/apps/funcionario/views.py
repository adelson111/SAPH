from .models import Funcionario
from django.views.generic import CreateView, UpdateView, ListView, DeleteView
from django.urls import reverse_lazy

class CadastrarFuncionario(CreateView):
    model = Funcionario
    fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'status', 'foto']

class AtualizarFuncionario(UpdateView):
    model = Funcionario
    fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'status', 'foto']
    def get_queryset(self):
        return Funcionario.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarFuncionarios(ListView):
    model = Funcionario

    def get_queryset(self):
        return Funcionario.objects.all()

class ApagarFuncionario(DeleteView):
    model = Funcionario
    success_url = reverse_lazy('listar_funcionarios')



