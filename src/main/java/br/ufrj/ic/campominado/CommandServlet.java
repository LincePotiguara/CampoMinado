package br.ufrj.ic.campominado;

import javax.ws.rs.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@ApplicationPath("/api")
@Path("hello")
public class CommandServlet {
    public static int[][] matriz;
    public static int tamanhoMatriz;
    public static void reset(int tamanho) {
        tamanhoMatriz = tamanho;
        matriz = initMatriz(tamanho);
    }

    public static int[][] initMatriz(int tamanho) {
        matriz = new int[tamanho][tamanho];
        for(int i = 0; i < tamanho; i++) {
            for(int j = 0; j < tamanho; j++) {
                matriz[i][j] = 10*i + j;
            }
        }
        return matriz;
    }

    public static int[][] getMatriz() {
        return matriz;
    }

    public static void clique(int linha, int coluna) {
        if(linha < tamanhoMatriz && coluna < tamanhoMatriz ) {
            matriz[linha][coluna] = 0;
        }
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