from django.db import models
# Create your models here.
from apps.funcionario.models import Funcionario



class Nivel(models.Model):
    nivelSuperior = models.ForeignKey('self', null=True, blank=True, on_delete=models.PROTECT, related_name='nivelsuperior')
    nivelInferior = models.ForeignKey('self', null=True, blank=True, on_delete=models.PROTECT, related_name='nivelinferior')
    funcionario = models.ForeignKey(Funcionario, on_delete=models.PROTECT)
