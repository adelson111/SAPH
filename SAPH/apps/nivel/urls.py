from django.urls import path

from apps.nivel.views import CadastrarNivel, ListarNivel, AtualizarNivel, DeletaNivel

urlpatterns = [
    path('cadastrar/', CadastrarNivel.as_view(), name="cadastrar_nivel"),
    path('listar/', ListarNivel.as_view(), name="listar_nivel"),
    path('atualizar/<int:pk>/', AtualizarNivel.as_view(), name="atualizar_nivel"),
    path('deletar/<int:pk>/', DeletaNivel.as_view(), name="apagar_nivel")
]