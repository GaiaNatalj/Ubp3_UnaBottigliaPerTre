package org.example;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

class GestoreVinoTest {

    @Test
    void getPrezzo() {
        GestoreVino g = new GestoreVino("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche", 1, 10);
        float expectedPrezzo = 1;
        assertEquals(expectedPrezzo, g.getPrezzo());
    }

    @Test
    void getQuantitaDisponibili() {
        GestoreVino g = new GestoreVino("Azienda1", "111", 111, "Rosso", "Tavernello", "Marche", 1, 10);
        int expectedQuantitaDisponibili = 10;
        assertEquals(expectedQuantitaDisponibili, g.getQuantitaDisponibili());
    }
}