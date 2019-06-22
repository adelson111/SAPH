import json

from django.contrib.auth.mixins import LoginRequiredMixin
from django.db.models import Prefetch
from django.forms import model_to_dict
from django.http import HttpResponse
from django.shortcuts import render, get_object_or_404

# Create your views here.
from django.views import View
from django.views.generic import CreateView, UpdateView, ListView
from pip._vendor import requests

from apps.funcionario.models import Funcionario
from apps.nivel.models import Nivel
from apps.organizacao.forms import OrganizacaoCadastra
from apps.setor.models import Setor
from apps.item.models import Item
from apps.solicitacao.models import Solicitacao
from .models import Organizacao

class CadastrarOrganizacao(LoginRequiredMixin, CreateView):
    model = Organizacao
    #fields = ['nome', 'cnpj', 'endereco', 'telefone']
    form_class = OrganizacaoCadastra

    def form_valid(self, form):
        organizacao = form.save(commit=False)
        organizacao.save()
        # identificador = organizacao.pk
        # funcionario = Funcionario.objects.filter(pk=self.request.user.funcionario.pk)
        funcionario = get_object_or_404(Funcionario, pk=self.request.user.funcionario.pk)
        funcionario.organizacao = organizacao

        funcionario.save()

        return super(CadastrarOrganizacao, self).form_valid(form)


class AtualizarOrganizacao(LoginRequiredMixin, UpdateView):
    model = Organizacao
    fields = ['nome', 'cnpj', 'endereco', 'telefone']

    def get_queryset(self):
        return Organizacao.objects.filter(pk=self.kwargs['pk'])

    template_name_suffix = '_update_form'

class ListarOrganizacao(LoginRequiredMixin, ListView):
    model = Organizacao

    def get_queryset(self):
        return Organizacao.objects.all()


class SubirOrganizacao(LoginRequiredMixin, View):

    def get(self, request):
        organizacoes = Organizacao.objects.filter(pk=request.user.funcionario.organizacao.pk).values()
        # funcionairos = Funcionario.objects.select_related('organizacao')
        funcionairos = Funcionario.objects.filter(organizacao=self.request.user.funcionario.organizacao)
        # niveis = Nivel.objects.values('id', 'nome', 'nivelSuperior', 'nivelInferior', 'funcionario')
        niveis = Nivel.objects.filter(organizacao=self.request.user.funcionario.organizacao)
        setores = Setor.objects.select_related('nivel').filter(nivel__organizacao=self.request.user.funcionario.organizacao)



            # objects.filter(pk=request.user.funcionario.organizacao.pk).values()

        lOrganizacao= []
        lOrganizacao1= []
        lFuncionarios = []
        lNiveis = []

        # lSetores = []
        organizacaoDic = {}

        for organizacao in organizacoes:
            # lOrganizacao1.append(organizacao)
            organizacaoDic  = {
                'id' : organizacao['id'],
                'nome' : organizacao['nome'],
                'cnpj' : organizacao['cnpj'],
                'endereco' : organizacao['endereco'],
                'telefone' : organizacao['telefone'],
                'situacao' : organizacao['situacao'],
            }

        for funcionario in funcionairos:
            dic = {
                'id': funcionario.pk,
                'ativo': funcionario.ativo,
                'cargo': funcionario.cargo,
                'cpf': funcionario.cpf,
                'endereco': funcionario.endereco,
                ##PODE DA ERRO NA IMAGEM
                'foto': funcionario.foto,
                'nome': funcionario.nome,
                'telefone': funcionario.telefone,
                'usuario': {
                    'id': funcionario.user.pk,
                    'email': funcionario.user.email,
                    'senha': funcionario.user.password
                }
            }
            lFuncionarios.append(dic)
        for nivel in niveis.values():
            nivelsuperior = nivel['nivelSuperior_id']
            nivelinfeiror = nivel['nivelInferior_id']
            if(nivel['nivelSuperior_id'] == None):
                nivelsuperior = ''
            if(nivel['nivelInferior_id'] == None):
                nivelinfeiror = ''
            if(nivel['nivelSuperior_id'] == None and nivel['nivelInferior_id'] == None):
                nivelsuperior = ''
                nivelinfeiror = ''

            setoresnivel = Setor.objects.select_related('nivel').filter(
                nivel__organizacao=self.request.user.funcionario.organizacao, nivel__pk=nivel['id'])
            lSetores = []
            for setor in setoresnivel.values():
                funcionarios = Funcionario.objects.filter(setor__pk=setor['id'])
                lfunc = []
                for func in funcionarios:
                    dic = {
                        'id': func.pk
                    }
                    lfunc.append(dic)

                dicSetor1 = {
                    'id': setor['id'],
                    'gerente': setor['gerente_id'],
                    'nivel': setor['nivel_id'],
                    'nome': setor['nome'],
                    'funcionario': lfunc
                }
                lSetores.append(dicSetor1)
            solicitacoes = Solicitacao.objects.prefetch_related('nivel').filter(nivel__id=nivel['id'])
            lSocilitacoes = []
            for solicitacao in solicitacoes:
                lisa = []
                for sol in solicitacao.itens.values('id', 'nome'):

                    dicitenssolicitacao = {
                        'id':sol['id'],
                        'nome':sol['nome'],
                    }
                    lisa.append(dicitenssolicitacao)
                dic = {
                    'id': solicitacao.pk,
                    'nome': solicitacao.tipo,
                    'descricao': solicitacao.descricao,
                    'tipo': 'SOLICITACAO',
                    # 'tipoItem': list(solicitacao.itens.values('id', 'nome'))
                    'tipoItem': lisa

                        # 'tipoCampo': list(solicitacao.itens.prefetch_related('campus').values())


                }

                lSocilitacoes.append(dic)


            dic = {
                'id': nivel['id'],
                'nome': nivel['nome'],
                'nivelSuperior': nivelsuperior,
                'nivelInferior': nivelinfeiror,
                'responsavel': {
                    'id': nivel['funcionario_id']},
                'setores': lSetores,
                'tipoSolicitacaoDelegacao': lSocilitacoes
            }
            lNiveis.append(dic)
            # solicitacoes = Solicitacao.objects.prefetch_related('nivel').filter(nivel__id=nivel['id'])
            # for solicitacao in solicitacoes:
            #
            #     dic = {
            #         'id':solicitacao.pk,
            #         'nome': solicitacao.tipo,
            #         'descricao': solicitacao.descricao,
            #         'tipo': 'SOLICITACAO',
            #         'itens': list(solicitacao.itens.values('id','nome'))
            #     }
            #     lSocilitacoes.append(dic)


        # FUNCIONARIOS
        dicfuncionario = {'funcionarios': lFuncionarios}
        #NIVELS
        dicNivel = {'niveis': lNiveis}

        organizacaoDic['funcionarios'] = dicfuncionario
        organizacaoDic['niveis'] = dicNivel



        lOrganizacao1.append(organizacaoDic)
        a = 0
        # resp = requests.post(url='http://localhost:8080/SAPH/saph/organizacao/lista/',
        #                      data=json.dumps(lOrganizacao),
        #                      headers={'content-type': 'application/json'})
        #
        # if(resp.status_code==200 or resp.status_code==201):
        #     return HttpResponse("ESSA MIZERA DEU CERTO")
        # else:
        #     return HttpResponse("ESSA MIZERA DEU ERRADO")
        return HttpResponse(lOrganizacao1)

