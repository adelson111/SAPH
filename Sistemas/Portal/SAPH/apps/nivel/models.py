from django.db import models
# Create your models here.
from apps.funcionario.models import Funcionario
from django.urls import reverse

from apps.organizacao.models import Organizacao


class Nivel(models.Model):
    nome = models.CharField(max_length=30, null=False, blank=False)
    nivelSuperior = models.ForeignKey('self', null=True, blank=True, on_delete=models.PROTECT, related_name='nivelsuperior')
    nivelInferior = models.ForeignKey('self', null=True, blank=True, on_delete=models.PROTECT, related_name='nivelinferior')
    funcionario = models.ForeignKey(Funcionario, on_delete=models.PROTECT, related_name='funcionario_do_nivel')
    organizacao = models.ForeignKey(Organizacao, on_delete=models.PROTECT, related_name='organizacao_do_nivel')


    def __str__(self):
        return self.nome

    def get_absolute_url(self):
        return reverse('cadastrar_nivel')
    class Meta:
        verbose_name_plural = 'Niveis'