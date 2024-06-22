package JavaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class Guesthome extends JFrame implements ActionListener
{

	private JLabel l2,l3,l4,l5,l6,l7,l8,l9,l10;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
	private JPanel p1,p2;
	

	
	public Guesthome()
	{
		super(" Gadget shop ");
		
		this.setSize(900,680);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		p1 = new JPanel();
		p1.setBounds(0,0,900,680);
		this.setLocationRelativeTo(null);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		p1.setLayout(null);
		
		p2 = new JPanel();
	    p2.setBounds(0, 0, 900, 130);
	    this.setLocationRelativeTo(null);
	    p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
	    p2.setLayout(null);
			
		l2 = new JLabel("Welcome to our Gadget Home Shop");
		l2.setBounds(140,8,600,50);
		l2.setFont(new Font("Segoe UI",Font.BOLD,36));
		p2.add(l2);
	
		l3 = new JLabel("All exclusive collection available in our store");
		l3.setBounds(142,55,520,30);
		l3.setFont(new Font("Segoe UI",Font.PLAIN,20));
		p2.add(l3);
		
		l4 = new JLabel("GAMING CONSOLES");
		l4.setBounds(100,320,200,15);
		l4.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l4);
		
		l5 = new JLabel("CAMERAS");
		l5.setBounds(400,315,200,15);
		l5.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l5);
		
		l6 = new JLabel("GADGETS");
		l6.setBounds(115,540,150,15);
		l6.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l6);
		
		l7 = new JLabel("SMART WATCHES");
		l7.setBounds(380,540,130,15);
		l7.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l7);
		
		l8 = new JLabel("SMART PHONES");
		l8.setBounds(695,318,130,15);
		l8.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l8);
		
		l9 = new JLabel("SECURITY DEVICES");
		l9.setBounds(655,540,150,15);
		l9.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l9);	

		b1 = new JButton("Create an Account!");
		b1.setFont(new Font("Segoe UI",Font.BOLD,14));
		b1.setBounds(725,7,200,30);
		b1.addActionListener(this);
		b1.setForeground(Color.RED);
		b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);
	    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(b1);		
		
	    ImageIcon icon11 = new ImageIcon("JavaGUI/Resources/back.png");
		b2 = new JButton(icon11);
		b2.setBounds(15,595,35,35);
	    b2.addActionListener(this);
	    b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b2.setContentAreaFilled(false);
	    b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b2);
		
		
		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/paper.jpg");
		b4 = new JButton(icon3);
		b4.setBounds(40,145,230,170);
	    b4.addActionListener(this);
	    b4.setFocusable(false);
	    b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b4);
		
		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/colour.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(335,140,230,170);
	    b5.addActionListener(this);
	    b5.setFocusable(false);
	    b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b5);
	
		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/pencil.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(40,365,230,170);
	    b6.addActionListener(this);
	    b6.setFocusable(false);
	    b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b6);
		
		ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/canvas.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(340,360,230,170);
	    b7.addActionListener(this);
	    b7.setFocusable(false);
	    b7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b7);
		
		ImageIcon icon8 = new ImageIcon("JavaGUI/Resources/painting.jpg");
		b8 = new JButton(icon8);
		b8.setBounds(620,145,230,170);
	    b8.addActionListener(this);
	    b8.setFocusable(false);
	    b8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b8);
		
		ImageIcon icon9 = new ImageIcon("JavaGUI/Resources/tool.jpg");
		b9 = new JButton(icon9);
		b9.setBounds(620,365,230,170);
	    b9.addActionListener(this);
	    b9.setFocusable(false);
	    b9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b9);
	
		
		ImageIcon ic2 = new ImageIcon("JavaGUI/Resources/cn1.jpg");
		JLabel l12 = new JLabel(ic2);
	    l12.setBounds(8,4,130,95);
        p2.add(l12);

		p1.add(p2);
		this.add(p1);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
	    if(e.getSource()==b1)
		{
			this.setVisible(false);
			
			new SignUp();
		}	
		else if(e.getSource()==b2)
		{
			this.setVisible(false);
			new Account();
			
		}
		else if(e.getSource()==b4)
		{
			this.setVisible(false);
			new GGamingConsole();
		}
		else if(e.getSource()==b5)
		{
			this.setVisible(false);
			new GCamera();
		}
		else if(e.getSource()==b6)
		{
			this.setVisible(false);
			new GGadget();
		}
		else if(e.getSource()==b7)
		{
			this.setVisible(false);
			new GSmartWatch();
		}
		else if(e.getSource()==b8)
		{
			this.setVisible(false);
			new GSmartPhone();
		}
		else if(e.getSource()==b9)
		{
			this.setVisible(false);
			new GSecurityDevice();
		}
		
	}
		
}
	