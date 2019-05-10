from django.db import models
# Create your models here.
from apps.funcionario.models import Funcionario
from django.urls import reverse


class Nivel(models.Model):
    nivelSuperior = models.ForeignKey('self', null=True, blank=True, on_delete=models.PROTECT, related_name='nivelsuperior')
    nivelInferior = models.ForeignKey('self', null=True, blank=True, on_delete=models.PROTECT, related_name='nivelinferior')
    funcionario = models.ForeignKey(Funcionario, on_delete=models.PROTECT)


    def __str__(self):
        return "Chefe do Nível: "+ self.funcionario.nome

    def get_absolute_url(self):
        return reverse('cadastrar_nivel')