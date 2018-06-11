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

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class EditMedicine extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tipFieldE;
	private JTextField nazivFieldE;
	
	public EditMedicine(String lek) {
		
		setTitle("Izmena leka");
		
		JLabel lblDodajteNoviLek = new JLabel("Izmenite lek:");
		lblDodajteNoviLek.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNaziv = new JLabel("Naziv:");
		
		JLabel lblTip = new JLabel("Tip:");
		
		JLabel lblSastojci = new JLabel("Sastojci:");
		
		tipFieldE = new JTextField();
		tipFieldE.setColumns(10);
		
		JTextArea sastojciFieldE = new JTextArea();
		nazivFieldE = new JTextField();
		nazivFieldE.setEditable(false);
		nazivFieldE.setColumns(10);
		nazivFieldE.setText(lek);
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = con.prepareStatement("select * from LEKOVI where naziv = '" + lek + "'");
			ResultSet r1 = statement1.executeQuery();
			while (r1.next()) {
				nazivFieldE.setText(r1.getString("naziv"));
				tipFieldE.setText(r1.getString("tip"));
				sastojciFieldE.setText(r1.getString("sastojci"));
			}
			con.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton OKLekE = new JButton("OK");
		
		JButton cancelLekE = new JButton("Ponisti");
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNaziv, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(nazivFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(OKLekE, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(cancelLekE, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSastojci, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(sastojciFieldE, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTip, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(tipFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(48, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(174, Short.MAX_VALUE)
					.addComponent(lblDodajteNoviLek, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDodajteNoviLek, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNaziv))
						.addComponent(nazivFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTip)
						.addComponent(tipFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblSastojci)
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sastojciFieldE, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(OKLekE)
						.addComponent(cancelLekE))
					.addGap(21))
		);
		getContentPane().setLayout(groupLayout);
		
		cancelLekE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelLekE).dispose();
		    	AdminPanel d = new AdminPanel();
	    		d.setSize(600, 400);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		OKLekE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("update LEKOVI set tip = '" + tipFieldE.getText() 
					+"', sastojci = '"+ sastojciFieldE.getText()
					+ "' where naziv = '" + nazivFieldE.getText() + "'");
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Lek je uspesno izmenjen!");
					con.close();
					SwingUtilities.getWindowAncestor(OKLekE).dispose();
					AdminPanel d = new AdminPanel();
		    		d.setSize(600, 400);
		    		d.setLocationRelativeTo(null);
		    		d.setVisible(true);
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
	}

}
