from django.urls import path

from apps.delegacao.views import ListarDelegacao, ApagarDelegacao, AtualizarDelegacao, CadastrarDelegacao

urlpatterns = [
    path('cadastrar-delegacao/', CadastrarDelegacao.as_view(), name="cadasrtrar_delegacao"),
    path('atualizar-delegacao/<int:pk>/', AtualizarDelegacao.as_view(), name="atualizar_delegacao"),
    path('apagar-delegacao/<int:pk>/', ApagarDelegacao.as_view(), name="apagar_delegacao"),
    path('listar-delegacao/', ListarDelegacao.as_view(), name="listar_delegacao"),
]