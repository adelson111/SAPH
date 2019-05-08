from .models import Funcionario
from django.views.generic import CreateView, UpdateView, ListView

class CadastrarFuncionario(CreateView):
    model = Funcionario
    fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'status', 'foto', 'user']
