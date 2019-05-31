from django.forms import ModelForm, fields

from apps.organizacao.models import Organizacao


class OrganizacaoCadastra(ModelForm):
    def __init__(self, *args, **kwargs):
        super(OrganizacaoCadastra, self).__init__(*args, **kwargs)


        self.fields['cnpj'].widget.attrs = {'oninput' : 'mascara(this, "cnpj")'}

    class Meta:
        model = Organizacao
        fields = ['nome', 'cnpj', 'endereco', 'telefone']
