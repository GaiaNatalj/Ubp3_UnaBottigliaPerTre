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
            org.example.Ubp3.ordineAnnullato();
        } else {
            System.out.println("Errore!");
            org.example.Ubp3.ordineAnnullato();
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

    public static void UC4() {
        GestoreVino vino;
        Cliente cliente = null;
        RigaAcquisto rigaAcquisto;
        LinkedList<GestoreVino> viniPartenza = org.example.Ubp3.copiaListaVini();
        LinkedList<RigaAcquisto> righeAcquisto = new LinkedList<>();
        float prezzoTot = 0;
        float prezzoTot2 = 0;
        System.out.println("Vuoi inserire un vino all'acquisto?y/n");
        String scelta = scan.nextLine();
        if (scelta.equals("n")) {
            return;
        } else if (!scelta.equals("n") && !scelta.equals("y")) {
            System.out.println("Inserimento errato!");
            return;
        }

        do {
            System.out.println("Ricerca vino:");
            System.out.println("Tipologia:");
            String t = scan.nextLine();
            System.out.println("Marchio:");
            String m = scan.nextLine();
            vino = org.example.Ubp3_2.ricercaVino(t, m);
            if (vino != null) {
                if (vino.getQuantitaDisponibili() != 0) {
                    System.out.println("Vuoi confermare l'acquisto del vino? y/n");
                    String x = scan.nextLine();
                    if (x.equals("y")) {
                        System.out.println("Quantità vino:");
                        int q = Integer.parseInt(scan.nextLine());

                        if (q <= vino.getQuantitaDisponibili()) {
                            rigaAcquisto = org.example.Ubp3_2.aggiungiVino(vino, q);
                            righeAcquisto.add(rigaAcquisto);
                        } else {
                            System.out.println("Le quantità presenti in magazzino sono inferiori a quelle richieste!\n");

                        }

                    } else if (x.equals("n")) {
                        System.out.println("Inserimento annullato!\n");
                    } else {
                        System.out.println("Inserimento Errato!\n");
                    }
                } else {
                    System.out.println("Vino non presente in magazzino! (quantità disponibili==0)\n");
                }
            } else {
                System.out.println("Vino non presente in lista!\n");

            }
            System.out.println("Vuoi inserire un altro vino all'acquisto?y/n");
            scelta = scan.nextLine();
            if (!scelta.equals("n") && !scelta.equals("y")) {
                System.out.println("Inserimento errato!\n");
                return;
            }

        } while (scelta.equals("y"));
        if(righeAcquisto.isEmpty()) {
            return;
        }
        for (RigaAcquisto ra : righeAcquisto) {
            prezzoTot = prezzoTot + ra.getPrezzo();
        }
        System.out.print("Prezzo totale: " + prezzoTot + "\n");
        System.out.println("Vuoi aggiungere un codice sconto?y/n");
        String z = scan.nextLine();
        if (z.equals("y")) {

            System.out.println("Aggiungi codice:");
            String cod = scan.nextLine();
            prezzoTot2 = org.example.Ubp3_2.applicaCodiceSconto(prezzoTot, cod);
            if (prezzoTot2 == 0) {
                System.out.print("Codice sconto non valido!\n");
            } else {
                prezzoTot = prezzoTot2;
                System.out.print("Nuovo prezzo totale: " + prezzoTot + "\n");
            }
        } else if (z.equals("n")) {
            System.out.println("Codice sconto non applicato!\n");

        } else {
            System.out.println("Inserimento errato!\n");
        }


        System.out.println("Vuoi Associare un cliente?y/n");
        String p = scan.nextLine();
        if (p.equals("y")) {
            System.out.println("Associa cliente ");
            System.out.println("Nome:");
            String n = scan.nextLine();
            System.out.println("Cognome:");
            String c = scan.nextLine();
            System.out.println("Email:");
            String e = scan.nextLine();
            cliente = org.example.Ubp3_2.associaCliente(n, c, e);
        } else if (p.equals("n")) {
            System.out.println("Cliente non associato!\n");

        } else {
            System.out.println("Inserimento errato!\n");
        }


        System.out.println("Vuoi confermare l'acquisto?y/n");
        String s = scan.nextLine();

        if (s.equals("y")) {
            System.out.println("Inserisci data:");
            String d = scan.nextLine();
            org.example.Ubp3_2.conferma(d, cliente, prezzoTot);

        } else if (s.equals("n")) {
            System.out.println("Acquisto annullato!\n");
            org.example.Ubp3_2.sovrascriviFile(viniPartenza);
            return;

        } else {
            System.out.println("Errore!\n");
        }


    }

    public static void UC5() {
        LinkedList<Acquisto> vendite;
        System.out.println("Ricerca vendita ");
        System.out.println("Data vendita:");
        String d = scan.nextLine();
        vendite = org.example.Ubp3_2.cercaVendita(d);
        if (vendite.isEmpty()) {
            System.out.print("Vendita non trovata!");

        } else {
            System.out.print(vendite);
        }
    }

    public static void UC6() {
        PrenotazioneVini pv;
        PrenotazioneClienti pc;
        LinkedList<PrenotazioneVini> prenotazioniVini = new LinkedList<>();
        System.out.println("Inserisci prenotazione: ");
        //System.out.println("Vuoi inserire un vino alla prenotazione?y/n");
        String scelta = "y";
        do {
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
            System.out.println("Quantità prenotazione:");
            int quantità = Integer.parseInt(scan.nextLine());
            pv = org.example.Ubp3_2.inserisciPrenotazione(nomeAzienda, partitaIva, IDvino, tipologia, marchio, provenienza, quantità);
            System.out.print(pv);
            prenotazioniVini.add(pv);
            System.out.println("\nVuoi inserire un altro vino alla prenotazione?y/n");
            scelta = scan.nextLine();
            if (!scelta.equals("n") && !scelta.equals("y")) {
                System.out.println("Inserimento errato!\n");
                return;
            }

        } while (scelta.equals("y"));
        System.out.println("Associa cliente: ");
        System.out.println("Inserisci cliente:\n" +
                "Nome: ");
        String nome = scan.nextLine();
        System.out.println("Cognome:");
        String cognome = scan.nextLine();
        System.out.println("Email:");
        String email = scan.nextLine();
        System.out.println("Numero di telefono:");
        String numero = scan.nextLine();
        Cliente c = new Cliente(nome, cognome, email, numero);
        pc = org.example.Ubp3_2.associaPrenotazioneCliente(c, prenotazioniVini);
        System.out.print(pc);

    }


}






