from django import forms

from apps.solicitacao.models import Item


class ItemForm(forms.Form):
    name = forms.CharField(max_length=30)

class SolicitacaoForm(forms.Form):
    tipo = forms.CharField(max_length=25)
    item = forms.ModelMultipleChoiceField(queryset=Item.objects.all())