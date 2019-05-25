from django.http import JsonResponse
from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView

from apps.item.forms import ItemForm, CampoForm

class Campos(object):
    campos = []

class  CadastrarCampo(CreateView):
    def  post(self, request):
        tipos = request.POST.getlist('tipo')
        nomes = request.POST.getlist('nome')
        data = dict()
        for tipo,nome in zip(tipos,nomes):
            print(tipo)
            print(nome)
            form = CampoForm({
                'nome':nome,
                'descricao':'alguma coisa',
                'tipo': tipo
            })
            if form.is_valid():
                campo = form.save()
                Campos.campos.append(campo)
        return JsonResponse(data)

class  CadastrarItem(CreateView):
    def  post(self, request):
        data = dict()
        form = ItemForm(request.POST)
        if form.is_valid():
            item = form.save()
            data['nome'] = item.nome
            data['id'] = item.id
            for campo in Campos.campos:
                item.campus.add(campo)

        return JsonResponse(data)

