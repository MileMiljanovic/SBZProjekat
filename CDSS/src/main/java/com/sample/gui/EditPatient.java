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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class EditPatient extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField prezimePFieldE;
	private JTextField imePFieldE;
	private JTextField brKarteFieldE;
	
	public EditPatient(String pacijent) {
		
		setTitle("Izmena pacijenta");
		
		JLabel lblDodajteNovogPacijenta = new JLabel("Izmenite pacijenta:");
		lblDodajteNovogPacijenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblBrojKarte = new JLabel("Broj karte:");
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		JLabel lblAlergijeodvojeneZarezima = new JLabel("Alergije (odvojene zarezima):");
		
		JButton OKPacijentE = new JButton("OK");
		
		JButton cancelPacijentE = new JButton("Ponisti");
		
		prezimePFieldE = new JTextField();
		prezimePFieldE.setColumns(10);
		
		imePFieldE = new JTextField();
		imePFieldE.setColumns(10);
		
		brKarteFieldE = new JTextField();
		brKarteFieldE.setEditable(false);
		brKarteFieldE.setColumns(10);
		brKarteFieldE.setText(pacijent);
		
		JTextArea alergijeFieldE = new JTextArea();
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = con.prepareStatement("select * from PACIJENTI where brkarte = " + pacijent);
			ResultSet r1 = statement1.executeQuery();
			while (r1.next()) {
				brKarteFieldE.setText(pacijent);
				imePFieldE.setText(r1.getString("ime"));
				prezimePFieldE.setText(r1.getString("prezime"));
				alergijeFieldE.setText(r1.getString("alergije"));
			}
			con.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBrojKarte, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(brKarteFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblIme, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(imePFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPrezime, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(prezimePFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAlergijeodvojeneZarezima)
								.addComponent(OKPacijentE, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(alergijeFieldE, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(88)
									.addComponent(cancelPacijentE, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(lblDodajteNovogPacijenta, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDodajteNovogPacijenta, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrojKarte)
						.addComponent(brKarteFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIme)
						.addComponent(imePFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrezime)
						.addComponent(prezimePFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlergijeodvojeneZarezima)
						.addComponent(alergijeFieldE, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(OKPacijentE)
						.addComponent(cancelPacijentE))
					.addGap(23))
		);
		getContentPane().setLayout(groupLayout);
		
		cancelPacijentE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelPacijentE).dispose();
		    }
		});
		
		OKPacijentE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("update PACIJENTI set alergije = '" + alergijeFieldE.getText() 
					+"', ime = '"+ imePFieldE.getText()+ "', prezime = '" + prezimePFieldE.getText() 
					+ "' where brkarte = " + brKarteFieldE.getText());
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Pacijent je uspesno izmenjen!");
					con.close();
					SwingUtilities.getWindowAncestor(OKPacijentE).dispose();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
	}
	
	
}
