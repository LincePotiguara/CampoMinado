package br.ufrj.ic.campominado;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import static java.lang.String.valueOf;


@Path("continuar")
public class ContinuarResource {
    @GET
    @Produces("text/html")
    public String tabuleiro(@QueryParam("tamanho") @DefaultValue("") String tamanho,
                            @QueryParam("dificuldade") @DefaultValue("") String dificuldade,
                            @QueryParam("linha") String linha,
                            @QueryParam("coluna") String coluna,
                            @Context UriInfo uriInfo
                            ) {
        StringBuilder tabuleiro = new StringBuilder();
        linha = uriInfo.getQueryParameters().getFirst("linha");
        coluna = uriInfo.getQueryParameters().getFirst("coluna");

        int tamanhoTabuleiro = 0;

        switch (tamanho) {
            case "10x10": tamanhoTabuleiro = 10; break;
            case "15x15": tamanhoTabuleiro = 15; break;
            case "20x20": tamanhoTabuleiro = 20; break;
        }
        int m_linha;
        int m_coluna;

            if (linha != null && coluna != null) {
                try {
                m_coluna = Integer.parseInt(coluna);
                m_linha = Integer.parseInt(linha);
                CommandServlet.clique(m_linha, m_coluna);
                } catch (NumberFormatException e){
                    return String.format("Numeros invalidos {%s : %s}", linha, coluna);
                }
            }

        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        tabuleiro.append("<div style=\"display: flex;\">");
        if (tamanhoTabuleiro == 0) {tamanhoTabuleiro = CommandServlet.tamanhoMatriz;}
        for(int i = 0; i < tamanhoTabuleiro; i++) {
            String temp = "<a onclick=\"ApiResponse('continuar', '$tamanho','$dificuldade', '$linha', '$coluna')\"><div id='$linha$coluna'class='quadrado'>#caractere</div></a>".replace(
                    "$coluna", valueOf(i))
                    .replace("$tamanho", tamanho)
                    .replace("$dificuldade", dificuldade);
            tabuleiro.append(temp);
        }
        tabuleiro.append("</div>");
        String template = tabuleiro.toString();

        tabuleiro = new StringBuilder();
        for(int i = 0; i < tamanhoTabuleiro; i++) {
            String temp = template.replace(
                    "$linha", valueOf(i));
            tabuleiro.append(temp);
        }
        // Essa função cria o campo. Modifique a classe quadrado e o style inline para mudar o estilo
        // |
        // V
        tabuleiro.insert(0, "<div style=\"display: inline-block;\">");
        tabuleiro.append("</div>");

        String s = tamanho +" {"+ linha +" : " + coluna + "} - " + dificuldade;
        String resposta = tabuleiro.toString();

        int[][] campo = CommandServlet.getMatriz();
        if (campo == null){
            return resposta + "Campo eh null " + s;
        }

        for (int i = 0; i < tamanhoTabuleiro; i++) {
            for (int j = 0; j < tamanhoTabuleiro; j++) {
                resposta = resposta.replaceFirst("#caractere", String.valueOf(campo[i][j]));
            }
        }
        return resposta + s + " Ok";
    }
}
