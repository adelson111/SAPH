from django.urls import path

from apps.item.views import CadastrarItem

urlpatterns = [
    path('cadastrar-item/', CadastrarItem.as_view(), name="cadastrar_item"),
]