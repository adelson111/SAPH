/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Dao.OrganizacaoDao;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "Eu sou Organizacao";
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("cadastrar/{organizacao}")
    public String cadastrar(@PathParam("organizacao") Modelo.Organizacao organizacao) {
        new OrganizacaoDao().salvar(organizacao);
        return "Eu sou Organizacao";
    }
}
