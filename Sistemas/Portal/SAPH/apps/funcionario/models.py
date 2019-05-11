from django.db import models
from django.contrib.auth.models import User
from django.urls import reverse

# Create your models here.

class Funcionario(models.Model):
    nome = models.CharField(max_length=80)
    email = models.EmailField(max_length=80)
    senha = models.CharField(max_length=15)
    cpf = models.CharField(max_length=14)
    cargo = models.CharField(max_length=15)
    endereco = models.CharField(max_length=100)
    telefone = models.CharField(max_length=10)
    ativo = models.BooleanField(default=True)
    foto = models.ImageField(upload_to='funcionarios/funcionarios_fotos', null=True, blank=True)
    user = models.OneToOneField(User, on_delete=models.CASCADE, null=True, blank=True)

    def __str__(self):
        return self.nome

    def get_absolute_url(self):
        return reverse('cadasrtrar_funcionario')
