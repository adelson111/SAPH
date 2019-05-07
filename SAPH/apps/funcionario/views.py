from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView
from django.contrib.auth.models import User
from .models import Funcionario
from django.shortcuts import render, redirect, get_object_or_404
from .form import FuncionarioForm


class FuncionarioNovo(CreateView):
    model = Funcionario
    fields = [
        'nome', 'email', 'senha', 'cpf',
        'cargo', 'endereco', 'telefone',
        'status', 'foto']

    def form_valid(self, form):
        funcionario = form.save(commit=False)
        username = funcionario.nome
        password = funcionario.senha
        funcionario.user = User.objects.create_user(username=username, password=password)
        funcionario.save()
        return super(FuncionarioNovo, self).form_valid(form)

def cadasrtrar(request):
    form = FuncionarioForm(request.POST or None, request.FILES or None)

    if form.is_valid():
        funcionario = form.save(commit=False)
        username = funcionario.cpf
        password = funcionario.senha
        form.instance.user = User.objects.create_user(username=username, password=password)
        form.save()
        return redirect('cadastrar_funcionario')
    return render(request, 'funcionariosForm.html', {'form':form})
