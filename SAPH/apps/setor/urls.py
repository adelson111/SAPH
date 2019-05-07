from django.urls import path
from .views import cadasrtra_setor

urlpatterns = [
    path('cadastrar/', cadasrtra_setor, name="cadasrtra_setor"),

]