package JavaGUI;

import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.File; 
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.lang.*;
import java.awt.Color;

public class ForgetPassword extends JFrame implements ActionListener{

	public JButton Previous_Password_Button, Sign_up_Button,Forget_Password_Button;
	public JTextField Email_txt,NID_txt;
	public JPasswordField New_Password_txt,Confirm_Password_txt ;
	public JButton SavePassword_Button, ClearAll_Button,Login_Button,Validate_Button;
	public Login login;
	private Cursor cursor;
	private FileReader reader;
	private JLabel Email_Label,NID_Label,New_Password_Lable,Confirm_Password_Lable;
	public JCheckBox checkBox ;
	
	
	public ForgetPassword(){

		this.setTitle("ForgetPassword");
		this.setSize(500,500);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cursor = new Cursor(Cursor.HAND_CURSOR);

		Email_Label = new JLabel("Enter Your Email:");
		Email_Label.setBounds(50,50,150,30);
		this.add(Email_Label);

		Email_txt = new JTextField();
		Email_txt.setBounds(250,50,200,25);
		this.add(Email_txt);
		
		NID_Label = new JLabel("Enter Your NID:");
		NID_Label.setBounds(50,100,150,30);
		this.add(NID_Label);

		NID_txt = new JTextField();
		NID_txt.setBounds(250,100,200,25);
		this.add(NID_txt);
		
		New_Password_Lable = new JLabel("New Password:");
		New_Password_Lable.setBounds(50,200,150,30);
		this.add(New_Password_Lable);

		New_Password_txt = new JPasswordField();
		New_Password_txt.setBounds(250,200,200,25);
		New_Password_txt.setEnabled(false);
		this.add(New_Password_txt);
		
		Confirm_Password_Lable = new JLabel("Confirm Password:");
		Confirm_Password_Lable.setBounds(50,250,150,30);
		this.add(Confirm_Password_Lable);
		
		Confirm_Password_txt = new JPasswordField();
		Confirm_Password_txt.setBounds(250,250,200,25);
		Confirm_Password_txt.setEnabled(false);
		this.add(Confirm_Password_txt);
		
		checkBox = new JCheckBox();
		checkBox.setText("Show Passwords");
		checkBox.setBounds(250,280,150,30);
		checkBox.setOpaque(false);
		checkBox.setEnabled(false);
		checkBox.addActionListener(this);
		this.add(checkBox);
		
		Validate_Button = new JButton("Validate");
		Validate_Button.setBounds(175,150,150,30);
		Validate_Button.setBorder(null);
		Validate_Button.addActionListener(this);
		Validate_Button.setCursor(cursor);
		this.add(Validate_Button);

		SavePassword_Button = new JButton("Save Password");
		SavePassword_Button.setBounds(75,350,150,30);
		SavePassword_Button.setBorder(null);
		SavePassword_Button.addActionListener(this);
		SavePassword_Button.setCursor(cursor);
		this.add(SavePassword_Button);
		
		ClearAll_Button = new JButton("ClearAll");
		ClearAll_Button.setBounds(275,350,150,30);
		ClearAll_Button.setBorder(null);
		ClearAll_Button.addActionListener(this);
		ClearAll_Button.setCursor(cursor);
		this.add(ClearAll_Button);
		
		Login_Button = new JButton("Go to Login");
		Login_Button.setBounds(175,400,150,30);
		Login_Button.setBorder(null);
		Login_Button.addActionListener(this);
		Login_Button.setCursor(cursor);
		this.add(Login_Button);
		
	}
	
