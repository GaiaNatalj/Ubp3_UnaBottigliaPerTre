package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Ubp3_3 {

    public Ubp3_3() {
    }

    public static Cliente ricercaCliente(String nome, String  cognome, String email){
        LinkedList<Cliente> clienti=new LinkedList<>();
        Cliente c=null;
        LinkedList<Cliente> client;
        client = org.example.Ubp3.copiaListaClienti();
       for (Cliente g: client){
            clienti.add(g);
        }
        for (int i=0;i<clienti.size();i++) {
            c=clienti.get(i);
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome) && c.getEmail().equals(email)) {
                System.out.println("Cliente trovato!");

                return c;
            }
        }

        return null;

    }

    public static void sovrascriviFileClienti(LinkedList<Cliente> clienti){
        File f = new File("Clienti.txt");
        f.delete();

        try {
            // Stampa su file dei dati nel formato richiesto
            PrintWriter output = new PrintWriter(new FileOutputStream("Clienti.txt", true));
            for(Cliente cliente: clienti) {
                output.append(cliente.getNome() + ", " + cliente.getCognome() +
                        ", " + cliente.getEmail() + ", " + cliente.getNumeroTelefono() +
                        ", " + cliente.getPunti() + "\n");
            }

            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Errore!");
            e.printStackTrace();
        }
    }
    public static void  aggiungiPunti(Cliente cliente, int punti){
        LinkedList<Cliente> clienti=new LinkedList<>();
        LinkedList<Cliente> client;
        Cliente c;
        client = org.example.Ubp3.copiaListaClienti();
        for (Cliente g: client){
            clienti.add(g);
        }
        for (int i=0;i<clienti.size();i++) {
            c=clienti.get(i);
            if (c.getNome().equals(cliente.getNome()) && c.getCognome().equals(cliente.getCognome()) && c.getEmail().equals(cliente.getEmail())) {
                clienti.remove(i);
            }
        }
        cliente.setPunti(cliente.getPunti()+punti);
        clienti.add(cliente);
        sovrascriviFileClienti(clienti);

    }

    public static void  rimuoviPunti(Cliente cliente, int punti){
        LinkedList<Cliente> clienti=new LinkedList<>();
        LinkedList<Cliente> client;
        Cliente c;
        client = org.example.Ubp3.copiaListaClienti();
        for (Cliente g: client){
            clienti.add(g);
        }
        for (int i=0;i<clienti.size();i++) {
            c=clienti.get(i);
            if (c.getNome().equals(cliente.getNome()) && c.getCognome().equals(cliente.getCognome()) && c.getEmail().equals(cliente.getEmail())) {
                clienti.remove(i);
            }
        }
        cliente.setPunti(cliente.getPunti()-punti);
        clienti.add(cliente);
        sovrascriviFileClienti(clienti);

    }

    public static LinkedList<CodiceSconto> copiaListaCodiciSconto() {
        LinkedList<CodiceSconto> codici = new LinkedList<>();
        File f = new File("CodiciSconto.txt");
        try {
            // Lettura da file di testo
            Scanner input = new Scanner(f);
            while (input.hasNextLine()) {
                String temp = input.nextLine();
                String[] p = temp.split(", ");
                String codice = p[0];
                int percentuale = Integer.parseInt(p[1]);
                CodiceSconto c = new CodiceSconto(codice,percentuale);
                codici.add(c);
            }
            input.close();
        } catch (Exception e) {
            //System.out.println("Errore!");
        }
        return codici;
    }

    public static CodiceSconto inserisciCodiceSconto(String codice, int percentuale) {
        CodiceSconto codiceSconto;
        LinkedList<CodiceSconto> codici;
        LinkedList<CodiceSconto>  codiciSconto=new LinkedList<>();
        codici= copiaListaCodiciSconto();
        for (CodiceSconto g: codici){
            codiciSconto.add(g);
        }
        for (CodiceSconto c : codiciSconto) {
            //System.out.println(c);
            if (c.getCodice().equals(codice)) {
                System.out.println("Codice sconto già inserito");
                return null;
            }
        }
        codiceSconto=new CodiceSconto(codice, percentuale);
        return codiceSconto;
    }

    public static void confermaCodiceSconto(CodiceSconto c) {
        LinkedList<CodiceSconto> codiciSconto=new LinkedList<>();
        codiciSconto.add(c);
        File f = new File("CodiciSconto.txt");
        try {
            // Stampa su file dei dati nel formato richiesto
            PrintWriter output = new PrintWriter(new FileOutputStream("CodiciSconto.txt", true));

            output.append(c.getCodice() + ", " + c.getPercentuale() + "\n");
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Errore!");
        }

        System.out.println("Codice sconto aggiunto correttamente");

    }




}
