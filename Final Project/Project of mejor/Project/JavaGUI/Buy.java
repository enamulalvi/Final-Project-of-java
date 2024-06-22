package JavaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Buy extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b4,b5,b6,b7;
	JComboBox cb1;
	JPanel p1,p2,p3,p4,p5,p6;
	
	CardLayout cd;
	Home home;

	GamingConsoles ap; 
	Camera colour; 
	Gadget pencil; 
	SmartWatch canvas; 
	SmartPhone painting; 
	SecurityDevice tool; 
	
	
	int b=0;
	int c=0;
	String name="";
	
    public Buy(SmartWatch canvas,Home home){

		super(" Buy ");
		this.canvas = canvas;
		this.home = home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
        ImageIcon icon1 = new ImageIcon("JavaGUI/Resources/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				canvas.setVisible(true);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("JavaGUI/Resources/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/can1.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,250,200);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/can2.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,250,200);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/can3.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,250,200);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/can4.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,250,200);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"1");
		cd.addLayoutComponent(p4,"2");
		cd.addLayoutComponent(p5,"3");
		cd.addLayoutComponent(p6,"4");

		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,400,40);
		l2.setFont(new Font("Serif", Font.BOLD, 26));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a == b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	public Buy(Gadget pencil,Home home){

		super(" Buy ");
		this.pencil = pencil;
		this.home = home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
        ImageIcon icon1 = new ImageIcon("JavaGUI/Resources/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				pencil.setVisible(true);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("JavaGUI/Resources/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/pen1.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,250,200);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/pen2.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,250,200);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/pen3.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,250,200);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/pen4.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,250,200);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"5");
		cd.addLayoutComponent(p4,"6");
		cd.addLayoutComponent(p5,"7");
		cd.addLayoutComponent(p6,"8");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,400,40);
		l2.setFont(new Font("Serif", Font.BOLD, 26));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a == b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	 public Buy(SmartPhone painting,Home home)
	{
		super(" Buy ");
		this.painting = painting;
		this.home = home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
        ImageIcon icon1 = new ImageIcon("JavaGUI/Resources/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				painting.setVisible(true);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("JavaGUI/Resources/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/pain1.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,250,200);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/pain2.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,250,200);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/pain3.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,250,200);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/pain4.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,250,200);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"9");
		cd.addLayoutComponent(p4,"10");
		cd.addLayoutComponent(p5,"11");
		cd.addLayoutComponent(p6,"12");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,400,40);
		l2.setFont(new Font("Serif", Font.BOLD, 26));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	public Buy(SecurityDevice tool,Home home)
	{
		super(" Buy ");
		this.tool = tool;
		this.home = home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
        ImageIcon icon1 = new ImageIcon("JavaGUI/Resources/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				tool.setVisible(true);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("JavaGUI/Resources/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/t1.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,250,200);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/t2.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,250,200);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/t3.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,250,200);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/t4.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,250,200);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"13");
		cd.addLayoutComponent(p4,"14");
		cd.addLayoutComponent(p5,"15");
		cd.addLayoutComponent(p6,"16");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,400,40);
		l2.setFont(new Font("Serif", Font.BOLD, 26));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	public Buy(Camera colour,Home home)
	{
		super(" Buy ");
		this.colour = colour;
		this.home=home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
        ImageIcon icon1 = new ImageIcon("JavaGUI/Resources/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				colour.setVisible(true);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("JavaGUI/Resources/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/col1.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,250,200);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/col2.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,250,200);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/col3.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,250,200);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/col4.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,250,200);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"21");
		cd.addLayoutComponent(p4,"22");
		cd.addLayoutComponent(p5,"23");
		cd.addLayoutComponent(p6,"24");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,400,40);
		l2.setFont(new Font("Serif", Font.BOLD, 26));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	public Buy(GamingConsoles ap,Home home)
	{
		super(" Buy ");
		this.ap = ap;
		this.home = home;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		setVisible(true);

		p1 = new JPanel();
		p1.setBounds(0,0,800,600);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		this.setLocationRelativeTo(null);
		p1.setLayout(null);
		
		cd = new CardLayout();
		
		p2 = new JPanel();
		p2.setBounds(30,100,300,250);
		p2.setBackground(Color.WHITE);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setLayout(cd);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(30,100,300,250);
		p3.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p3.setLayout(null);
		p2.add(p3);
		
		p4 = new JPanel();
		p4.setBounds(30,100,300,250);
		p4.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p4.setLayout(null);
		p2.add(p4);
		
		p5 = new JPanel();
		p5.setBounds(30,100,300,250);
		p5.setBackground(Color.WHITE);
		//p3.setBackground(Color.decode("#99eaff"));
		p5.setLayout(null);
		p2.add(p5);
		
		
		p6 = new JPanel();
		p6.setBounds(30,100,300,250);
		p6.setBackground(Color.WHITE);
		//p6.setBackground(Color.decode("#99eaff"));
		p6.setLayout(null);
		p2.add(p6);
		
        ImageIcon icon1 = new ImageIcon("JavaGUI/Resources/back.png");
		b1 = new JButton(icon1);
		b1.setBounds(18,25,35,35);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent av)
			{
				setVisible(false);
				ap.setVisible(true);
			}
		});
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);	
		p1.add(b1);
		
		//ImageIcon icon2 = new ImageIcon("JavaGUI/Resources/buy-now-button.png");
		b2 = new JButton("Buy Now");
		b2.setBounds(520,450,150,35);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
        b2.setFocusPainted(false);
		p1.add(b2);
		
		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/ap1.jpg");
		b4 = new JButton(icon3);
        b4.setBounds(20,30,250,200);
	    //b4.addActionListener(this);
	    p3.add(b4);
		
		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/ap2.jpg");
		b5 = new JButton(icon4);
		b5.setBounds(20,30,250,200);
	    p4.add(b5);
	
		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/ap3.jpg");
		b6 = new JButton(icon6);
		b6.setBounds(20,30,250,200);
	    p5.add(b6);
		
		ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/ap4.jpg");
		b7 = new JButton(icon7);
		b7.setBounds(20,30,250,200);
	    p6.add(b7);
		
		cd.addLayoutComponent(p3,"17");
		cd.addLayoutComponent(p4,"18");
		cd.addLayoutComponent(p5,"19");
		cd.addLayoutComponent(p6,"20");
		
	
		
		
				for(int i=0; i<home.info.length; i++)
				{
					
					if(home.info[i]!=null)
					{
						 String sp[] = home.info[i].split("/");
						 b = Integer.parseInt(sp[1]);
						 if(home.a==b)
						 {
						 name=sp[0];
						 c = Integer.parseInt(sp[2]);
						break;
						 }
					}
					
				}
		
		
		String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        cb1 = new JComboBox(quantity);
        cb1.setBounds(500, 241, 75, 26);
		cb1.addActionListener(this);
		p1.add(cb1);
		
        l1 = new JLabel("Quantity");
        l1.setBounds(420, 230, 240, 40);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l1);
		
		
		l2= new JLabel();
		l2.setBounds(380,170,400,40);
		l2.setFont(new Font("Serif", Font.BOLD,26));
		p1.add(l2);
		
		l3= new JLabel();
		l3.setBounds(80,380,150,30);
		l3.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l3);
		
		l4= new JLabel();
		l4.setBounds(80,430,220,30);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		p1.add(l4);

		if(home.a==b)
		{
			l2.setText(name);
			l3.setText("Quantity : "+cb1.getSelectedItem().toString());
			l4.setText("Price : "+c+" TK");
			cd.show(p2,String.valueOf(home.a));
			
		}
		
		
		this.add(p1);
        
	}
	
	
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==cb1){

		     int count = Integer.parseInt(cb1.getSelectedItem().toString());
			 int price = c*count;
		     l4.setText("Price : "+price+" TK");
			 l3.setText("Quantity : "+cb1.getSelectedItem().toString());
		}
		
		if(e.getSource() == b2){

			this.setVisible(false);
			new Payment(this);
		}
		
	}
	
}
