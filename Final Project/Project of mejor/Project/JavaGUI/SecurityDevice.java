package JavaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SecurityDevice extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JPanel p1;
	private Home home;
	private Login login;
	
	public SecurityDevice(Home home,Login login){
		
		super("SecurityDevice");
		this.home=home;
		this.login=login;
		this.setSize(800,630);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		p1 = new JPanel();
		p1.setBounds(0,0,800,630);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		l2 = new JLabel("COLLECTION -> SECURITY DEVICES");
		l2.setBounds(18,65,500,25);
		l2.setFont(new Font("Segoe UI",Font.BOLD,20));
		p1.add(l2);
		
		l3 = new JLabel();
		l3.setBounds(180,290,500,19);
		l3.setFont(new Font("Segoe UI",Font.PLAIN,15));
		p1.add(l3);
		
		l4 = new JLabel();
		l4.setBounds(180,310,310,19);
		l4.setFont(new Font("Segoe UI",Font.PLAIN,15));
		p1.add(l4);
		
		l5 = new JLabel();
		l5.setBounds(540,295,120,19);
		l5.setFont(new Font("Segoe UI",Font.PLAIN,15));
		p1.add(l5);
		
		l8 = new JLabel();
		l8.setBounds(530,315,100,19);
		l8.setFont(new Font("Segoe UI",Font.PLAIN,15));
		p1.add(l8);
		
		l6 = new JLabel();
		l6.setBounds(220,535,100,19);
		l6.setFont(new Font("Segoe UI",Font.PLAIN,15));
		p1.add(l6);
		
		l9 = new JLabel();
		l9.setBounds(220,555,120,19);
		l9.setFont(new Font("Segoe UI",Font.PLAIN,15));
		p1.add(l9);
		
		l7 = new JLabel();
		l7.setBounds(520,535,100,18);
		l7.setFont(new Font("Segoe UI",Font.PLAIN,15));
		p1.add(l7);
		
		l1 = new JLabel();
		l1.setBounds(520,555,150,19);
		l1.setFont(new Font("Segoe UI",Font.PLAIN,15));
		p1.add(l1);
			
		
		ImageIcon icon1 = new ImageIcon("JavaGUI/Resources/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,20,35,35);
		b1.addActionListener(this);
		b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);
	    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(b1);	
		
		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/t1.jpg");
		b4 = new JButton(icon3);
		b4.setBounds(140,110,200,180);
	    b4.addActionListener(this);
	    b4.setFocusable(false);
	    b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b4);
		
		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/t2.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(460,110,200,180);
	    b5.addActionListener(this);
	    b5.setFocusable(false);
	    b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b5);
	
		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/t3.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(140,350,200,180);
	    b6.addActionListener(this);
	    b6.setFocusable(false);
	    b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b6);
	
	    ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/t4.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(460,350,200,180);
	    b7.addActionListener(this);
	    b7.setFocusable(false);
	    b7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b7);
		for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 if(sp[1].equals("13"))
						 {
						    l3.setText(sp[0]);
							l4.setText("BDT "+sp[2]+"tk");
							
						 }
						else if(sp[1].equals("14"))
						 {
						    l5.setText(sp[0]);
							l8.setText("BDT "+sp[2]+"tk");
							
						 }
						 else if(sp[1].equals("15"))
						 {
						    l6.setText(sp[0]);
							l9.setText("BDT "+sp[2]+"tk");
							
						 }
						  else if(sp[1].equals("16"))
						 {
						    l7.setText(sp[0]);
							l1.setText("BDT "+sp[2]+"tk");
							
						 }
					}
					
				}
		
		this.add(p1);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			this.setVisible(false);
         home.setVisible(true);
	
		}
		if(e.getSource()==b4)
		{ 
	        home.a=13;
           this.setVisible(false);
		   new Buy(this,home);
		}
		if(e.getSource()==b5)
		{
          home.a=14;
           this.setVisible(false);
		   new Buy(this,home);
		}
		if(e.getSource()==b6)
		{
           home.a=15;
           this.setVisible(false);
		   new Buy(this,home);
		}
		if(e.getSource()==b7)
		{
           home.a=16;
           this.setVisible(false);
		   new Buy(this,home);
		}
	}
		
}