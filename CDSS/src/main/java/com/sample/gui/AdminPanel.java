package com.sample.gui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

public class AdminPanel extends JFrame {
	
	private JTable lekariTable;
	private JTable table;
	private JTable bolestiTable;
	private JTable lekoviTable;
	private JTable pacijentiTable;
	
	public AdminPanel() {
		setTitle("Administratorski panel");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel lekari = new JPanel();
		tabbedPane.addTab("Lekari", null, lekari, null);
		
		JButton dodajLekara = new JButton("Dodaj novog lekara");
		
		JButton izmeniLekara = new JButton("Izmeni");
		
		JButton obrisiLekara = new JButton("Obrisi");
		
		JComboBox izmeniLekaraBox = new JComboBox();
		
		JComboBox obrisiLekaraBox = new JComboBox();
		
		lekariTable = new JTable();
		lekariTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GroupLayout gl_lekari = new GroupLayout(lekari);
		gl_lekari.setHorizontalGroup(
			gl_lekari.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lekari.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_lekari.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lekari.createSequentialGroup()
							.addComponent(izmeniLekara)
							.addGap(50)
							.addGroup(gl_lekari.createParallelGroup(Alignment.LEADING)
								.addComponent(obrisiLekaraBox, 0, 120, Short.MAX_VALUE)
								.addComponent(izmeniLekaraBox, 0, 120, Short.MAX_VALUE))
							.addGap(186))
						.addGroup(gl_lekari.createSequentialGroup()
							.addComponent(obrisiLekara)
							.addContainerGap(360, Short.MAX_VALUE))
						.addGroup(gl_lekari.createSequentialGroup()
							.addComponent(lekariTable, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(13, Short.MAX_VALUE))
						.addGroup(gl_lekari.createSequentialGroup()
							.addComponent(dodajLekara)
							.addContainerGap(294, Short.MAX_VALUE))))
		);
		gl_lekari.setVerticalGroup(
			gl_lekari.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lekari.createSequentialGroup()
					.addGap(19)
					.addComponent(dodajLekara)
					.addGap(18)
					.addGroup(gl_lekari.createParallelGroup(Alignment.BASELINE)
						.addComponent(izmeniLekara)
						.addComponent(izmeniLekaraBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_lekari.createParallelGroup(Alignment.BASELINE)
						.addComponent(obrisiLekara)
						.addComponent(obrisiLekaraBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(lekariTable, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		lekari.setLayout(gl_lekari);
		
		JPanel pacijenti = new JPanel();
		tabbedPane.addTab("Pacijenti", null, pacijenti, null);
		
		JButton dodajPacijenta = new JButton("Dodaj novog pacijenta");
		
		JButton button_1 = new JButton("Izmeni");
		
		JButton button_2 = new JButton("Obrisi");
		
		JComboBox comboBox = new JComboBox();
		
		JComboBox comboBox_1 = new JComboBox();
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton dodajPacijent = new JButton("Dodaj novog pacijenta");
		
		JButton izmeniPacijenta = new JButton("Izmeni");
		
		JComboBox izmeniPacijentaBox = new JComboBox();
		
		JButton obrisiPacijenta = new JButton("Obrisi");
		
		JComboBox obrisiPacijentaBox = new JComboBox();
		
		pacijentiTable = new JTable();
		pacijentiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GroupLayout gl_pacijenti = new GroupLayout(pacijenti);
		gl_pacijenti.setHorizontalGroup(
			gl_pacijenti.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pacijenti.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pacijenti.createSequentialGroup()
							.addComponent(izmeniPacijenta, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(izmeniPacijentaBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pacijenti.createSequentialGroup()
							.addComponent(obrisiPacijenta, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(obrisiPacijentaBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addComponent(pacijentiTable, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
						.addComponent(dodajPacijent, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_pacijenti.setVerticalGroup(
			gl_pacijenti.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pacijenti.createSequentialGroup()
					.addGap(19)
					.addComponent(dodajPacijent)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING)
						.addComponent(izmeniPacijenta)
						.addGroup(gl_pacijenti.createSequentialGroup()
							.addGap(1)
							.addComponent(izmeniPacijentaBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING)
						.addComponent(obrisiPacijenta)
						.addGroup(gl_pacijenti.createSequentialGroup()
							.addGap(1)
							.addComponent(obrisiPacijentaBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addComponent(pacijentiTable, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		pacijenti.setLayout(gl_pacijenti);
		
		JPanel bolesti = new JPanel();
		tabbedPane.addTab("Bolesti", null, bolesti, null);
		
		JButton dodajBolest = new JButton("Dodaj novu bolest");
		
		JButton izmeniBolest = new JButton("Izmeni");
		
		JButton obrisiBolest = new JButton("Obrisi");
		
		JComboBox izmeniBolestBox = new JComboBox();
		
		JComboBox obrisiBolestBox = new JComboBox();
		
		bolestiTable = new JTable();
		bolestiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GroupLayout gl_bolesti = new GroupLayout(bolesti);
		gl_bolesti.setHorizontalGroup(
			gl_bolesti.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bolesti.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_bolesti.createParallelGroup(Alignment.LEADING)
						.addComponent(dodajBolest, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_bolesti.createSequentialGroup()
							.addComponent(izmeniBolest, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(izmeniBolestBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_bolesti.createSequentialGroup()
							.addComponent(obrisiBolest, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(obrisiBolestBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addComponent(bolestiTable, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_bolesti.setVerticalGroup(
			gl_bolesti.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_bolesti.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addGap(9)
					.addComponent(dodajBolest)
					.addGap(18)
					.addGroup(gl_bolesti.createParallelGroup(Alignment.LEADING)
						.addComponent(izmeniBolest)
						.addGroup(gl_bolesti.createSequentialGroup()
							.addGap(1)
							.addComponent(izmeniBolestBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_bolesti.createParallelGroup(Alignment.LEADING)
						.addComponent(obrisiBolest)
						.addGroup(gl_bolesti.createSequentialGroup()
							.addGap(1)
							.addComponent(obrisiBolestBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addComponent(bolestiTable, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		bolesti.setLayout(gl_bolesti);
		
		JPanel lekovi = new JPanel();
		tabbedPane.addTab("Lekovi", null, lekovi, null);
		
		JButton dodajLek = new JButton("Dodaj novi lek");
		
		JButton izmeniLek = new JButton("Izmeni");
		
		JButton obrisiLek = new JButton("Obrisi");
		
		JComboBox izmeniLekBox = new JComboBox();
		
		JComboBox obrisiLekBox = new JComboBox();
		
		lekoviTable = new JTable();
		lekoviTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GroupLayout gl_lekovi = new GroupLayout(lekovi);
		gl_lekovi.setHorizontalGroup(
			gl_lekovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lekovi.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_lekovi.createParallelGroup(Alignment.LEADING)
						.addComponent(dodajLek, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_lekovi.createSequentialGroup()
							.addComponent(izmeniLek, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(izmeniLekBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_lekovi.createSequentialGroup()
							.addComponent(obrisiLek, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(obrisiLekBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addComponent(lekoviTable, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_lekovi.setVerticalGroup(
			gl_lekovi.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_lekovi.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addGap(9)
					.addComponent(dodajLek)
					.addGap(18)
					.addGroup(gl_lekovi.createParallelGroup(Alignment.LEADING)
						.addComponent(izmeniLek)
						.addGroup(gl_lekovi.createSequentialGroup()
							.addGap(1)
							.addComponent(izmeniLekBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_lekovi.createParallelGroup(Alignment.LEADING)
						.addComponent(obrisiLek)
						.addGroup(gl_lekovi.createSequentialGroup()
							.addGap(1)
							.addComponent(obrisiLekBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addComponent(lekoviTable, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		lekovi.setLayout(gl_lekovi);
		getContentPane().add(tabbedPane);
	}
}
