/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

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
    public String getSolicitacoes() {
    	List solicitacoes = new ArrayList();
    	ArrayList<modelo.Item> itens = new ArrayList();
    	ArrayList<modelo.Campo> campos = new ArrayList();
    	for(int i=0; i<10;i++) {
    		campos.add(new modelo.Campo("Campo"+i, "campo descricao", "text"));
    		modelo.Item it = new modelo.Item("item-"+i);
    		it.setCampo(campos);
    		itens.add(it);
    		modelo.Solicitacao s = new modelo.Solicitacao("Tipo-"+i,"descrição-"+i,"ativo");
    		s.setItem(itens);
    		solicitacoes.add(s);
    	}
        return new Gson().toJson(solicitacoes);
    }
}
