package JavaGUI;

import JavaGUI.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUp extends JFrame implements ActionListener{

	public JFrame SignUPFrame;
	public JButton backButton, signupButton,confirmButton, clearButton;
	public JTextField nameText,emailText, mobilenoText, passwordText, cpasswordText;
	public JTextField addressText, nidText,birthdateText;
	public FileWriter FW;
	private Cursor cursor;

	public SignUp(){

		SignUPFrame = new JFrame("Sign UP");
		SignUPFrame.setSize(800,450);
		SignUPFrame.setLayout(null);
		SignUPFrame.setLocationRelativeTo(null);
		SignUPFrame.setVisible(true);
		SignUPFrame.setResizable(false);
		SignUPFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel BackgroundImage_label;
		ImageIcon img = new ImageIcon("JavaGUI/Resources/br.png");
		BackgroundImage_label = new JLabel ("",img,JLabel.CENTER);
		BackgroundImage_label.setBounds(0,0,800,450);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(453, 20, 90, 30);
		nameLabel.setForeground(Color.white);
		SignUPFrame.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setBounds(550, 25, 175, 23);
		nameText.setBorder(null);
		SignUPFrame.add(nameText);
	
		JLabel mobilenoLabel = new JLabel("Mobile:");
		mobilenoLabel.setBounds(453, 60, 90, 30);
		mobilenoLabel.setForeground(Color.white);
		SignUPFrame.add(mobilenoLabel);
		
		mobilenoText = new JTextField();
		mobilenoText.setBounds(550, 65, 175, 23);
		mobilenoText.setBorder(null);
		SignUPFrame.add(mobilenoText);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(453, 100, 90, 30);
        emailLabel.setForeground(Color.white);
        SignUPFrame.add(emailLabel);		
		
		emailText = new JTextField();
		emailText.setBounds(550, 105, 175, 23);
		emailText.setBorder(null);
		SignUPFrame.add(emailText);
		
		JLabel nidLabel = new JLabel("NID No:");
		nidLabel.setBounds(453, 140, 90, 30);
		nidLabel.setForeground(Color.white);
		SignUPFrame.add(nidLabel);
		
		nidText = new JTextField();
		nidText.setBounds(550, 145, 175, 23);
		nidText.setBorder(null);
		SignUPFrame.add(nidText);

		JLabel birthdateLabel = new JLabel("Birth Date:");
		birthdateLabel.setBounds(453, 180, 90, 30);
		birthdateLabel.setForeground(Color.white);
		SignUPFrame.add(birthdateLabel);
		
		birthdateText = new JTextField();
		birthdateText.setBounds(550, 185, 175, 23);
		birthdateText.setBorder(null);
		SignUPFrame.add(birthdateText);

		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(453, 220, 90, 30);
		addressLabel.setForeground(Color.white);
		SignUPFrame.add(addressLabel);
		
		addressText = new JTextField();
		addressText.setBounds(550, 225, 175, 23);
		addressText.setBorder(null);
		SignUPFrame.add(addressText);
		
		JLabel passwordLable = new JLabel("Password:");
		passwordLable.setBounds(453, 260, 90, 30);
		passwordLable.setForeground(Color.white);
		SignUPFrame.add(passwordLable);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(550, 265, 175, 23);
		passwordText.setBorder(null);
		SignUPFrame.add(passwordText);
		
		JLabel cpasswordLable = new JLabel("Confirm Pass:");
		cpasswordLable.setBounds(453, 300, 90, 30);
		cpasswordLable.setForeground(Color.white);
		SignUPFrame.add(cpasswordLable);

		cpasswordText = new JPasswordField();
		cpasswordText.setBounds(550, 305, 175, 23);
		cpasswordText.setBorder(null);
		SignUPFrame.add(cpasswordText);
		
		backButton = new JButton("Back");
		backButton.setBounds(0,0,100,23);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setBorder(null);
		backButton.setCursor(cursor);
		SignUPFrame.add(backButton);			
					
		confirmButton = new JButton("Confirm Registration");
		confirmButton.setBounds(435,340,140,23);
		confirmButton.setFocusable(false);
		confirmButton.addActionListener(this);
		confirmButton.setBorder(null);
		confirmButton.setCursor(cursor);
		SignUPFrame.add(confirmButton);
	
		clearButton = new JButton("Clear All");
		clearButton.setBounds(650,340,100,23);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		clearButton.setBorder(null);
		clearButton.setCursor(cursor);
		SignUPFrame.add(clearButton);
		
		SignUPFrame.add(BackgroundImage_label);

		SignUPFrame.setVisible(true);

	}
	
	public void clearAll(){

			nameText.setText("");
			emailText.setText("");
			mobilenoText.setText("");
			nidText.setText("");
			birthdateText.setText("");
			addressText.setText("");
			passwordText.setText("");
			cpasswordText.setText("");
	}
	
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == confirmButton){

			String pass = passwordText.getText();
			String cpass = cpasswordText.getText();
			if(pass.equals(cpass)){

					try{
					
					
						String Str = emailText.getText()+","+
									 passwordText.getText()+","+
									 nameText.getText()+","+
									 mobilenoText.getText()+","+
									 nidText.getText()+","+
									 birthdateText.getText()+","+
									 addressText.getText()+"\n";
				

						FW= new FileWriter("All Text Files/UserInfo.txt",true);
				
						FW.write(Str);

						FW.close();
					}
				
					catch(Exception E)
					{

					}
				
					clearAll();
					JOptionPane.showMessageDialog(null,"Registration Successfull");
			}

			else{
				JOptionPane.showMessageDialog(null,"Password doesn't match");
			}
			
		}
		
		else if(e.getSource() == clearButton)
		{
			clearAll();
		}
		
		else if(e.getSource() == backButton)
		{
			SignUPFrame.setVisible(false);
			new Account();
		}

	}


}

