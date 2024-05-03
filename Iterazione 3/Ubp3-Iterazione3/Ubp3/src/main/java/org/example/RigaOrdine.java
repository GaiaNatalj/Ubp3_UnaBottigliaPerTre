package org.example;

public class RigaOrdine extends Vino{

	private int quantitàPrenotazione;


	public RigaOrdine(String nomeAzienda, String partitaIva, double IDvino, String tipologia, String marchio, String provenienza,int quantitàPrenotazione) {
		super(nomeAzienda, partitaIva, IDvino, tipologia, marchio, provenienza);
		this.quantitàPrenotazione = quantitàPrenotazione;
	}

	public int getQuantitàPrenotazione() {
		return quantitàPrenotazione;
	}

	public void setQuantitàPrenotazione(int quantitàPrenotazione) {
		this.quantitàPrenotazione = quantitàPrenotazione;
	}

	@Override
	public String toString() {
		return "RigaOrdine{" +
				" nomeAzienda='" + getNomeAzienda() + '\'' +
				", partitaIva='" + getPartitaIva() + '\'' +
				", IDvino=" + getIDvino() +'\'' +
				", tipologia='" + getTipologia() + '\'' +
				", marchio='" + getMarchio() + '\'' +
				", provenienza='" + getProvenienza() + '\'' +
				", quantitàPrenotazione=" + quantitàPrenotazione +
				'}';
	}

}
