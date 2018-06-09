package com.sample.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Login extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	
	public Login() {
		
		getContentPane().setBackground(Color.BLUE);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Korisnicko ime");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblPassword = new JLabel("Lozinka");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton loginButton = new JButton("Login");
		
		JLabel lblNewLabel = new JLabel("Clinical Decision Support System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton izlazButton = new JButton("Izlaz");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(186)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(173)
							.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
							.addComponent(izlazButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsername)
							.addGap(8)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(loginButton)
							.addGap(25))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(izlazButton)
							.addContainerGap())))
		);
		getContentPane().setLayout(groupLayout);
		
		loginButton.addActionListener(new ActionListener() {


		    public void actionPerformed(ActionEvent e) {
		    	String passText = new String(password.getPassword());
		    	if (username.getText().equals("admin") && passText.equals("admin")) {
		    		SwingUtilities.getWindowAncestor(loginButton).dispose();
		    		AdminPanel d = new AdminPanel();
		    		d.setSize(600, 400);
		    		d.setLocationRelativeTo(null);
		    		d.setVisible(true);
		    	}
		    	else {
		    			
		    	    	Connection con;
						try {
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Orcl","c##ljemi","ljemi");
							PreparedStatement statement;
							statement = con.prepareStatement("select username, pass from LEKARI");
							ResultSet result = statement.executeQuery();
							boolean logged = false;
							while(result.next()){
								if (username.getText().equals(result.getString("username")) && passText.equals(result.getString("pass"))) {
						    		SwingUtilities.getWindowAncestor(loginButton).dispose();
						    		DoctorPanel d = new DoctorPanel(result.getString("username"));
						    		d.setSize(600, 350);
						    		d.setLocationRelativeTo(null);
						    		d.setVisible(true);
						    		logged = true;
						    		break;
								}				
					        }
							if (logged == false) {
								JOptionPane.showMessageDialog(getContentPane(), "Korisnicko ime ili sifra su netacni!"); 		 
							}
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

		    	        
		    	}
		        
		    }
		});
		
		izlazButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	System.exit(0);		    	
		    }
		});
	}
}
