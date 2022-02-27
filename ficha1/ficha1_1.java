package com.poo.ficha1;

import java.time.LocalDateTime;
import java.util.Arrays;
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
        return diasSemana[((year-1900)*365 + (year-1900)/4 + count + day - 1)%7];
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
            numClass[i/5] += 1;
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

    public static String areaPerimetroTR(double base, double altura) {
        return String.format("Área: %.5f; Perímetro: %.5f\n", (base*altura)/2,base+altura+Math.sqrt(Math.pow(base,2) + Math.pow(altura,2)));
    }

    public static boolean isPrime(int p) {
        //só é preciso ver até à raiz de p, se não aparece nenhum divisor então é primo
        //também só seria preciso ver até p/2, mas raiz de p é menor
        for(int i = 2; i<=Math.sqrt(p);i++) {
            if (p%i == 0) return false;
        }
        return true;
    }

    public static String calculaIdade(int year, int month, int day) {
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
        return "Calculadas " + count + " horas desde o nascimento " + year + "/" + month + "/" + day + " e a data " + currentDate.getDayOfMonth() + "/" + cmonth + "/" + cyear + " às " + chour + " horas.";
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Escolha o exercício:");
        while(ler.hasNextInt()) {
            int switched = ler.nextInt();
            ler.nextLine();
            switch (switched) {
                case 1:
                    int day, month, year;
                    do {
                        System.out.println("Calcular o dia da semana. Escreva o dia...");
                    }while(!ler.hasNextInt());
                    day = ler.nextInt();
                    do {
                        System.out.println("...o mês...");
                    }while(!ler.hasNextInt());
                    month = ler.nextInt();
                    do {
                        System.out.println("...e o ano.");
                    }while(!ler.hasNextInt());
                    year = ler.nextInt();
                    System.out.println("O dia da semana foi: " + diaDaSemana(year,month,day));
                    break;
                case 2:
                    String lido;
                    String[] split1, split2;
                    int[] d1 = new int[4],d2 = new int[4];
                    int i;
                    do {
                        System.out.println("Escreva a primeira data no formato day/hour/minute/second: ");
                        lido = ler.next();
                        split1 = lido.split("/");
                    }while(split1.length != 4);
                    do {
                        System.out.println("Escreva a segunda data no formato day/hour/minute/second: ");
                        lido = ler.next();
                        split2 = lido.split("/");
                    }while(split2.length != 4);
                    for(i = 0; i<4;i++) {
                        d1[i] = Integer.parseInt(split1[i]);
                        d2[i] = Integer.parseInt(split2[i]);
                    }
                    System.out.println(somaDatas(d1,d2));
                    break;
                case 3:
                    System.out.println("Escreva quantas classificações pretende, separada por espaço.");
                    lido = ler.nextLine();
                    split1 = lido.split(" ");
                    d1 = new int[split1.length];
                    for(i = 0; i<split1.length; i++){
                        try {
                            d1[i] = Integer.parseInt(split1[i]);
                        } catch (NumberFormatException e) {
                            //do nothing
                        }
                    }
                    d1 = classificacoes(d1);
                    for(i = 0; i<d1.length-1; i++)
                        System.out.printf("%d ", d1[i]);
                    System.out.printf("%d\n", d1[i]);
                    break;
                case 4:
                    System.out.println("Escreva quantas temperaturas pretende, separada por espaço (pelo menos 2).");
                    do {
                        lido = ler.nextLine();
                        split1 = lido.split(" ");
                    }while(split1.length < 2);
                    d1 = new int[split1.length];
                    for(i = 0; i<split1.length; i++){
                        try {
                            d1[i] = Integer.parseInt(split1[i]);
                        } catch (NumberFormatException e) {
                            //do nothing
                        }
                    }
                    System.out.println(temperaturas(d1));
                    break;
                case 5:
                    double base, altura;
                    do {
                        System.out.println("Escreva o valor da base: ");
                    }while(!ler.hasNextDouble());
                    base = ler.nextDouble();
                    while (base != 0.0) {
                        do {
                            System.out.println("Escreva o valor da altura: ");
                        }while(!ler.hasNextDouble());
                        altura = ler.nextDouble();
                        System.out.println(areaPerimetroTR(base,altura));
                        //refactor a esta porra que já me está a chatear
                        do {
                            System.out.println("Escreva o valor da base: ");
                        }while(!ler.hasNextDouble());
                        base = ler.nextDouble();

                    }
                    break;
                case 6:
                    int p;
                    char yes = 's';
                    while(yes == 's') {
                        do {
                            System.out.println("Introduza o inteiro que deseja: ");
                        }while(!ler.hasNextInt());
                        p = ler.nextInt();
                        for(i = 2; i<p-1; i++) {
                            if (isPrime(i))
                                System.out.printf("%d ", i);
                        }
                        if (isPrime(i))
                            System.out.print(i);
                        System.out.print('\n');
                        System.out.println("Pretende jogar novamente? (s para sim)");
                        yes = ler.next().charAt(0);
                    }
                    break;
                case 7:
                    //não funcionou ler tudo seguido na mesma linha
                    int teste = 0;
                    month = 0;
                    day = 0;
                    do {
                        System.out.println("Calcular horas de vida. Escreva o ano seguido do mês e do dia de nascimento");
                    }while(!ler.hasNextInt());
                    year = ler.nextInt();
                    while (!ler.hasNextInt() && ((month = ler.nextInt())<1 || month >12)) {
                        System.out.println("Mês inválido");
                    }
                    if (year%4 == 0 && month == 2)
                        teste++;
                    while(!ler.hasNextInt() && ((day = ler.nextInt())<1 || day>(diasMes[month]+teste))) {
                        System.out.println("Dia inválido");
                    }
                    System.out.println(calculaIdade(year,month,day));
                    break;
                default:
                    break;
            }
            System.out.println("Escolha o exercício:");
        }
        ler.close();
    }
}
