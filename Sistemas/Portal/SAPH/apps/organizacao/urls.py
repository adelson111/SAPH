from django.urls import path

from apps.organizacao.views import SolicitarReabertura, CancelarReabertura, ConsultarOrganizacao
from .views import CadastrarOrganizacao, AtualizarOrganizacao, ListarOrganizacao

urlpatterns = [
    path('cadastrar-organizacao/', CadastrarOrganizacao.as_view(), name="cadastrar_organizacao"),
    path('atualizar-organizacao/<int:pk>/', AtualizarOrganizacao.as_view(), name="atualizar_organizacao"),
    path('listar-organizacao/', ListarOrganizacao.as_view(), name="listar_organizacao"),

    path('solicitar-reabertura/', SolicitarReabertura.as_view(), name="solicitar_reabertura"),
    path('cancelar-reabertura/', CancelarReabertura.as_view(), name="cancelar_reabertura"),

    path('consultar/', ConsultarOrganizacao.as_view(), name="consultar")

]