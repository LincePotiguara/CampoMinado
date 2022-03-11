package br.ufrj.ic.campominado;

import javax.ws.rs.*;

@Path("dificuldade")
public class DificuldadeResource {
    @GET
    @Produces("text/html")
    public String dificuldade(@QueryParam("tamanho") @DefaultValue("") String tamanho) {
        return "<center>"
                + "<p><h2>Selecione a quantidade de bombas</h2></p>"
                + "<p><a onclick=\"ApiResponse('novo jogo', '" + tamanho + "', 'facil')\" class='hover-text' >Fácil (10%)</a></p>"
                + "<p><a onclick=\"ApiResponse('novo jogo', '" + tamanho + "', 'dificil')\" class='hover-text' >Difícil (25%)</a></p>"
                + "</center>";
    }
}
