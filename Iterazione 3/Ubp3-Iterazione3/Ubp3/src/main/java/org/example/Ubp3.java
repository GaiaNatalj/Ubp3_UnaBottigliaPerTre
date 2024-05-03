package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;


public class Ubp3 {

	static Scanner scan = new Scanner(System.in);
	private static LinkedList<GestoreVino> vini = new LinkedList<>();
	private static LinkedList<Cliente> clienti = new LinkedList<>();

	private static LinkedList<PrenotazioneVini> prenotazioniVini=new LinkedList<>();

	private static LinkedList<RigaOrdine> righeOrdine=new LinkedList<>();



	private static PrenotazioneVini pv=new PrenotazioneVini("Azienda1", "111", 111 ,"Rosso",
			"Antinori", "Toscana", 5);
	private static PrenotazioneVini pv1=new PrenotazioneVini("Azienda2", "222", 222 ,"Rosso",
			"Antinori", "Toscana", 5);
	private static PrenotazioneVini pv2=new PrenotazioneVini("Azienda3", "333", 333 ,"Rosso",
			"Antinori", "Toscana", 5);



	public Ubp3() {
	}

	public static LinkedList<GestoreVino> getVini() {
		return vini;
	}

	public static void setVini(LinkedList<GestoreVino> vini) {
		Ubp3.vini = vini;
	}

	public static LinkedList<Cliente> getClienti() {
		return clienti;
	}

	public static void setClienti(LinkedList<Cliente> clienti) {
		Ubp3.clienti = clienti;
	}

	public static LinkedList<PrenotazioneVini> getPrenotazioniVini() {
		return prenotazioniVini;
	}

	public static void setPrenotazioniVini(LinkedList<PrenotazioneVini> prenotazioniVini) {
		Ubp3.prenotazioniVini = prenotazioniVini;
	}

	public static LinkedList<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public static void setRigheOrdine(LinkedList<RigaOrdine> righeOrdine) {
		Ubp3.righeOrdine = righeOrdine;
	}




	public static GestoreVino inserisciVino(String nomeA, String partitaIva, double IDVino, String tipologia, String marchio, String provenienza, float prezzo, int quantità) {
		GestoreVino vino;
		LinkedList<GestoreVino> gVini;
		gVini = copiaListaVini();
		/*for (GestoreVino g: gVini){
			vini.add(g);
		}*/
		for (GestoreVino v : gVini) {
			if (v.getIDvino() == IDVino) {
				System.out.println("Vino già presente in lista!");
				return null;
			}
		}
		vino=new GestoreVino(nomeA, partitaIva, IDVino, tipologia, marchio, provenienza, prezzo, quantità);
		return vino;
	}

	public static void confermaVino(GestoreVino gestoreVino) {
		File f = new File("Vini.txt");
         vini.add(gestoreVino);
			try {
				// Stampa su file dei dati nel formato richiesto
				PrintWriter output = new PrintWriter(new FileOutputStream("Vini.txt", true));

				output.append(gestoreVino.getNomeAzienda() + ", " + gestoreVino.getPartitaIva() +
						", " + gestoreVino.getIDvino() + ", " + gestoreVino.getTipologia() +
						", " + gestoreVino.getMarchio() + ", " + gestoreVino.getProvenienza() +
						", " + gestoreVino.getPrezzo() + ", " + gestoreVino.getQuantitaDisponibili() + "\n");

				output.close();

			} catch (FileNotFoundException e) {
				System.out.println("Errore!");
				e.printStackTrace();
			}
			System.out.println("Vino aggiunto correttamente!");


		}


	public static Cliente inserisciCliente(String nome, String cognome, String email, String numero) {
		Cliente cliente;
		LinkedList<Cliente> client;
		client = copiaListaClienti();
		for (Cliente g: client){
			clienti.add(g);
		}
		for (Cliente c : clienti) {
			//System.out.println(c);
			if (c.getEmail().equals(email)) {
				System.out.println("email già inserita");
				return null;
			}
		}
		cliente=new Cliente(nome, cognome, email, numero, 0);
		return cliente;
	}

	public static void confermaCliente(Cliente cliente) {
		File f = new File("Clienti.txt");
		clienti.add(cliente);
			try {
				// Stampa su file dei dati nel formato richiesto
				PrintWriter output = new PrintWriter(new FileOutputStream("Clienti.txt", true));

				output.append(cliente.getNome() + ", " + cliente.getCognome() +
						", " + cliente.getEmail() + ", " + cliente.getNumeroTelefono() +
						", " + cliente.getPunti() + "\n");
				output.close();

			} catch (FileNotFoundException e) {
				//System.out.println("Errore!");
			}

			System.out.println("cliente aggiunto correttamente");

		}



