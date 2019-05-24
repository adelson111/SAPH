from django.forms import ModelForm, fields

from apps.funcionario.models import Funcionario

from apps.organizacao.models import Organizacao


class FuncionarioEdit(ModelForm):
    class Meta:
        model = Funcionario
        fields = ['nome', 'ativo']

class FuncionaioPreCadastro(ModelForm):
    class Meta:
        model = Funcionario
        fields = ['email','user']


class FuncionarioCadastra(ModelForm):
    def __init__(self, organizacao, *args, **kwargs):
        organ = Organizacao.objects.filter(pk=organizacao)

        super(FuncionarioCadastra, self).__init__(*args, **kwargs)
        self.fields['organizacao'].queryset = organ


    class Meta:
        model = Funcionario
        fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'ativo', 'foto', 'organizacao']
