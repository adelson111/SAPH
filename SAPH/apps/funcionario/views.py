from apps.funcionario.forms import FuncionarioEdit
from .models import Funcionario
from django.views.generic import CreateView, UpdateView, ListView, DeleteView
from django.urls import reverse_lazy
from django.contrib.auth.models import User

class CadastrarFuncionario(CreateView):
    model = Funcionario
    fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'ativo', 'foto']

    def form_valid(self, form):
        funcionario = form.save(commit=False)
        username = funcionario.email
        password = funcionario.senha
        funcionario.user = User.objects.create_user(username=username, password=password)
        funcionario.save()
        return super(CadastrarFuncionario, self).form_valid(form)

class AtualizarFuncionario(UpdateView):
    model = Funcionario
    fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'ativo', 'foto']
    def get_queryset(self):
        return Funcionario.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarFuncionarios(ListView):
    model = Funcionario

    def get_queryset(self):
        return Funcionario.objects.all()


class ListarFuncionarioBloqueado(ListView):
    model = Funcionario


    def get_queryset(self):
        return Funcionario.objects.filter(ativo=False)

    template_name_suffix = '_func_bloqueado'

class BloquearFuncionario(UpdateView):
    model = Funcionario
    # fields = ['nome', 'ativo']
    form_class = FuncionarioEdit
    def get_queryset(self):
        return Funcionario.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_bloquear_funcionario'

class ApagarFuncionario(DeleteView):
    model = Funcionario
    success_url = reverse_lazy('listar_funcionarios')



