from django.forms import ModelForm, fields

from apps.funcionario.models import Funcionario


class FuncionarioEdit(ModelForm):
    class Meta:
        model = Funcionario
        fields = ['nome', 'ativo']

class FuncionaioPreCadastro(ModelForm):
    class Meta:
        model = Funcionario
        fields = ['email']