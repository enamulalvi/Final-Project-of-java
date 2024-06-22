package JavaGUI;

import JavaGUI.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.*;  
import java.awt.*;
import java.lang.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Account extends JFrame implements ActionListener{

    private Font fontstyle1;
    private Font fontstyle2;
    private JButton loginButton;
    private JButton signupButton;
    private JButton visitButton;
    private JButton aboutusButton;
    private JFrame frame2;

    public Account(){
        
        frame2 = new JFrame("Account");
        frame2.setLayout(null);
        frame2.setSize(800,450);
        frame2.setResizable(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);

        fontstyle1 = new Font("Chesna Grotesk", Font.BOLD, 24);
        fontstyle2 = new Font("Chesna Grotesk", Font.BOLD, 18);

        JLabel BackgroundImage_label;
        ImageIcon img = new ImageIcon("JavaGUI/Resources/br.png");
        BackgroundImage_label = new JLabel("",img,JLabel.CENTER);
        BackgroundImage_label.setBounds(0,0,800,450);

        JLabel acc = new JLabel("Have an Account:");
        acc.setBounds(290, 230, 100, 50);
        acc.setForeground(Color.white);
        //acc.setFont(fontstyle1);
        frame2.add(acc);

        loginButton = new JButton("Login");
        loginButton.setBounds(290, 270, 100, 30);
		loginButton.setFocusable(false);
        frame2.add(loginButton);
        loginButton.addActionListener(this);

        JLabel create = new JLabel("Create an Account:");
        create.setBounds(485, 230, 150, 50);
        create.setForeground(Color.white);
        //create.setFont(fontstyle1);
        frame2.add(create);

        signupButton = new JButton("Sign Up");
        signupButton.setBounds(485, 270, 100, 30);
		signupButton.setFocusable(false);
        frame2.add(signupButton);
        signupButton.addActionListener(this);

        JLabel visit = new JLabel("Visit Shop:");
        visit.setBounds(290, 140, 100, 50);
        visit.setForeground(Color.white);
        //create.setFont(fontstyle1);
        frame2.add(visit);

        visitButton = new JButton("Visit");
        visitButton.setBounds(290, 185, 100, 30);
        visitButton.setFocusable(false);
        frame2.add(visitButton);
        visitButton.addActionListener(this);

        aboutusButton = new JButton("About Us");
        aboutusButton.setBounds(485,185,100,30);
        aboutusButton.setFocusable(false);
        //aboutusButton.setBorder(null);
        //aboutusButton.setCursor(cursor);
        frame2.add(aboutusButton);
        aboutusButton.addActionListener(this);

        frame2.add(BackgroundImage_label);

        frame2.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource() == loginButton){

            frame2.setVisible(false);
            new Login();
        } 
        else if (e.getSource() == signupButton){

            frame2.setVisible(false);
            new SignUp();
        }
        else if (e.getSource() == aboutusButton){

            this.setVisible(false);
            new AboutUs();
        }
        else if (e.getSource() == visitButton){

            this.setVisible(false);
            new Guesthome();
        }
    }
}
