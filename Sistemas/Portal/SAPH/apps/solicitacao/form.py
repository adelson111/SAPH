from django import forms
from django.forms import ModelForm

from apps.solicitacao.models import Item, Solicitacao


class ItemForm(ModelForm):
    class Meta:
        model = Item
        fields = ['nome']

class SolicitacaoForm(ModelForm):
    class Meta:
        model = Solicitacao
        fields = ['tipo','descricao','itens']

