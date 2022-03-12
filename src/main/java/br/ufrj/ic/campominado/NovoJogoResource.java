package br.ufrj.ic.campominado;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("novo-jogo")
public class NovoJogoResource {
    @GET
    public Response app(@QueryParam("tamanho") @DefaultValue("10x10") String tamanho,
                        @QueryParam("dificuldade") @DefaultValue("") String dificuldade,
                        @QueryParam("linha") String linha, // valor default é null
                        @QueryParam("coluna") String coluna, // valor default é null
                        @Context HttpServletRequest request,
                        @Context UriInfo uriInfo) {

        // reseta o estado da aplicação
        int m_tamanho = 0;

        switch (tamanho) {
            case "10x10": m_tamanho = 10; break;
            case "15x15": m_tamanho = 15; break;
            case "20x20": m_tamanho = 20; break;
        }
        int m_dificuldade;
        if (dificuldade.equals("facil")) {
            m_dificuldade = 10;
        } else {
            m_dificuldade = 25;
        }
        //int m_tamanho = Integer.parseInt(tamanho.split("x")[0]);
        //int m_linha = Integer.parseInt(linha);
        //int m_coluna = Integer.parseInt(coluna);
        CommandServlet.reset(m_tamanho, m_dificuldade);

        return Response.status(302).location(
                uriInfo.getBaseUriBuilder().path("continuar")
                        .queryParam("tamanho", request.getParameter("tamanho"))
                        .queryParam("dificuldade", request.getParameter("dificuldade"))
                        //.queryParam("linha", uriInfo.getQueryParameters().getFirst("linha"))
                        //.queryParam("coluna", uriInfo.getQueryParameters().getFirst("coluna"))
                        .build()
        ).build();
    }
}
