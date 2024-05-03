package org.example;

import org.example.RigaAcquisto;

import java.util.Collection;
import java.util.LinkedList;

public class Acquisto {

	private String data;
	private Cliente cliente;
	private float prezzoTot;

	public Acquisto(String data, Cliente cliente,float prezzoTot) {
		this.data=data;
		this.cliente=cliente;
		this.prezzoTot=prezzoTot;
	}

	public Acquisto(String data,float prezzoTot) {
		this.data=data;
		this.prezzoTot=prezzoTot;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getPrezzoTot() {
		return prezzoTot;
	}

	public void setPrezzoTot(float prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	@Override
	public String toString() {
		return "Acquisto{" +
				"data='" + data + '\'' +
				", prezzoTot=" + prezzoTot +
				'}' + '\n';
	}
}
