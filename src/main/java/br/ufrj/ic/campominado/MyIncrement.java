package br.ufrj.ic.campominado;

public class MyIncrement {
    public int x = 0;

    public int getX() {
        return incX();
    }

    public void setX(int x) {
        this.x = x;
    }

    public int incX() {
        return x++;
    }
}
