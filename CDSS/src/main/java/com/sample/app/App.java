package com.sample.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.sample.model.Dijagnoza;


public class App {

	public static void main(String[] args) {
		Dijagnoza d = new Dijagnoza();
		d.setBolest("amin");
		d.setDoktor("pera");
		d.setId(123);
		d.setKartaPacijenta(532);
		d.setDatum(new Date(Calendar.getInstance().getTime().getTime()));
		System.out.println(d.getDatum());
		

	}
	
	public static String toString(ArrayList<String> lista) {
		String s = "";
		for(int i = 0; i < lista.size(); i++) {
			if(i != lista.size()-1)
				s += lista.get(i) + ",";
			else s += lista.get(i);
		}
		return s;
	}

}
