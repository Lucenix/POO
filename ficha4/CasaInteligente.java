package com.poo.ficha4;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CasaInteligente {
    ArrayList<Lampada> lampadas;

    public CasaInteligente(CasaInteligente c) {
        this.lampadas = (c.getLampadas());
    }

    public CasaInteligente(ArrayList<Lampada> lampadas) {
        this.setLampadas(lampadas);
    }

    public ArrayList<Lampada> getLampadas() {
        return lampadas;
    }

    public void setLampadas(ArrayList<Lampada> lampadas) {
        this.lampadas.addAll(lampadas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CasaInteligente that = (CasaInteligente) o;
        return Objects.equals(lampadas, that.lampadas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lampadas);
    }

    @Override
    public String toString() {
        return "CasaInteligente{" +
                "lampadas=" + lampadas +
                '}';
    }

    public void addLampada(Lampada l) {
        this.lampadas.add(l);
    }

    public void ligaLampadaNormal(int index) {
        if (index < lampadas.size()) {
            lampadas.get(index).lampON();
        }
    }

    public void ligaLampadaEco(int index) {
        if (0<=index && index < lampadas.size()) {
            lampadas.get(index).lampECO();
        }
    }

    public int qtEmEco() {
        int count = 0;
        for (Lampada l: lampadas) {
            if (l.getModo() == Lampada.Modo.ECO) count++;
        }
        return count;
    }

    public void removeLampada(int index) {
        if (0 <= index && index < lampadas.size()) {
            lampadas.remove(index);
        }
    }

    public void ligaTodosEco() {
        for (Lampada l: lampadas) {
            l.lampECO();
        }
    }
    public void ligaTodosMax() {
        for (Lampada l: lampadas) {
            l.lampON();
        }
    }

    public double consumoTotal() {
        return lampadas.stream().mapToDouble(Lampada::getConsumoTotal).sum();
    }

    public Lampada maisGastadora() {
        return (lampadas.stream().max(Comparator.comparingDouble(Lampada::getConsumoTotal))).get();
    }

    public Set<Lampada> podiumEconomia() {
        //ver esta com atenção: tirar o top 3 pode ser complicado porque TreeSet esquece-se das que tiverem o mesmo custo.
        //usar um comparator que tem um compare que não veja só o custo como qualquer outra coisa que as diferencie, se houver
        //não há :C
        Comparator<Lampada> c = (o1, o2) -> {
            int test;
            if ((test = Double.compare(o1.getConsumoTotal(), o2.getConsumoTotal()))!=0)
                return test;
            else
                return Double.compare(o1.getPeriodoConsumo(), o2.getPeriodoConsumo());
        };
        return this.lampadas.stream().sorted(c).limit(3).collect(Collectors.toSet());
        //retornar apenas o top 3
    }
}
