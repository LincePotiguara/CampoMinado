package br.ufrj.ic.campominado;

import javax.ws.rs.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@ApplicationPath("/api")
@Path("hello")
public class CommandServlet {
    public static int[][] matriz;
    public static void reset() {
        val = "";
        matriz = new int[10][10];
    }

    public static String initMatriz() {
        return val;
    }

    public static String printMatrix() {
        return "";
    }

    private static String val = "";
    @GET
    @Produces("text/plain")
    public String doGet(@QueryParam("value") @DefaultValue("") String param) {
        val = val + param;
        return val;
    }

    public void destroy() {
    }
}