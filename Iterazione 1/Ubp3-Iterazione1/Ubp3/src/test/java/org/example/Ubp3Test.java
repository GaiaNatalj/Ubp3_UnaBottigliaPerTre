package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;


import static org.junit.jupiter.api.Assertions.*;

class Ubp3Test {

    @Test
    void inserisciVino() {
        Ubp3 ubp3=new Ubp3();
        GestoreVino g;
        g=ubp3.inserisciVino("Azienda", "partitaIva", 122, "tipologia", "marchio", "provenienza", 8, 5);
        double expectedID=122;
        if(g!=null) {
            assertEquals(expectedID, g.getIDvino());
        }else{
            System.out.print("Vino già presente in lita");
        }

    }

    @Test
    void confermaVino() {
        Ubp3 ubp3=new Ubp3();
        GestoreVino g= new GestoreVino("Azienda", "partitaIva", 123, "tipologia", "marchio", "provenienza", 8, 5);
        LinkedList<GestoreVino>  vini;
        double expectedID = 0;
        ubp3.confermaVino(g);
        vini=ubp3.copiaListaVini();
        for(GestoreVino v: vini){
            if(v.getIDvino()==g.getIDvino()){
               expectedID=g.getIDvino();
            }
        }
        assertEquals( expectedID,g.getIDvino() );


    }

    @Test
    void inserisciCliente() {
        Ubp3 ubp3=new Ubp3();
        Cliente c;
        c=ubp3.inserisciCliente("nome", "cognome", "email@123", "1234");
        String expectedEmail="email@123";
        if(c!=null){
            assertEquals(expectedEmail,c.getEmail());}
        else {
            System.out.print("Cliente già presente in lista!");
        }
    }

    @Test
    void confermaCliente() {
        Ubp3 ubp3=new Ubp3();
        String expectedEmail = null;
        LinkedList<Cliente>  clienti;
        Cliente client=new Cliente("nome", "cognome", "email@1234", "1234");
        ubp3.confermaCliente(client);
        clienti=ubp3.copiaListaClienti();
        for(Cliente c: clienti){
            if(c.getEmail().equals(client.getEmail())){
                expectedEmail=client.getEmail();
            }
        }
        assertEquals( expectedEmail, client.getEmail() );
    }

    @Test
    void inserisciAzienda() {
        Ubp3 ubp3=new Ubp3();
        PrenotazioneVini pv=new PrenotazioneVini("Azienda4", "444", 789 ,"Rosso",
                "Antinori", "Toscana", 5);
        LinkedList<RigaOrdine> righe;
        ubp3.getPrenotazioniVini().add(pv);
        righe=ubp3.inserisciAzienda(pv.getNomeAzienda(), pv.getPartitaIva());
        if(righe.isEmpty()){
            System.out.print("Non ci sono prenotazioni!");
        }else {
            for (RigaOrdine r : righe) {
                assertEquals(pv.getIDvino(), r.getIDvino());
            }
        }

    }

    @Test
    void inserisciOrdineVini() {
        Ubp3 ubp3=new Ubp3();
        RigaOrdine ro;
        RigaOrdine er= new RigaOrdine("nomeA", "pI", 783,"tip", "march", "provenienza",3);
        ro= ubp3.inserisciOrdineVini(er.getNomeAzienda(), er.getPartitaIva(), er.getQuantitàPrenotazione(), er.getIDvino(), er.getTipologia(), er.getMarchio(), er.getProvenienza());
        assertEquals(er.getIDvino(), ro.getIDvino());
    }


}