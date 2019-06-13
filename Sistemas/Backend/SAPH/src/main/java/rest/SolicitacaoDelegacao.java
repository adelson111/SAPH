/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import banco.Persistencia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
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
import modelo.TipoCampo;
import modelo.TipoItem;
import modelo.TipoSolicitacaoDelegacao;

/**
 *
 * @author adelson
 */
@Path("solicitacao-delegacao")
public class SolicitacaoDelegacao {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String cadastrar(String json) {
    	new Persistencia().cadastrar(montarSolicitacaoDelegacao(json));
    	return "Cadastrado com sucesso!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("lista")
    public String cadastrarLista(String json) {
        new Persistencia().cadastrar((List<Object>) new Gson().fromJson(json, new TypeToken<List<modelo.SolicitacaoDelegacao>>() {
        }.getType()));
        return "Cadastrado com sucesso!";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String atualizar(String json) {
        new Persistencia().atualizar(new Gson().fromJson(json, modelo.SolicitacaoDelegacao.class));
        return "Atualizado com sucesso!";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String remover(@PathParam("id") long id) {
        new Persistencia().remover(new modelo.SolicitacaoDelegacao(), id);
        return "Removido com sucesso!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String selecionar() {
        return new Gson().toJson(new Persistencia().selecionar(new modelo.SolicitacaoDelegacao()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String selecionar(@PathParam("id") long id) {
        return new Gson().toJson(new Persistencia().selecionar(new modelo.SolicitacaoDelegacao(), id));
    }
    
    private modelo.SolicitacaoDelegacao montarSolicitacaoDelegacao(String json){
    	System.out.println(json);
    	int i = json.lastIndexOf("tipoSolicitacaoDelegacao");
    	int tipoSolicitacaoDelegacao = Integer.parseInt(String.valueOf(json.charAt(i+27)));
    	char[] replace = json.toCharArray();
    	replace[i+27] = ' ';
    	json = String.valueOf(replace).replace("\" \"", "null");
    	modelo.SolicitacaoDelegacao solicitacaoDelegacao = new Gson().fromJson(json, modelo.SolicitacaoDelegacao.class);
    	Persistencia persistencia = new Persistencia();
    	modelo.TipoSolicitacaoDelegacao tiDelegacao = (TipoSolicitacaoDelegacao) persistencia.selecionar(new modelo.TipoSolicitacaoDelegacao(), tipoSolicitacaoDelegacao);
    	
    	solicitacaoDelegacao.setTipoSolicitacaoDelegacao(tiDelegacao);
    	return solicitacaoDelegacao;
    }
}
