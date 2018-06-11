package com.sample.gui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class NewDoctor extends JFrame {
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField imeLField;
	private JTextField prezimeLField;
	
	public NewDoctor() {
		
		setTitle("Novi lekar");
		
		JLabel lblNewLabel = new JLabel("Korisnicko ime:");
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		JButton OKLekar = new JButton("OK");
		
		JButton cancelDoktor = new JButton("Ponisti");
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		
		imeLField = new JTextField();
		imeLField.setColumns(10);
		
		prezimeLField = new JTextField();
		prezimeLField.setColumns(10);
		
		JLabel lblDodajteNovogDoktora = new JLabel("Dodajte novog lekara:");
		lblDodajteNovogDoktora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPrezime, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIme, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLozinka, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(OKLekar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addComponent(imeLField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addComponent(prezimeLField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(74)
									.addComponent(cancelDoktor, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(137)
							.addComponent(lblDodajteNovogDoktora, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblDodajteNovogDoktora, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLozinka))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(imeLField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIme))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(prezimeLField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrezime))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelDoktor)
						.addComponent(OKLekar))
					.addGap(29))
		);
		getContentPane().setLayout(groupLayout);
		
		cancelDoktor.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelDoktor).dispose();
		    	AdminPanel d = new AdminPanel();
	    		d.setSize(600, 400);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		OKLekar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(usernameField.getText().trim().equals("")) {
		    		JOptionPane.showMessageDialog(getContentPane(), "Korisnicko ime ne sme da bude prazno!");
		    		return;		    		
		    	}
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("insert into LEKARI values('" + usernameField.getText() 
					+"','"+ passwordField.getText()+ "','" + imeLField.getText() + "','" + prezimeLField.getText() + "')");
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Lekar je uspesno dodat!");
					con.close();
					SwingUtilities.getWindowAncestor(OKLekar).dispose();
					AdminPanel d = new AdminPanel();
		    		d.setSize(600, 400);
		    		d.setLocationRelativeTo(null);
		    		d.setVisible(true);
				}
				catch (SQLException e1) {
					if(e1 instanceof SQLIntegrityConstraintViolationException) {
						JOptionPane.showMessageDialog(getContentPane(), "Korisnicko ime vec postoji!");
				    }
					else e1.printStackTrace();
				}
		    }
		});
	}

}
