
from django.shortcuts import render, redirect, get_object_or_404
from django.http import JsonResponse

# Create your views here.
from django.urls import reverse_lazy
from django.views.generic import CreateView, ListView, UpdateView, DeleteView

from apps.solicitacao.form import SolicitacaoForm, ItemForm
from apps.solicitacao.models import Item, Solicitacao


class CadastrarSolicitacao(CreateView):
    form1 = ItemForm
    form2 = SolicitacaoForm
    template_name = 'solicitacao/solicitacao_form.html'

    def get(self, request, *args, **kwargs):
        formOne = self.form1(prefix='form1')
        formTwo = self.form2(prefix='form2')
        return render(request, self.template_name, {
            'form1': formOne,
            'form2': formTwo
        })

    def post(self, request, *args, **kwargs):
        nome_itens = request.POST.getlist('form1-nome')
        data_dicts = [{'nome':nome}for nome in nome_itens]
        itens = []
        for data in data_dicts:
            formOne = self.form1(data)
            if formOne.is_valid():
                pk = formOne.save()
                itens.append(get_object_or_404(Item, pk=pk.pk))


        formTwo = self.form2(request.POST,prefix="form2")

        if formTwo.is_valid():
            solicitacao = formTwo.save()
            for item in itens:
                solicitacao.itens.add(item)

            return redirect('cadasrtrar_solicitacao')

        return render(request, self.template_name, {
            'form1': self.form1(prefix='form1'),
            'form2': self.form2(prefix='form2')
        })


class ListarSolicitacao(ListView):
    model = Solicitacao
    def get_queryset(self):
        return Solicitacao.objects.all()

class AtualizarSolicitacao(UpdateView):
    model = Solicitacao
    fields = ['tipo','descricao','itens']
    def get_queryset(self):
        return Solicitacao.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listar_solicitacao')

class ApagarSolicitacao(DeleteView):
    model = Solicitacao
    success_url = reverse_lazy('listar_solicitacao')

class  CadastrarItem(CreateView):
    def  post(self, request):
        data = dict()
        form = ItemForm(request.POST)
        if form.is_valid():
            item = form.save()
            data['nome'] = item.nome
            data['id'] = item.id
        return JsonResponse(data)

class  ListarItem(ListView):
    def  get(self, request):
        itens =  list(Item.objects.all().values())
        data =  dict()
        data['nome'] = itens
        return JsonResponse(data)