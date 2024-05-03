package org.example;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

class VinoTest {

    @Test
    void getIDvino() {
        Vino v = new Vino("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche");
        double expectedIDvino = 111;
        assertEquals(expectedIDvino, v.getIDvino());
    }

    @Test
    void getTipologia() {
        Vino v = new Vino("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche");
        String expectedTipologia = "Rosso";
        assertEquals(expectedTipologia, v.getTipologia());
    }

    @Test
    void getMarchio() {
        Vino v = new Vino("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche");
        String expectedMarchio = "Tavernello";
        assertEquals(expectedMarchio, v.getMarchio());
    }

    @Test
    void getProvenienza() {
        Vino v = new Vino("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche");
        String expectedProvenienza = "Marche";
        assertEquals(expectedProvenienza, v.getProvenienza());
    }
}