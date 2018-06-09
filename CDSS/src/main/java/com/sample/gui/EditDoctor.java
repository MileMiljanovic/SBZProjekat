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
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditDoctor extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameFieldE;
	private JTextField passwordFieldE;
	private JTextField imeLFieldE;
	private JTextField prezimeLFieldE;
	
	public EditDoctor(String doctor) {
		setTitle("Izmena lekara");
		
		JLabel lblNewLabel = new JLabel("Korisnicko ime:");
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		JButton OKLekarE = new JButton("OK");
		
		JButton cancelDoktorE = new JButton("Ponisti");
		
		usernameFieldE = new JTextField();
		usernameFieldE.setEditable(false);
		usernameFieldE.setColumns(10);
		usernameFieldE.setText(doctor);
		
		passwordFieldE = new JTextField();
		passwordFieldE.setColumns(10);
		
		imeLFieldE = new JTextField();
		imeLFieldE.setColumns(10);
		
		prezimeLFieldE = new JTextField();
		prezimeLFieldE.setColumns(10);
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = con.prepareStatement("select * from LEKARI where username = '" + doctor + "'");
			ResultSet r1 = statement1.executeQuery();
			while (r1.next()) {
				usernameFieldE.setText(r1.getString("username"));
				passwordFieldE.setText(r1.getString("pass"));
				imeLFieldE.setText(r1.getString("ime"));
				prezimeLFieldE.setText(r1.getString("prezime"));
			}
			con.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblDodajteNovogDoktora = new JLabel("Izmenite lekara:");
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
								.addComponent(OKLekarE, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addComponent(usernameFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addComponent(imeLFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addComponent(prezimeLFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(74)
									.addComponent(cancelDoktorE, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(146)
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
						.addComponent(usernameFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLozinka))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(imeLFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIme))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(prezimeLFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrezime))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelDoktorE)
						.addComponent(OKLekarE))
					.addGap(29))
		);
		getContentPane().setLayout(groupLayout);
		
		cancelDoktorE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelDoktorE).dispose();
		    }
		});
		
		OKLekarE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("update LEKARI set pass = '" + passwordFieldE.getText() 
					+"', ime = '"+ imeLFieldE.getText()+ "', prezime = '" + prezimeLFieldE.getText() 
					+ "' where username = '" + usernameFieldE.getText() + "'");
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Lekar je uspesno izmenjen!");
					con.close();
					SwingUtilities.getWindowAncestor(OKLekarE).dispose();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
	}

}
