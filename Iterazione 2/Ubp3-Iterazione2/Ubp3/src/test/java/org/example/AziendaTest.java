package org.example;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

class AziendaTest {

    @Test
    void getNomeAzienda() {
        Azienda a = new Azienda("Azienda1", "111");
        String expectedNomeAzienda = "Azienda1";
        assertEquals(expectedNomeAzienda, a.getNomeAzienda());
    }

    @Test
    void getPartitaIva() {
        Azienda a = new Azienda("Azienda1", "111");
        String expectedPartitaIva = "111";
        assertEquals(expectedPartitaIva, a.getPartitaIva());
    }
}