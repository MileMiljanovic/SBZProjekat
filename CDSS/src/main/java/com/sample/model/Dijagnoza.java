package com.sample.model;

import java.sql.Date;
import java.util.ArrayList;

public class Dijagnoza {
	
	private Integer id;
	private Integer kartaPacijenta;
	private String doktor;
	private String bolest;
	private ArrayList<String> lekovi;
	private Date datum;

	public Dijagnoza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dijagnoza(Integer id, Integer kartaPacijenta, String doktor, String bolest, ArrayList<String> lekovi) {
		super();
		this.id = id;
		this.kartaPacijenta = kartaPacijenta;
		this.doktor = doktor;
		this.bolest = bolest;
		this.lekovi = lekovi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKartaPacijenta() {
		return kartaPacijenta;
	}

	public void setKartaPacijenta(Integer kartaPacijenta) {
		this.kartaPacijenta = kartaPacijenta;
	}

	public String getDoktor() {
		return doktor;
	}

	public void setDoktor(String doktor) {
		this.doktor = doktor;
	}

	public String getBolest() {
		return bolest;
	}

	public void setBolest(String bolest) {
		this.bolest = bolest;
	}

	public ArrayList<String> getLekovi() {
		return lekovi;
	}

	public void setLekovi(ArrayList<String> lekovi) {
		this.lekovi = lekovi;
	}
	
	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	
}
