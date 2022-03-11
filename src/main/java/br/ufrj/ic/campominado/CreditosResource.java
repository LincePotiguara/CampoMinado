package br.ufrj.ic.campominado;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("creditos")
public class CreditosResource {
    @GET
    @Produces("text/html")
    public String creditos() {
        return "<center>"
                + "<p><h2>Créditos</h2></p>"
                + "<p><h3>Alunos</h3></p>"
                + "<p>Camila Lacerda<br>"
                + "Douglas Lima<br>"
                + "Gabriel Quintela<br>"
                + "Julia Lopes<br></p>"
                +"</center>";
    }
}
