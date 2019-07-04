from django import forms
from django.forms import ModelForm

from apps.item.models import Item
from apps.nivel.models import Nivel
from apps.solicitacao.models import Solicitacao


class SolicitacaoForm(ModelForm):
    class Meta:
        model = Solicitacao
        fields = ['tipo','descricao','itens']

class CreateSolicitacao(ModelForm):

    def __init__(self, organizacao,*args, **kwargs):
        niveis = Nivel.objects.filter(organizacao=organizacao)
        itens = Item.objects.filter(organizacao=organizacao)

        super(CreateSolicitacao, self).__init__(*args, **kwargs)

        self.fields['nivel'].widget.attrs = {'class': 'custom-select'}
        self.fields['itens'].widget.attrs = {'class': 'custom-select'}
        self.fields['itens'].queryset = itens
        self.fields['nivel'].queryset = niveis

    class Meta:
        model = Solicitacao
        fields = ['tipo', 'descricao', 'itens', 'nivel']
