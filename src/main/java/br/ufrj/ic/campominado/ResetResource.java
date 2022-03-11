package br.ufrj.ic.campominado;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Scanner;


@Path("reset")
public class ResetResource {
    @GET
    public Response app(@QueryParam("tamanho") @DefaultValue("") String tamanho,
                        @QueryParam("linha") @DefaultValue("") String linha,
                        @QueryParam("coluna") @DefaultValue("") String coluna,
                        @QueryParam("dificuldade") @DefaultValue("") String dificuldade,
                        @Context HttpServletRequest request,
                        @Context UriInfo uriInfo) {

        // reseta o estado da aplicação
        int m_tamanho = Integer.parseInt(tamanho.split("x")[0]);
        int m_linha = Integer.parseInt(linha);
        int m_coluna = Integer.parseInt(coluna);
        CommandServlet.reset(m_tamanho);

        return Response.status(302).location(
                uriInfo.getBaseUriBuilder().path("continuar")
                        .queryParam("tamanho", request.getParameter("tamanho"))
                        .queryParam("dificuldade", request.getParameter("dificuldade"))
                        .queryParam("linha", request.getParameter("linha"))
                        .queryParam("coluna", request.getParameter("coluna"))
                        .build()
        ).build();
    }
}
