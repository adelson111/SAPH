from django.urls import path

from .views import CadastrarSetor,AtualizarSetor,ListarSetor,ApagarSetor

urlpatterns = [
    path('cadastrar-setor', CadastrarSetor.as_view(), name="cadastrar_setor"),
    path('atualizar-setor/<int:pk>/', AtualizarSetor.as_view(), name="atualizar_setor"),
    path('apagar-setor/<int:pk>/', ApagarSetor.as_view(), name="apagar_setor"),
    path('listar-setor/', ListarSetor.as_view(), name="listar_setor"),

]