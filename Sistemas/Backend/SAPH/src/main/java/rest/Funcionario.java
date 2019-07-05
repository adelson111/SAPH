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
@Path("funcionario")
public class Funcionario {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String cadastrar(String json) {
        return new Persistencia().cadastrar(new Gson().fromJson(json, modelo.Funcionario.class));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("lista")
    public String cadastrarLista(String json) {
        return new Persistencia().cadastrar((List<Object>) new Gson().fromJson(json, new TypeToken<List<modelo.Funcionario>>() {
        }.getType()));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String atualizar(String json) {
        return new Persistencia().atualizar(new Gson().fromJson(json, modelo.Funcionario.class));
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String remover(@PathParam("id") long id) {
        return new Persistencia().remover(new modelo.Funcionario(), id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String selecionar() {
        return new Gson().toJson(new Persistencia().selecionar(new modelo.Funcionario()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String selecionar(@PathParam("id") long id) {
        return new Gson().toJson(new Persistencia().selecionar(new modelo.Funcionario(), id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ativo/{ativo}")
    public String selecionar(@PathParam("ativo") boolean ativo) {
        return new Gson().toJson(new Persistencia().getFuncionarioByStatus(ativo));
    }
    
}
