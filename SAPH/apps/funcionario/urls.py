from django.urls import path


from .views import CadastrarFuncionario, AtualizarFuncionario, ListarFuncionarios

urlpatterns = [
    path('cadastrar-funcionario/', CadastrarFuncionario.as_view(), name="cadasrtrar_funcionario"),
    path('atualizar-funcionario/<int:pk>/', AtualizarFuncionario.as_view(), name="atualizar_funcionario"),
    path('listar-funcionarios/', ListarFuncionarios.as_view(), name="listar_funcionarios"),
]