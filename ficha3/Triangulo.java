package com.poo.ficha3;

import java.util.Objects;

public class Triangulo {
    int x1,x2, y1,y2, z1,z2;

    public Triangulo() {
        this.x1 = 0;
        this.y1 = 0;
        this.z1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.z2 = 0;
    }

    public Triangulo(int x, int x2, int y, int y2,  int z, int z2) {
        this.x1 = x;
        this.y1 = y;
        this.z1 = z;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
    }

    public Triangulo(Triangulo t) {
        this.x1 = t.x1;
        this.y1 = t.y1;
        this.z1 = t.z1;
        this.x2 = t.x2;
        this.y2 = t.y2;
        this.z2 = t.z2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getZ1() {
        return z1;
    }

    public void setZ1(int z1) {
        this.z1 = z1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangulo triangulo = (Triangulo) o;
        return x1 == triangulo.x1 &&
                x2 == triangulo.x2 &&
                y1 == triangulo.y1 &&
                y2 == triangulo.y2 &&
                z2 == triangulo.z2 &&
                z1 == triangulo.z1;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", z1=" + z1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", z2=" + z2 +
                '}';
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getZ2() {
        return z2;
    }

    public void setZ2(int z2) {
        this.z2 = z2;
    }

    private double dist(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    public double calculaAreaTriangulo() {
        return ((double) ((y1*z2 - y2*z1) - (x1*z2 - x2*z1) + (x1*y2 - y1*x2)))/2;
    }

    public double calculaPerimetroTriangulo() {
        return dist(x1,x2,y1,y2) + dist(x1,x2,z1,z2) + dist(z1,z2,y1,y2);
    }

    public double altura () {
        int min = x2;
        if (Math.min(y2,z2)<x2) min = Math.min(y2,z2);

        int max = x2;
        if (Math.max(y2,z2) > x2) min = Math.max(y2,z2);

        return max-min;
    }
}
