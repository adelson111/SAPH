from django.db import models

# Create your models here.
class Setor(models.Model):
    nome = models.CharField(max_length=20)

    def __str__(self):
        return self.nome

    class Meta:
        verbose_name_plural = 'Setores'