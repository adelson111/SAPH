from django.urls import path

from .views import CadastrarSolicitacao, ListarSolicitacao, AtualizarSolicitacao, ApagarSolicitacao, CadastrarItem

urlpatterns = [
    path('cadastrar-solicitacao/', CadastrarSolicitacao.as_view(), name="cadasrtrar_solicitacao"),
    path('atualizar-solicitacao/<int:pk>/', AtualizarSolicitacao.as_view(), name="atualizar_solicitacao"),
    path('apagar-solicitacao/<int:pk>/', ApagarSolicitacao.as_view(), name="apagar_solicitacao"),
    path('listar-solicitacao/', ListarSolicitacao.as_view(), name="listar_solicitacao"),
    path('cadastrar-item/', CadastrarItem.as_view(), name="cadastrar_item"),
]