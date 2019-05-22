
from django.db import models
from django.urls import reverse
# Create your models here.

class Item(models.Model):
    nome = models.CharField(max_length=30)
    def __str__(self):
        return self.nome

class Solicitacao(models.Model):
    tipo = models.CharField(max_length=25)
    descricao = models.CharField(max_length=300, null=False)
    itens = models.ManyToManyField(Item, related_name='itens_solicitacao')
    status = models.CharField(max_length=30, null=False, blank=False)

    def __str__(self):
        return self.tipo

    def get_absolute_url(self):
        return reverse('cadasrtrar_solicitacao')


    class Meta:
        verbose_name_plural = 'Solicitações'






