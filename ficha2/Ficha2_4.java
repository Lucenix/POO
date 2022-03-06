package com.poo.ficha2;

import java.util.Arrays;

public class Ficha2_4 {
    int[] array;

    public Ficha2_4(int[] array) {
        this.array = array;
    }

    public void sortArray() {
        Arrays.sort(this.array);
    }

    public int binarySearch(int x) {
        this.sortArray();
        return Arrays.binarySearch(this.array, x);
    }
}
