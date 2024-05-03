package org.example;

import com.beust.ah.A;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class Ubp3_2Test {

    @Test
    void ricercaVino() {
    Ubp3_2 ubp3=new Ubp3_2();
    GestoreVino vino;
    vino=ubp3.ricercaVino("tipologia", "marchio");
    String expectedTipologia="tipologia";
    String expectedMarchio="marchio";
    if(vino!=null){
    assertEquals(expectedTipologia, vino.getTipologia());
    assertEquals(expectedMarchio, vino.getMarchio());}
    else{
        System.out.print("Vino non trovato!");
    }

    }

    @Test
    void aggiungiVino() {
        Ubp3_2 ubp3=new Ubp3_2();
        RigaAcquisto ra;
        GestoreVino g= new GestoreVino("Azienda", "partitaIva", 123, "tipologia", "marchio", "provenienza", 8, 5);
        ra=ubp3.aggiungiVino(g, 3);
        float expectedPrezzo=g.getPrezzo()*3;
        assertEquals(expectedPrezzo, ra.getPrezzo());

    }


    //runnare confermaCliente
    @Test
    void associaClienti() {
        Ubp3_2 ubp3=new Ubp3_2();
        Cliente c;
        c=ubp3.associaCliente("nome", "cognome", "email@12345");
        String expectedEmail="email@12345";
        assertEquals(expectedEmail, c.getEmail());

    }

    @Test
    void conferma() {
        Ubp3_2 ubp3=new Ubp3_2();
        LinkedList<Acquisto> acquisti;
        String expectedData=null;
        Acquisto acq=new Acquisto("data",  50);
       ubp3.conferma("data",null, 50);
       acquisti=ubp3.copiaListaAcquisti();
       for(Acquisto a: acquisti){
           if(a.getData().equals("data")){
               expectedData=a.getData();
           }
       }
        assertEquals( expectedData, acq.getData() );

    }

    @Test
    void applicaCodiceSconto() {
        Ubp3_2 ubp3=new Ubp3_2();
        CodiceSconto codice1=new CodiceSconto("codice", 10);
        float expecterdPrezzo;
        float prezzo=ubp3.applicaCodiceSconto(50,codice1.getCodice());
        float d=(50*codice1.getPercentuale())/100;
        expecterdPrezzo=50-d;
        if(prezzo!=0){
            assertEquals(expecterdPrezzo, prezzo);
        }else{
            assertEquals(0, prezzo);
        }


    }

    @Test
    void cercaVendita() {
        Ubp3_2 ubp3=new Ubp3_2();
        LinkedList<Acquisto> acquisti;
        String data="data";
        acquisti=ubp3.cercaVendita(data);
        if(acquisti.isEmpty()){
            System.out.print("Non ci sono vendite corrispondenti alla data specificata!");
        }else {
        for(Acquisto a: acquisti){
            if(a.getData().equals(data)){
                assertEquals(data, a.getData());
            }
        }}
    }


    @Test
    void inserisciPrenotazione() {
        Ubp3_2 ubp3=new Ubp3_2();
        PrenotazioneVini pv=ubp3.inserisciPrenotazione("Azienda", "partitaIva", 123, "tipologia", "marchio", "provenienza", 8);
        double expectedID=123;
        assertEquals(expectedID,pv.getIDvino() );
    }

    @Test
    void associaPrenotazioneCliente() {
        Ubp3_2 ubp3=new Ubp3_2();
        double d=0;
        LinkedList<PrenotazioneVini> prenotazioniV=new LinkedList<>();
        PrenotazioneVini pv=new PrenotazioneVini("Azienda", "partitaIva", 123, "tipologia", "marchio", "provenienza", 8);
        PrenotazioneVini pv2=new PrenotazioneVini("Azienda1", "partitaIva1", 1234, "tipologia1", "marchio1", "provenienza1", 9);
        Cliente c=new Cliente("nome", "cognome", "email");
        double expectedId=1234;
        prenotazioniV.add(pv);
        prenotazioniV.add(pv2);
        PrenotazioneClienti pc=ubp3.associaPrenotazioneCliente(c,prenotazioniV);

        for (PrenotazioneVini p: pc.getPrenotazioniVini()){
            if(p.getIDvino()==1234){
                d=p.getIDvino();
            }
        }
        assertEquals(expectedId, d);

    }
}