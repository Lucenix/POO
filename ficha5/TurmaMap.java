package com.poo.ficha5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TurmaMap {
    private Map<String, Aluno> alunos;
    public TurmaMap() {
        this.alunos = new HashMap<>();
    }
    public TurmaMap(Map<String, Aluno> alunos) {
        this(); //construtor vazio, só pode ser chamado dentro de outro construtor.
        for (String n: alunos.keySet()) {
            Aluno a =  alunos.get(n);
            this.alunos.put(n, a.clone());
        } //copio exatamente a estrutura de dados
        for (Aluno a: alunos.values()) {
            String n = a.getNumero();
            this.alunos.put(n, a.clone());
        } //copio usando os numeros de cada aluno
        for (Map.Entry<String, Aluno> e: alunos.entrySet()) {
            String n = e.getKey();
            Aluno a = e.getValue();
            this.alunos.put(n, a.clone());
        } //usar um iterador externo de entries

        //ter entradas numa stream e depois coletar toda a gente e fazer o clone
        this.alunos = alunos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public Map<String, Aluno> getAlunos() {
        return this.alunos.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }

    public Map<String,Aluno> getAlunos2() {
        return this.alunos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public void adicAluno(Aluno a) {
        this.alunos.put(a.getNumero(), a.clone());
    }

    public boolean existe(String num) {
        return this.alunos.containsKey(num);
    }

    public void setAlunos(Map<String, Aluno> alunos) {
        //o mapa em si tem de ser completamente novo, ou alterações noutro sítio também alteram aqui (não necessariamente aos elementos)
        this.alunos = new HashMap<>();
        for (Map.Entry<String, Aluno> e: alunos.entrySet()) {
            String n = e.getKey();
            Aluno a = e.getValue();
            alunos.put(n, a.clone());
        } //usar um iterador externo de entries
    }

    public Aluno getAluno(String num) {
        Aluno a = this.alunos.get(num);
        return a==null?a:a.clone();
    }

    public List<Aluno> porNota() {
        Comparator<Aluno> c = (a1, a2) -> Double.compare(a1.getNota(), a2.getNota());
        return this.alunos.values().stream().sorted(c).collect(Collectors.toList());
    }
}
