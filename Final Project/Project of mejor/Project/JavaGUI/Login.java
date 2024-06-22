 package JavaGUI;

import JavaGUI.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.event.*;  
import java.awt.*;
import java.lang.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.io.File; 
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Login extends JFrame implements ActionListener {
	
    private Font fontstyle1;
    private Font fontstyle2;
    private JButton loginButton, backButton, forgetButton;
    private JTextField emailText;
    private JPasswordField passwordText; 
    private JFrame frame3;
    private Cursor cursor;
    public String checkPass, checkusername;
    public FileReader reader;
    public String email_to_check;

    public String get_email(){

        return email_to_check;
    }

    public Login () {
	   
        frame3 = new JFrame("Login");
        frame3.setSize(800, 450);
        frame3.setResizable(true);
        frame3.setLayout(null);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLocationRelativeTo(null);
		
        JLabel BackgroundImage_label ;
        ImageIcon img = new ImageIcon("JavaGUI/Resources/br.png");
        BackgroundImage_label = new JLabel("", img, JLabel.CENTER);
        BackgroundImage_label.setBounds(0,0,800,450);
		
        fontstyle1 = new Font("Chesna Grotesk", Font.BOLD, 24);
        fontstyle2 = new Font("Chesna Grotesk", Font.BOLD, 16);

        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(320, 150, 70, 30);
        emailLabel.setForeground(Color.black);
        //emailLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        frame3.add(emailLabel);
        
        emailText = new JTextField();
        emailText.setBounds(390, 155, 175, 20);
        frame3.add(emailText);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(320, 200, 70, 30);
        passwordLabel.setForeground(Color.black);
        //passwordLabel.setFont(fontstyle2);
        frame3.add(passwordLabel);
        
        passwordText = new JPasswordField();
        passwordText.setBounds(390, 205, 175, 20);
        frame3.add(passwordText);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(310, 260, 75, 23);
        frame3.add(loginButton);
        loginButton.addActionListener(this);

        forgetButton = new JButton("Forget Password");
        forgetButton.setBounds(420, 260, 150, 23);
        frame3.add(forgetButton);
        forgetButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(00, 00, 75, 23);
        frame3.add(backButton);
        backButton.addActionListener(this);
        
        frame3.add(BackgroundImage_label);
		
        frame3.setVisible(true);
    }
	
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton){

            String email = emailText.getText();
            String password = String.valueOf(passwordText.getText());
             
             
            String LoginInfo = email+","+password;
            String adminLoginInfo = "admin"+","+"admin";
             

            BufferedReader bfreader = null;
            String line;
            int count = 0;

            try{
            
                reader = new FileReader("All Text Files/UserInfo.txt");
                bfreader = new BufferedReader(reader);
                
                while((line = bfreader.readLine()) != null){

                    String[] parts = line.split(",");
                    String Email = parts[0];
                    String Password = parts[1];
                    
                    String User_login_info = Email + "," + Password;

                    if(LoginInfo.equals(User_login_info)){

                        count++;
                    }               
                }
                if(count == 1){

                    email_to_check = emailText.getText();
                    frame3.setVisible(false);
                    new Home(this);
		System.out.println("Login Successfully ");
                }
                else if (LoginInfo.equals(adminLoginInfo)){

                    frame3.setVisible(false);
                    new Admin(this);
                }
                
                else if(email.isEmpty() || password.isEmpty()){

                    JOptionPane.showMessageDialog(this,"Please fill up all the fields");
                }
                else{

                    JOptionPane.showMessageDialog(this,"Enter Correct ID & Password");
                }
                                
                reader.close();
                bfreader.close();         
            }
            catch(Exception ex){}

        }
        else if (e.getSource() == backButton){

            this.setVisible(false);
            new Account();
        }
        else if (e.getSource() == forgetButton){

            this.setVisible(false);
            new ForgetPassword();
        }
        
    }
}
