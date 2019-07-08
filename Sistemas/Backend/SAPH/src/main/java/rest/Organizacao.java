/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import banco.Persistencia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adelson
 */
@Path("organizacao")
public class Organizacao {

    private String exportarC(modelo.Organizacao organizacao) {
        Persistencia persistencia = new Persistencia();

        for (modelo.Funcionario funcionarios : organizacao.getFuncionarios()) {
            persistencia.cadastrar(funcionarios.getUsuario());
            persistencia.cadastrar(funcionarios);
        }
        for (modelo.Nivel niveis : organizacao.getNiveis()) {
            for (modelo.Setor setores : niveis.getSetores()) {
                persistencia.cadastrar(setores);
            }
            for (modelo.TipoSolicitacaoDelegacao tipoSolicitacoesDelegacoes : niveis.getTipoSolicitacoesDelegacoes()) {
                for (modelo.TipoItem tipoItens : tipoSolicitacoesDelegacoes.getTipoItens()) {
                    for (modelo.TipoCampo tipoCampos : tipoItens.getTipoCampos()) {
                        if (!tipoCampos.equals(persistencia.selecionar(new modelo.TipoCampo(), tipoCampos.getId()))) {
                            persistencia.cadastrar(tipoCampos);
                        }
                    }
                    if (!tipoItens.equals(persistencia.selecionar(new modelo.TipoItem(), tipoItens.getId()))) {
                        persistencia.cadastrar(tipoItens);
                    }
                }
                persistencia.cadastrar(tipoSolicitacoesDelegacoes);
            }
            persistencia.cadastrar(niveis);
        }

        return persistencia.cadastrar(organizacao);
    }

    private String exportarA(modelo.Organizacao organizacao) {
        Persistencia persistencia = new Persistencia();

        for (modelo.Funcionario funcionarios : organizacao.getFuncionarios()) {
            persistencia.atualizar(funcionarios.getUsuario());
            persistencia.atualizar(funcionarios);
        }
        persistencia.atualizar(organizacao.getFuncionarios());
        for (modelo.Nivel niveis : organizacao.getNiveis()) {
            for (modelo.Setor setores : niveis.getSetores()) {
                persistencia.atualizar(setores);
            }
            for (modelo.TipoSolicitacaoDelegacao tipoSolicitacoesDelegacoes : niveis.getTipoSolicitacoesDelegacoes()) {
                for (modelo.TipoItem tipoItens : tipoSolicitacoesDelegacoes.getTipoItens()) {
                    for (modelo.TipoCampo tipoCampos : tipoItens.getTipoCampos()) {
                        if (!tipoCampos.equals(persistencia.selecionar(new modelo.TipoCampo(), tipoCampos.getId()))) {
                            persistencia.atualizar(tipoCampos);
                        }
                    }
                    if (!tipoItens.equals(persistencia.selecionar(new modelo.TipoItem(), tipoItens.getId()))) {
                        persistencia.atualizar(tipoItens);
                    }
                }
                persistencia.atualizar(tipoSolicitacoesDelegacoes);
            }
            persistencia.atualizar(niveis);
        }

        return persistencia.atualizar(organizacao);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("exportar")
    public String exportar(String json) {

        Persistencia persistencia = new Persistencia();
        modelo.Organizacao organizacao = new Gson().fromJson(json.substring(1, json.length() - 1), modelo.Organizacao.class);

        if (persistencia.existe(organizacao, organizacao.getId())) {
            return exportarA(organizacao);
        } else {
            return exportarC(organizacao);
        }

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("configuracao")
    public String configuracao(String json) {
        return new Persistencia().atualizar(new Gson().fromJson(json, modelo.Organizacao.class));
    }
    
    @GET
    @Path("enviado/{id}")
    public boolean getEnviado(@PathParam("id") long id) {
        return new Persistencia().getEnviado(id);
    }
    
    @GET
    @Path("bloquado/{id}")
    public boolean getBloqueado(@PathParam("id") long id) {
        return new Persistencia().getBloqueado(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String cadastrar(String json) {
        return new Persistencia().cadastrar(new Gson().fromJson(json, modelo.Organizacao.class));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("lista")
    public String cadastrarLista(String json) {
//        return new Persistencia().cadastrar((List<Object>) new Gson().fromJson(json, new TypeToken<List<modelo.Organizacao>>() {
//        }.getType()));
        return json;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("situacao")
    public String atualizarSituacao(String json) {
    	modelo.Organizacao  org = new Gson().fromJson(json, modelo.Organizacao.class);
    	org.setSituacao(!org.isSituacao());
    	return new Persistencia().atualizar(org);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("configuracao")
    public String atualizarConfiguracao(String json) {
    	modelo.Organizacao org = new Gson().fromJson(json, modelo.Organizacao.class);
    	org.setPedido(!org.isPedido());
        org.setEnviado(!org.isEnviado());
    	return new Persistencia().atualizar(org);
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String remover(@PathParam("id") long id) {
        return new Persistencia().remover(new modelo.Organizacao(), id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String selecionar() {
        return new Gson().toJson(new Persistencia().selecionar(new modelo.Organizacao()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String selecionar(@PathParam("id") long id) {
        return new Gson().toJson(new Persistencia().selecionar(new modelo.Organizacao(), id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("situacao/{situacao}")
    public String selecionarO(@PathParam("situacao") boolean situacao) {
        return new Gson().toJson(new Persistencia().getOrganizacaoByStatus(situacao));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("pedido/{pedido}")
    public String selecionarPedido(@PathParam("pedido") boolean pedido) {
        return new Gson().toJson(new Persistencia().getOrganizacaoByPedido(pedido));
    }

}
