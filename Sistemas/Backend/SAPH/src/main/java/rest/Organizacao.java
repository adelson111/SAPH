/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import banco.Persistencia;
import com.google.gson.Gson;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("exportar")
    public String exportar(String json) {

        Persistencia persistencia = new Persistencia();
        modelo.Organizacao organizacao = new Gson().fromJson(json.substring(1, json.length() - 1), modelo.Organizacao.class);

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

//        return json.substring(1, json.length()-1);
        
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
    public String atualizar(String json) {
        return new Persistencia().atualizar(new Gson().fromJson(json, modelo.Organizacao.class));
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

}
