package br.ufrj.ic.campominado;

import java.util.Random;

public class CommandServlet {
    public static int[][] matriz;
    public static int[][] matrizInterna;
    public static int tamanhoMatriz;

    public static void reset(int tamanho, int dificuldade) {
        tamanhoMatriz = tamanho;
        matriz = initMatriz(tamanho);
        matrizInterna = initMatriz(tamanho);
        montaCampo(dificuldade);
    }

    public static int[][] initMatriz(int tamanho) {
        try{
            matriz = new int[tamanho][tamanho];
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    matriz[i][j] = 10 * i + j;
                }
            }
            return matriz;
        } catch (ArrayIndexOutOfBoundsException e) {
            return initMatriz(tamanhoMatriz);
        }
    }
    public static int[][] initMatriz2(int tamanho) {
        try{
            matriz = new int[tamanho][tamanho];
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    matriz[i][j] = i;
                }
            }
            return matriz;
        } catch (ArrayIndexOutOfBoundsException e) {
            return initMatriz(tamanhoMatriz);
        }
    }
    public static int[][] initMatriz3(int tamanho) {
        try{
            matriz = new int[tamanho][tamanho];
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    matriz[i][j] = i + j;
                }
            }
            return matriz;
        } catch (ArrayIndexOutOfBoundsException e) {
            return initMatriz(tamanhoMatriz);
        }
    }

    public static int[][] getMatriz() {
        return matriz;
    }
    public static int[][] getMatrizInterna() {
        return matrizInterna;
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
        try {
            matriz[i][j] = 50;
            if (i != 0) {
                matriz[i - 1][j] = matrizInterna[i - 1][j];
                if (matriz[i - 1][j] == 0) matriz[i - 1][j] = 50;
                if (j != 0) {
                    matriz[i - 1][j - 1] = matrizInterna[i - 1][j - 1];
                    if (matriz[i - 1][j - 1] == 0) matriz[i - 1][j - 1] = 50;

                }
            }
            if (i != tamanhoMatriz - 1) {
                matriz[i + 1][j] = matrizInterna[i + 1][j];
                if (matriz[i + 1][j] == 0) matriz[i + 1][j] = 50;
                if (j != tamanhoMatriz - 1) {
                    matriz[i + 1][j + 1] = matrizInterna[i + 1][j + 1];
                    if (matriz[i + 1][j + 1] == 0) matriz[i + 1][j + 1] = 50;
                }
            }
            if (j != 0) {
                matriz[i][j - 1] = matrizInterna[i][j - 1];
                if (matriz[i][j - 1] == 0) matriz[i][j - 1] = 50;
                if (i != tamanhoMatriz - 1) {
                    matriz[i + 1][j - 1] = matrizInterna[i + 1][j - 1];
                    if (matriz[i + 1][j - 1] == 0) matriz[i + 1][j - 1] = 50;
                }
            }
            if (j != tamanhoMatriz - 1) {
                matriz[i][j + 1] = matrizInterna[i][j + 1];
                if (matriz[i][j + 1] == 0) matriz[i][j + 1] = 50;
                if (i != 0) {
                    matriz[i - 1][j + 1] = matrizInterna[i - 1][j + 1];
                    if (matriz[i - 1][j + 1] == 0) matriz[i - 1][j + 1] = 50;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            matriz = initMatriz2(tamanhoMatriz);
        }
    }
    public static void vizinhos(int i, int j)
    {
        try {
            //Random random = new Random();
            //int x = random.nextInt()%4;
            int x = 1;
            matriz[i][j] = matrizInterna[i][j];

            if (x == 0) {
                if (i != 0) {
                    if (matrizInterna[i - 1][j] != 100) {
                        matriz[i - 1][j] = matrizInterna[i - 1][j];
                        if (matriz[i - 1][j] == 0) matriz[i - 1][j] = 50;
                    }
                }
                if (j != 0) {
                    if (matrizInterna[i][j - 1] != 100) {
                        matriz[i][j - 1] = matrizInterna[i][j - 1];
                        if (matriz[i][j - 1] == 0) matriz[i][j - 1] = 50;
                    }

                }
                if (i != 0 && j != 0) {
                    if (matrizInterna[i - 1][j - 1] != 100) {
                        matriz[i - 1][j - 1] = matrizInterna[i - 1][j - 1];
                        if (matriz[i - 1][j - 1] == 0) matriz[i - 1][j - 1] = 50;
                    }

                }
            } else if (x == 1) {
                if (i != 0) {
                    if (matrizInterna[i - 1][j] != 100) {
                        matriz[i - 1][j] = matrizInterna[i - 1][j];
                        if (matriz[i - 1][j] == 0) matriz[i - 1][j] = 50;
                    }
                }
                if (j != tamanhoMatriz - 1) {
                    if (matrizInterna[i][j + 1] != 100) {
                        matriz[i][j + 1] = matrizInterna[i][j + 1];
                        if (matriz[i][j + 1] == 0) matriz[i][j + 1] = 50;
                    }

                }
                if (i != 0 && j != tamanhoMatriz - 1) {
                    if (matrizInterna[i - 1][j + 1] != 100) {
                        matriz[i - 1][j + 1] = matrizInterna[i - 1][j + 1];
                        if (matriz[i - 1][j + 1] == 0) matriz[i - 1][j + 1] = 50;
                    }
                }
            } else if (x == 2) {
                if (i != tamanhoMatriz - 1) {
                    if (matrizInterna[i + 1][j] != 100) {
                        matriz[i + 1][j] = matrizInterna[i + 1][j];
                        if (matriz[i + 1][j] == 0) matriz[i + 1][j] = 50;
                    }
                }
                if (j != tamanhoMatriz - 1) {
                    if (matrizInterna[i][j + 1] != 100) {
                        matriz[i][j + 1] = matrizInterna[i][j + 1];
                        if (matriz[i][j + 1] == 0) matriz[i][j + 1] = 50;
                    }

                }
                if (i != tamanhoMatriz - 1 && j != tamanhoMatriz - 1) {
                    if (matrizInterna[i + 1][j + 1] != 100) {
                        matriz[i + 1][j + 1] = matrizInterna[i + 1][j + 1];
                        if (matriz[i + 1][j + 1] == 0) matriz[i + 1][j + 1] = 50;
                    }
                }
            } else {
                if (i != tamanhoMatriz - 1) {
                    if (matrizInterna[i + 1][j] != 100) {
                        matriz[i + 1][j] = matrizInterna[i + 1][j];
                        if (matriz[i + 1][j] == 0) matriz[i + 1][j] = 50;
                    }
                }
                if (j != 0) {
                    if (matrizInterna[i][j - 1] != 100) {
                        matriz[i][j - 1] = matrizInterna[i][j - 1];
                        if (matriz[i][j - 1] == 0) matriz[i][j - 1] = 50;
                    }

                }
                if (i != tamanhoMatriz - 1 && j != 0) {
                    if (matrizInterna[i + 1][j - 1] != 100) {
                        matriz[i + 1][j - 1] = matrizInterna[i + 1][j - 1];
                        if (matriz[i + 1][j - 1] == 0) matriz[i + 1][j - 1] = 50;
                    }
                }
            }
        }  catch (ArrayIndexOutOfBoundsException e) {
            matriz = initMatriz3(tamanhoMatriz);
        }
    }

    public static void minasArredores()
    {
        try {
            for (int i = 0; i < tamanhoMatriz; i++) {
                for (int j = 0; j < tamanhoMatriz; j++) {
                    int cnt = 0;
                    if (matrizInterna[i][j] != 100) {
                        if (i != 0) {
                            if (matrizInterna[i - 1][j] == 100) cnt++;
                            if (j != 0) {
                                if (matrizInterna[i - 1][j - 1] == 100) cnt++;
                            }

                        }
                        if (i != tamanhoMatriz -1) {
                            if (matrizInterna[i + 1][j] == 100) cnt++;
                            if (j != tamanhoMatriz -1) {
                                if (matrizInterna[i + 1][j + 1] == 100) cnt++;
                            }
                        }
                        if (j != 0) {
                            if (matrizInterna[i][j - 1] == 100) cnt++;
                            if (i != tamanhoMatriz -1) {
                                if (matrizInterna[i + 1][j - 1] == 100) cnt++;
                            }
                        }
                        if (j != tamanhoMatriz -1) {
                            if (matrizInterna[i][j + 1] == 100) cnt++;
                            if (i != 0) {
                                if (matrizInterna[i - 1][j + 1] == 100) cnt++;
                            }
                        }

                        matrizInterna[i][j] = cnt;
                    }
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            matriz = initMatriz(tamanhoMatriz);
        }
    }

    public static void montaCampo(int diff)
    {
        int var = 0;
        diff = (tamanhoMatriz*tamanhoMatriz*diff)/100;
        while(var != diff)
        {
            Random random = new Random();
            int i = random.nextInt(tamanhoMatriz);
            int j = random.nextInt(tamanhoMatriz);
            if(matrizInterna[i][j] != 100) {
                var++;
                matrizInterna[i][j] = 100;
            }
        }
        minasArredores();
    }

}