package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class CasiDuso {
    static Scanner scan = new Scanner(System.in);


    public static void UC1() throws IOException {
        GestoreVino vino;
        //boolean d;
        System.out.println("Inserisci nuovo vino:\n" +
                "Nome azienda:");
        String nomeAzienda = scan.nextLine();
        System.out.println("Partita Iva:");
        String partitaIva = scan.nextLine();
        System.out.println("IDvino:");
        double IDvino = Double.parseDouble(scan.nextLine());
        System.out.println("Tipologia:");
        String tipologia = scan.nextLine();
        System.out.println("Marchio:");
        String marchio = scan.nextLine();
        System.out.println("Provenienza:");
        String provenienza = scan.nextLine();
        System.out.println("Prezzo:");
        float prezzo = Float.parseFloat(scan.nextLine());
        System.out.println("Quantità disponibili:");
        int quantitàDisponibili = Integer.parseInt(scan.nextLine());
        vino = org.example.Ubp3.inserisciVino(nomeAzienda, partitaIva, IDvino, tipologia, marchio, provenienza, prezzo, quantitàDisponibili);
        if (vino != null) {
            //vino=new GestoreVino(nomeAzienda, partitaIva, IDvino, tipologia, marchio, provenienza, prezzo, quantitàDisponibili);
            System.out.println(vino);
            System.out.println("Vuoi confermare il vino inserito? y/n");
            String x = scan.nextLine();
            if (x.equals("y")) {
                org.example.Ubp3.confermaVino(vino);
            } else if (x.equals("n")) {
                System.out.println("Inserimento annullato!");
            } else {
                System.out.println("Errore!");
            }
        }
    }

    public static void UC2() throws IOException {
        boolean y = true;

        LinkedList<RigaOrdine> righeOrdine;
        LinkedList<PrenotazioneVini> prenotazioneV;
        RigaOrdine rOrdine;
        System.out.println("Nome azienda:");
        String nAzienda = scan.nextLine();
        System.out.println("Partita Iva:");
        String pIva = scan.nextLine();
        righeOrdine = org.example.Ubp3.inserisciAzienda(nAzienda, pIva);
        if (righeOrdine.isEmpty()) {
            System.out.println("Non ci sono prenotazioni");
        } else {
            System.out.println(righeOrdine);
        }
        do {
            System.out.println("Inserisci vino da prenotare:");
            System.out.println("IDvino:");
            double ID = Double.parseDouble(scan.nextLine());
            System.out.println("Tipologia:");
            String t = scan.nextLine();
            System.out.println("Marchio:");
            String m = scan.nextLine();
            System.out.println("Provenienza:");
            String pro = scan.nextLine();
            System.out.println("Quantità:");
            int q = Integer.parseInt(scan.nextLine());
            rOrdine = org.example.Ubp3.inserisciOrdineVini(nAzienda, pIva, q, ID, t, m, pro);
            System.out.println(rOrdine);
            righeOrdine.add(rOrdine);
            System.out.println("Vuoi inserire un altro vino? y/n");
            String yes = scan.nextLine();
            if (yes.equals("y")) {
                y = true;
            } else if (yes.equals("n")) {
                y = false;

            } else {
                System.out.println("Errore!");
            }
        } while (y);

        System.out.println("Vuoi confermare l'ordine inserito? y/n");
        String x = scan.nextLine();
        if (x.equals("y")) {
            org.example.Ubp3.confermaOrdine(nAzienda, pIva, righeOrdine);
        } else if (x.equals("n")) {
            System.out.println("Ordine annullato!");
            righeOrdine.clear();
        } else {
            System.out.println("Errore!");
        }


    }

    public static void UC3() throws IOException {
        Cliente cliente;
        System.out.println("Inserisci nuovo cliente:\n" +
                "Nome: ");
        String nome = scan.nextLine();
        System.out.println("Cognome:");
        String cognome = scan.nextLine();
        System.out.println("Email:");
        String email = scan.nextLine();
        System.out.println("Numero di telefono:");
        String numeroTelefono = scan.nextLine();


        cliente = org.example.Ubp3.inserisciCliente(nome, cognome, email, numeroTelefono);
        if (cliente != null) {
            System.out.println(cliente);
            System.out.println("Vuoi confermare il cliente inserito? y/n");
            String x = scan.nextLine();
            if (x.equals("y")) {
                org.example.Ubp3.confermaCliente(cliente);
            } else if (x.equals("n")) {
                System.out.println("Inserimento annullato!");
            } else {
                System.out.println("Errore!");
            }
        }
    }






}






