package com.poo.ficha2;

public class Ficha2_7 {
    int[] numeros;
    int[] estrelas;

    public Ficha2_7() {
        this.numeros = new int[50];
        this.estrelas = new int[9];
        int ind;
        for (int i = 0; i < 5;) {
            ind = (int) (Math.random() * (50)) + 1;
            if (this.numeros[ind] == 0) {
                this.numeros[ind] = 1;
                i++;
            }
        }
        for (int i = 0; i < 2;) {
            ind = (int) (Math.random() * (9)) + 1;
            if (this.estrelas[ind] == 0) {
                this.estrelas[ind] = 1;
                i++;
            }
        }
    }

    public int[] commonNum(int[] numeros, int[] estrelas) {
        int i;
        int[] r = new int[7];
        for (i = 0; i<5; i++) {
            if(this.numeros[numeros[i]] == 1) {
                r[i] = numeros[i];
            }
        }
        for (i = 0; i<2; i++) {
            if(this.estrelas[estrelas[i]] == 1) {
                r[i+5] = estrelas[i];
            }
        }
        return r;
    }

    public boolean checkAll(int[] resultados) {
        for (int num:
             resultados) {
            if(num == 0)
                return false;
        }
        return true;
    }
}
