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

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class NewMedicine extends JFrame {
	private JTextField tipField;
	private JTextField nazivField;
	public NewMedicine() {
		setTitle("Novi lek");
		
		JLabel lblDodajteNoviLek = new JLabel("Dodajte novi lek:");
		lblDodajteNoviLek.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNaziv = new JLabel("Naziv:");
		
		JLabel lblTip = new JLabel("Tip:");
		
		JLabel lblSastojci = new JLabel("Sastojci:");
		
		tipField = new JTextField();
		tipField.setColumns(10);
		
		nazivField = new JTextField();
		nazivField.setColumns(10);
		
		JButton OKLek = new JButton("OK");
		
		JButton cancelLek = new JButton("Ponisti");
		
		JTextArea sastojciField = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(166, Short.MAX_VALUE)
					.addComponent(lblDodajteNoviLek, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNaziv, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(nazivField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(OKLek, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(cancelLek, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSastojci, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(sastojciField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTip, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(tipField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDodajteNoviLek, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNaziv))
						.addComponent(nazivField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTip)
						.addComponent(tipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblSastojci)
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sastojciField, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(OKLek)
						.addComponent(cancelLek))
					.addGap(21))
		);
		getContentPane().setLayout(groupLayout);
		
		cancelLek.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelLek).dispose();
		    	AdminPanel d = new AdminPanel();
	    		d.setSize(600, 400);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		OKLek.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(nazivField.getText().trim().equals("")) {
		    		JOptionPane.showMessageDialog(getContentPane(), "Naziv leka ne sme da bude prazan!");
		    		return;		    		
		    	}
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("insert into LEKOVI values('" + nazivField.getText() 
					+"','"+ tipField.getText()+ "','" + sastojciField.getText() + "')");
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Lek je uspesno dodat!");
					con.close();
					SwingUtilities.getWindowAncestor(OKLek).dispose();
					AdminPanel d = new AdminPanel();
		    		d.setSize(600, 400);
		    		d.setLocationRelativeTo(null);
		    		d.setVisible(true);
				}
				catch (SQLException e1) {
					if(e1 instanceof SQLIntegrityConstraintViolationException) {
						JOptionPane.showMessageDialog(getContentPane(), "Lek sa tim nazivom vec postoji!");
				    }
					else e1.printStackTrace();
				}
		    }
		});
	}

}
