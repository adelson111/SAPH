from django.urls import path


from .views import CadastrarFuncionario, \
    AtualizarFuncionario, ListarFuncionarios, \
    ApagarFuncionario, ListarFuncionarioBloqueado,\
    BloquearFuncionario, PreCadastroFuncionario, PreUpdateFuncionario

urlpatterns = [
    path('cadastrar-funcionario/', CadastrarFuncionario.as_view(), name="cadasrtrar_funcionario"),
    path('pre-cadastro-funcionario/', PreCadastroFuncionario.as_view(), name="pre_cadasrtrar_funcionario"),

    path('atualizar-funcionario/<int:pk>/', AtualizarFuncionario.as_view(), name="atualizar_funcionario"),
    path('pre-atualizar-funcionario/<int:pk>/', PreUpdateFuncionario.as_view(), name="pre_atualizar_funcionario"),

    path('apagar-funcionario/<int:pk>/', ApagarFuncionario.as_view(), name="apagar_funcionario"),

    path('bloquear-funcionario/<int:pk>/', BloquearFuncionario.as_view(), name="bloquear_funcionario"),

    path('listar-funcionarios/', ListarFuncionarios.as_view(), name="listar_funcionarios"),
    path('listar-funcionarios-bloqueado/', ListarFuncionarioBloqueado.as_view(), name="listar_funcionarios_bloqueado"),
]