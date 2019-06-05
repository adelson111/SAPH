/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @Path("buscarF")
    public String getNomes() {
        return "Meu nome fun funcionario é: ";
    }
}
