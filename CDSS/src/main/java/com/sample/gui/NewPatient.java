package com.sample.gui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class NewPatient extends JFrame {
	private JTextField prezimePField;
	private JTextField imePField;
	private JTextField brKarteField;
	
	public NewPatient() {
		
		setTitle("Novi pacijent");
		
		JLabel lblDodajteNovogPacijenta = new JLabel("Dodajte novog pacijenta:");
		lblDodajteNovogPacijenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblBrojKarte = new JLabel("Broj karte:");
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		JLabel lblAlergijeodvojeneZarezima = new JLabel("Alergije (odvojene zarezima):");
		
		JButton OKPacijent = new JButton("OK");
		
		JButton cancelPacijent = new JButton("Ponisti");
		
		prezimePField = new JTextField();
		prezimePField.setColumns(10);
		
		imePField = new JTextField();
		imePField.setColumns(10);
		
		brKarteField = new JTextField();
		brKarteField.setColumns(10);
		
		JTextArea alergijeField = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(132)
							.addComponent(lblDodajteNovogPacijenta, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBrojKarte, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(brKarteField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblIme, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(imePField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPrezime, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(prezimePField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAlergijeodvojeneZarezima)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(OKPacijent, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(alergijeField, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(73)
									.addComponent(cancelPacijent, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDodajteNovogPacijenta, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrojKarte)
						.addComponent(brKarteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIme)
						.addComponent(imePField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrezime)
						.addComponent(prezimePField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlergijeodvojeneZarezima)
						.addComponent(alergijeField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(OKPacijent)
						.addComponent(cancelPacijent))
					.addGap(23))
		);
		getContentPane().setLayout(groupLayout);
		
		cancelPacijent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelPacijent).dispose();
		    }
		});
		
		OKPacijent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(brKarteField.getText().trim().equals("")) {
		    		JOptionPane.showMessageDialog(getContentPane(), "Korisnicko ime ne sme da bude prazno!");
		    		return;		    		
		    	}
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("insert into PACIJENTI values(" + brKarteField.getText() 
					+",'"+ imePField.getText()+ "','" + prezimePField.getText() + "','" + alergijeField.getText() + "')");
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Pacijent je uspesno dodat!");
					con.close();
					SwingUtilities.getWindowAncestor(OKPacijent).dispose();
				}
				catch (SQLException e1) {
					if(e1 instanceof SQLIntegrityConstraintViolationException) {
						JOptionPane.showMessageDialog(getContentPane(), "Broj karte je zauzet!");
				    }
					else e1.printStackTrace();
				}
		    }
		});
	}
}
