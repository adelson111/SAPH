from django.urls import path

from apps.solicitacao.views import CadastrarDelegacao, AtualizarDelegacao, ApagarDelegacao, ListarDelegacao
from .views import CadastrarSolicitacao, ListarSolicitacao, AtualizarSolicitacao, ApagarSolicitacao

urlpatterns = [
    path('cadastrar-solicitacao/', CadastrarSolicitacao.as_view(), name="cadasrtrar_solicitacao"),
    path('atualizar-solicitacao/<int:pk>/', AtualizarSolicitacao.as_view(), name="atualizar_solicitacao"),
    path('apagar-solicitacao/<int:pk>/', ApagarSolicitacao.as_view(), name="apagar_solicitacao"),
    path('listar-solicitacao/', ListarSolicitacao.as_view(), name="listar_solicitacao"),

    path('cadastrar-delegacao/', CadastrarDelegacao.as_view(), name="cadastrar_delegacao"),
    path('atualizar-delegacao/<int:pk>/', AtualizarDelegacao.as_view(), name="atualizar_delegacao"),
    path('apagar-delegacao/<int:pk>/', ApagarDelegacao.as_view(), name="apagar_delegacao"),
    path('listar-delegacao/', ListarDelegacao.as_view(), name="listar_delegacao"),
]