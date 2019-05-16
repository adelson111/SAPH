from django.urls import path

from .views import cadastrar_usuario

urlpatterns = [
    path('cadastrar-solicitacao', cadastrar_usuario, name="cadasrtrar_solicitacao"),

]