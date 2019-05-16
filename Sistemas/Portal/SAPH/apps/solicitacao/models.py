
from django.db import models
from django.urls import reverse
# Create your models here.

class Item(models.Model):
    nome = models.CharField(max_length=30)

class Solicitacao(models.Model):
    tipo = models.CharField(max_length=25)
    item = models.ManyToManyField(Item)

    def get_absolute_url(self):
        return reverse('cadasrtrar_solicitacao')
    class Meta:
        verbose_name_plural = 'Solicitações'





