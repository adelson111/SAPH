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

/**
 *
 * @author adelson
 */
@Path("tipo-solicitacao-delegacao")
public class TipoSolicitacaoDelegacao {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String cadastrar(String json) {
        new Persistencia().cadastrar(new Gson().fromJson(json, modelo.TipoSolicitacaoDelegacao.class));
        return "Cadastrado com sucesso!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("lista")
    public String cadastrarLista(String json) {
        new Persistencia().cadastrar((List<Object>) new Gson().fromJson(json, new TypeToken<List<modelo.TipoSolicitacaoDelegacao>>(){}.getType()));
        return "Cadastrado com sucesso!";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String atualizar(String json) {
        new Persistencia().atualizar(new Gson().fromJson(json, modelo.TipoSolicitacaoDelegacao.class));
        return "Atualizado com sucesso!";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String remover(@PathParam("id") long id) {
        new Persistencia().remover(new modelo.TipoSolicitacaoDelegacao(), id);
        return "Removido com sucesso!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String selecionar() {
        //return new Gson().toJson(new Persistencia().selecionar(new modelo.TipoSolicitacaoDelegacao()));

        System.out.println("Campo");
        TipoCampo tipoCampo = new TipoCampo();
        tipoCampo.setId(1);
        tipoCampo.setNome("Campo 1");
        tipoCampo.setDescricao("Descrição do campo 1");
        tipoCampo.setTipo(tipo.TipoCampo.TEXTO);
        List<TipoCampo> campos = new ArrayList<>();
        campos.add(tipoCampo);
        
        System.out.println("Tipo");
        TipoItem tipoItem = new TipoItem();
        tipoItem.setId(1);
        tipoItem.setNome("Item 1");
        tipoItem.setTipoCampo(campos);
        List<TipoItem> items = new ArrayList<>();
        items.add(tipoItem);
        
        System.out.println("Solicitação");
        modelo.TipoSolicitacaoDelegacao tipoSolicitacaoDelegacao = new modelo.TipoSolicitacaoDelegacao();
        tipoSolicitacaoDelegacao.setId(1);
        tipoSolicitacaoDelegacao.setNome("Compra");
        tipoSolicitacaoDelegacao.setDescricao("Compra de mouse");
        tipoSolicitacaoDelegacao.setTipo(tipo.TipoSolicitacaoDelegacao.SOLICITACAO);
        tipoSolicitacaoDelegacao.setTipoItem(items);
        System.out.println("Vai retornar");
        return new Gson().toJson(tipoSolicitacaoDelegacao);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String selecionar(@PathParam("id") long id) {
        return new Gson().toJson(new Persistencia().selecionar(new modelo.TipoSolicitacaoDelegacao(), id));
    }

}
