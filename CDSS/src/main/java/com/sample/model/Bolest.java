package com.sample.model;

import java.util.ArrayList;

public class Bolest {
	
	private String naziv;
	private String grupa;
	private ArrayList<String> simptomi;
	
	public Bolest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bolest(String naziv, String grupa, ArrayList<String> simptomi) {
		super();
		this.naziv = naziv;
		this.grupa = grupa;
		this.simptomi = simptomi;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public ArrayList<String> getSimptomi() {
		return simptomi;
	}

	public void setSimptomi(ArrayList<String> simptomi) {
		this.simptomi = simptomi;
	}
	
	

}
