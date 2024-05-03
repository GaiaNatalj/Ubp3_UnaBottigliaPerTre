package org.example;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

class RigaOrdineTest {

    @Test
    void getQuantitàPrenotazione() {
        RigaOrdine r = new RigaOrdine("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche", 1);
        int expectedQuantitaPrenotazione = 1;
        assertEquals(expectedQuantitaPrenotazione, r.getQuantitàPrenotazione());
    }
}