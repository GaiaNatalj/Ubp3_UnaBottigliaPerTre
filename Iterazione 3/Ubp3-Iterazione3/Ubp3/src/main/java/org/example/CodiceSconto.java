package org.example;

public class CodiceSconto {

	private String codice;

	private int percentuale;

	public CodiceSconto(String codice, int percentuale) {
		this.codice = codice;
		this.percentuale=percentuale;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getPercentuale() {
		return percentuale;
	}

	public void setPercentuale(int percentuale) {
		this.percentuale = percentuale;
	}

	@Override
	public String toString() {
		return "CodiceSconto{" +
				"codice='" + codice + '\'' +
				", percentuale=" + percentuale +
				'}';
	}
}
