package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class Ubp3_3Test {

    @Test
    void ricercaCliente() {
        Ubp3_3 ubp3=new Ubp3_3();
        Cliente c;
        c=ubp3.ricercaCliente("nome", "cognome", "email@1234");
        String expectedEmail="email@1234";
        if(c!=null){
        assertEquals(expectedEmail,c.getEmail());}
        else{
            System.out.print("Cliente non trovato!");
        }
    }


    @Test
    void inserisciCodiceSconto() {
        Ubp3_3 ubp3=new Ubp3_3();
        CodiceSconto c;
        c=ubp3.inserisciCodiceSconto("codice2",123 );
        String expectedCodice="codice2";
        if(c!=null){
        assertEquals(expectedCodice,c.getCodice());}
        else{
            System.out.print("Codice sconto già inserito!");
        }
    }



    @Test
    void confermaCodiceSconto() {
        Ubp3_3 ubp3=new Ubp3_3();
        String expectedCodice = null;
        LinkedList<CodiceSconto>  codici;
        CodiceSconto codiceSconto=new CodiceSconto("codice", 10);
        ubp3.confermaCodiceSconto(codiceSconto);
        codici=ubp3.copiaListaCodiciSconto();
        for(CodiceSconto c: codici){
            if(c.getCodice().equals(codiceSconto.getCodice())){
                expectedCodice=c.getCodice();
            }
        }
        assertEquals( expectedCodice, codiceSconto.getCodice() );

    }


}