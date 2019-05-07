from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class Funcionario(models.Model):
    nome = models.CharField(max_length=80)
    email = models.EmailField(max_length=80)
    senha = models.CharField(max_length=15)
    cpf = models.CharField(max_length=14)
    cargo = models.CharField(max_length=10)
    endereco = models.CharField(max_length=10)
    telefone = models.CharField(max_length=10)
    status = models.BooleanField(default=True)
    user = models.OneToOneField(User, on_delete=models.CASCADE)

    def __str__(self):
        return self.nome
