from django.db import models

# Create your models here.


class Solicitacao(models.Model):
    tipo = models.CharField(max_length=25)
    teste = models.CharField(max_length=1, null=True)


class Item(models.Model):
    solicitacao = models.ManyToManyField(Solicitacao)
    nome = models.CharField(max_length=30)

