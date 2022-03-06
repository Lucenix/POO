package com.poo.ficha2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Ficha2_3 {
    LocalDate[] arrayDatas;
    int pos = 0;
    public Ficha2_3(int size) {
        this.arrayDatas = new LocalDate[size];
    }

    public void insereData(LocalDate data) {
        boolean contain = true;
        for (LocalDate arrayData : arrayDatas) {
            if (arrayData.equals(data)) {
                contain = false;
                break;
            }
        }
        if(contain) this.arrayDatas[pos++] = data;
    }

    public LocalDate dataMaisProxima(LocalDate data){
        int min = 0;
        long comp = Math.abs(ChronoUnit.DAYS.between(data, this.arrayDatas[min]));
        for (int i = 1; i<pos; i++) {
            long temp = Math.abs(ChronoUnit.DAYS.between(data, this.arrayDatas[i]));
            if (temp < comp) {
                comp = temp;
                min = i;
            }
        }
        return this.arrayDatas[min];
    }

    public String toString() {
        return Arrays.deepToString(this.arrayDatas);
    }
}
