from django.db import models

# Create your models here.
class Setor(models.Model):
    nome = models.CharField(max_length=20)

    def __str__(self):
        return self.nome

    class Meta:
        verbose_name_plural = 'Setores'

class Funcionario(models.Model):
    nome = models.CharField(max_length=80)
    email = models.EmailField(max_length=80)
    senha = models.CharField(max_length=15)
    cpf = models.CharField(max_length=14)
    cargo = models.CharField(max_length=10)
    endereco = models.CharField(max_length=10)
    telefone = models.CharField(max_length=10)
    setor = models.ForeignKey(Setor,on_delete=models.CASCADE, null=True)

    status = models.BooleanField(default=True)
    def __str__(self):
        return self.nome



