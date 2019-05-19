from django.forms import ModelForm

from apps.funcionario.models import Funcionario
from apps.nivel.models import Nivel
from .models import Setor


class SetorCreate(ModelForm):
    def __init__(self, organizacao, *args, **kwargs):
        funcionarios = Funcionario.objects.filter(organizacao=organizacao)
        niveis= Nivel.objects.filter(organizacao=organizacao)
        super(SetorCreate, self).__init__(*args, **kwargs)
        self.fields['funcionario'].queryset = funcionarios
        self.fields['nivel'].queryset = niveis
        self.fields['gerente'].queryset = funcionarios

    class Meta:
        model = Setor
        fields = ['nome','funcionario', 'nivel', 'gerente']