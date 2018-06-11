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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Dijagnoza extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField pacijentDiag;
	
	public Dijagnoza(String pacijent, String doktor, String simptomi) {
		
		JLabel lblUspostaviteDijagnozu = new JLabel("Uspostavite dijagnozu:");
		lblUspostaviteDijagnozu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblBroj = new JLabel("Pacijent:");
		
		JLabel lblPacijent = new JLabel("Bolest:");
		
		pacijentDiag = new JTextField();
		pacijentDiag.setEditable(false);
		pacijentDiag.setColumns(10);
		pacijentDiag.setText(pacijent);
		
		JButton OKDiag = new JButton("OK");
		
		JButton cancelDiag = new JButton("Ponisti");
		
		Integer pacijentBr = Integer.parseInt(pacijent);
		
		JComboBox bolestiBox = new JComboBox();
		
		JLabel lblLekovi = new JLabel("Lekovi:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton addLek = new JButton(">>");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JList<String> chosenLekovi = new JList<String>();
		scrollPane_1.setViewportView(chosenLekovi);
		
		JList<String> allLekovi = new JList<String>();
		scrollPane.setViewportView(allLekovi);
		
		
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from BOLESTI");
			ResultSet result1 = statement1.executeQuery();
			while(result1.next()) {
				bolestiBox.addItem(result1.getString("naziv"));
			}
			
			PreparedStatement statement3;
			statement3 = conn.prepareStatement("select naziv from LEKOVI");
			ResultSet result3 = statement3.executeQuery();
			Vector<String> as = new Vector<String>();
			while(result3.next()) {
				String s = result3.getString("naziv");
				as.add(s);
			}
			allLekovi.setListData(as);
			conn.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JButton removeLek = new JButton("<<");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addComponent(lblUspostaviteDijagnozu, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblLekovi)
									.addGap(18)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(removeLek)
										.addComponent(addLek))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPacijent, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bolestiBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblBroj, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(pacijentDiag, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(OKDiag, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(cancelDiag, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUspostaviteDijagnozu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBroj)
						.addComponent(pacijentDiag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPacijent)
						.addComponent(bolestiBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(addLek)
							.addGap(18)
							.addComponent(removeLek))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(lblLekovi)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(OKDiag)
						.addComponent(cancelDiag)))
		);
		
		
		getContentPane().setLayout(groupLayout);
		
		addLek.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int index = allLekovi.getSelectedIndex();
		    	Vector<String> v1 = new Vector<String>();
		    	Vector<String> v2 = new Vector<String>();
		    	for (int i = 0; i < allLekovi.getModel().getSize(); i++) {
		    		v1.add(allLekovi.getModel().getElementAt(i));
		    	}
		    	
		    	if(chosenLekovi.getModel().getSize() > 0) {
			    	for (int i = 0; i < chosenLekovi.getModel().getSize(); i++) {
			    		v2.add(chosenLekovi.getModel().getElementAt(i));
			    	}
		    	}
		    	
		    	if (index != -1) {
		    		v2.add(v1.get(index));
		    		v1.remove(index);
		    		allLekovi.setListData(v1);
		    		allLekovi.revalidate();
		    		allLekovi.repaint();
		    		chosenLekovi.setListData(v2);
		    		chosenLekovi.revalidate();
		    		chosenLekovi.repaint();
		    	}
		    	
		    }
		});
		
		removeLek.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int index = chosenLekovi.getSelectedIndex();
		    	Vector<String> v1 = new Vector<String>();
		    	Vector<String> v2 = new Vector<String>();
		    	for (int i = 0; i < chosenLekovi.getModel().getSize(); i++) {
		    		v1.add(chosenLekovi.getModel().getElementAt(i));
		    	}
		    	
		    	if(allLekovi.getModel().getSize() > 0) {
			    	for (int i = 0; i < allLekovi.getModel().getSize(); i++) {
			    		v2.add(allLekovi.getModel().getElementAt(i));
			    	}
		    	}
		    	
		    	if (index != -1) {
		    		v2.add(v1.get(index));
		    		v1.remove(index);
		    		chosenLekovi.setListData(v1);
		    		chosenLekovi.revalidate();
		    		chosenLekovi.repaint();
		    		allLekovi.setListData(v2);
		    		allLekovi.revalidate();
		    		allLekovi.repaint();
		    	}
		    	
		    }
		    	
		    
		});
		
		cancelDiag.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(cancelDiag).dispose();
		    	DoctorPanel d = new DoctorPanel(doktor);
	    		d.setSize(600, 350);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		OKDiag.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Connection con;
		    	Date d = new Date(Calendar.getInstance().getTime().getTime());
		    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		    	String strDate = formatter.format(d); 
		    	String lekovi = "";
		    	for(int i = 0; i< chosenLekovi.getModel().getSize();i++){
		    		lekovi += chosenLekovi.getModel().getElementAt(i);
		            if(i < chosenLekovi.getModel().getSize()-1) {
		            	lekovi += ",";
		            }
		        }
				try {
					int broj = 0;
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement2;
					statement2 = con.prepareStatement("select max(broj) from DIJAGNOZE");
					ResultSet result2 = statement2.executeQuery();
					while(result2.next()) {
						broj = result2.getInt("max(broj)")+1;
					}
					PreparedStatement statement1;
					statement1 = con.prepareStatement("insert into DIJAGNOZE values(" + broj 
					+","+ pacijentBr + ",'" + doktor + "','" + bolestiBox.getSelectedItem().toString() + "','" 
					+ lekovi + "','" + strDate + "','" + simptomi + "')");
					statement1.executeQuery();
					JOptionPane.showMessageDialog(getContentPane(), "Dijagnoza je uspesno dodata!");
					con.close();
					SwingUtilities.getWindowAncestor(OKDiag).dispose();
					DoctorPanel dp = new DoctorPanel(doktor);
		    		dp.setSize(600, 350);
		    		dp.setLocationRelativeTo(null);
		    		dp.setVisible(true);
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }
		});
	}
}
