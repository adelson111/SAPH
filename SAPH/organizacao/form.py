from django.forms import ModelForm

from .models import Setor

class SetorForm(ModelForm):
    class Meta:
        model = Setor
        fields = ['nome']