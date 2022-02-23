package com.poo.ficha1;

import java.time.LocalDateTime;

public class Ficha1_Classe {
    public double celsiusParaFarenheit(double graus) {
        return graus*1.8 + 32;
    }

    public int maximoNumeros(int a, int b) {
        return Math.max(a, b);
    }

    public String criaDescricaoConta(String nome, float saldo) {
        return "Nome: " + nome + ", saldo: " + saldo;
    }

    public double eurosParaLibras(double valor, double taxaConversao) {
        return taxaConversao*valor;
    }

    public long factorial(int num) {
        int count = 1;
        for (int i = 2; i <= num; i++) {
            count*=i;
        }
        return count;
    }

    public long tempoGasto() {
        long t = System.nanoTime();
        factorial(5000);
        return System.nanoTime() - t;
    }
}
