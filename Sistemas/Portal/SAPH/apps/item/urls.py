from django.urls import path

from apps.item.views import CadastrarItem, CadastrarCampo

urlpatterns = [
    path('cadastrar-item/', CadastrarItem.as_view(), name="cadastrar_item"),
    path('cadastrar-campo/', CadastrarCampo.as_view(), name="cadastrar_campo"),
]