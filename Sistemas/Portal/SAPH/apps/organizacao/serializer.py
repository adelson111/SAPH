from rest_framework import routers, serializers, viewsets
from .models import Organizacao

class OrganizacaoSerializer(serializers.ModelSerializer):
    class Meta:
        model = Organizacao
        fields = ('nome', 'cnpj', 'endereco', 'telefone')