package org.example;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

class PrenotazioneViniTest {

    @Test
    void getQuantitàPrenotazione() {
        PrenotazioneVini p = new PrenotazioneVini("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche", 1);
        int expectedQuantitaPrenotazione = 1;
        assertEquals(expectedQuantitaPrenotazione, p.getQuantitàPrenotazione());
    }
}