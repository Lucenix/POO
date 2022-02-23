package com.poo.ficha1;

import java.util.Scanner;

public class ficha1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ficha1_Classe f = new Ficha1_Classe();
        System.out.println("Escolha o exercício:");
        while (sc.hasNextInt()) {
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Digite a temperatura em Graus para converter: ");
                    double in = sc.nextDouble();
                    System.out.printf("%.2f graus é igual a %.2f graus farenheit.\n", in, f.celsiusParaFarenheit(in));
                    break;
                case 2:
                    System.out.println("Digite dois números para determinar o máximo: ");
                    int x = sc.nextInt(), y = sc.nextInt();
                    System.out.println("O maior dos dois é " + f.maximoNumeros(x,y));
                    break;
                case 3:
                    System.out.println("Digite um nome: ");
                    String nome = sc.next();
                    System.out.println("Digite um saldo: ");
                    int saldo = sc.nextInt();
                    System.out.println(f.criaDescricaoConta(nome, saldo));
                    break;
                case 4:
                    System.out.println("Escreva um valor em euros e uma taxa de conversão: ");
                    double euros = sc.nextDouble();
                    double taxa = sc.nextDouble();
                    System.out.printf("Em libras, tal dá: %.2f\n", f.eurosParaLibras(euros, taxa));
                    break;
                case 5:
                    System.out.println("Digite dois inteiros: ");
                    int a = sc.nextInt(), b = sc.nextInt();
                    double media = (((double)(a+b))/2);
                    System.out.println("A média emtre " + Math.max(a,b) + " e " + Math.min(a,b) + " é de " + media);
                    break;
                case 6:
                    if (args.length > 0)
                        System.out.println("O valor do fatorial passado é: " + f.factorial(Integer.parseInt(args[0])));
                    break;
                case 7:
                    System.out.println("O tempo gasto foi de: " + ((double) f.tempoGasto())/1000000 + " ms");
            }
            System.out.println("Escolha o exercício:");
        }
    }
}
