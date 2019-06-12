from django import forms
from django.forms import ModelForm

from apps.solicitacao.models import Solicitacao


class SolicitacaoForm(ModelForm):
    class Meta:
        model = Solicitacao
        fields = ['tipo','descricao','itens']

class CreateSolicitacao(ModelForm):

    def __init__(self, *args, **kwargs):
        super(CreateSolicitacao, self).__init__(*args, **kwargs)
        self.fields['nivel'].widget.attrs = {'class': 'custom-select'}
        self.fields['itens'].widget.attrs = {'class': 'custom-select'}

    class Meta:
        model = Solicitacao
        fields = ['tipo', 'descricao', 'itens', 'nivel']
