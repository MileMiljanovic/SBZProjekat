package com.sample.model;

public class Result {
	
	private Integer noSymptoms;
	private String result;
	private boolean sviZadovoljeni;
	
	public Result(Integer noSymptoms, String result, boolean sviZadovoljeni) {
		super();
		this.noSymptoms = noSymptoms;
		this.result = result;
		this.sviZadovoljeni = sviZadovoljeni;
	}

	public Integer getNoSymptoms() {
		return noSymptoms;
	}

	public void setNoSymptoms(Integer noSymptoms) {
		this.noSymptoms = noSymptoms;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isSviZadovoljeni() {
		return sviZadovoljeni;
	}

	public void setSviZadovoljeni(boolean sviZadovoljeni) {
		this.sviZadovoljeni = sviZadovoljeni;
	}
	
	
	

}
