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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.Bolest;
import com.sample.model.FinalResult;
import com.sample.model.Result;
import com.sample.model.Results;
import com.sample.model.Symptoms;
import com.sample.app.KnowledgeSessionHelper;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

public class DoctorPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable allPacijenti;
	private JTable dijagnozeTable;
	
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
		
		JLabel loggedLabel = new JLabel("Ulogovani ste kao: " + logged);
		
		GroupLayout gl_dijagnoze = new GroupLayout(dijagnoze);
		gl_dijagnoze.setHorizontalGroup(
			gl_dijagnoze.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dijagnoze.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dijagnoze.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
							.addComponent(loggedLabel))
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
								.addComponent(lblPacijent)
								.addComponent(pacijentBox, 0, 111, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(bolestiSimpBox, 0, 111, Short.MAX_VALUE)
								.addComponent(prikaziSimptomeBtn, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(logout, Alignment.TRAILING))))
					.addContainerGap())
		);
		gl_dijagnoze.setVerticalGroup(
			gl_dijagnoze.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dijagnoze.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(loggedLabel))
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
									.addComponent(logout)
									.addGap(18)
									.addComponent(lblPacijent)
									.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
									.addComponent(pacijentBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(19)
									.addComponent(label)
									.addGap(15)
									.addComponent(bolestiSimpBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(7)))
							.addGap(3))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_dijagnoze.createParallelGroup(Alignment.BASELINE)
						.addComponent(dijagnozaBtn)
						.addComponent(povezaneBtn)
						.addComponent(prikaziSimptomeBtn)))
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
		
		KieContainer kc = KnowledgeSessionHelper.createRuleBase();
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "ksession-rules");
		
		
		dijagnozaBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (chosenSimptomi.getModel().getSize() < 1) {
		    		JOptionPane.showMessageDialog(getContentPane(), "Morate izabrati bar jedan simptom!");
		    		return;
		    	}

		    	String s = "";
		    	ArrayList<String> simp = new ArrayList<String>();					
		    	for(int i = 0; i< chosenSimptomi.getModel().getSize();i++){
		            s += chosenSimptomi.getModel().getElementAt(i);
		            if(i < chosenSimptomi.getModel().getSize()-1) {
		            	s += ",";
		            }
		            simp.add(chosenSimptomi.getModel().getElementAt(i));
		        }
		    	Symptoms smp = new Symptoms(simp);
		    	Results r = new Results(new ArrayList<Result>());
		    	FinalResult f = new FinalResult("");
		    	kSession.insert(f);
		    	kSession.insert(r);
		    	kSession.insert(smp);		    	
		    	kSession.getAgenda().getAgendaGroup( "simptomi" ).setFocus();
		    	kSession.fireAllRules();
		    	kSession.getAgenda().getAgendaGroup( "maxSimp" ).setFocus();
		    	kSession.fireAllRules();

			    JOptionPane.showMessageDialog(getContentPane(), "Najverovatnija bolest je: " + f.getFinalRes());
			    kSession.dispose();			    
		    	SwingUtilities.getWindowAncestor(dijagnozaBtn).dispose();
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
		
		JButton logout3 = new JButton("Odjava");
		JButton logout4 = new JButton("Odjava");
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from BOLESTI");
			ResultSet result1 = statement1.executeQuery();
			while(result1.next()) {
				bolestiSimpBox.addItem(result1.getString("naziv"));
				Bolest b = new Bolest();
				b.setNaziv(result1.getString("naziv"));
				b.setGrupa(result1.getString("grupa"));
				b.setSimptomi(toArrayList(result1.getString("simptomi")));
				kSession.insert(b);
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
			for (int i = as.size()-1; i > 0; i--) {
				if(as.get(i).startsWith("*")) {
					as.remove(i);
				}
			}
			as.add("*Oporavlja se od operacije");
			allSimptomi.setListData(as);
			
			JPanel pacijenti = new JPanel();
			tabbedPane.addTab("Pacijenti", null, pacijenti, null);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			
			JLabel lblNewLabel_1 = new JLabel("Pregled svih pacijenata:");
			
			
			GroupLayout gl_pacijenti = new GroupLayout(pacijenti);
			gl_pacijenti.setHorizontalGroup(
				gl_pacijenti.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pacijenti.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pacijenti.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_pacijenti.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
								.addComponent(logout3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_pacijenti.setVerticalGroup(
				gl_pacijenti.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pacijenti.createSequentialGroup()
						.addGroup(gl_pacijenti.createParallelGroup(Alignment.BASELINE)
							.addComponent(logout3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			
			PreparedStatement statement5;
			statement5 = conn.prepareStatement("select * from PACIJENTI");
			ResultSet result5 = statement5.executeQuery();
			allPacijenti = new JTable(buildTableModel(result5));
			allPacijenti.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollPane_2.setViewportView(allPacijenti);
			pacijenti.setLayout(gl_pacijenti);
			
			JPanel allDijagnoze = new JPanel();
			tabbedPane.addTab("Pregled dijagnoza", null, allDijagnoze, null);
			
			JLabel lblPregledSvihDijagnoza = new JLabel("Pregled svih dijagnoza:");
			
			JScrollPane scrollPane_3 = new JScrollPane();
			
			
			GroupLayout gl_allDijagnoze = new GroupLayout(allDijagnoze);
			gl_allDijagnoze.setHorizontalGroup(
				gl_allDijagnoze.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_allDijagnoze.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_allDijagnoze.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
							.addGroup(gl_allDijagnoze.createSequentialGroup()
								.addComponent(lblPregledSvihDijagnoza, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
								.addComponent(logout4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
			);
			gl_allDijagnoze.setVerticalGroup(
				gl_allDijagnoze.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_allDijagnoze.createSequentialGroup()
						.addGroup(gl_allDijagnoze.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPregledSvihDijagnoza)
							.addComponent(logout4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			
			

			PreparedStatement statement4;
			statement4 = conn.prepareStatement("select * from DIJAGNOZE");
			ResultSet result4 = statement4.executeQuery();
			dijagnozeTable = new JTable(buildTableModel(result4));
			dijagnozeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			scrollPane_3.setViewportView(dijagnozeTable);
			allDijagnoze.setLayout(gl_allDijagnoze);
			
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
		logout3.addActionListener(l);
		logout4.addActionListener(l); 
		
		povezaneBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(chosenSimptomi.getModel().getSize() > 0) {
		    		String s = "";
			    	for (int i = 0; i < chosenSimptomi.getModel().getSize(); i++) {
			    		s += chosenSimptomi.getModel().getElementAt(i);
			    		if(i < chosenSimptomi.getModel().getSize()-1) {
			    			s += ",";
			    		}
			    	}
			    	PovezaneBolesti p = new PovezaneBolesti(s);
		    		p.setSize(450, 350);
		    		p.setLocationRelativeTo(null);
		    		p.setVisible(true);
		    	}
		    	else
		    		JOptionPane.showMessageDialog(getContentPane(), "Morate izabrati bar jedan simptom!");
		    	
		    }
		});
		
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
	
	/*public static Result removeAndMax(ArrayList<Result> list) {
		
		ArrayList<Result> allList = new ArrayList<Result>();
		boolean hasAllFlag = false;
		for(int i=0; i < list.size(); i++){	    	
	    	if(list.get(i).isSviZadovoljeni() == true) {
	    		hasAllFlag = true;
	    		allList.add(list.get(i));
	    	}
	    }
		
	    int max = Integer.MIN_VALUE;
	    Result maxR = new Result(0,"",false);
	    if(hasAllFlag == false) {
		    for(int i=0; i < list.size(); i++){	    	
		    	if(list.get(i).getNoSymptoms() > max){
		    		maxR = list.get(i);
			    }
		    }
	    }
	    else
	    {
	    	for(int i=0; i < allList.size(); i++){	    	
		    	if(allList.get(i).getNoSymptoms() > max){
		    		maxR = allList.get(i);
			    }
		    }
	    }
	    return maxR;
	}*/
}
