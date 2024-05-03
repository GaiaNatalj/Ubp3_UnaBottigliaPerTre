package org.example;

public class RigaAcquisto extends Vino{

	private int quantità;
	private float prezzo;


	public RigaAcquisto(String nomeAzienda, String partitaIva, double IDvino, String tipologia, String marchio, String provenienza, int quantità, float prezzo) {
		super(nomeAzienda, partitaIva, IDvino, tipologia, marchio, provenienza);
		this.quantità=quantità;
		this.prezzo=prezzo;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "RigaAcquisto{" +
				"quantità=" + quantità +
				'}';
	}
}
