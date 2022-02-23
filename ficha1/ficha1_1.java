package com.poo.ficha1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ficha1_1 {
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
                + (ind+1) + " e " + (ind+2) + ", tendo a temperatura " +  var + " " + Math.abs(max) + " graus.";
    }

    public static void areaPerimetroTR() {
        Scanner ler = new Scanner(System.in);
        double base, altura;
        System.out.println("Introduza o valor da base: ");
        while((base = ler.nextDouble()) != 0.0) {
            System.out.println("Introduza o valor da altura: ");
            altura = ler.nextDouble();
            System.out.printf("Área: %.5f; Perímetro: %.5f\n", (base*altura)/2, base+altura+Math.sqrt(Math.pow(base,2) + Math.pow(altura,2)));
            System.out.println("Introduza o valor da base: ");
        }
        ler.close();
    }

    public static boolean isPrime(int p) {
        //só é preciso ver até à raiz de p, se não aparece nenhum divisor então é primo
        //também só seria preciso ver até p/2, mas raiz de p é menor
        for(int i = 2; i<=Math.sqrt(p);i++) {
            if (p%i == 0) return false;
        }
        return true;
    }

    public static void printPrimes() {
        Scanner ler = new Scanner(System.in);
        int p, i;
        System.out.println("Introduza o inteiro que deseja: ");
        while(ler.hasNextInt()) {
            p = ler.nextInt();
            for(i = 2; i<p-1; i++) {
                if (isPrime(i))
                    System.out.printf("%d ", i);
            }
            if (isPrime(i))
                System.out.print(i);
            System.out.print('\n');
            System.out.println("Introduza o inteiro que deseja: ");
        }
    }

    public static int calculaIdade(int year, int month, int day) {
        int cyear, cday, chour, cmonth;
        LocalDateTime currentDate = LocalDateTime.now();
        cyear = currentDate.getYear();
        cmonth = currentDate.getMonthValue();
        cday = currentDate.getDayOfYear();
        chour = currentDate.getHour();
        int count = (cyear - year - 2)*365 + (cyear - year - 1)/4; //somar os dias de todos os anos exceto o 1º e o último
        //somar os dias dos meses do ano de nascimento menos o de nascimento
        for(int i = month; i<12; i++)
            count += diasMes[i];
        //somar os dias passados do mes de nascimento
        count+=diasMes[month]-day;

        //somar os dias do ano atual
        count+=cday-1;
        //contar as horas
        count *= 24;
        //somar as horas atuais
        count += chour;
        System.out.println("Calculadas " + count + " horas desde o nascimento e a data " + currentDate.getDayOfMonth() + "/" + cmonth + "/" + cyear + " às " + chour + " horas.");
        return count;
    }

    public static void main(String[] args) {
        calculaIdade(2002, 5, 17);

    }
}
