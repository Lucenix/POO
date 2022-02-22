package com.poo.ficha1;

import java.util.Scanner;

public class OlaMundo {
    public static String geraSaudacao(String nome) {
        return "Olá " + nome + "!";
    }

    public static void dizMaior(int i1, int i2) {
        /*if (i1 > i2)
            System.out.println("O maior é " + i1);
        else
            System.out.println("O maior é " + i2);*/
        System.out.println("O maior é: " + Math.max(i1, i2));
    }

    public static void sumIO() {
        int sum = 0, resp;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduza números a somar: ");
        while (input.hasNextInt()) {
            resp = input.nextInt();
            sum += resp;
        }
        input.close();
        System.out.println("Soma: " + sum);
    }

    /*public static void main(String[] args) {
        sumIO();

         int a,b;
        Scanner ler = new Scanner(System.in);
        System.out.println("Indique dois números inteiros: ");
        a = ler.nextInt();
        b = ler.nextInt();
        dizMaior(a, b);
        ler.close();

        String saudacao = geraSaudacao("Mundo");
        System.out.println(saudacao);
    }*/
}
