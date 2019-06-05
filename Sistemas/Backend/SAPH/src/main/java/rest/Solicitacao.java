/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import Dao.OrganizacaoDao;

//import com.google.gson.Gson;

import modelo.TipoCampo;
import modelo.TipoItem;
import modelo.TipoSolicitacaoDelegacao;



/**
 *
 * @author adelson
 */
@Path("solicitacao")
public class Solicitacao {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "Eu sou Solicitação";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
    public String getTiposSolicitacoes() {
    	List<TipoSolicitacaoDelegacao> solicitacoes = new ArrayList<TipoSolicitacaoDelegacao>();
    	List<TipoItem> itens = new ArrayList<TipoItem>();
    	List<TipoCampo> campos = new ArrayList<TipoCampo>();																																																																												
    	for(int i=0; i<5;i++) {
    		campos.add(new TipoCampo(i,"Campo"+i, "campo descricao", "text"));
    		TipoItem it = new TipoItem(i,"item-"+i);
    		it.setCampo(campos);
    		itens.add(it);
    		TipoSolicitacaoDelegacao s = new TipoSolicitacaoDelegacao(i,"Tipo-"+i,"descrição-"+i,"ativo");
    		s.setItens(itens);
    		solicitacoes.add(s);
    	}
    	System.out.println(cadastrar("oi"));
        return new Gson().toJson(solicitacoes);
    }
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("cadastrar")
    public String cadastrar(String solicitacao) {
    	
    	//modelo.SolicitacaoDelegacao soli = new Gson().fromJson(solicitacao, modelo.SolicitacaoDelegacao.class);
    	//System.out.println(soli);
        return solicitacao;
    }
}
