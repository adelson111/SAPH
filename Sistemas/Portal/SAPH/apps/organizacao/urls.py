from django.urls import path


from .views import CadastrarOrganizacao, AtualizarOrganizacao, ListarOrganizacao

urlpatterns = [
    path('cadastrar-organizacao/', CadastrarOrganizacao.as_view(), name="cadastrar_organizacao"),
    path('atualizar-organizacao/<int:pk>/', AtualizarOrganizacao.as_view(), name="atualizar_organizacao"),
    path('listar-organizacao/', ListarOrganizacao.as_view(), name="listar_organizacao"),

]