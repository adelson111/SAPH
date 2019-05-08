from .models import Funcionario
from django.views.generic import CreateView, UpdateView, ListView

class CadastrarFuncionario(CreateView):
    model = Funcionario
    fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'status', 'foto', 'user']

class AtualizarFuncionario(UpdateView):
    model = Funcionario
    fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'status', 'foto', 'user']
    def get_queryset(self):
        return Funcionario.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarFuncionarios(ListView):
    model = Funcionario

    def get_queryset(self):
        return Funcionario.objects.all()

