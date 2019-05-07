from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView
from django.contrib.auth.models import User
from .models import Funcionario


class FuncionarioNovo(CreateView):
    model = Funcionario
    fields = [
        'nome', 'email', 'senha', 'cpf',
        'cargo', 'endereco', 'telefone',
        'status', 'user']

    def form_valid(self, form):
        funcionario = form.save(commit=False)
        username = funcionario.nome
        password = funcionario.senha
        funcionario.user = User.objects.create_user(username=username, password=password)
        funcionario.save()
        return super(FuncionarioNovo, self).form_valid(form)
