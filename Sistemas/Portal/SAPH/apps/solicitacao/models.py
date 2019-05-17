
from django.db import models
from django.urls import reverse
# Create your models here.

class Item(models.Model):
    nome = models.CharField(max_length=30)
    def __str__(self):
        return self.nome

class Solicitacao(models.Model):
    tipo = models.CharField(max_length=25)
    item = models.ManyToManyField(Item,null=True)

    def get_absolute_url(self):
        return reverse('cadasrtrar_solicitacao')

    def __str__(self):
        return self.tipo
    class Meta:
        verbose_name_plural = 'Solicitações'






