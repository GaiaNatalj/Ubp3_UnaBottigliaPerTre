package org.example;

public class GestoreVino extends Vino{

	private float prezzo;

	private int quantitaDisponibili;


	public GestoreVino(String nomeAzienda, String partitaIva, double IDvino, String tipologia,
					   String marchio, String provenienza,
					   float prezzo, int quantitaDisponibili ){
		super(nomeAzienda, partitaIva,IDvino, tipologia,marchio,provenienza);
		this.prezzo=prezzo;
		this.quantitaDisponibili=quantitaDisponibili;

	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantitaDisponibili() {
		return quantitaDisponibili;
	}

	public void setQuantitaDisponibili(int quantitaDisponibili) {
		this.quantitaDisponibili = quantitaDisponibili;
	}



	@Override
	public String toString() {

		return  "Vino{" + '\'' +
				"IDvino=" + getIDvino() +'\'' +
				", tipologia='" + getTipologia() + '\'' +
				", marchio='" + getMarchio() + '\'' +
				", provenienza='" + getProvenienza() + '\'' +


				", nomeAzienda='" + getNomeAzienda() + '\'' +
				", partitaIva='" + getPartitaIva() + '\'' +


				", prezzo=" + prezzo + '\'' +
				", quantitaDisponibili=" + quantitaDisponibili +
				'}';
	}

}
