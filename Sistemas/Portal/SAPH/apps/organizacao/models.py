from django.db import models
from django.urls import reverse

# Create your models here.

class Organizacao(models.Model):
    nome = models.CharField(max_length=80)
    cnpj = models.CharField(max_length=20)
    endereco = models.CharField(max_length=50)
    telefone = models.CharField(max_length=15)
    situacao = models.BooleanField(default=True)
    numeroNivel = models.CharField(max_length=2)

    def __str__(self):
        return 'Empresa: '+ self.nome + ' - CNPJ: ' + self.cnpj

    def get_absolute_url(self):

        return reverse('page_home')

        # return reverse('cadasrtra_organizacao')

    class Meta:
        verbose_name_plural = 'Organizações'

