from django.urls import path

from .views import CadastrarSolicitacao

urlpatterns = [
    path('cadastrar-solicitacao/', CadastrarSolicitacao.as_view(), name="cadasrtrar_solicitacao"),

]