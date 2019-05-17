
from django.http import HttpResponseRedirect
from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView

from apps.solicitacao.form import SolicitacaoForm, ItemForm
from apps.solicitacao.models import Solicitacao, Item


class CadastraItem(CreateView):
    model = Item
    fields = ['nome']


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
        formOne = self.form1(request.POST,prefix="form1")
        formTwo = self.form2(request.POST,prefix="form2")

        if formOne.is_valid() and formTwo.is_valid():
            formOne.save()
            formTwo.save()
            return HttpResponseRedirect('/solicitacao/')

        return render(request, self.template_name, {
            'form1': formOne,
            'form2': formTwo
        })