	public void ClearAll(){

		New_Password_txt.setText("");
		Confirm_Password_txt.setText("");
		Email_txt.setText("");
		NID_txt.setText("");
	}
	
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == Validate_Button){

			String T_email = Email_txt.getText();
			String T_nid = String.valueOf(NID_txt.getText());

			String LoginInfo = T_email +","+ T_nid;
			
			
			BufferedReader bfreader = null;
			String line;
			//String Email = "";
			//String NID = "";
			int count = 0;
			try{

				reader = new FileReader("All Text Files/UserInfo.txt");
				bfreader = new BufferedReader(reader);
				
				while((line=bfreader.readLine()) != null){

					String[] parts = line.split(",");
					String Email = parts[0];
					String NID = parts[4];
					
					String User_login_info = Email + "," + NID;
					
					if(LoginInfo.equals(User_login_info)){

						count++;
					}	
				}
				
				if(count == 1){

					JOptionPane.showMessageDialog(this,"User Verified!");
					New_Password_txt.setEnabled(true);
					Confirm_Password_txt.setEnabled(true);
					checkBox.setEnabled(true);
				}
				if(T_email.isEmpty() && T_nid.isEmpty()){

						JOptionPane.showMessageDialog(this,"Please fill-up email & NID");
				}
				else{

						JOptionPane.showMessageDialog(this,"Please enter the correct email or NID");
				}
					
				/*else if(!(LoginInfo.equals(User_login_info))){

						JOptionPane.showMessageDialog(this,"Please enter the correct email or NID");
				}*/
					
				/*else if(!(T_email.equals(Email))){

						JOptionPane.showMessageDialog(this,"Please enter the correct email ");
				}
				else if(!(T_nid.equals(NID))){

						JOptionPane.showMessageDialog(this,"Please enter the correct NID");
				}*/
				reader.close();
				bfreader.close();
			}
			catch(Exception ex){}			
		}
		
		else if (e.getSource() == SavePassword_Button){

			if(New_Password_txt.getText().isEmpty() && Confirm_Password_txt.getText().isEmpty()){

				JOptionPane.showMessageDialog(this,"Pleas fill-up All the fileds!");
			}
			else if(New_Password_txt.getText().equals(Confirm_Password_txt.getText())){
			
				try {
					String email = "";
					String pass = "";
					String name = "";
					String phone = "";
					String nid = "";
					String dob = "";
					String address = "";

					File oldFile = new File("All Text Files/UserInfo.txt");
					File newFile = new File("All Text Files/userTemp.txt");

					newFile.createNewFile();
					FileWriter fw = new FileWriter("All Text Files/userTemp.txt", true);

					FileReader fr = new FileReader(oldFile);
					BufferedReader bfr = new BufferedReader(fr);
					String SingleLine="";

					while ((SingleLine=bfr.readLine())!= null){
						String sp[] = SingleLine.split(",");
						if (sp[0].equals(Email_txt.getText())) {
							email = sp[0];
							pass = sp[1];
							name = sp[2];
							phone = sp[3];
							nid = sp[4];
							dob = sp[5];
							address = sp[6];
						}
				    	if(!sp[0].equals(Email_txt.getText())){

							fw.write(SingleLine + "\n");
						}
			    	}
					bfr.close(); 
					fr.close();
					fw.close();

					oldFile.delete();
					File dump = new File("All Text Files/UserInfo.txt");
					newFile.renameTo(dump);

					String newpass = New_Password_txt.getText();
					String s = email + "," + newpass + "," + name + "," + phone + "," + nid + "," + dob + "," + address + "\n";
					FileWriter fw1 = new FileWriter("All Text Files/UserInfo.txt", true);
					fw1.write(s);
					fw1.close();
				} 
				catch (IOException ioe){
					ioe.printStackTrace();
				}
		
				ClearAll();
				JOptionPane.showMessageDialog(null, "Password Saved Successfully");
			}
		

			else{
				JOptionPane.showMessageDialog(this,"New Password & Confirm Password Doesn't Match");
			}
			
		}
		else if(e.getSource()==ClearAll_Button){

			ClearAll();
		}
		else if(e.getSource()==Login_Button){

			this.setVisible(false);
			new Login();
		}
		else if(checkBox.isSelected()){

			New_Password_txt.setEchoChar((char) 0);
			Confirm_Password_txt.setEchoChar((char) 0);
			
		}
		else if(checkBox.isSelected()!=true){

			New_Password_txt.setEchoChar('\u2022');
			Confirm_Password_txt.setEchoChar('\u2022');
		}
		
	}
	
}