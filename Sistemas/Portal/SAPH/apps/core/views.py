import json

from django.contrib.auth.mixins import LoginRequiredMixin
from django.contrib.auth.models import User
from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.
from django.views import View
from pip._vendor import requests

from apps.funcionario.models import Funcionario
from apps.nivel.models import Nivel
from apps.organizacao.models import Organizacao
from apps.setor.models import Setor


class MyHome(View):
	def get(self, request, *args, **kwargs):
		return render(request, 'core/home.html')

class Exportar(LoginRequiredMixin, View) :

	def get(self, request):
		#Usuário
		usuarios = User.objects.all()
		lUsuario = []
		for usuario in usuarios:
			dicUsuario = {
				'id': usuario.pk,
				'email': usuario.username,
				'senha': usuario.password
			}
			lUsuario.append(dicUsuario)

		# Organização
		organizacoes = Organizacao.objects.values()
		lOrganizacao = []
		for organizacao in organizacoes:
			lOrganizacao.append(organizacao)

		# Funcionário
		funcionarios = Funcionario.objects.values('id', 'nome', 'cpf', 'cargo', 'endereco', 'telefone', 'ativo', 'foto', 'user_id')
		lFuncionario = []
		organizacao = self.request.user.funcionario.organizacao.pk
		for funcionario in funcionarios:
			dicFuncionario = {
				'id': funcionario['id'],
				'ativo': funcionario['ativo'],
				'cargo': funcionario['cargo'],
				'cpf': funcionario['cpf'],
				'endereco': funcionario['endereco'],
				'foto': funcionario['foto'],
				'nome': funcionario['nome'],
				'telefone': funcionario['telefone'],
				'organizacao': {
					'id': organizacao},
				'usuario': {
					'id': funcionario['user_id']}
			}
			lFuncionario.append(dicFuncionario)

		# Nível
		niveis = Nivel.objects.values('id', 'nome', 'nivelSuperior', 'nivelInferior', 'funcionario', 'organizacao')
		lNivel = []
		for setor in niveis:
			dicNivel = {
				'id': setor['id'],
				'nome': setor['nome'],
				'nivelSuperior': setor['nivelSuperior'],
				'nivelInferior': setor['nivelInferior'],
				'responsavel': {
					'id': setor['funcionario']},
				'organizacao': {
					'id': setor['organizacao']}
			}
			lNivel.append(dicNivel)

		# Setor
		setores = Setor.objects.values('id', 'nome', 'funcionario', 'nivel', 'gerente')
		lSetor = []
		for setor in setores:
			dicSetor = {
				'id': setor['id'],
				'nome': setor['nome'],
				'funcionario': {
					'id': setor['funcionario']},
				'gerente': {
					'id': setor['gerente']},
				'nivel': {
					'id': setor['nivel']}
			}
			lSetor.append(dicSetor)

		# Envio das requests
		respUsuario = requests.post(url='http://localhost:8080/SAPH/saph/usuario/lista/',
									data=json.dumps(lUsuario),
									headers={'content-type': 'application/json'})
		if (respUsuario.status_code == 200 or respUsuario.status_code == 201):
			respOrganizacao = requests.post(url='http://localhost:8080/SAPH/saph/organizacao/lista/',
											data=json.dumps(lOrganizacao),
											headers={'content-type': 'application/json'})
			if (respOrganizacao.status_code == 200 or respOrganizacao.status_code == 201):
				respFuncionario = requests.post(url='http://localhost:8080/SAPH/saph/funcionario/lista/',
												data=json.dumps(lFuncionario),
												headers={'content-type': 'application/json'})
				if (respFuncionario.status_code == 200 or respFuncionario.status_code == 201):
					respNivel = requests.post(url='http://localhost:8080/SAPH/saph/nivel/lista/',
										 data=json.dumps(lNivel),
										 headers={'content-type': 'application/json'})

					if (respNivel.status_code == 200 or respNivel.status_code == 201):
						'''respSetor = requests.post(url='http://localhost:8080/SAPH/saph/setor/lista/',
												  data=json.dumps(lSetor[0]),
												  headers={'content-type': 'application/json'})

						if (respSetor.status_code == 200 or respSetor.status_code == 201):
							return HttpResponse("DEU TUDO CERTO")
						else:
							return HttpResponse("ERRO SETOR")'''
						return HttpResponse("sim")
					else:
						return HttpResponse("ERRO NÍVEL")
				else:
					return HttpResponse("ERRO FUNCIONÁRIO")
			else:
				return HttpResponse("ERRO ORGANOGRAMA")
		else:
			return HttpResponse("ERRO USUÁRIO")
