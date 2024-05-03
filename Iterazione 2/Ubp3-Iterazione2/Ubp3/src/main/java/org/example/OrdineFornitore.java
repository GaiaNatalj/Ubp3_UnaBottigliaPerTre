package org.example;

import java.util.LinkedList;

public class OrdineFornitore extends Azienda {

	private LinkedList<RigaOrdine> righeOrdine;

	public OrdineFornitore(String nomeAzienda, String partitaIva, LinkedList<RigaOrdine> righe) {
		super(nomeAzienda, partitaIva);
		this.righeOrdine = righe;
	}

	public LinkedList<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(LinkedList<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
	}

	@Override
	public String toString() {
		return "Azienda{" +
				"nomeAzienda='" + getNomeAzienda() + '\'' +
				", partitaIva='" + getPartitaIva() + '\'' +
				'}' + "OrdineFornitore{" +
				"rigaOrdine=" + righeOrdine +
				'}';
	}

}
