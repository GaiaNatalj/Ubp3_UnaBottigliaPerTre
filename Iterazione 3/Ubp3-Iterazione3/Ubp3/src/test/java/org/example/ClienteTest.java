package org.example;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

class ClienteTest {

    @Test
    void getNome() {
        Cliente c = new Cliente("Marco", "Rossi", "marco.rossi@live.it", "3331323123", 1);
        String expectedNome = "Marco";
        assertEquals(expectedNome, c.getNome());
    }

    @Test
    void getCognome() {
        Cliente c = new Cliente("Marco", "Rossi", "marco.rossi@live.it", "3331323123", 1);
        String expectedCognome = "Rossi";
        assertEquals(expectedCognome, c.getCognome());
    }

    @Test
    void getEmail() {
        Cliente c = new Cliente("Marco", "Rossi", "marco.rossi@live.it", "3331323123", 1);
        String expectedEmail = "marco.rossi@live.it";
        assertEquals(expectedEmail, c.getEmail());

    }

    @Test
    void getNumeroTelefono() {
        Cliente c = new Cliente("Marco", "Rossi", "marco.rossi@live.it", "3331323123", 1);
        String expectedNumeroTelefono = "3331323123";
        assertEquals(expectedNumeroTelefono, c.getNumeroTelefono());
    }

    @Test
    void getPunti() {
        Cliente c = new Cliente("Marco", "Rossi", "marco.rossi@live.it", "3331323123", 1);
        int expectedPunti = 1;
        assertEquals(expectedPunti, c.getPunti());
    }
}