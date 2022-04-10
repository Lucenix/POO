package com.poo.ficha5;

public class Aluno {

    double nota;
    String numero;

    public Aluno(Aluno a) {
        numero = a.numero;
        nota = a.nota;
    }

    public Aluno clone() {
        return new Aluno(this);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
