package com.poo.ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o exercício.");
        while(sc.hasNextInt()) {
            int switched = sc.nextInt();
            sc.nextLine();
            switch (switched) {
                case 1:
                    //1a
                    int n;
                    Ficha2 f2 = new Ficha2();
                    do {
                        System.out.println("Introduza quantos inteiros quer:");
                    }while(!sc.hasNextInt());
                    n = sc.nextInt();
                    int[] d = new int[n];
                    int i = 0;
                    while(i<n) {
                        do {
                            System.out.println("Faltam introduzir " + (n-i) + " inteiros.");
                        }while(!sc.hasNextInt());
                        d[i++] = sc.nextInt();
                    }
                    f2.setArray1(d);
                    System.out.println("O mínimo do array é " + f2.min());

                    //1b
                    do {
                        System.out.println("Introduza o primeiro índice:");
                    }while(!sc.hasNextInt());
                    int s = sc.nextInt();

                    do {
                        System.out.println("Introduza o segundo índice:");
                    }while(!sc.hasNextInt());
                    int f = sc.nextInt();
                    d = f2.between(s,f);
                    System.out.println(Arrays.toString(d));

                    //1c
                    do {
                        System.out.println("Introduza quantos inteiros quer:");
                    }while(!sc.hasNextInt());
                    n = sc.nextInt();
                    d = new int[n];
                    i = 0;
                    while(i<n) {
                        do {
                            System.out.println("Faltam introduzir " + (n-i) + " inteiros.");
                        }while(!sc.hasNextInt());
                        d[i++] = sc.nextInt();
                    }
                    f2.setArray2(d);
                    System.out.println(Arrays.toString(f2.comum()));
                    break;
            }
            System.out.println("Escolha o exercício.");
        }
    }
}
