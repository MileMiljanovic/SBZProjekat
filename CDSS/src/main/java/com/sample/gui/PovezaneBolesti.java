package com.sample.gui;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import com.sample.app.KnowledgeSessionHelper;
import com.sample.model.Bolest;
import com.sample.model.Bolesti;
import com.sample.model.Povezane;
import com.sample.model.PovezaneBolestiList;
import com.sample.model.Symptoms;


import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.swing.JTextArea;

public class PovezaneBolesti extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PovezaneBolesti(String simptomi) {
		
		JLabel simptomiLabel = new JLabel("Simptomi:");
		
		JLabel lblBolesti = new JLabel("Povezane bolesti:");
		
		JList<String> list = new JList<String>();
		
		JButton zatvoriButton = new JButton("Zatvori");
		
		JTextArea simptomiArea = new JTextArea();
		simptomiArea.setText(simptomi);
		simptomiArea.setLineWrap(true);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(zatvoriButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(simptomiLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(simptomiArea, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBolesti, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(simptomiLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(simptomiArea, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblBolesti)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(zatvoriButton))
		);
		getContentPane().setLayout(groupLayout);
		
		ArrayList<String> symps = toArrayList(simptomi);
		Symptoms sy = new Symptoms(symps);
		ArrayList<Bolest> bolesti = new ArrayList<Bolest>();
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select * from BOLESTI");
			ResultSet result1 = statement1.executeQuery();
			while(result1.next()) {
				Bolest b = new Bolest();
				b.setNaziv(result1.getString("naziv"));
				b.setGrupa(result1.getString("grupa"));
				b.setSimptomi(toArrayList(result1.getString("simptomi")));
				bolesti.add(b);
			}
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Bolesti bs = new Bolesti(bolesti);
		PovezaneBolestiList pbl = new PovezaneBolestiList(new ArrayList<Povezane>());
		KieContainer kc = KnowledgeSessionHelper.createRuleBase();
		KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "ksession-rules");
		kSession.insert(bs);
		kSession.insert(sy);
		kSession.insert(pbl);
		kSession.getAgenda().getAgendaGroup( "povezane" ).setFocus();
    	kSession.fireAllRules();
    	//ArrayList<Povezane> sorted = new ArrayList<Povezane>();
    	for (int i = 0; i < pbl.getPovezane().size(); i++) {

            for (int j = pbl.getPovezane().size() - 1; j > i; j--) {
                if (pbl.getPovezane().get(i).getBroj() > pbl.getPovezane().get(j).getBroj()) {
                    Povezane tmp = pbl.getPovezane().get(i);
                    pbl.getPovezane().set(i,pbl.getPovezane().get(j)) ;
                    pbl.getPovezane().set(j,tmp);
                }
            }
        }
    	
    	Vector<String> v1 = new Vector<String>();
    	for(int i = pbl.getPovezane().size()-1; i >= 0; i--) {
    		v1.add(pbl.getPovezane().get(i).getBolest() + " - " 
    				+ pbl.getPovezane().get(i).getBroj() + " simptoma" );
    	}
    	
    	list.setListData(v1);
    	kSession.dispose();	
		
		zatvoriButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(zatvoriButton).dispose();
		    }
		});
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


