package br.ufrj.ic.campominado;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


@Path("teste")
public class TesteResource {
    @GET
    @Produces("text/html")
    public String app(@QueryParam("tamanho") @DefaultValue("") String tamanho,
                        @QueryParam("linha") @DefaultValue("") String linha,
                        @QueryParam("coluna") @DefaultValue("") String coluna,
                        @QueryParam("dificuldade") @DefaultValue("") String dificuldade,
                        @QueryParam("tes") @DefaultValue("") String tes,
                        @Context UriInfo uriInfo,
                        @Context HttpServletRequest request,
                        @Context HttpServletResponse response) {
        // reseta o estado da aplicação
        //CommandServlet.reset();

        //UriBuilder uu = new UriBuilder() (uriInfo.getBaseUriBuilder().path("continuar"));
        //CommandServlet.reset(in.nextInt());

        String pls = tamanho.split("x")[0];
        /*
        String tam = uriInfo.getBaseUriBuilder().path("continuar")
                .queryParam("tamanho", request.getParameter("tamanho"))
                .queryParam("dificuldade", request.getParameter("dificuldade"))
                .build().toString();

         */
        /*
        response.setStatus(302);
        response.encodeRedirectURL(uriInfo.getBaseUriBuilder().path("continuar").build().toString());

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //pls = tamanho + linha + coluna;
        response.getWriter().println(tamanho);
        response.getWriter().println(linha);
        response.getWriter().println(coluna);
        response.getWriter().println(dificuldade);

        response.getWriter().flush();
        */
        //return Response.status(200).build();
        return pls;
    }

    /*
    public void app(@Context HttpServletRequest request,
                        @Context HttpServletResponse response,
                        @Context UriInfo uriInfo) throws IOException {
        // reseta o estado da aplicação
        CommandServlet.reset();

        //UriBuilder uu = new UriBuilder() (uriInfo.getBaseUriBuilder().path("continuar"));

        String pls = "Hellooooo";
        String tam = uriInfo.getBaseUriBuilder().path("continuar")
                        .queryParam("tamanho", request.getParameter("tamanho"))
                        .queryParam("dificuldade", request.getParameter("dificuldade"))
                                .build().toString();
        response.setStatus(200);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(tam);
        response.getWriter().flush();
        //return Response.status(200).build();
    }
     */
}
