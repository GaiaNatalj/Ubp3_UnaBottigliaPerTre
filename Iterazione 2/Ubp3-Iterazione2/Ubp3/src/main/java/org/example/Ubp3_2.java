package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Ubp3_2 {

    static Scanner scan = new Scanner(System.in);
    private static LinkedList<GestoreVino> vini=new LinkedList<>();

    private static LinkedList<RigaAcquisto> righeAquisto=new LinkedList<>();

    private static LinkedList<Acquisto> acquisti=new LinkedList<>();

    private static LinkedList<CodiceSconto> codiciSconto=new LinkedList<>();

    private static CodiceSconto codice1=new CodiceSconto("123", 10);
    private static CodiceSconto codice2=new CodiceSconto("345", 20);
    private static CodiceSconto codice3=new CodiceSconto("567", 30);

    public Ubp3_2() {
    }
    public static GestoreVino ricercaVino(String tipologia, String marchio){
        LinkedList<GestoreVino> gVino;
        gVino=org.example.Ubp3.copiaListaVini();
        for(GestoreVino v: gVino){
            if(v.getTipologia().equals(tipologia) && v.getMarchio().equals(marchio)){
                System.out.println(v);
                return v;
            }
        }

        return null;
    }
    public static RigaAcquisto aggiungiVino(GestoreVino v, int quantità) {
        RigaAcquisto riga;
        GestoreVino g;
        int q;
        float prezzo;
        vini = org.example.Ubp3.copiaListaVini();
       for (int i=0;i<vini.size();i++) {
           g=vini.get(i);
            if(g.getIDvino()==v.getIDvino()){
                vini.remove(i);
        }
       }

        q=v.getQuantitaDisponibili()-quantità;
        v.setQuantitaDisponibili(q);
        vini.add(v);
        prezzo=v.getPrezzo()*quantità;
        riga=new RigaAcquisto(v.getNomeAzienda(), v.getPartitaIva(), v.getIDvino(), v.getTipologia(), v.getMarchio(), v.getProvenienza(),quantità, prezzo);
        sovrascriviFile(vini);
        return riga;
    }

    public static void sovrascriviFile(LinkedList<GestoreVino> v){
        File f = new File("Vini.txt");
        f.delete();

        try {
            // Stampa su file dei dati nel formato richiesto
            PrintWriter output = new PrintWriter(new FileOutputStream("Vini.txt", true));
            for(GestoreVino g: v) {
                output.append(g.getNomeAzienda() + ", " + g.getPartitaIva() +
                        ", " + g.getIDvino() + ", " + g.getTipologia() +
                        ", " + g.getMarchio() + ", " + g.getProvenienza() +
                        ", " + g.getPrezzo() + ", " + g.getQuantitaDisponibili() + "\n");
            }
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Errore!");
            e.printStackTrace();
        }

    }

    public static Cliente associaCliente(String nome, String cognome, String email) {
        LinkedList<Cliente> clienti=new LinkedList<>();
        Cliente cliente;
        LinkedList<Cliente> client;
        client = org.example.Ubp3.copiaListaClienti();
        for (Cliente g: client){
            clienti.add(g);
        }
        for (Cliente c : clienti) {
            //System.out.println(c);
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome) && c.getEmail().equals(email)) {
                System.out.println("Cliente trovato!");
                return c;
            }
        }
        System.out.println("Cliente non presente in lista!");
        System.out.println("Vuoi inserire un nuovo cliente?y/n:");
        String scelta = scan.nextLine();
        if(scelta.equals("y")) {
            System.out.println("Inserisci cliente");
            System.out.println("Numero di telefono:");
            String numeroTelefono = scan.nextLine();

            cliente = new Cliente(nome, cognome, email, numeroTelefono);
            org.example.Ubp3.confermaCliente(cliente);
            return cliente;
        } else if (scelta.equals("n")) {
            System.out.println("Cliente non inserito!");
        }else{
            System.out.println("Errore!");
        }
         return null;
    }

    public static void conferma(String dataVendita, Cliente c, float prezzoTot){

            Acquisto acquisto;

            File f = new File("Acquisti.txt");
            try {
                // Stampa su file dei dati nel formato richiesto
                PrintWriter output = new PrintWriter(new FileOutputStream("Acquisti.txt", true));
              if(c==null) {
                  acquisto = new Acquisto(dataVendita, prezzoTot);
                  acquisti.add(acquisto);
                  output.append(acquisto.getData() + ", " + acquisto.getPrezzoTot()+ "\n");
                          //output.append(acquisto.getData() + ", " + acquisto.getPrezzoTot() + ", " +"null" +
                   //       ", " + "null" + ", " + "null" + "\n");
              }else{
                  acquisto = new Acquisto(dataVendita,c, prezzoTot);
                  acquisti.add(acquisto);
                  output.append(acquisto.getData() + ", " + acquisto.getPrezzoTot() + ", " + acquisto.getCliente().getNome() +
                          ", " + acquisto.getCliente().getCognome() + ", " + acquisto.getCliente().getEmail() + "\n");
              }
                output.close();

            } catch (FileNotFoundException e) {
                System.out.println("Errore!");
                e.printStackTrace();
            }
            System.out.println("Acquisto aggiunto correttamente!");

    }


    public static float applicaCodiceSconto(float p,String cod){
        float newPrezzoTot=0;
        int percentuale=0;
        float d;
        codiciSconto.add(codice1);
        codiciSconto.add(codice2);
       codiciSconto.add(codice3);

        for (CodiceSconto cs: codiciSconto){
            if(cs.getCodice().equals(cod)){
                percentuale=cs.getPercentuale();
                newPrezzoTot=calcoloNuovoPrezzo(p, percentuale);
                return newPrezzoTot;
            }
        }
      return 0;

    }

    public static LinkedList<Acquisto> copiaListaAcquisti(){
        LinkedList<Acquisto> acquisti = new LinkedList<>();
        Acquisto acq;
        File f = new File("Acquisti.txt");
        try {
            // Lettura da file di testo
            Scanner input = new Scanner(f);
            while (input.hasNextLine()) {
                String temp = input.nextLine();
                String[] p = temp.split(", ");
                String data = p[0];
                float prezzo = Float.parseFloat(p[1]);
                acq = new Acquisto(data, prezzo);
                acquisti.add(acq);
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Errore file Acquisti!");
        }
        return acquisti;
    }

    public static LinkedList<Acquisto> cercaVendita(String dataVendita){
        LinkedList<Acquisto> acquisti;
        LinkedList<Acquisto> vendite=new LinkedList<>();
        acquisti=copiaListaAcquisti();
        for(Acquisto a: acquisti){
            if(a.getData().equals(dataVendita)){
                vendite.add(a);
            }
        }
        return vendite;
    }

    public static LinkedList<PrenotazioneVini> copiaPrenotazioni(){
        LinkedList<PrenotazioneVini> prenotazioneVini = new LinkedList<>();
        File f = new File("prenotazioneVini.txt");
        try {
            // Lettura da file di testo
            Scanner input = new Scanner(f);
            while (input.hasNextLine()) {
                String temp = input.nextLine();
                String[] p = temp.split(", ");
                String nomeAzienda = p[0];
                String partitaIva = p[1];
                double IDVino = Double.parseDouble(p[2]);
                String tipologia = p[3];
                String marchio = p[4];
                String provenienza = p[5];
                int quantita = Integer.parseInt(p[6]);
                PrenotazioneVini pr = new PrenotazioneVini(nomeAzienda, partitaIva, IDVino, tipologia, marchio, provenienza, quantita);
                prenotazioneVini.add(pr);


            }
            input.close();
        } catch (Exception e) {
            System.out.println("Errore file Acquisti!");
        }
        return prenotazioneVini;

    }

    public static void eliminaFilePrenotazioneVini(LinkedList<PrenotazioneVini> prenotazioni){
        File f = new File("prenotazioneVini.txt");
        f.delete();

        try {
            // Stampa su file dei dati nel formato richiesto
            PrintWriter output = new PrintWriter(new FileOutputStream("prenotazioneVini.txt", true));
        for (PrenotazioneVini p: prenotazioni) {
            output.append(p.getNomeAzienda() + ", " + p.getPartitaIva() +
                    ", " + p.getIDvino() + ", " + p.getTipologia() +
                    ", " + p.getMarchio() + ", " + p.getProvenienza() +
                    ", " + p.getQuantitàPrenotazione() + "\n");
        }
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Errore!");
            e.printStackTrace();
        }

    }
    public static PrenotazioneVini inserisciPrenotazione(String nomeAzienda, String partitaIva, double IDVino, String tipologia, String marchio, String provenienza, int quantitàPrenotazione){
    //LinkedList<PrenotazioneVini> pr=copiaPrenotazioni();
        LinkedList<PrenotazioneVini> prenotazioni=new LinkedList<>();
        PrenotazioneVini p=new PrenotazioneVini(nomeAzienda, partitaIva, IDVino, tipologia, marchio, provenienza, quantitàPrenotazione);
        prenotazioni.add(p);
        File f = new File("prenotazioneVini.txt");
        try {
            // Stampa su file dei dati nel formato richiesto
            PrintWriter output = new PrintWriter(new FileOutputStream("prenotazioneVini.txt", true));

            output.append(p.getNomeAzienda() + ", " + p.getPartitaIva() +
                    ", " + p.getIDvino() + ", " + p.getTipologia() +
                    ", " + p.getMarchio() + ", " + p.getProvenienza() +
                     ", " + p.getQuantitàPrenotazione() + "\n");

            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Errore!");
            e.printStackTrace();
        }
        System.out.println("Vino aggiunto correttamente!");

      return p;
    }

    public static PrenotazioneClienti associaPrenotazioneCliente(Cliente c, LinkedList<PrenotazioneVini> prenotazioniV){
        PrenotazioneClienti pc=new PrenotazioneClienti(c, prenotazioniV);
        File f = new File("PrenotazioniClienti.txt");
        try {
            // Stampa su file dei dati nel formato richiesto
            PrintWriter output = new PrintWriter(new FileOutputStream("PrenotazioniClienti.txt", true));
            output.append(c + "\n");
            for (PrenotazioneVini pv: prenotazioniV) {
                output.append( pv + "\n");
            }
            output.close();
            System.out.println("File creato correttamente!");

        } catch (FileNotFoundException e) {
            System.out.println("Errore!");
            e.printStackTrace();
        }
 return pc;
    }

    public static float calcoloNuovoPrezzo(float p, int percentuale){
        float d=(p*percentuale)/100;
        return p-d;
    }





}
