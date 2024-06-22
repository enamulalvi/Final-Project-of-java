package JavaGUI;

import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.lang.*;
import javax.swing.border.*;
import java.util.Scanner;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class Admin extends JFrame implements ActionListener{

	private JLabel l1,dashboardLabel, userinfoLabel,l4, updateLabel,l6; 
	private JButton signoutButton, userinfoButton,b2, updateButton,b4,b5;
	public JPanel p1;
	public Login login;
 
    public Admin(Login login){

		super("Admin Dashboard");
		this.login = login;
		this.setSize(850,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setUndecorated(true);
		this.setResizable(false);
		this.setLayout(null);
			
		p1 = new JPanel();
		p1.setBounds(0,0,850,600);
		p1.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		p1.setLayout(null);

		dashboardLabel = new JLabel("Admin Dashboard");
		dashboardLabel.setFont(new Font("Segoe UI",Font.BOLD,30));
		dashboardLabel.setBounds(420,25,400,35);
		dashboardLabel.setForeground(Color.BLACK);
		p1.add(dashboardLabel);	
		
		userinfoLabel = new JLabel("User information");
		userinfoLabel.setFont(new Font("Segoe UI",Font.BOLD,16));
		userinfoLabel.setBounds(540,250,400,30);
		userinfoLabel.setForeground(Color.BLACK);
		p1.add(userinfoLabel);

		ImageIcon icon2 = new ImageIcon("JavaGUI/Resources/userinfo.jpg");
		userinfoButton = new JButton(icon2);
		userinfoButton.setBounds(530,120,170,130);
		userinfoButton.addActionListener(this);
		userinfoButton.setFocusPainted(false);
	    userinfoButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    userinfoButton.setContentAreaFilled(false);
		userinfoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(userinfoButton);		
		
		updateLabel = new JLabel("Update Products");
		updateLabel.setFont(new Font("Segoe UI",Font.BOLD,16));
		updateLabel.setBounds(540,470,400,30);
		updateLabel.setForeground(Color.BLACK);
		p1.add(updateLabel);

		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/adminInfo.jpg");
		updateButton = new JButton(icon4);
		updateButton.setBounds(530,340,170,130);
		updateButton.addActionListener(this);
		updateButton.setFocusPainted(false);
	    updateButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    updateButton.setContentAreaFilled(false);
		updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(updateButton);

		signoutButton = new JButton("Sign out");
		signoutButton.setFont(new Font("Segoe UI",Font.BOLD,15));
	    signoutButton.setForeground(Color.WHITE);
		signoutButton.setFocusPainted(false);
	    signoutButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    signoutButton.setContentAreaFilled(false);
	    signoutButton.setBorder(null);
	    signoutButton.setBounds(750,10,70,30);
	    signoutButton.addActionListener(this);
	    signoutButton.setFocusable(false);
	    signoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(signoutButton);

	    ImageIcon i1 = new ImageIcon("JavaGUI/Resources/admin.png");
		JLabel l7 = new JLabel(i1);
    	l7.setBounds(30,170,320,283);
    	p1.add(l7);
		
    	ImageIcon ic = new ImageIcon("JavaGUI/Resources/red.jpg");
    	JLabel l8 = new JLabel(ic);
    	l8.setBounds(400,0,500,660);
    	p1.add(l8);

	    this.add(p1);
    	this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

	    if(e.getSource() == signoutButton){

			this.dispose();
			login.setVisible(true);
		}
		else if(e.getSource() == userinfoButton){

			this.setVisible(false);
			new UserInformation(this, login);
		}
		else if(e.getSource() == updateButton){

			this.setVisible(false);
			new UpdateProducts(this,login);
		}
	}
}

		
			