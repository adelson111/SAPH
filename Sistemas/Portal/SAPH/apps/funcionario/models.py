from django.db import models
from django.contrib.auth.models import User
from django.shortcuts import redirect, render
from django.urls import reverse, reverse_lazy
from django.template.loader import render_to_string
from django.core.mail import send_mail
from apps.organizacao.models import Organizacao
# Create your models here.



class Funcionario(models.Model):
    nome = models.CharField(max_length=80, null=True)
    email = models.EmailField(max_length=80, null=True)
    senha = models.CharField(max_length=65, null=True)
    cpf = models.CharField(max_length=15, null=True)
    cargo = models.CharField(max_length=30, null=True)
    endereco = models.CharField(max_length=100, null=True)
    telefone = models.CharField(max_length=17, null=True)
    ativo = models.BooleanField(default=True)
    foto = models.ImageField(upload_to='media/funcionario', null=True, blank=True)
    user = models.OneToOneField(User, on_delete=models.CASCADE, null=True, blank=True)
    organizacao = models.ForeignKey(Organizacao, on_delete=models.CASCADE, null=True, blank=True, related_name="organizacao")

    def __str__(self):
        return self.email

    def get_absolute_url(self):
        if(self.nome==None):
            return reverse('page_home')
        elif(self.nome!=None and self.cpf!=None):
            # return reverse('cadasrtrar_funcionario')
            return reverse_lazy('page_home')
        return reverse('page_home')

    def save(self, *args, **kwargs):
        super(Funcionario, self).save(*args, **kwargs)
        if(self.nome==None):
            data = {'pk': self.pk, 'email': self.email}
            # plain_text = render_to_string('clientes/email/novo_aluno.txt', data)
            html_email = render_to_string('funcionario/email/func_novo.html', data)
            # if not self.status:
            send_mail(
                'Novo Cliente Cadastrado',
                #'O seu pre-cadastro %s foi realizado' % self.first_name,
                # plain_text,
                from_email='teste@msdevelopment.com.br',
                message='sasas',
                recipient_list=[self.email],
                html_message=html_email,
                fail_silently=False,
                )
