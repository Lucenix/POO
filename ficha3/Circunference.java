package com.poo.ficha3;

public class Circunference {

    private double x, y, raio;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Circunference(int x, int y, int raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circunference() {
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    public Circunference(Circunference c) {
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    public Circunference clone(Circunference c) {
        return new Circunference(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circunference that = (Circunference) o;
        return x == that.x &&
                y == that.y &&
                raio == that.raio;
    }

    @Override
    public String toString() {
        return "Circunference{x=" +
                x +
                ", y=" +
                y +
                ", raio=" +
                raio +
                "}";
    }

    public void alteraCentro(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public double calculaArea() {
        return Math.PI*Math.pow(this.raio, 2);
    }

    public double calculaPerimetro() {
        return Math.PI*2*this.raio;
    }
}
