package br.ufrj.ic.campominado;

import java.util.Random;

public class CommandServlet {
    public static int[][] matriz;
    public static int[][] matrizInterna;
    public static int tamanhoMatriz;

    public static void reset(int tamanho) {
        tamanhoMatriz = tamanho;
        matriz = initMatriz(tamanho);
        matrizInterna = initMatriz(tamanho);
        montaCampo(10);
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

            if(matrizInterna[linha][coluna] == 100)
            {
                // Todo: game over
            }
            else if(matrizInterna[linha][coluna] == 0)
            {
                imediato(linha, coluna);
            }
            else
            {
                vizinhos(linha, coluna);
            }
        }
    }

    public static void imediato(int i, int j)
    {
        matriz[i][j] = 50;
        if(i != 0)
        {
            matriz[i-1][j] = matrizInterna[i-1][j];
            if(matriz[i-1][j] == 0) matriz[i-1][j] = 50;
            if(j != 0)
            {
                matriz[i-1][j-1] = matrizInterna[i-1][j-1];
                if(matriz[i-1][j-1] == 0) matriz[i-1][j-1] = 50;

            }
        }
        if(i != 9)
        {
            matriz[i+1][j] = matrizInterna[i+1][j];
            if(matriz[i+1][j]==0) matriz[i+1][j] = 50;
            if(j!=9)
            {
                matriz[i+1][j+1] = matrizInterna[i+1][j+1];
                if(matriz[i+1][j+1] == 0) matriz[i+1][j+1] = 50;
            }
        }
        if(j != 0)
        {
            matriz[i][j-1] = matrizInterna[i][j-1];
            if(matriz[i][j-1] == 0) matriz[i][j-1] = 50;
            if(i!=9)
            {
                matriz[i+1][j-1] = matrizInterna[i+1][j-1];
                if(matriz[i+1][j-1] == 0) matriz[i+1][j-1] = 50;
            }
        }
        if(j != 9)
        {
            matriz[i][j+1] = matrizInterna[i][j+1];
            if(matriz[i][j+1] == 0) matriz[i][j+1] = 50;
            if(i!=0)
            {
                matriz[i-1][j+1] = matrizInterna[i-1][j+1];
                if(matriz[i-1][j+1] == 0) matriz[i-1][j+1] = 50;
            }
        }
    }
    public static void vizinhos(int i, int j)
    {
        //Random random = new Random();
        //int x = random.nextInt()%4;
        int x = 1;
        matriz[i][j] = matrizInterna[i][j];

        if(x == 0)
        {
            if(i != 0)
            {
                if(matrizInterna[i-1][j] != 100)
                {
                    matriz[i-1][j] = matrizInterna[i-1][j];
                    if(matriz[i-1][j]==0)  matriz[i-1][j] = 50;
                }
            }
            if(j != 0)
            {
                if(matrizInterna[i][j-1]!=100)
                {
                    matriz[i][j-1] = matrizInterna[i][j-1];
                    if(matriz[i][j-1]==0)  matriz[i][j-1] = 50;
                }

            }
            if(i!=0 && j!=0)
            {
                if(matrizInterna[i-1][j-1]!=100)
                {
                    matriz[i-1][j-1] = matrizInterna[i-1][j-1];
                    if(matriz[i-1][j-1]==0)  matriz[i-1][j-1] = 50;
                }

            }
        }
        else if(x==1)
        {
            if(i!=0)
            {
                if(matrizInterna[i-1][j] != 100)
                {
                    matriz[i-1][j] = matrizInterna[i-1][j];
                    if(matriz[i-1][j]==0)  matriz[i-1][j] = 50;
                }
            }
            if(j!=9)
            {
                if(matrizInterna[i][j+1] != 100)
                {
                    matriz[i][j+1] = matrizInterna[i][j+1];
                    if(matriz[i][j+1]==0)  matriz[i][j+1] = 50;
                }

            }
            if(i!=0 && j!=9)
            {
                if(matrizInterna[i-1][j+1] != 100)
                {
                    matriz[i-1][j+1] = matrizInterna[i-1][j+1];
                    if(matriz[i-1][j+1]==0)  matriz[i-1][j+1] = 50;
                }
            }
        }
        else if(x==2)
        {
            if(i!=9)
            {
                if(matrizInterna[i+1][j] != 100)
                {
                    matriz[i+1][j] = matrizInterna[i+1][j];
                    if(matriz[i+1][j]==0)  matriz[i+1][j] = 50;
                }
            }
            if(j!=9)
            {
                if(matrizInterna[i][j+1] != 100)
                {
                    matriz[i][j+1] = matrizInterna[i][j+1];
                    if(matriz[i][j+1]==0)  matriz[i][j+1] = 50;
                }

            }
            if(i!=9 && j!=9)
            {
                if(matrizInterna[i+1][j+1] != 100)
                {
                    matriz[i+1][j+1] = matrizInterna[i+1][j+1];
                    if(matriz[i+1][j+1]==0)  matriz[i+1][j+1] = 50;
                }
            }
        }
        else
        {
            if(i != 9)
            {
                if(matrizInterna[i+1][j] != 100)
                {
                    matriz[i+1][j] = matrizInterna[i+1][j];
                    if(matriz[i+1][j]==0)  matriz[i+1][j] = 50;
                }
            }
            if(j != 0)
            {
                if(matrizInterna[i][j-1] != 100)
                {
                    matriz[i][j-1] = matrizInterna[i][j-1];
                    if(matriz[i][j-1]==0)  matriz[i][j-1] = 50;
                }

            }
            if(i!=9 && j!=0)
            {
                if(matrizInterna[i+1][j-1] != 100)
                {
                    matriz[i+1][j-1] = matrizInterna[i+1][j-1];
                    if(matriz[i+1][j-1]==0)  matriz[i+1][j-1] = 50;
                }
            }
        }
    }

    public static void minasArredores()
    {
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                int cnt = 0;
                if(matrizInterna[i][j] != 100)
                {

                    if(i != 0)
                    {
                        if(matrizInterna[i-1][j] == 100) cnt++;
                        if(j != 0)
                        {
                            if(matrizInterna[i-1][j-1] == 100) cnt++;
                        }

                    }
                    if(i != 9)
                    {
                        if(matrizInterna[i+1][j] == 100) cnt++;
                        if(j != 9)
                        {
                            if(matrizInterna[i+1][j+1] == 100) cnt++;
                        }
                    }
                    if(j != 0)
                    {
                        if(matrizInterna[i][j-1] == 100) cnt++;
                        if(i!=9)
                        {
                            if(matrizInterna[i+1][j-1] == 100) cnt++;
                        }
                    }
                    if(j != 9)
                    {
                        if(matrizInterna[i][j+1] == 100) cnt++;
                        if(i != 0)
                        {
                            if(matrizInterna[i-1][j+1] == 100) cnt++;
                        }
                    }

                    matrizInterna[i][j] = cnt;
                }
            }
        }
    }

    public static void montaCampo(int diff)
    {
        int var = 0;
        while(var != diff)
        {
            Random random = new Random();
            int i = random.nextInt(10);
            int j = random.nextInt(10);
            matrizInterna[i][j] = 100;
            var++;
        }
        minasArredores();
    }

}