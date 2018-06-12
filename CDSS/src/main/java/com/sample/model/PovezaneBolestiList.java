package com.sample.model;

import java.util.ArrayList;

public class PovezaneBolestiList {
	
	private ArrayList<Povezane> povezane;

	public PovezaneBolestiList(ArrayList<Povezane> povezane) {
		super();
		this.povezane = povezane;
	}

	public ArrayList<Povezane> getPovezane() {
		return povezane;
	}

	public void setPovezane(ArrayList<Povezane> povezane) {
		this.povezane = povezane;
	}
	 

}
