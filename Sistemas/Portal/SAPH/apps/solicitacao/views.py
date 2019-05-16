from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView

from apps.solicitacao.form import SolicitacaoForm, ItemForm
from apps.solicitacao.models import Solicitacao, Item


class CadastraItem(CreateView):
    model = Item
    fields = ['nome']
class CadastrarSolicitacao(CreateView):
    model = Solicitacao
    fields = ['tipo','item']

def cadastrar_usuario(request):
    form1 = SolicitacaoForm()
    form2 = ItemForm()
    return render(request, "solicitacao/solicitacao_form.html", {'form1':form1,'form2':form2})



