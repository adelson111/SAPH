from django.db import models
from django.contrib.auth.models import User

# Create your models here.
from django.urls import reverse

from apps.funcionario.models import Funcionario
from apps.nivel.models import Nivel


class Setor(models.Model):
    nome = models.CharField(max_length=20)
    funcionario = models.ManyToManyField(Funcionario, blank=True, null=True)
    nivel = models.ForeignKey(Nivel, blank=True, null=True, on_delete=models.PROTECT)
    gerente = models.ForeignKey(Funcionario, blank=False, null=True, on_delete=models.SET_NULL, related_name='gerentesetor')

    def __str__(self):
        return self.nome

    class Meta:
        verbose_name_plural = 'Setores'

    def get_absolute_url(self):
        return reverse('cadastrar_setor')