package com.sample.gui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class DoctorPanel extends JFrame {
	private JTable table;
	
	public DoctorPanel() {
		setTitle("Dijagnosticki panel");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel dijagnoze = new JPanel();
		tabbedPane.addTab("Dijagnoze", null, dijagnoze, null);
		
		JButton logout = new JButton("Logout");
		
		JList allSimptomi = new JList();
		
		JList chosenSimptomi = new JList();
		
		JButton addSimptom = new JButton(">>");
		
		JButton button = new JButton("<<");
		
		JLabel lblOdaberiteSimptomeKoji = new JLabel("Odaberite simptome koji se manifestuju:");
		
		JButton dijagnozaButton = new JButton("Dijagnoza");
		
		JButton btnPovezaneBolesti = new JButton("Povezane bolesti");
		
		JComboBox bolestiSimpBox = new JComboBox();
		
		JButton prikaziSimptomeBtn = new JButton("Prikazi simptome");
		
		JLabel lblBolest = new JLabel("Bolest:");
		
		JLabel lblPacijent = new JLabel("Pacijent za dijagnozu:");
		
		JComboBox pacijentBox = new JComboBox();
		GroupLayout gl_dijagnoze = new GroupLayout(dijagnoze);
		gl_dijagnoze.setHorizontalGroup(
			gl_dijagnoze.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dijagnoze.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dijagnoze.createSequentialGroup()
							.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
								.addComponent(allSimptomi, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(dijagnozaButton))
							.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dijagnoze.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
										.addComponent(addSimptom)
										.addComponent(button))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chosenSimptomi, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_dijagnoze.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(pacijentBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblPacijent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(logout, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_dijagnoze.createSequentialGroup()
											.addGap(4)
											.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
												.addComponent(prikaziSimptomeBtn)
												.addComponent(bolestiSimpBox, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblBolest))))
									.addGap(30))
								.addGroup(gl_dijagnoze.createSequentialGroup()
									.addGap(15)
									.addComponent(btnPovezaneBolesti))))
						.addComponent(lblOdaberiteSimptomeKoji))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_dijagnoze.setVerticalGroup(
			gl_dijagnoze.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dijagnoze.createSequentialGroup()
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_dijagnoze.createSequentialGroup()
							.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dijagnoze.createSequentialGroup()
									.addGap(61)
									.addComponent(addSimptom)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button))
								.addGroup(gl_dijagnoze.createSequentialGroup()
									.addComponent(lblOdaberiteSimptomeKoji)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_dijagnoze.createParallelGroup(Alignment.BASELINE)
										.addComponent(chosenSimptomi, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(allSimptomi, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))))
							.addGap(18))
						.addGroup(gl_dijagnoze.createSequentialGroup()
							.addGap(2)
							.addComponent(logout)
							.addGap(18)
							.addComponent(lblPacijent)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pacijentBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblBolest)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bolestiSimpBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)))
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
						.addComponent(prikaziSimptomeBtn)
						.addComponent(dijagnozaButton)
						.addComponent(btnPovezaneBolesti))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		dijagnoze.setLayout(gl_dijagnoze);
		
		JPanel izvestaji = new JPanel();
		tabbedPane.addTab("Izvestaji", null, izvestaji, null);
		
		JButton logout1 = new JButton("Logout");
		
		JComboBox izvestajBox = new JComboBox();
		izvestajBox.setModel(new DefaultComboBoxModel(new String[] {"Spisak mogucih zavisnika", "Spisak pacijenata sa oslabljenim imunitetom", "Pacijenti sa mogucim hronicnim oboljenjima"}));
		
		JButton reportBtn = new JButton("Dostavi izvestaj");
		
		table = new JTable();
		GroupLayout gl_izvestaji = new GroupLayout(izvestaji);
		gl_izvestaji.setHorizontalGroup(
			gl_izvestaji.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_izvestaji.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_izvestaji.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_izvestaji.createSequentialGroup()
							.addGroup(gl_izvestaji.createParallelGroup(Alignment.LEADING)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
								.addGroup(gl_izvestaji.createSequentialGroup()
									.addComponent(izvestajBox, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(reportBtn)))
							.addContainerGap())
						.addComponent(logout1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
		);
		gl_izvestaji.setVerticalGroup(
			gl_izvestaji.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_izvestaji.createSequentialGroup()
					.addComponent(logout1)
					.addGap(11)
					.addGroup(gl_izvestaji.createParallelGroup(Alignment.BASELINE)
						.addComponent(izvestajBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(reportBtn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addContainerGap())
		);
		izvestaji.setLayout(gl_izvestaji);
		getContentPane().add(tabbedPane);
		
		JPanel monitoring = new JPanel();
		tabbedPane.addTab("Monitoring", null, monitoring, null);
		
		JButton logout2 = new JButton("Logout");
		GroupLayout gl_monitoring = new GroupLayout(monitoring);
		gl_monitoring.setHorizontalGroup(
			gl_monitoring.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_monitoring.createSequentialGroup()
					.addContainerGap(349, Short.MAX_VALUE)
					.addComponent(logout2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
		);
		gl_monitoring.setVerticalGroup(
			gl_monitoring.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_monitoring.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(logout2))
		);
		monitoring.setLayout(gl_monitoring);
	}
}
