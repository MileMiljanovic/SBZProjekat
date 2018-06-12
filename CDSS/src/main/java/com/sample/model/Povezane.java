package com.sample.model;

public class Povezane {
	
	private Integer broj;
	private String bolest;
	
	public Povezane(Integer broj, String bolest) {
		super();
		this.broj = broj;
		this.bolest = bolest;
	}

	public Integer getBroj() {
		return broj;
	}

	public void setBroj(Integer broj) {
		this.broj = broj;
	}

	public String getBolest() {
		return bolest;
	}

	public void setBolest(String bolest) {
		this.bolest = bolest;
	}
	
	

}
