package com.sample.gui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import java.awt.List;

public class DoctorPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public DoctorPanel(String logged) {
		setTitle("Dijagnosticki panel");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		
		JPanel dijagnoze = new JPanel();
		tabbedPane.addTab("Dijagnoze", null, dijagnoze, null);
		
		JLabel lblNewLabel = new JLabel("Unesite simptome koji se manifestuju:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton addSimptom = new JButton(">>");
		
		JButton removeSimptom = new JButton("<<");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton dijagnozaBtn = new JButton("Dijagnoza");
		
		JButton povezaneBtn = new JButton("Povezane bolesti");
		
		JButton logout = new JButton("Odjava");
		
		JLabel lblPacijent = new JLabel("Pacijent:");
		
		JComboBox pacijentBox = new JComboBox();
		
		JLabel label = new JLabel("Bolesti:");
		
		JComboBox bolestiSimpBox = new JComboBox();
		
		JButton prikaziSimptomeBtn = new JButton("Prikazi simptome");
		GroupLayout gl_dijagnoze = new GroupLayout(dijagnoze);
		gl_dijagnoze.setHorizontalGroup(
			gl_dijagnoze.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dijagnoze.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dijagnoze.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
							.addComponent(logout))
						.addGroup(gl_dijagnoze.createSequentialGroup()
							.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dijagnoze.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
										.addComponent(removeSimptom)
										.addComponent(addSimptom)))
								.addGroup(gl_dijagnoze.createSequentialGroup()
									.addGap(10)
									.addComponent(dijagnozaBtn)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dijagnoze.createParallelGroup(Alignment.TRAILING)
								.addComponent(povezaneBtn)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
								.addComponent(prikaziSimptomeBtn, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(lblPacijent)
								.addComponent(pacijentBox, 0, 111, Short.MAX_VALUE)
								.addComponent(bolestiSimpBox, 0, 111, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_dijagnoze.setVerticalGroup(
			gl_dijagnoze.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dijagnoze.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(logout))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dijagnoze.createSequentialGroup()
							.addGap(34)
							.addComponent(addSimptom)
							.addGap(18)
							.addComponent(removeSimptom))
						.addGroup(gl_dijagnoze.createSequentialGroup()
							.addGroup(gl_dijagnoze.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_dijagnoze.createSequentialGroup()
									.addComponent(lblPacijent)
									.addGap(11)
									.addComponent(pacijentBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(label)
									.addGap(12)
									.addComponent(bolestiSimpBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
									.addComponent(prikaziSimptomeBtn)
									.addGap(7)))
							.addGap(3))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.BASELINE)
						.addComponent(dijagnozaBtn)
						.addComponent(povezaneBtn)))
		);
		
		JList<String> allSimptomi = new JList<String>(model);
		scrollPane.setViewportView(allSimptomi);
		
		JList<String> chosenSimptomi = new JList<String>(model);
		scrollPane_1.setViewportView(chosenSimptomi);
		dijagnoze.setLayout(gl_dijagnoze);
		
		
		
		addSimptom.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int index = allSimptomi.getSelectedIndex();
		    	Vector<String> v1 = new Vector<String>();
		    	Vector<String> v2 = new Vector<String>();
		    	for (int i = 0; i < allSimptomi.getModel().getSize(); i++) {
		    		v1.add(allSimptomi.getModel().getElementAt(i));
		    	}
		    	
		    	if(chosenSimptomi.getModel().getSize() > 0) {
			    	for (int i = 0; i < chosenSimptomi.getModel().getSize(); i++) {
			    		v2.add(chosenSimptomi.getModel().getElementAt(i));
			    	}
		    	}
		    	
		    	if (index != -1) {
		    		v2.add(v1.get(index));
		    		v1.remove(index);
		    		allSimptomi.setListData(v1);
		    		allSimptomi.revalidate();
		    		allSimptomi.repaint();
		    		chosenSimptomi.setListData(v2);
			    	chosenSimptomi.revalidate();
			    	chosenSimptomi.repaint();
		    	}
		    	
		    }
		});
		
		removeSimptom.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int index = chosenSimptomi.getSelectedIndex();
		    	Vector<String> v1 = new Vector<String>();
		    	Vector<String> v2 = new Vector<String>();
		    	for (int i = 0; i < chosenSimptomi.getModel().getSize(); i++) {
		    		v1.add(chosenSimptomi.getModel().getElementAt(i));
		    	}
		    	
		    	if(allSimptomi.getModel().getSize() > 0) {
			    	for (int i = 0; i < allSimptomi.getModel().getSize(); i++) {
			    		v2.add(allSimptomi.getModel().getElementAt(i));
			    	}
		    	}
		    	
		    	if (index != -1) {
		    		v2.add(v1.get(index));
		    		v1.remove(index);
		    		chosenSimptomi.setListData(v1);
		    		chosenSimptomi.revalidate();
		    		chosenSimptomi.repaint();
		    		allSimptomi.setListData(v2);
			    	allSimptomi.revalidate();
			    	allSimptomi.repaint();
		    	}
		    	
		    }
		    	
		    
		});
		
		prikaziSimptomeBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Simptomi s = new Simptomi(bolestiSimpBox.getSelectedItem().toString());
	    		s.setSize(250, 300);
	    		s.setLocationRelativeTo(null);
	    		s.setVisible(true);
		    }
		});
		
		dijagnozaBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (chosenSimptomi.getModel().getSize() < 1) {
		    		JOptionPane.showMessageDialog(getContentPane(), "Morate izabrati bar jedan simptom!");
		    		return;
		    	}
		    	String s = "";
		    	for(int i = 0; i< chosenSimptomi.getModel().getSize();i++){
		            s += chosenSimptomi.getModel().getElementAt(i);
		            if(i < chosenSimptomi.getModel().getSize()-1) {
		            	s += ",";
		            }
		        }
		    	Dijagnoza d = new Dijagnoza(pacijentBox.getSelectedItem().toString(), logged, s);
	    		d.setSize(500, 350);
	    		d.setLocationRelativeTo(null);
	    		d.setVisible(true);
		    }
		});
		
		JPanel izvestaji = new JPanel();
		tabbedPane.addTab("Izvestaji", null, izvestaji, null);
		
		JButton logout1 = new JButton("Odjava");
		
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
		
		JButton logout2 = new JButton("Odjava");
		GroupLayout gl_monitoring = new GroupLayout(monitoring);
		gl_monitoring.setHorizontalGroup(
			gl_monitoring.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_monitoring.createSequentialGroup()
					.addContainerGap(339, Short.MAX_VALUE)
					.addComponent(logout2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_monitoring.setVerticalGroup(
			gl_monitoring.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_monitoring.createSequentialGroup()
					.addContainerGap()
					.addComponent(logout2)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		monitoring.setLayout(gl_monitoring);
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from BOLESTI");
			ResultSet result1 = statement1.executeQuery();
			while(result1.next()) {
				bolestiSimpBox.addItem(result1.getString("naziv"));
			}

			
			PreparedStatement statement2;
			statement2 = conn.prepareStatement("select * from PACIJENTI");
			ResultSet result2 = statement2.executeQuery();
			while(result2.next()) {
				pacijentBox.addItem(result2.getInt("brkarte"));
			}
			
			PreparedStatement statement3;
			statement3 = conn.prepareStatement("select * from BOLESTI where simptomi is not null");
			ResultSet result3 = statement3.executeQuery();
			Set<String> hs = new HashSet<>();
			Vector<String> as = new Vector<String>();
			while(result3.next()) {
				String s = result3.getString("simptomi");
				ArrayList<String> a = toArrayList(s);
				hs.addAll(a);
			}
			as.addAll(hs);

			allSimptomi.setListData(as);
			
			conn.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		class LogoutListener implements ActionListener{
		    public void actionPerformed(ActionEvent event){
		    	SwingUtilities.getWindowAncestor(logout1).dispose();
	    		Login l = new Login();
	    		l.setSize(450, 300);
	    		l.setLocationRelativeTo(null);
	    		l.setVisible(true);
		    }
		}
		
		
		LogoutListener l = new LogoutListener();
		logout.addActionListener(l);
		logout1.addActionListener(l);
		logout2.addActionListener(l);
		
		
	}
	
	public static String toString(ArrayList<String> lista) {
		String s = "";
		for(int i = 0; i < lista.size(); i++) {
			if(i != lista.size()-1)
				s += lista.get(i) + ",";
			else s += lista.get(i);
		}
		return s;
	}
	
	public static ArrayList<String> toArrayList(String s) {
		ArrayList<String> l = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(s, ",");
        
        while (tokenizer.hasMoreTokens()) {
            l.add(tokenizer.nextToken());
        }        
		return l;
	}
}
