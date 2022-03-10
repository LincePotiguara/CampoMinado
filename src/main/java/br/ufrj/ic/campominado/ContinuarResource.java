package br.ufrj.ic.campominado;

import javax.ws.rs.*;
import java.util.Locale;

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

        tabuleiro.append("<div style=\"background-color: blue;display: flex;\">");
        for(int i = 0; i < linha; i++) {
            tabuleiro.append("<div class='quadrado'>#</div>");
            //tabuleiro.append("<td><div class='cell-content'>#</div></td>");
        }
        tabuleiro.append("</div>");
        //String temp = tabuleiro.append("<br>").toString();
        String temp = tabuleiro.toString();
        for(int i = 0; i < linha; i++) {
            tabuleiro.append(temp);
        }
        //tabuleiro.insert(0,"<table id='table-data' cellpadding=0 cellspacing=0>");
        //tabuleiro.append("</table>");
        // Essa função cria o campo. Modifique a classe quadrado e o style inline para mudar o estilo
        // |
        // V
        tabuleiro.insert(0, "<div style=\"display: inline-block;\">");
        tabuleiro.append("</div>");
        return tabuleiro.toString();
    }
}
