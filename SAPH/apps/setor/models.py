from django.db import models
from django.contrib.auth.models import User

# Create your models here.
from apps.funcionario.models import Funcionario


class Setor(models.Model):
    nome = models.CharField(max_length=20)
    funcionario = models.ManyToManyField(Funcionario, blank=True)

    def __str__(self):
        return self.nome

    class Meta:
        verbose_name_plural = 'Setores'
