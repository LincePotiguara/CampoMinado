package br.ufrj.ic.campominado;

import javax.ws.rs.*;

import java.util.Arrays;

import static java.lang.String.valueOf;


@Path("continuar")
public class ContinuarResource {
    @GET
    @Produces("text/html")
    public String tabuleiro(@QueryParam("tamanho") @DefaultValue("") String tamanho,
                            @QueryParam("linha") @DefaultValue("") String linha,
                            @QueryParam("coluna") @DefaultValue("") String coluna) {
        StringBuilder tabuleiro = new StringBuilder();
        String[] l1 = tamanho.split(":");
        tamanho = l1[0];
        if(l1.length > 1){
            linha = l1[1].split("=")[1];
            coluna = l1[2].split("=")[1];
        }

        int tamanhoTabuleiro = 0;
        switch (tamanho) {
            case "10x10": tamanhoTabuleiro = 10; break;
            case "15x15": tamanhoTabuleiro = 15; break;
            case "20x20": tamanhoTabuleiro = 20; break;
        }

        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Todo: debug

        tabuleiro.append("<div style=\"display: flex;\">");

        for(int i = 0; i < tamanhoTabuleiro; i++) {
            String temp = "<a onclick=\"ApiResponse('jogando', '$tamanho', '$letra', '$numero')\"><div id='$letra$numero'class='quadrado'>$letra$numero</div></a>".replace(
                    "$numero", valueOf(i)).replace("$tamanho", tamanho);
            tabuleiro.append(temp);
        }
        tabuleiro.append("</div>");
        String temp = tabuleiro.toString();
        String template = tabuleiro.toString();
        tabuleiro = new StringBuilder();
        for(int i = 0; i < tamanhoTabuleiro; i++) {
            String temp2 = temp.replace(
                    "$letra", valueOf(i));
            tabuleiro.append(temp2);
        }
        // Essa função cria o campo. Modifique a classe quadrado e o style inline para mudar o estilo
        // |
        // V
        tabuleiro.insert(0, "<div style=\"display: inline-block;\">");
        tabuleiro.append("</div>");

        //linha = l1[1].split("=")
        String[] ret;
        /*
        if(l1.length > 1){
         ret = l1[1].split("=");
            String s = linha +" + " + coluna;
            return s;
        }*/
        String s = tamanho + "=" + linha +" + " + coluna;
        return tabuleiro.toString() + "-" + s;
    }
}
