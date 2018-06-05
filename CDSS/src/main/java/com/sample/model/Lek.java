package com.sample.model;

import java.util.ArrayList;

public class Lek {
	
	private String naziv;
	private String tip;
	private ArrayList<String> sastojci;
	
	
	public Lek() {
		super();
	}

	public Lek(String naziv, String tip, ArrayList<String> sastojci) {
		super();
		this.naziv = naziv;
		this.tip = tip;
		this.sastojci = sastojci;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public ArrayList<String> getSastojci() {
		return sastojci;
	}

	public void setSastojci(ArrayList<String> sastojci) {
		this.sastojci = sastojci;
	}

}
