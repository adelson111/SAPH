from django.forms import ModelForm

from apps.funcionario.models import Funcionario
from apps.nivel.models import Nivel



class NivelCreate(ModelForm):
    def __init__(self, organizacao, *args, **kwargs):
        funcionarios = Funcionario.objects.filter(organizacao=organizacao)
        nivel = Nivel.objects.filter(organizacao=organizacao)
        super(NivelCreate, self).__init__(*args, **kwargs)
        self.fields['nivelSuperior'].queryset = nivel
        self.fields['nivelInferior'].queryset = nivel
        self.fields['funcionario'].queryset = funcionarios

        self.fields['nivelSuperior'].widget.attrs = {'class' : 'custom-select'}
        self.fields['nivelInferior'].widget.attrs = {'class' : 'custom-select'}
        self.fields['funcionario'].widget.attrs = {'class' : 'custom-select'}

    class Meta:
        model = Nivel
        fields = ['nome', 'nivelSuperior', 'nivelInferior', 'funcionario', 'organizacao']

class NivelEdit(ModelForm):
    class Meta:
        model = Nivel
        fields = ['nome','nivelSuperior', 'nivelInferior', 'funcionario', 'organizacao']