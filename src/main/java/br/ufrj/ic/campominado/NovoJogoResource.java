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
    public Response app(@QueryParam("tamanho") @DefaultValue("") String tamanho,
                        @QueryParam("dificuldade") @DefaultValue("") String dificuldade,
                        @QueryParam("linha") String linha, // valor default é null
                        @QueryParam("coluna") String coluna, // valor default é null
                        @Context HttpServletRequest request,
                        @Context UriInfo uriInfo) {

        // reseta o estado da aplicação
        int m_tamanho = Integer.parseInt(tamanho.split("x")[0]);
        //int m_linha = Integer.parseInt(linha);
        //int m_coluna = Integer.parseInt(coluna);
        CommandServlet.reset(m_tamanho);

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
