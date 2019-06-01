/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.GET;
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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultar/{nome}")
    public String getNome(@PathParam("nome") String nome) {
        return "Meu nome é: "+nome;
    }
}
