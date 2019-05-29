
from django.db import models
from django.urls import reverse
# Create your models here.
from apps.item.models import Item


class Solicitacao(models.Model):
    tipo = models.CharField(max_length=100)
    descricao = models.CharField(max_length=300, null=False)
    itens = models.ManyToManyField(Item, related_name='itens_solicitacao')
    status = models.CharField(max_length=30, null=False, blank=False)

    def __str__(self):
        return self.tipo

    def get_absolute_url(self):
        return reverse('cadasrtrar_solicitacao')


    class Meta:
        verbose_name_plural = 'Solicitações'






