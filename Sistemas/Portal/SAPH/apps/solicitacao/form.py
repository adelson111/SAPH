from django import forms
from django.forms import ModelForm

from apps.solicitacao.models import Solicitacao


class SolicitacaoForm(ModelForm):
    class Meta:
        model = Solicitacao
        fields = ['tipo','descricao','itens']

