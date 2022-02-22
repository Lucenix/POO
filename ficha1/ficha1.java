package com.poo.ficha1;

public class ficha1 {
    private static final int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static final String[] diasSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};

    public static String diaDaSemana(int year, int month, int day) {
        int count = 0;
        if (year%4==0 && month<=2) count--;
        for (int i = 0; i<month-1; i++) {
            count += diasMes[i];
        }
        return diasSemana[((year-1900)*365 + (year-1900)/4 + count + day)%7];
    }

    public static String somaDatas(int[] d1, int[] d2) {
        int d,h,m,s,tmp;
        tmp = d1[3] + d2[3];
        s = tmp%60;
        tmp = d1[2] + d2[2] + tmp/60;
        m = tmp%60;
        tmp = d1[1] + d2[1] + tmp/60;
        h = tmp%24;
        d = d1[0] + d2[0] + tmp/24;
        return d + "D " + h + "H " + m + "M " + s + "S";
    }

    public static int[] classificacoes(int[] notas) {
        int[] numClass = {0,0,0,0};
        for (int i : notas) {
            if (i == 20)
                i--;
            numClass[i%5] += 1;
        }
        return numClass;
    }

    public static String temperaturas(int[] temps) {
        int n = temps.length, max = temps[1] - temps[0], count = temps[0], i, ind = 0;
        for (i = 1; i<n-1; i++) {
            count += temps[i];
            if (Math.abs(max) < Math.abs(temps[i+1] - temps[i])) {
                max = temps[i+1] - temps[i];
                ind = i;
            }
        }
        count += temps[n-1];

        String var;
        if(max<0) var = "descido";
        else var = "subido";
        return "A média das " + n + " temperaturas foi de " + count/n + " graus.\nA maior variação registou-se entre os dias "
                + ind + " e " + (ind+1) + ", tendo a temperatura " +  var + " " + Math.abs(max) + " graus.";
    }

    public static void main(String[] args) {
        
    }
}
