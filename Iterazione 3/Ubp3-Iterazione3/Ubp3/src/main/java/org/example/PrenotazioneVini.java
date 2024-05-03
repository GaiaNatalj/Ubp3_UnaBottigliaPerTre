package org.example;

public class PrenotazioneVini extends Vino{

	private int quantitàPrenotazione;

	public PrenotazioneVini(String nomeAzienda, String partitaIva, double IDvino, String tipologia, String marchio, String provenienza, int quantitàPrenotazione) {
		super(nomeAzienda, partitaIva, IDvino, tipologia, marchio, provenienza);
		this.quantitàPrenotazione = quantitàPrenotazione;
	}

	public int getQuantitàPrenotazione() {
		return quantitàPrenotazione;
	}

	@Override
	public String getNomeAzienda() {
		return super.getNomeAzienda();
	}

	@Override
	public void setNomeAzienda(String nomeAzienda) {
		super.setNomeAzienda(nomeAzienda);
	}

	@Override
	public String getPartitaIva() {
		return super.getPartitaIva();
	}

	@Override
	public void setPartitaIva(String partitaIva) {
		super.setPartitaIva(partitaIva);
	}

	@Override
	public double getIDvino() {
		return super.getIDvino();
	}

	@Override
	public void setIDvino(double IDvino) {
		super.setIDvino(IDvino);
	}

	@Override
	public String getTipologia() {
		return super.getTipologia();
	}

	@Override
	public void setTipologia(String tipologia) {
		super.setTipologia(tipologia);
	}

	@Override
	public String getMarchio() {
		return super.getMarchio();
	}

	@Override
	public void setMarchio(String marchio) {
		super.setMarchio(marchio);
	}

	@Override
	public String getProvenienza() {
		return super.getProvenienza();
	}

	@Override
	public void setProvenienza(String provenienza) {
		super.setProvenienza(provenienza);
	}

	@Override
	public String toString() {
		return "PrenotazioneVini{" +

				"quantitàPrenotazione=" + quantitàPrenotazione +

				", nomeAzienda='" + getNomeAzienda() + '\'' +
				", partitaIva='" + getPartitaIva() + '\'' +

				", IDvino=" + getIDvino() +'\'' +
				", tipologia='" + getTipologia() + '\'' +
				", marchio='" + getMarchio() + '\'' +
				", provenienza='" + getProvenienza() + '\'' +


				'}';
	}

}
