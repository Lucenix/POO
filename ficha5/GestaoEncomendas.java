package com.poo.ficha5;

import com.poo.ficha4.EncEficiente;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GestaoEncomendas {
    private Map<Integer, EncEficiente> encomendaMap;

    public GestaoEncomendas() {
        this.encomendaMap = new HashMap<>();
    }

    public GestaoEncomendas(Map<Integer, EncEficiente> encMap) {
        this.setEncomendaMap(encMap);
    }

    public Map<Integer, EncEficiente> getEncomendaMap() {
        return this.encomendaMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public void setEncomendaMap(Map<Integer, EncEficiente> encomendaMap) {
        this.encomendaMap = new HashMap<>();
        for (Map.Entry<Integer, EncEficiente> e: encomendaMap.entrySet()) {
            Integer key = e.getKey();
            EncEficiente value = e.getValue();
            this.encomendaMap.put(key, value.clone());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestaoEncomendas that = (GestaoEncomendas) o;
        return Objects.equals(encomendaMap, that.encomendaMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encomendaMap);
    }
}
