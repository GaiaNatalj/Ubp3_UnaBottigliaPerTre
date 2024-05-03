package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.testng.Assert.assertEquals;

class OrdineFornitoreTest {

    @Test
    void getRigheOrdine() {
        RigaOrdine r = new RigaOrdine ("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche",  1);
        LinkedList<RigaOrdine> righe = new LinkedList<>();
        righe.add(r);
        OrdineFornitore o = new OrdineFornitore("Azienda1", "111", righe);
        String expectedNomeAzienda = "Azienda1";
        String expectedPartitaIva = "111";
        double expectedIDvino = 111;
        String expectedTipologia = "Rosso";
        String expectedMarchio = "Tavernello";
        String expectedProvenienza = "Marche";
        int expectedQuantitaPrenotazione = 1;
        assertEquals(expectedNomeAzienda, r.getNomeAzienda());
        assertEquals(expectedPartitaIva, r.getPartitaIva());
        assertEquals(expectedIDvino, r.getIDvino());
        assertEquals(expectedTipologia, r.getTipologia());
        assertEquals(expectedMarchio, r.getMarchio());
        assertEquals(expectedProvenienza, r.getProvenienza());
        assertEquals(expectedQuantitaPrenotazione, r.getQuantitàPrenotazione());
    }
}