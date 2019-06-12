/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saph;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author adelson
 */
@ApplicationPath("saph")
public class Conf extends ResourceConfig {
    public Conf() {
        packages("rest");
    }
}
