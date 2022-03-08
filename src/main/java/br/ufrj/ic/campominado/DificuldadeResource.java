package br.ufrj.ic.campominado;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("dificuldade")
public class DificuldadeResource {
    @GET
    @Produces("text/html")
    public String dificuldade() {
        return "Fácil (10%)</br>" +
                "Difícil (25%)";
    }
}
