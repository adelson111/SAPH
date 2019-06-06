from django.contrib.messages.views import SuccessMessageMixin
from django.shortcuts import render
from django.views import View
from django.views.generic import CreateView,UpdateView,ListView,DeleteView
from django.urls import reverse_lazy, reverse

from apps.funcionario.models import Funcionario
from apps.setor.form import SetorCreate
from .models import Setor
from apps.organizacao.models import Organizacao


class CadastrarSetor(SuccessMessageMixin, CreateView):
    model = Setor
    # fields = ['nome','funcionario', 'nivel', 'gerente']
    form_class = SetorCreate
    success_message = "%(nome)s Cadastrado com sucesso"

    def get_form_kwargs(self):
        kwargs = super(CadastrarSetor, self).get_form_kwargs()
        kwargs.update({'organizacao': self.kwargs['pk_organizacao']})
        return kwargs

    def get_success_message(self, cleaned_data):
        # return messages.add_message(self.request, messages.SUCCESS, self.message_data)
        return self.success_message % dict(
            cleaned_data,
            nome = self.object.nome
        )


    def get_success_url(self):
        return reverse('cadastrar_setor', args=[self.request.user.funcionario.organizacao.pk])


class AtualizarSetor(UpdateView):
    model = Setor
    fields = ['nome','funcionario', 'nivel', 'gerente']
    def get_queryset(self):
        return Setor.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarSetor(ListView):
    model = Setor

    def get_queryset(self):
        # return Setor.objects.all()
        return Setor.objects.select_related('nivel').filter(nivel__organizacao=self.request.user.funcionario.organizacao)

class ApagarSetor(DeleteView):
    model = Setor
    success_url = reverse_lazy('listar_funcionarios')

class DetalharSetor(View):
    def get(self, request, pk):
        setor = Setor.objects.filter(pk=pk)
        funcionarios = Funcionario.objects.filter(setor__pk=pk)
        return render(request, 'setor/setor_detalhar.html', {'setor': setor, 'funcionarios': funcionarios})