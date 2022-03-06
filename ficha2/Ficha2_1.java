package com.poo.ficha2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ficha2_1 {
    //1
    int[] array1;
    int[] array2;

    public int[] getArray1() {
        return array1;
    }

    public void setArray1(int[] array1) {
        this.array1 = array1;
    }

    public int[] getArray2() {
        return array2;
    }

    public void setArray2(int[] array2) {
        this.array2 = array2;
    }

    public Ficha2_1() {

    }
    public Ficha2_1(int[] array2) {
        this.array2 = array2;
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for (int num: this.array1) {
            if (num<min)
                min = num;
        }
        return min;
    }

    public int[] between(int s, int f) {
        int[] r;
        if (f<this.array1.length) {
            int i;
            r = new int[f-s+1];

            for (i = 0; s<=f; s++, i++)
                r[i] = this.array1[s];
        } else
            r = null;
        return r;
    }

    public int[] comum() {
        int[] a1 = new int[this.array1.length];
        int[] a2 = new int[this.array2.length];
        System.arraycopy(this.array1, 0 , a1, 0, a1.length);
        System.arraycopy(this.array2, 0 , a2, 0, a2.length);
        Arrays.sort(a1);
        Arrays.sort(a2);
        int i1, i2, w;
        for (i1 = 0, i2 = 0, w = 0; i1 < a1.length && i2 <a2.length;) {
            if (a2[i2] < a1[i1])
                i2++;
            else if (a2[i2] > a1[i1]) {
                i1++;
            } else {
                a1[w] = a1[i1];
                while(i1 < a1.length && a1[i1] == a1[w]) i1++;
                while(i2 < a2.length && a2[i2] == a1[w]) i2++;
                w++;
            }
        }
        int[] res = new int[w];
        System.arraycopy(a1, 0, res, 0, w);
        return res;
    }


}
