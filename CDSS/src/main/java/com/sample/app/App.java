package com.sample.app;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sample.gui.DoctorPanel;



public class App {

	public static void main(String[] args) {
		DoctorPanel d = new DoctorPanel();
		d.setSize(500, 300);
		d.setLocationRelativeTo(null);
		d.setVisible(true);

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
	
	public static ArrayList<String> toArrayList(String s) {
		ArrayList<String> l = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(s, ",");
        
        while (tokenizer.hasMoreTokens()) {
            l.add(tokenizer.nextToken());
        }        
		return l;
	}

}
