from django.shortcuts import render
from apps.setor.form import SetorForm
from django.views.generic import CreateView

from .models import Setor

# Create your views here.
# def cadasrtra_setor(request):
#     dado = {}
#     form = SetorForm(request.POST or None)
#     dado['setores'] = Setor.objects.all()
#     dado['form'] = form
#     if form.is_valid():
#         form.save()
#     return render(request, 'index.html', dado)

class CadastrarSetor(CreateView):
    model = Setor
    fields = ['nome', 'funcionario']