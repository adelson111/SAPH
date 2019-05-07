from django.db import models
from django.urls import reverse

# Create your models here.

class Organizacao(models.Model):
    nome = models.CharField(max_length=80)
    cnpj = models.CharField(max_length=15)
    endereco = models.CharField(max_length=50)
    telefone = models.CharField(max_length=15)
    situacao = models.BooleanField(default=True)

    def __str__(self):
        return self.cnpj

    def get_absolute_url(self):
        return reverse('cadasrtra_organizacao')