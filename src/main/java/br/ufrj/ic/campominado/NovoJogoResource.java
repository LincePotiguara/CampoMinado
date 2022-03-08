package br.ufrj.ic.campominado;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("novo-jogo")
public class NovoJogoResource {
    @GET
    public Response app(@Context HttpServletRequest request, @Context UriInfo uriInfo) {
        // reseta o estado da aplicação
        CommandServlet.reset();
        return Response.status(302).location(uriInfo.getBaseUriBuilder().path("continuar").build()).build();
    }
}
