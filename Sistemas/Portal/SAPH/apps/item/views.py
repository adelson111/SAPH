import json

from django.contrib.auth.mixins import LoginRequiredMixin
from django.forms import model_to_dict
from django.http import JsonResponse, HttpResponse
from django.shortcuts import render

# Create your views here.
from django.views import View
from django.views.generic import CreateView

from apps.item.forms import ItemForm, CampoForm
from apps.item.models import Item


class Campos(object):
    campos = []

class  CadastrarCampo(LoginRequiredMixin, CreateView):
    def  post(self, request):
        tipos = request.POST.getlist('tipo')
        nomes = request.POST.getlist('nome')
        descricoes = request.POST.getlist('descricao')
        data = dict()
        for tipo,nome,descricao in zip(tipos,nomes,descricoes):
            form = CampoForm({
                'nome':nome,
                'descricao':descricao,
                'tipo': tipo
            })
            if form.is_valid():
                campo = form.save()
                if campo not in Campos.campos:
                    Campos.campos.append(campo)
        return JsonResponse(data)

class  CadastrarItem(LoginRequiredMixin, CreateView):
    def  post(self, request):
        data = dict()
        form = ItemForm(request.POST)
        if form.is_valid():
            item = form.save()
            data['nome'] = item.nome
            data['id'] = item.id
            for campo in Campos.campos:
                item.campus.add(campo)
            Campos.campos=[]

        return JsonResponse(data)

