package br.ufrj.ic.campominado;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("creditos")
public class CreditosResource {
    @GET
    @Produces("text/plain")
    public String creditos() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    }
}
