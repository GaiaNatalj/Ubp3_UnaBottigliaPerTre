package org.example;

import java.util.LinkedList;

public class PrenotazioneClienti {
    private Cliente cliente;
    private LinkedList<PrenotazioneVini> prenotazioniVini;

    public PrenotazioneClienti(Cliente cliente, LinkedList<PrenotazioneVini> prenotazioniVini) {
        this.cliente = cliente;
        this.prenotazioniVini=prenotazioniVini;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LinkedList<PrenotazioneVini> getPrenotazioniVini() {
        return prenotazioniVini;
    }

    public void setPrenotazioniVini(LinkedList<PrenotazioneVini> prenotazioniVini) {
        this.prenotazioniVini = prenotazioniVini;
    }

    @Override
    public String toString() {
        return "PrenotazioneClienti{" +
                "cliente=" + cliente +
                ", prenotazioniVini=" + prenotazioniVini +
                '}';
    }
}