	public static LinkedList<Cliente> copiaListaClienti() {
		LinkedList<Cliente> clienti2 = new LinkedList<>();
		File f = new File("Clienti.txt");
		try {
			// Lettura da file di testo
			Scanner input = new Scanner(f);
			while (input.hasNextLine()) {
				String temp = input.nextLine();
				String[] p = temp.split(", ");
				String nome = p[0];
				String cognome = p[1];
				String email = p[2];
				String numero = p[3];
				int punti = Integer.parseInt(p[4]);
				Cliente c = new Cliente(nome, cognome, email, numero, punti);
				clienti2.add(c);
			}
			input.close();
		} catch (Exception e) {
			//System.out.println("Errore!");
		}
		return clienti2;
	}


	public static LinkedList<GestoreVino> copiaListaVini() {
		File f = new File("Vini.txt");
		 LinkedList<GestoreVino> vini2 = new LinkedList<>();
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
				float prezzo = Float.parseFloat(p[6]);
				int quantita = Integer.parseInt(p[7]);
				GestoreVino g = new GestoreVino(nomeAzienda, partitaIva, IDVino, tipologia, marchio, provenienza, prezzo, quantita);
				vini2.add(g);
			}
			input.close();

		} catch (Exception e) {
			//System.err.println("Errore!");
		}
		return vini2;
	}


	public static LinkedList<RigaOrdine> inserisciAzienda(String nomeAzienda, String partitaIva) {
		LinkedList<RigaOrdine> prenotazioniv=new LinkedList<>();
		LinkedList<PrenotazioneVini> prenotazioni=new LinkedList<>();
		//prenotazioniVini.add(pv);
		//prenotazioniVini.add(pv1);
		//prenotazioniVini.add(pv2);
		prenotazioniVini=org.example.Ubp3_2.copiaPrenotazioni();
		prenotazioni=org.example.Ubp3_2.copiaPrenotazioni();
		for(int i=0;i<prenotazioni.size();i++){
			PrenotazioneVini p=prenotazioni.get(i);
			if(p.getPartitaIva().equals(partitaIva) && p.getNomeAzienda().equals(nomeAzienda)){
           RigaOrdine ro=new RigaOrdine(p.getNomeAzienda(), p.getPartitaIva(), p.getIDvino(),
					p.getTipologia(), p.getMarchio(), p.getProvenienza(), p.getQuantitàPrenotazione());
		   prenotazioni.remove(i);
			prenotazioniv.add(ro);
			//righeOrdine.add(ro);
			}

		}
		org.example.Ubp3_2.eliminaFilePrenotazioneVini(prenotazioni);
		return prenotazioniv;
	}


	public static RigaOrdine inserisciOrdineVini(String nomeAzienda, String partitaIva, int quantitàPrenotazione,
															 double IDVino, String tipologia, String marchio, String provenienza){
		RigaOrdine ro=new RigaOrdine(nomeAzienda, partitaIva, IDVino, tipologia, marchio, provenienza, quantitàPrenotazione);

		return ro;

	}

	public static void confermaOrdine(String nomeAzienda, String partitaIva, LinkedList<RigaOrdine> righe){
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci nome file:");
		String nomeFile = scan.nextLine();
		File f = new File(nomeFile+".txt");
		//LinkedList<OrdineFornitore> ordini = new LinkedList<>();
		OrdineFornitore ordine =  new OrdineFornitore(nomeAzienda, partitaIva, righe);
		try {
			// Stampa su file dei dati nel formato richiesto
			PrintWriter output = new PrintWriter(new FileOutputStream(nomeFile+".txt", true));
			output.append("Nome Azienda:  "+ ordine.getNomeAzienda() + ", Partita Iva: " + ordine.getPartitaIva()+"\n");
         for(RigaOrdine r: ordine.getRigheOrdine()) {
			output.append("Riga Ordine:{ "+ r.getIDvino()+", "+ r.getTipologia()+", "+
					r.getMarchio()+", "+ r.getProvenienza()+ ", "+ r.getQuantitàPrenotazione()+"}\n");
		}
			output.close();
		System.out.println("File creato correttamente!");

		} catch (FileNotFoundException e) {
			System.out.println("Errore!");
			e.printStackTrace();
		}

	}

	public static void ordineAnnullato(){
		org.example.Ubp3_2.eliminaFilePrenotazioneVini(prenotazioniVini);
	}



}