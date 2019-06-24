from django.urls import path

from apps.nivel.views import CadastrarNivel, ListarNivel, \
    AtualizarNivel, DeletaNivel, PesquisaNivel, Organograma

urlpatterns = [
    path('cadastrar/<int:pk_organizacao>/', CadastrarNivel.as_view(), name="cadastrar_nivel"),
    path('listar/', ListarNivel.as_view(), name="listar_nivel"),
    path('organograma/', Organograma.as_view(), name="organograma_nivel"),
    path('atualizar/<int:pk>/', AtualizarNivel.as_view(), name="atualizar_nivel"),
    path('pesquisa/<int:pk>/', PesquisaNivel.as_view(), name="pesquisa_nivel"),
    path('deletar/<int:pk>/', DeletaNivel.as_view(), name="apagar_nivel")
]
