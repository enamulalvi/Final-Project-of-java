package JavaGUI;

import JavaGUI.*;
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
import java.util.Scanner;
import javax.swing.border.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.net.*;

public class Home extends JFrame implements ActionListener{

	private JLabel welcomeLabel, lineLabel, paperLabel, colorLabel, pencilLabel, 
					canvasLabel, paintingLabel, toolLabel,l10,l11;
	private JButton b1,b2,b3,paperButton, colorButton, pencilButton, canvasButton, paintingButton, toolButton,b10,b11,b12;
	private JPanel p1,p2;
	private Login login_obj;
	public String Email_Address;
	
	public static int a = 0;
	public static String info[];

	public Home(Login login_obj){

		super("Home");
		this.setSize(900,680);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		this.login_obj = login_obj;
		Email_Address = login_obj.get_email();

		p1 = new JPanel();
		p1.setBounds(0,0,900,680);
		this.setLocationRelativeTo(null);
		p1.setBackground(Color.WHITE);
		//p1.setBackground(Color.decode("#99eaff"));
		p1.setLayout(null);
		
		p2 = new JPanel();
	    p2.setBounds(0, 0, 900, 130);
	    this.setLocationRelativeTo(null);
		//p2.setBackground(Color.decode("#99eaff"));
		p2.setBackground(Color.WHITE);
	    p2.setLayout(null);

	    welcomeLabel = new JLabel("Welcome to our Gadget shop");
		welcomeLabel.setBounds(140,8,600,50);
		welcomeLabel.setFont(new Font("Segoe UI",Font.BOLD,36));
		p2.add(welcomeLabel);
	
		lineLabel = new JLabel("All exclusive collection available in our store");
		lineLabel.setBounds(142,55,520,30);
		lineLabel.setFont(new Font("Segoe UI",Font.PLAIN,20));
		p2.add(lineLabel);

		paperLabel = new JLabel("GAMING CONSOLES ");
		paperLabel.setBounds(100,320,200,15);
		paperLabel.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(paperLabel);

		ImageIcon icon3 = new ImageIcon("JavaGUI/Resources/paper.jpg");
		paperButton = new JButton(icon3);
		paperButton.setBounds(40,145,230,170);
	    paperButton.addActionListener(this);
	    paperButton.setFocusable(false);
	    paperButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(paperButton);
		
		colorLabel = new JLabel("CAMERAS");
		colorLabel.setBounds(395,315,200,15);
		colorLabel.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(colorLabel);

		ImageIcon icon4 = new ImageIcon("JavaGUI/Resources/colour.jpg");
		colorButton = new JButton(icon4);
		colorButton.setBounds(335,140,230,170);
	    colorButton.addActionListener(this);
	    colorButton.setFocusable(false);
	    colorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(colorButton);
		
		pencilLabel = new JLabel("GADGETS");
		pencilLabel.setBounds(115,540,150,15);
		pencilLabel.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(pencilLabel);

		ImageIcon icon6 = new ImageIcon("JavaGUI/Resources/pencil.jpg");
		pencilButton = new JButton(icon6);
		pencilButton.setBounds(40,365,230,170);
	    pencilButton.addActionListener(this);
	    pencilButton.setFocusable(false);
	    pencilButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(pencilButton);
		
		canvasLabel = new JLabel("SMART WATCHES");
		canvasLabel.setBounds(395,540,130,15);
		canvasLabel.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(canvasLabel);

		ImageIcon icon7 = new ImageIcon("JavaGUI/Resources/canvas.jpg");
		canvasButton = new JButton(icon7);
		canvasButton.setBounds(340,360,230,170);
	    canvasButton.addActionListener(this);
	    canvasButton.setFocusable(false);
	    canvasButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(canvasButton);
		
		
		paintingLabel = new JLabel("SMART PHONES");
		paintingLabel.setBounds(695,318,130,15);
		paintingLabel.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(paintingLabel);

		ImageIcon icon8 = new ImageIcon("JavaGUI/Resources/painting.jpg");
		paintingButton = new JButton(icon8);
		paintingButton.setBounds(620,145,230,170);
	    paintingButton.addActionListener(this);
	    paintingButton.setFocusable(false);
	    paintingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(paintingButton);
		
		toolLabel = new JLabel("SECURITY DEVICES");
		toolLabel.setBounds(680,540,150,15);
		toolLabel.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(toolLabel);

		ImageIcon icon9 = new ImageIcon("JavaGUI/Resources/tool.jpg");
		toolButton = new JButton(icon9);
		toolButton.setBounds(620,365,230,170);
	    toolButton.addActionListener(this);
	    toolButton.setFocusable(false);
	    toolButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(toolButton);		
		
	    ImageIcon icon11 = new ImageIcon("JavaGUI/Resources/logout.png");
		b2 = new JButton(icon11);
		b2.setBounds(840,20,30,30);
	    b2.addActionListener(this);
	    b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b2.setContentAreaFilled(false);
	    b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(b2);
		
	

	   info = new String [100000];
	   try{

			Scanner sc = new Scanner(new File("All Text Files/ProductInfo.txt"));
			
			while(sc.hasNextLine()){

				String stp = sc.nextLine();
				for(int i=0; i<info.length; i++){

					if(info[i] == null){

						info[i] = stp;
						break;
					}
					
				}
			}
			sc.close();
		}
		catch(Exception ex){}


		ImageIcon ic2 = new ImageIcon("JavaGUI/Resources/cn1.jpg");
		JLabel l12 = new JLabel(ic2);
	    l12.setBounds(8,4,130,95);
        p2.add(l12);
		
		p1.add(p2);
		this.add(p1);
       setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
	
		if(e.getSource()==b2){
			
			this.setVisible(false);
			login_obj.setVisible(true);
		}
		else if(e.getSource() == paperButton){

			this.setVisible(false);
			new GamingConsoles(this,login_obj);
		}
		else if(e.getSource() == colorButton)
		{
			this.setVisible(false);
			new Camera(this,login_obj);
		}
		else if(e.getSource() == pencilButton)
		{
			this.setVisible(false);
			new Gadget(this,login_obj);
		}
		else if(e.getSource() == canvasButton)
		{
			this.setVisible(false);
			new SmartWatch(this,login_obj);
		}
		else if(e.getSource() == paintingButton)
		{
			this.setVisible(false);
			new SmartPhone(this,login_obj);
		}
		else if(e.getSource() == toolButton)
		{
			this.setVisible(false);
			new SecurityDevice(this,login_obj);
		}
	}
}
		