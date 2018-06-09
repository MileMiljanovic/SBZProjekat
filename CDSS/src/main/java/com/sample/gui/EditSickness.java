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
import javax.swing.JTextArea;
import javax.swing.JButton;

public class EditSickness extends JFrame {
	private JTextField nazivFieldE;
	private JTextField grupaFieldE;
	
	public EditSickness(String bolest) {
		
		JLabel lblIzmeniteBolest = new JLabel("Izmenite bolest:");
		lblIzmeniteBolest.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_1 = new JLabel("Naziv:");
		
		JLabel label_2 = new JLabel("Grupa:");
		
		JLabel label_3 = new JLabel("Simptomi:");
		
		nazivFieldE = new JTextField();
		nazivFieldE.setEditable(false);
		nazivFieldE.setColumns(10);
		nazivFieldE.setText(bolest);
		
		grupaFieldE = new JTextField();
		grupaFieldE.setColumns(10);
		
		JTextArea simptomiFieldE = new JTextArea();
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = con.prepareStatement("select * from BOLESTI where naziv = '" + bolest + "'");
			ResultSet r1 = statement1.executeQuery();
			while (r1.next()) {
				nazivFieldE.setText(r1.getString("naziv"));
				grupaFieldE.setText(r1.getString("grupa"));
				simptomiFieldE.setText(r1.getString("simptomi"));
			}
			con.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton OKSicknessE = new JButton("OK");
		
		JButton cancelSicknessE = new JButton("Ponisti");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(lblIzmeniteBolest, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(nazivFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(grupaFieldE, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(simptomiFieldE, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(OKSicknessE, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(77)
							.addComponent(cancelSicknessE, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIzmeniteBolest, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(nazivFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(grupaFieldE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(label_3))
						.addComponent(simptomiFieldE, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(OKSicknessE)
						.addComponent(cancelSicknessE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		cancelSicknessE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelSicknessE).dispose();
		    }
		});
		
		OKSicknessE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("update BOLESTI set grupa = '" + grupaFieldE.getText() 
					+"', simptomi = '"+ simptomiFieldE.getText()
					+ "' where naziv = '" + nazivFieldE.getText() + "'");
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Bolest je uspesno izmenjena!");
					con.close();
					SwingUtilities.getWindowAncestor(OKSicknessE).dispose();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
	}

}
