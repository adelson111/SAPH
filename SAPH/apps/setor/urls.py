from django.urls import path

from .views import CadastrarSetor

urlpatterns = [
    # path('cadastrar/', cadasrtra_setor, name="cadasrtra_setor"),
    path('cadastrar/', CadastrarSetor.as_view(), name="cadasrtra_setor"),

]