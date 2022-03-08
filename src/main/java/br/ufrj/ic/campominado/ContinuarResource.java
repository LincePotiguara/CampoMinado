package br.ufrj.ic.campominado;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("continuar")
public class ContinuarResource {
    @GET
    @Produces("text/html")
    public String tabuleiro() {
        return "#########<br>" +
                "#########<br>"+
                "#########<br>"+
                "#########<br>";
    }
}
