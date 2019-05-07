from django.db import models

# Create your models here.

class Organizacao(models.Model):
    nome = models.CharField(max_length=80)
    cnpj = models.CharField(max_length=15)
    endereco = models.CharField(max_length=50)
    telefone = models.CharField(max_length=15)

    def __str__(self):
        return self.cnpj