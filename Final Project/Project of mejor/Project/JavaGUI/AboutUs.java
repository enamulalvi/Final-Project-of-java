package JavaGUI;

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

public class AboutUs extends JFrame implements ActionListener{
   
    private JButton backButton;
    private JLabel l1;
    private JPanel p1;
	
    public AboutUs(){

        super("AboutUs");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		p1 = new JPanel();
		p1.setBounds(0,0,800, 450);
		this.setLocationRelativeTo(null);
		p1.setLayout(null);

		JLabel l1 = new JLabel("Developed By");
		l1.setBounds(300,30,200,23);
		l1.setFont(new Font("Segoe UI",Font.BOLD,22));
		p1.add(l1);

		ImageIcon ic1 = new ImageIcon("JavaGUI/Resources/m1.jpg");
		JLabel l2 = new JLabel(ic1);
		l2.setBounds(25,120,160,160);
		p1.add(l2);

		JLabel l5 = new JLabel("Nur-E Sarjina Khan");
		l5.setBounds(25,300,320,40);
		l5.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l5);

		JLabel l6 = new JLabel("ID:22-49754-3");
		l6.setBounds(25,320,320,40);
		l6.setFont(new Font("Segoe UI",Font.BOLD,12));
		p1.add(l6);

		ImageIcon ic2 = new ImageIcon("JavaGUI/Resources/m2.jpg");
		JLabel l3 = new JLabel(ic2);
		l3.setBounds(225,120,160,160);
		p1.add(l3);

		JLabel l7 = new JLabel("OwafeeUzzaman Patwary ");
		l7.setBounds(225,300,320,40);
		l7.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l7);

		JLabel l8 = new JLabel("ID:22-49885-3");
		l8.setBounds(225,320,320,40);
		l8.setFont(new Font("Segoe UI",Font.BOLD,12));
		p1.add(l8);

		ImageIcon ic3 = new ImageIcon("JavaGUI/Resources/m3.jpg");
		JLabel l4 = new JLabel(ic3);
		l4.setBounds(420,120,160,160);
		p1.add(l4);

		JLabel l9 = new JLabel("Enamul Alvi");
		l9.setBounds(450,300,320,40);
		l9.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l9);

		JLabel l10 = new JLabel("ID:23-51417-1");
		l10.setBounds(450,320,320,40);
		l10.setFont(new Font("Segoe UI",Font.BOLD,12));
		p1.add(l10);
		
		
		ImageIcon ic4 = new ImageIcon("JavaGUI/Resources/m4.jpg");
		JLabel l11 = new JLabel(ic4);
		l11.setBounds(600,120,160,160);
		p1.add(l11);

		JLabel l12 = new JLabel("Yousha");
		l12.setBounds(630,300,320,40);
		l12.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l12);

		JLabel l13 = new JLabel("ID:22-49878-3");
		l13.setBounds(630,320,320,40);
		l13.setFont(new Font("Segoe UI",Font.BOLD,12));
		p1.add(l13);
		
		backButton = new JButton("Back");
        backButton.setBounds(700, 10, 80, 23);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		p1.add(backButton);
		
		/*ImageIcon ic = new ImageIcon("./Recources/AboutUs.png");
		l1 = new JLabel(ic);
	    l1.setBounds(0,0,786,415);
        p1.add(l1);*/
	
		this.add(p1);
		p1.setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==backButton)
		{
			setVisible(false);
			new Account();
		}
	}
	
	
}