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

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class NewSickness extends JFrame {
	private JTextField grupaField;
	private JTextField nazivField;
	
	public NewSickness() {
		
		JLabel lblDodajteNovuBolest = new JLabel("Dodajte novu bolest:");
		lblDodajteNovuBolest.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_1 = new JLabel("Naziv:");
		
		JLabel lblGrupa = new JLabel("Grupa:");
		
		JLabel lblSimptomi = new JLabel("Simptomi:");
		
		JTextArea simptomiField = new JTextArea();
		
		grupaField = new JTextField();
		grupaField.setColumns(10);
		
		nazivField = new JTextField();
		nazivField.setColumns(10);
		
		JButton OKSickness = new JButton("OK");
		
		JButton cancelSickness = new JButton("Ponisti");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(72, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(lblDodajteNovuBolest, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(nazivField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblGrupa, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(grupaField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSimptomi, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(simptomiField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(OKSickness, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(cancelSickness, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addGap(58))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDodajteNovuBolest, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(nazivField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblGrupa))
						.addComponent(grupaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(lblSimptomi))
						.addComponent(simptomiField, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(OKSickness)
						.addComponent(cancelSickness))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		cancelSickness.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelSickness).dispose();
		    }
		});
		
		OKSickness.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(nazivField.getText().trim().equals("")) {
		    		JOptionPane.showMessageDialog(getContentPane(), "Naziv bolesti ne sme da bude prazan!");
		    		return;		    		
		    	}
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("insert into BOLESTI values('" + nazivField.getText() 
					+"','"+ grupaField.getText()+ "','" + simptomiField.getText() + "')");
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Bolest je uspesno dodata!");
					con.close();
					SwingUtilities.getWindowAncestor(OKSickness).dispose();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					if(e1 instanceof SQLIntegrityConstraintViolationException) {
						JOptionPane.showMessageDialog(getContentPane(), "Bolest sa tim nazivom vec postoji!");
				    }
					else e1.printStackTrace();
				}
		    }
		});
	}
}
