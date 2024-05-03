package org.example;

import java.util.Collection;

public class Cliente {

	private String nome;

	private String cognome;

	private String email;

	private String numeroTelefono;

	private int punti;


	private Collection<PrenotazioneVini> prenotazioneVini;

	public Cliente(String nome, String cognome, String email, String numeroTelefono, int punti) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.numeroTelefono = numeroTelefono;
		this.punti = punti;
	}

	public Cliente(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;

	}
	public Cliente(String nome, String cognome, String email, int punti) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.punti=punti;

	}

	public Cliente(String nome, String cognome, String email, String numeroTelefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.numeroTelefono = numeroTelefono;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"nome='" + nome + '\'' +
				", cognome='" + cognome + '\'' +
				", email='" + email + '\'' +
				", numeroTelefono='" + numeroTelefono + '\'' +
				", punti=" + punti +
				'}';
	}

}
