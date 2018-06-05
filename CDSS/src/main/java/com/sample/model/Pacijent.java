package com.sample.model;

import java.util.ArrayList;

public class Pacijent {
	
	private Integer brKarte;
	private String ime;
	private String prezime;
	private ArrayList<String> alergije;
	
	public Pacijent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pacijent(Integer brKarte, String ime, String prezime, ArrayList<String> alergije) {
		super();
		this.brKarte = brKarte;
		this.ime = ime;
		this.prezime = prezime;
		this.alergije = alergije;
	}

	public Integer getBrKarte() {
		return brKarte;
	}

	public void setBrKarte(Integer brKarte) {
		this.brKarte = brKarte;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public ArrayList<String> getAlergije() {
		return alergije;
	}

	public void setAlergije(ArrayList<String> alergije) {
		this.alergije = alergije;
	}

}
