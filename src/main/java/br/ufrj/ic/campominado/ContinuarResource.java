package br.ufrj.ic.campominado;

import javax.ws.rs.*;

import static java.lang.String.valueOf;


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

        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Todo: debug

        tabuleiro.append("<div style=\"display: flex;\">");

        for(int i = 0; i < linha; i++) {
            String temp = "<a onclick=\"ApiResponse('continuar', '$letra$numero')\"><div id='$letra$numero'class='quadrado'>$letra$numero</div></a>".replace(
                    "$numero", valueOf(i));
            tabuleiro.append(temp);
        }
        tabuleiro.append("</div>");
        String temp = tabuleiro.toString();
        String template = tabuleiro.toString();
        tabuleiro = new StringBuilder();
        for(int i = 0; i < linha; i++) {
            String temp2 = temp.replace(
                    "$letra", valueOf(alfabeto.charAt(i)));
            tabuleiro.append(temp2);
        }
        // Essa função cria o campo. Modifique a classe quadrado e o style inline para mudar o estilo
        // |
        // V
        tabuleiro.insert(0, "<div style=\"display: inline-block;\">");
        tabuleiro.append("</div>");
        return tabuleiro.toString();
    }
}
