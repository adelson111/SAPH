from django.forms import ModelForm

from apps.funcionario.models import Funcionario


class FuncionarioEdit(ModelForm):
    class Meta:
        model = Funcionario
        fields = ['nome', 'ativo']