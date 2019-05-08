from django.urls import path


from .views import CadastrarFuncionario

urlpatterns = [
    path('cadastrar-funcionario/', CadastrarFuncionario.as_view(), name="cadasrtrar_funcionario"),

]