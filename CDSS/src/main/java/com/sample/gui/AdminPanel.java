package com.sample.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class AdminPanel extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable lekariTable;
	private JTable bolestiTable;
	private JTable lekoviTable;
	private JTable pacijentiTable;
	
	public AdminPanel()  {
		
		Connection conn;
		setTitle("Administratorski panel");
		getContentPane().setLayout(new BorderLayout(0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel lekari = new JPanel();
		tabbedPane.addTab("Lekari", null, lekari, null);
		
		JButton dodajLekara = new JButton("Dodaj novog lekara");
		
		JButton izmeniLekara = new JButton("Izmeni");
		
		JButton obrisiLekara = new JButton("Obrisi");
		
		JComboBox<String> izmeniLekaraBox = new JComboBox<String>();
		
		JComboBox<String> obrisiLekaraBox = new JComboBox<String>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from LEKARI");
			ResultSet result1 = statement1.executeQuery();
			lekariTable = new JTable(buildTableModel(result1));
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		JButton logoutBtn = new JButton("Logout");
		
		JButton izlazBtn = new JButton("Izlaz");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_lekari = new GroupLayout(lekari);
		gl_lekari.setHorizontalGroup(
			gl_lekari.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lekari.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_lekari.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lekari.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_lekari.createSequentialGroup()
							.addGroup(gl_lekari.createParallelGroup(Alignment.LEADING)
								.addComponent(dodajLekara)
								.addGroup(gl_lekari.createSequentialGroup()
									.addGroup(gl_lekari.createParallelGroup(Alignment.LEADING)
										.addComponent(izmeniLekara)
										.addComponent(obrisiLekara))
									.addGap(50)
									.addGroup(gl_lekari.createParallelGroup(Alignment.LEADING, false)
										.addComponent(obrisiLekaraBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(izmeniLekaraBox, 0, 134, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
							.addGroup(gl_lekari.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(izlazBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(logoutBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_lekari.setVerticalGroup(
			gl_lekari.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lekari.createSequentialGroup()
					.addGroup(gl_lekari.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lekari.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_lekari.createParallelGroup(Alignment.BASELINE)
								.addComponent(izmeniLekara)
								.addComponent(izmeniLekaraBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_lekari.createParallelGroup(Alignment.BASELINE)
								.addComponent(obrisiLekaraBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(obrisiLekara)))
						.addGroup(gl_lekari.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_lekari.createParallelGroup(Alignment.BASELINE)
								.addComponent(logoutBtn)
								.addComponent(dodajLekara))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(izlazBtn)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		scrollPane.setViewportView(lekariTable);
		lekariTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		lekari.setLayout(gl_lekari);
		
		JPanel pacijenti = new JPanel();
		tabbedPane.addTab("Pacijenti", null, pacijenti, null);
		
		JButton dodajPacijent = new JButton("Dodaj novog pacijenta");
		
		JButton izmeniPacijenta = new JButton("Izmeni");
		
		JComboBox<Integer> izmeniPacijentaBox = new JComboBox<Integer>();
		
		JButton obrisiPacijenta = new JButton("Obrisi");
		
		JComboBox<Integer> obrisiPacijentaBox = new JComboBox<Integer>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from PACIJENTI");
			ResultSet result1 = statement1.executeQuery();
			pacijentiTable = new JTable(buildTableModel(result1));
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton logoutBtn1 = new JButton("Logout");
		
		JButton izlazBtn1 = new JButton("Izlaz");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_pacijenti = new GroupLayout(pacijenti);
		gl_pacijenti.setHorizontalGroup(
			gl_pacijenti.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pacijenti.createSequentialGroup()
					.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pacijenti.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING)
								.addComponent(dodajPacijent, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pacijenti.createSequentialGroup()
									.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING, false)
										.addComponent(obrisiPacijenta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(izmeniPacijenta, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
									.addGap(44)
									.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING, false)
										.addComponent(izmeniPacijentaBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(obrisiPacijentaBox, 0, 151, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addGroup(gl_pacijenti.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(izlazBtn1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(logoutBtn1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
						.addGroup(gl_pacijenti.createSequentialGroup()
							.addGap(27)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pacijenti.setVerticalGroup(
			gl_pacijenti.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pacijenti.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pacijenti.createParallelGroup(Alignment.BASELINE)
						.addComponent(dodajPacijent)
						.addComponent(logoutBtn1))
					.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pacijenti.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_pacijenti.createParallelGroup(Alignment.BASELINE)
								.addComponent(izmeniPacijenta)
								.addComponent(izmeniPacijentaBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(gl_pacijenti.createParallelGroup(Alignment.BASELINE)
								.addComponent(obrisiPacijenta)
								.addComponent(obrisiPacijentaBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pacijenti.createSequentialGroup()
							.addGap(8)
							.addComponent(izlazBtn1)))
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		scrollPane_1.setViewportView(pacijentiTable);
		pacijentiTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		pacijenti.setLayout(gl_pacijenti);
		
		JPanel lekovi = new JPanel();
		tabbedPane.addTab("Lekovi", null, lekovi, null);
		
		JButton dodajLek = new JButton("Dodaj novi lek");
		
		JButton izmeniLek = new JButton("Izmeni");
		
		JButton obrisiLek = new JButton("Obrisi");
		
		JComboBox<String> izmeniLekBox = new JComboBox<String>();
		
		JComboBox<String> obrisiLekBox = new JComboBox<String>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from LEKOVI");
			ResultSet result1 = statement1.executeQuery();
			lekoviTable = new JTable(buildTableModel(result1));
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton logoutBtn3 = new JButton("Logout");
		
		JButton izlazBtn3 = new JButton("Izlaz");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_lekovi = new GroupLayout(lekovi);
		gl_lekovi.setHorizontalGroup(
			gl_lekovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lekovi.createSequentialGroup()
					.addGroup(gl_lekovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lekovi.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_lekovi.createParallelGroup(Alignment.LEADING)
								.addComponent(dodajLek, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_lekovi.createSequentialGroup()
									.addGroup(gl_lekovi.createParallelGroup(Alignment.LEADING, false)
										.addComponent(obrisiLek, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(izmeniLek, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
									.addGap(37)
									.addGroup(gl_lekovi.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(izmeniLekBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(obrisiLekBox, 0, 145, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
							.addGroup(gl_lekovi.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(izlazBtn3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(logoutBtn3, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
						.addGroup(gl_lekovi.createSequentialGroup()
							.addGap(22)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_lekovi.setVerticalGroup(
			gl_lekovi.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_lekovi.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_lekovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(dodajLek)
						.addComponent(logoutBtn3))
					.addGroup(gl_lekovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lekovi.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_lekovi.createParallelGroup(Alignment.BASELINE)
								.addComponent(izmeniLek)
								.addComponent(izmeniLekBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_lekovi.createParallelGroup(Alignment.BASELINE)
								.addComponent(obrisiLek)
								.addComponent(obrisiLekBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_lekovi.createSequentialGroup()
							.addGap(10)
							.addComponent(izlazBtn3)))
					.addGap(18)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(311))
		);
		
		scrollPane_2.setViewportView(lekoviTable);
		lekoviTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		lekovi.setLayout(gl_lekovi);
		getContentPane().add(tabbedPane);
		
		JPanel bolesti = new JPanel();
		tabbedPane.addTab("Bolesti", null, bolesti, null);
		
		JButton dodajBolest = new JButton("Dodaj novu bolest");
		
		JButton izmeniBolest = new JButton("Izmeni");
		
		JButton obrisiBolest = new JButton("Obrisi");
		
		JComboBox<String> izmeniBolestBox = new JComboBox<String>();
		
		JComboBox<String> obrisiBolestBox = new JComboBox<String>();
		
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from BOLESTI");
			ResultSet result1 = statement1.executeQuery();
			bolestiTable = new JTable(buildTableModel(result1));
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton logoutBtn2 = new JButton("Logout");
		
		JButton izlazBtn2 = new JButton("Izlaz");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_bolesti = new GroupLayout(bolesti);
		gl_bolesti.setHorizontalGroup(
			gl_bolesti.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bolesti.createSequentialGroup()
					.addGroup(gl_bolesti.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bolesti.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_bolesti.createParallelGroup(Alignment.LEADING)
								.addComponent(dodajBolest, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_bolesti.createSequentialGroup()
									.addGroup(gl_bolesti.createParallelGroup(Alignment.LEADING, false)
										.addComponent(obrisiBolest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(izmeniBolest, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
									.addGap(40)
									.addGroup(gl_bolesti.createParallelGroup(Alignment.LEADING, false)
										.addComponent(izmeniBolestBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(obrisiBolestBox, 0, 141, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
							.addGroup(gl_bolesti.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(izlazBtn2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(logoutBtn2, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)))
						.addGroup(gl_bolesti.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_bolesti.setVerticalGroup(
			gl_bolesti.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_bolesti.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_bolesti.createParallelGroup(Alignment.BASELINE)
						.addComponent(dodajBolest)
						.addComponent(logoutBtn2))
					.addGroup(gl_bolesti.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bolesti.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_bolesti.createParallelGroup(Alignment.BASELINE)
								.addComponent(izmeniBolest)
								.addComponent(izmeniBolestBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_bolesti.createParallelGroup(Alignment.BASELINE)
								.addComponent(obrisiBolest)
								.addComponent(obrisiBolestBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_bolesti.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(izlazBtn2)))
					.addGap(18)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		scrollPane_3.setViewportView(bolestiTable);
		bolestiTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		bolesti.setLayout(gl_bolesti);
		
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from LEKARI");
			ResultSet result1 = statement1.executeQuery();
			while(result1.next()) {
				izmeniLekaraBox.addItem(result1.getString("username"));
				obrisiLekaraBox.addItem(result1.getString("username"));
			}

			
			PreparedStatement statement2;
			statement2 = conn.prepareStatement("select * from PACIJENTI");
			ResultSet result2 = statement2.executeQuery();
			while(result2.next()) {
				izmeniPacijentaBox.addItem(result2.getInt("brkarte"));
				obrisiPacijentaBox.addItem(result2.getInt("brkarte"));
				
			}
			
			PreparedStatement statement3;
			statement3 = conn.prepareStatement("select * from LEKOVI");
			ResultSet result3 = statement3.executeQuery();
			while(result3.next()) {
				izmeniLekBox.addItem(result3.getString("naziv"));
				obrisiLekBox.addItem(result3.getString("naziv"));
			}
			
			PreparedStatement statement4;
			statement4 = conn.prepareStatement("select * from BOLESTI");
			ResultSet result4 = statement4.executeQuery();
			while(result4.next()) {
				izmeniBolestBox.addItem(result4.getString("naziv"));
				obrisiBolestBox.addItem(result4.getString("naziv"));
			}
			
			conn.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		class IzlazListener implements ActionListener{
		    public void actionPerformed(ActionEvent event){
		    	int dialogButton = JOptionPane.YES_NO_OPTION;
		    	int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?","Upozorenje",dialogButton);
		    	if(dialogResult == JOptionPane.YES_OPTION){
		    	  System.exit(0);
		    	}
		    }
		}
		
		class LogoutListener implements ActionListener{
		    public void actionPerformed(ActionEvent event){
		    	SwingUtilities.getWindowAncestor(logoutBtn).dispose();
	    		Login l = new Login();
	    		l.setSize(450, 300);
	    		l.setLocationRelativeTo(null);
	    		l.setVisible(true);
		    }
		}
		
		IzlazListener il = new IzlazListener();
		izlazBtn.addActionListener(il);
		izlazBtn1.addActionListener(il);
		izlazBtn2.addActionListener(il);
		izlazBtn3.addActionListener(il);
		
		LogoutListener ll = new LogoutListener();
		logoutBtn.addActionListener(ll);
		logoutBtn1.addActionListener(ll);
		logoutBtn2.addActionListener(ll);
		logoutBtn3.addActionListener(ll);
		
		dodajLekara.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(dodajLekara).dispose();
		    	NewDoctor d = new NewDoctor();
	    		d.setSize(450, 300);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		dodajPacijent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(dodajLekara).dispose();
		    	NewPatient d = new NewPatient();
	    		d.setSize(450, 300);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		dodajLek.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(dodajLekara).dispose();
		    	NewMedicine d = new NewMedicine();
	    		d.setSize(450, 300);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		dodajBolest.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(dodajLekara).dispose();
		    	NewSickness d = new NewSickness();
	    		d.setSize(450, 300);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		izmeniLekara.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(dodajLekara).dispose();
		    	EditDoctor d = new EditDoctor(izmeniLekaraBox.getSelectedItem().toString());
	    		d.setSize(450, 300);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		izmeniPacijenta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(dodajLekara).dispose();
		    	EditPatient d = new EditPatient(izmeniPacijentaBox.getSelectedItem().toString());
	    		d.setSize(450, 300);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		izmeniLek.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(dodajLekara).dispose();
		    	EditMedicine d = new EditMedicine(izmeniLekBox.getSelectedItem().toString());
	    		d.setSize(450, 300);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		izmeniBolest.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(dodajLekara).dispose();
		    	EditSickness d = new EditSickness(izmeniBolestBox.getSelectedItem().toString());
	    		d.setSize(450, 300);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		obrisiLekara.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String brisi = obrisiLekaraBox.getSelectedItem().toString();
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("delete from lekari where username='" + brisi + "'");
					statement1.executeQuery();
					int index = obrisiLekaraBox.getSelectedIndex();
					obrisiLekaraBox.removeItemAt(index);
					izmeniLekaraBox.removeItemAt(index);
					PreparedStatement statement2;
					statement2 = con.prepareStatement("select * from LEKARI");
					ResultSet result2 = statement2.executeQuery();
					lekariTable.setModel(buildTableModel(result2));
					con.close();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		obrisiPacijenta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String brisi = obrisiPacijentaBox.getSelectedItem().toString();
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("delete from pacijenti where brkarte=" + brisi);
					statement1.executeQuery();
					int index = obrisiPacijentaBox.getSelectedIndex();
					obrisiPacijentaBox.removeItemAt(index);
					izmeniPacijentaBox.removeItemAt(index);
					PreparedStatement statement2;
					statement2 = con.prepareStatement("select * from PACIJENTI");
					ResultSet result2 = statement2.executeQuery();
					pacijentiTable.setModel(buildTableModel(result2));
					con.close();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		obrisiBolest.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String brisi = obrisiBolestBox.getSelectedItem().toString();
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("delete from bolesti where naziv='" + brisi + "'");
					statement1.executeQuery();
					int index = obrisiBolestBox.getSelectedIndex();
					obrisiBolestBox.removeItemAt(index);
					izmeniBolestBox.removeItemAt(index);
					PreparedStatement statement2;
					statement2 = con.prepareStatement("select * from BOLESTI");
					ResultSet result2 = statement2.executeQuery();
					bolestiTable.setModel(buildTableModel(result2));
					con.close();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		obrisiLek.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String brisi = obrisiLekBox.getSelectedItem().toString();
		    	Connection con;
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
					PreparedStatement statement1;
					statement1 = con.prepareStatement("delete from lekovi where naziv='" + brisi + "'");
					statement1.executeQuery();
					int index = obrisiLekBox.getSelectedIndex();
					obrisiLekBox.removeItemAt(index);
					izmeniLekBox.removeItemAt(index);
					PreparedStatement statement2;
					statement2 = con.prepareStatement("select * from LEKOVI");
					ResultSet result2 = statement2.executeQuery();
					lekoviTable.setModel(buildTableModel(result2));
					con.close();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});

	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
}
