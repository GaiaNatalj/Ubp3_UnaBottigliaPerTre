package org.example;

public class Vino extends Azienda {

	private double IDvino;

	private String tipologia;

	private String marchio;

	private String provenienza;


	public Vino(String nomeAzienda, String partitaIva, double IDvino, String tipologia,
				String marchio, String provenienza){
		super(nomeAzienda,partitaIva);
		this.IDvino=IDvino;
		this.tipologia=tipologia;
		this.marchio=marchio;
		this.provenienza=provenienza;
	}

	public double getIDvino() {
		return IDvino;
	}

	public void setIDvino(double IDvino) {
		this.IDvino = IDvino;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getMarchio() {
		return marchio;
	}

	public void setMarchio(String marchio) {
		this.marchio = marchio;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	@Override
	public String toString() {
		return "Vino{" +
				"IDvino=" + IDvino +
				", tipologia='" + tipologia + '\'' +
				", marchio='" + marchio + '\'' +
				", provenienza='" + provenienza + '\'' +
				'}';
	}


}
