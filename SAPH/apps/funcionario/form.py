from django.forms import ModelForm
from .models import Funcionario

class FuncionarioForm(ModelForm):
    class Meta:
        model = Funcionario
        fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'status', 'foto', 'user']