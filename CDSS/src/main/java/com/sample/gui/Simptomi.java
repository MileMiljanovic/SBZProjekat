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
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class Simptomi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField bolestSimpList;
	
	public Simptomi(String bolest) {
		
		JList<String> simptomiList = new JList<String>();
		
		JLabel lblBolest = new JLabel("Bolest:");
		
		JLabel lblSimptomi = new JLabel("Simptomi:");
		
		bolestSimpList = new JTextField();
		bolestSimpList.setEditable(false);
		bolestSimpList.setColumns(10);
		bolestSimpList.setText(bolest);
		
		JButton zatvoriBtn = new JButton("Zatvori");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBolest)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bolestSimpList, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSimptomi)
								.addComponent(simptomiList, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(zatvoriBtn)))
					.addContainerGap(237, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBolest)
						.addComponent(bolestSimpList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblSimptomi)
					.addGap(9)
					.addComponent(simptomiList, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(zatvoriBtn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		Connection conn;
		try {
			String symptoms = null;
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
			PreparedStatement statement1;
			statement1 = conn.prepareStatement("select simptomi from BOLESTI where naziv = '" + bolest + "'");
			ResultSet result1 = statement1.executeQuery();
			while(result1.next()) {
				symptoms = result1.getString("simptomi");
			}
			ArrayList<String> symp = toArrayList(symptoms);
			Vector<String> v = new Vector<String>();
			for (int i = 0; i < symp.size(); i++) {
				v.add(symp.get(i));
			}
			simptomiList.setListData(v);
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		zatvoriBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SwingUtilities.getWindowAncestor(zatvoriBtn).dispose();
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
