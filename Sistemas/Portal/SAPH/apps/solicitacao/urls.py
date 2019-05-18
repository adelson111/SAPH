from django.urls import path

from .views import CadastrarSolicitacao, ListarSolicitacao, AtualizarSolicitacao, ApagarSolicitacao

urlpatterns = [
    path('cadastrar-solicitacao/', CadastrarSolicitacao.as_view(), name="cadasrtrar_solicitacao"),
    path('atualizar-solicitacao/<int:pk>/', AtualizarSolicitacao.as_view(), name="atualizar_solicitacao"),
    path('apagar-solicitacao/<int:pk>/', ApagarSolicitacao.as_view(), name="apagar_solicitacao"),
    path('listar-solicitacao/', ListarSolicitacao.as_view(), name="listar_solicitacao"),
]