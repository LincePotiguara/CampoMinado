package br.ufrj.ic.campominado;

import javax.ws.rs.*;

@Path("continuar")
public class ContinuarResource {
    @GET
    @Produces("text/html")
    public String tabuleiro(@QueryParam("tamanho") @DefaultValue("") String tamanho) {
        StringBuilder tabuleiro = new StringBuilder();
        int linha = 0;
        switch (tamanho) {
            case "10x10": linha = 10; break;
            case "15x15": linha = 15; break;
            case "20x20": linha = 20; break;
        }
        for(int i = 0; i < linha; i++) {
            tabuleiro.append("#");
        }
        String temp = tabuleiro.append("<br>").toString();
        for(int i = 0; i < linha; i++) {
            tabuleiro.append(temp);
        }
        return tabuleiro.toString();
    }
}
