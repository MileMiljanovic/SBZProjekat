package com.sample.model;


public class Lekar {
	
	private String username;
	private String password;
	private String ime;
	private String prezime;
	
	public Lekar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lekar(String username, String password, String ime, String prezime) {
		super();
		this.username = username;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
