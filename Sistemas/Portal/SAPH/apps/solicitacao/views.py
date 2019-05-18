
from django.shortcuts import render, redirect, get_object_or_404

# Create your views here.
from django.views.generic import CreateView

from apps.solicitacao.form import SolicitacaoForm, ItemForm
from apps.solicitacao.models import Item


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




