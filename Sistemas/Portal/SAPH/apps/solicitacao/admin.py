from django.contrib import admin

# Register your models here.
from apps.solicitacao.models import Solicitacao, Item

admin.site.register(Solicitacao)
admin.site.register(Item)