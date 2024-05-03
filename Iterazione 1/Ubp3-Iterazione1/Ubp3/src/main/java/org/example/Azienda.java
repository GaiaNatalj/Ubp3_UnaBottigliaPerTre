package org.example;

public class Azienda {

	private String nomeAzienda;

	private String partitaIva;


	public Azienda(String nomeAzienda, String partitaIva) {
		this.nomeAzienda = nomeAzienda;
		this.partitaIva = partitaIva;
	}

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	@Override
	public String toString() {
		return "Azienda{" +
				"nomeAzienda='" + nomeAzienda + '\'' +
				", partitaIva='" + partitaIva + '\'' +
				'}';
	}

}
