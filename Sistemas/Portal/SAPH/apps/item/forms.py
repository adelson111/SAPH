from django.forms import ModelForm

from apps.item.models import Item, Campo


class CampoForm(ModelForm):
    class Meta:
        model = Campo
        fields = ['nome','descricao','tipo']

class ItemForm(ModelForm):
    class Meta:
        model = Item
        fields = ['nome']