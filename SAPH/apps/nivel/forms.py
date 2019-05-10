from django.forms import ModelForm

from apps.nivel.models import Nivel


class NivelEdit(ModelForm):
    class Meta:
        model = Nivel
        fields = ['nivelSuperior', 'nivelInferior', 'funcionario']