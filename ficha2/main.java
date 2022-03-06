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
                    Ficha2_1 f2 = new Ficha2_1();
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
                case 2:
                    int [][] array = new int[5][5];
                    Ficha2_2 f2_2 = new Ficha2_2(array);
                    System.out.println("Escolha a alinea.");
                    switch (sc.next()) {
                        case "a":
                            i = 0;
                            int j;
                            while(i<5) {
                                System.out.println("Notas do " + (i+1) + "º aluno:");
                                j = 0;
                                do {
                                    System.out.println("Introduza a nota da " + (j+1) + "ª disciplina.");
                                    if (sc.hasNextInt()) {
                                        array[i][j] = sc.nextInt();
                                        j++;
                                    }
                                }while(j<5);
                                i++;
                            }
                            f2_2.setArray(array);
                            break;
                        case "b":
                            do {
                                System.out.println("Introduza o índice da disciplina.");
                            }while(sc.hasNextInt());
                            j = sc.nextInt();
                            System.out.println("A soma das notas é " + f2_2.somaNotasDisc(j));
                            break;
                        case "c":
                            do {
                                System.out.println("Introduza o índice do Aluno.");
                            }while(sc.hasNextInt());
                            i = sc.nextInt();
                            System.out.println("A média das notas é " + f2_2.mediaNotasAluno(i));
                            break;
                        case "d":
                            do {
                                System.out.println("Introduza o índice da disciplina.");
                            }while(sc.hasNextInt());
                            j = sc.nextInt();
                            System.out.println("A média das notas é " + f2_2.mediaNotasDisc(j));
                            break;
                        case "e":
                            for(j = 0;j<5; j++) {
                                System.out.println("A maior nota da disciplina " + (j+1) + " é " + f2_2.maxNotaDisc(j));
                            }
                            break;
                        case "f":
                            for(j = 0;j<5; j++) {
                                System.out.println("A menor nota da disciplina " + (j+1) + " é " + f2_2.minNotaDisc(j));
                            }
                            break;
                        case "g":
                            do {
                                System.out.println("Introduza o valor de comparação.");
                            }while(sc.hasNextInt());
                            int nota = sc.nextInt();
                            System.out.println(Arrays.toString(f2_2.notasMaiores(nota)));
                            break;
                        case "h":
                            System.out.println(f2_2.notasToString());
                            break;
                        case "i":
                            System.out.println("A disciplina com a média mais elevada tem como índice " + f2_2.discMaiorMedia());
                            break;
                    }
                    break;
                case 3:
                    break;
            }
        }
        System.out.println("Escolha o exercício.");
    }
}

