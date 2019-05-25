from django.http import JsonResponse
from django.shortcuts import render

# Create your views here.
from django.views.generic import CreateView

from apps.item.forms import ItemForm, CampoForm

def _get_form(request, formcls, prefix):
    data = request.POST if prefix in request.POST else None
    return formcls(data, prefix=prefix)

class  CadastrarItem(CreateView):

    def get(self, request, *args, **kwargs):
        return self.render_to_response({
            'form1': ItemForm(prefix='item_form'),
            'form2': CampoForm(prefix='campo_form')
        })

    def  post(self, request):
        data = dict()
        formOne = _get_form(request,ItemForm,'item_form')
        formTwo = _get_form(request,CampoForm,'campo_form')
        campos = []
        if formTwo.is_valid():
            campos.append(formTwo.save())

        if formOne.is_valid():
            item = formOne.save()
            for campo in campos:
                item.add(campo)
            data['nome'] = item.nome
            data['id'] = item.id

        return JsonResponse(data)