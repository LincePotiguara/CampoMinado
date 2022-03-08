package br.ufrj.ic.campominado;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;


@Path("novo-jogo")
public class NovoJogoResource {
    @GET
    public Response app(@Context HttpServletRequest request, @Context UriInfo uriInfo) {
        // reseta o estado da aplicação
        CommandServlet.reset();
        //UriBuilder uu = new UriBuilder() (uriInfo.getBaseUriBuilder().path("continuar"));

        return Response.status(302).location(
                uriInfo.getBaseUriBuilder().path("continuar")
                        .queryParam("tamanho", request.getParameter("tamanho"))
                        .build()
        ).build();
    }
}
