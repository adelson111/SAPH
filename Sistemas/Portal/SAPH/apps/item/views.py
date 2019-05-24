from django.http import JsonResponse
from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView

from apps.item.forms import ItemForm


class  CadastrarItem(CreateView):
    def  post(self, request):
        data = dict()
        form = ItemForm(request.POST)
        if form.is_valid():
            item = form.save()
            data['nome'] = item.nome
            data['id'] = item.id
        return JsonResponse(data)