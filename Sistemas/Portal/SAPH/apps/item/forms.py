from django.forms import ModelForm

from apps.item.models import Item


class ItemForm(ModelForm):
    class Meta:
        model = Item
        fields = ['nome']