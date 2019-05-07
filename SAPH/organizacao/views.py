from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse
from django.shortcuts import render
from .form import SetorForm
from .models import Setor

def cadasrtra_setor(request):
    dado = {}
    form = SetorForm(request.POST or None)
    dado['setores']=Setor.objects.all()
    dado['form']= form
    if form.is_valid():
        form.save()
    return render(request,'index.html',dado)