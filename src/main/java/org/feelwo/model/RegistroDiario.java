package org.feelwo.model;

import org.feelwo.model.enums.Intensidade;
import org.feelwo.model.enums.Sintoma;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegistroDiario {

    private Calendar data;
    private Map<Sintoma, Intensidade> sintomas =  new HashMap<>();

    public RegistroDiario(Calendar data) {
        this.data = data;
    }

    public void adicionarSintoma(Sintoma sintoma, Intensidade intensidade) {
        sintomas.put(sintoma, intensidade); //O put() serve para adicionar um par de informações dentro do Map
    }
    public Calendar getData() {
        return data;
    }
    public Map<Sintoma, Intensidade> getSintomas() {
        return sintomas; //Esse metodo serve para devolver o mapa que guarda os sintomas e suas intensidades.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroDiario outro = (RegistroDiario) o;      //transforma o objeto o em um objeto do tipo RegistroDiario, para eu acessar os atributos e métodos dessa classe.
        return data.get(Calendar.YEAR) == outro.data.get(Calendar.YEAR)
                && data.get(Calendar.MONTH) == outro.data.get(Calendar.MONTH)
                && data.get(Calendar.DAY_OF_MONTH) == outro.data.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int hashCode() { //sse metodo ensina ao Java como calcular o hashCode() de um objeto RegistroDiario, usando a data como referência.
        return Objects.hash(
                data.get(Calendar.YEAR),
                data.get(Calendar.MONTH),
                data.get(Calendar.DAY_OF_MONTH));
    }
}

//public boolean equals(Object o) é um metodo DO JAVA que recebe outro objeto para comparar com o objeto atual e retorna true ou false
//this é o objeto atual; o é o objeto recebido para comparação