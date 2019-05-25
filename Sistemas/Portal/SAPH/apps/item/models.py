from django.db import models

# Create your models here.
TYPE = [
    ('int', 'Inteiro' ),
    ('double', 'Real' ),
    ('date', 'Data' ),
    ('text', 'Texto'),
    ('file', 'Arquivo'),
]

class Campo(models.Model):
    nome = models.CharField(max_length=100)
    descricao = models.TextField(max_length=300,null=True)
    tipo = models.CharField(
        max_length=6,
        choices= TYPE,
        default='text'
    )
    def __str__(self):
        return self.nome

class Item(models.Model):
    nome = models.CharField(max_length=30)
    campus = models.ManyToManyField(Campo)
    def __str__(self):
        return self.nome