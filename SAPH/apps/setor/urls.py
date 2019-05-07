from django.urls import path
from .views import cadasrtra_setor

urlpatterns = [
    path('cadastrar-setor/', cadasrtra_setor, name="cadasrtra_setor"),

]