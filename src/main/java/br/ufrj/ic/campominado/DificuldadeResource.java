package br.ufrj.ic.campominado;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("dificuldade")
public class DificuldadeResource {
    @GET
    @Produces("text/html")
    public String dificuldade() {
        return "<center>"
                + "<p><h2>Selecione o tamanho do tabuleiro</h2></p>"
                + "<p><a onclick=\"ApiResponse('novo jogo', '10x10')\" class='hover-text' >Pequeno (10x10)</a></p>"
                + "<p><a onclick=\"ApiResponse('novo jogo', '15x15')\" class='hover-text' >Médio (15x15)</a></p>"
                + "<p><a onclick=\"ApiResponse('novo jogo', '20x20')\" class='hover-text' >Grande (20x20)</a></p>"
                + "</center>";
    }
}
