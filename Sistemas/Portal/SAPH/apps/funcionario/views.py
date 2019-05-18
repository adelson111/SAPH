
from apps.funcionario.forms import FuncionaioPreCadastro, FuncionarioCadastra, FuncionarioEdit
from django.core.exceptions import ObjectDoesNotExist
from django.db import IntegrityError

from django.http import HttpResponse
from django.shortcuts import render


from .models import Funcionario
from django.views.generic import CreateView, UpdateView, ListView, DeleteView
from django.urls import reverse_lazy
from django.contrib.auth.models import User

class CadastrarFuncionario(CreateView):
    model = Funcionario
    # fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'ativo', 'foto', 'organizacao']
    form_class = FuncionarioCadastra

    def get_form_kwargs(self, *args, **kwargs):
        kwargs = super(CadastrarFuncionario, self).get_form_kwargs()
        # kwargs.update({'organizacao': self.request.user.funcionario.organizacao.pk})
        kwargs.update({'organizacao': self.kwargs['pk']})
        return kwargs

    def form_valid(self, form):
        funcionario = form.save(commit=False)
        username = funcionario.email
        password = funcionario.senha
        try:
            funcionario.user = User.objects.create_user(username=username, password=password)
            funcionario.save()
            return super(CadastrarFuncionario, self).form_valid(form)
        except IntegrityError:
            return HttpResponse('FUDEU1')


    success_url = reverse_lazy('page_home')

class AtualizarFuncionario(UpdateView):
    model = Funcionario
    fields = ['nome', 'email', 'senha', 'cpf', 'cargo', 'endereco', 'telefone', 'ativo', 'foto']
    def get_queryset(self):
        return Funcionario.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarFuncionarios(ListView):
    model = Funcionario

    def get_queryset(self):
        # return Funcionario.objects.all()
        return Funcionario.objects.filter(organizacao=self.request.user.funcionario.organizacao.pk)


class ListarFuncionarioBloqueado(ListView):
    model = Funcionario


    def get_queryset(self):
        # return Funcionario.objects.filter(ativo=False)
        return Funcionario.objects.filter(ativo=False, organizacao=self.request.user.funcionario.organizacao.pk)

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


class PreCadastroFuncionario(CreateView):
    model = Funcionario
    form_class = FuncionaioPreCadastro

    def form_valid(self, form):
        funcionario = form.save(commit=False)
        username = funcionario.email
        funcionario.senha = 'ifrn2018'

        try:
            funcionario.user = User.objects.create_user(username=username, password='ifrn2018')
            funcionario.save()
        except IntegrityError:
            return HttpResponse('FUDEU')

        return super(PreCadastroFuncionario, self).form_valid(form)

    template_name_suffix = '_pre_cadastro_funcionario'

class PreUpdateFuncionario(UpdateView):
    model = Funcionario
    fields = ['nome', 'cpf', 'cargo', 'endereco', 'telefone', 'foto']
    # form_class = FuncionarioEd    it
    def get_queryset(self):
        return Funcionario.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_pre_update_funcionario'


