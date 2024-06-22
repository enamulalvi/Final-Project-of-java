package JavaGUI;

import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.table.*;

public class UpdateProducts extends JFrame implements ActionListener{

	public JPanel panel;
	public JButton button1,button2, backButton, signoutButton;
	public JLabel l1,l2,l3,l4;
	public JTextField text1,text2;
	public JTable table;
	public DefaultTableModel model;
	Admin admin;
	Login login;
	int row =0;
	String productsName = "";

	public UpdateProducts(Admin admin, Login login){

		super("Update Products");
		this.admin = admin;
		this.login = login;
		initializeForm();
		createTable();
		
		this.setVisible(true);
	}

	public void initializeForm(){

		this.setSize(800,650);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //this.setUndecorated(true);
	    this.setResizable(false);
	    this.setLayout(null);
		this.setLocationRelativeTo(null);
		
	    panel = new JPanel();
	    panel.setBounds(0,0,800,650);
	    panel.setBackground(Color.WHITE);
	    panel.setLayout(null);

	    l1 = new JLabel("Update Products Information");
	    l1.setFont(new Font("Segoe UI",Font.BOLD,30));
	    l1.setBounds(70,15,450,32);
	    l1.setForeground(Color.BLACK);

	    ImageIcon icon1 = new ImageIcon("JavaGUI/Resources/back.png");
		backButton = new JButton(icon1);
		backButton.setBounds(13,15,35,35);
		backButton.setForeground(Color.BLACK);
		backButton.setFocusPainted(false);
	    backButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    backButton.setContentAreaFilled(false);
	    backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.addActionListener(this);

		signoutButton = new JButton("Sign out");
	 	signoutButton.setFont(new Font("Segoe UI",Font.BOLD,20));
	    signoutButton.setForeground(Color.RED);
		signoutButton.setFocusPainted(false);
	    signoutButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    signoutButton.setContentAreaFilled(false);
	    signoutButton.setBorder(null);
		signoutButton.setBounds(670,30,80,28);
		signoutButton.setFocusable(false);
		signoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	 	signoutButton.addActionListener(this);

	 	l2 = new JLabel("Update Products : ");
	 	l2.setFont(new Font("Segoe UI",Font.BOLD,20));
	 	l2.setBounds(50,100,185,25);
	 	l2.setForeground(Color.BLACK);

	 	text1 = new JTextField();
		text1.setFont(new Font("Segoe UI",Font.BOLD,15));
		text1.setBounds(245,100,200,30);
		text1.setForeground(Color.BLACK);
		text1.setHorizontalAlignment(JTextField.CENTER);

		button1 = new JButton("Update");
	 	button1.setFont(new Font("Segoe UI",Font.BOLD,15));
	 	button1.setBounds(550,100,90,30);
	 	button1.setForeground(Color.BLACK);
	 	button1.setFocusable(false);
	 	button1.addActionListener(this);
	 
	 	l3 = new JLabel("Update Price : ");
	 	l3.setFont(new Font("Segoe UI",Font.BOLD,20));
	 	l3.setBounds(50,160,185,25);
	 	l3.setForeground(Color.BLACK);

	 	text2 = new JTextField();
	 	text2.setFont(new Font("Segoe UI",Font.BOLD,15));
	 	text2.setBounds(245,160,200,30);
	 	text2.setForeground(Color.BLACK);
	  	text2.setHorizontalAlignment(JTextField.CENTER);
	 
	 	button2 = new JButton("Clear");
	 	button2.setFont(new Font("Segoe UI",Font.BOLD,15));
	 	button2.setBounds(550,160,80,30);
	 	button2.setForeground(Color.BLACK);
	 	button2.setFocusable(false);
	 	button2.addActionListener(this);

	 	l4 = new JLabel("Products History");
	 	l4.setFont(new Font("Segoe UI",Font.BOLD,25));
	 	l4.setBounds(40,270,300,30);
	 	l4.setForeground(Color.BLACK);
	 
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(text1);
		panel.add(text2);
		panel.add(button1);
		panel.add(button2);
		panel.add(backButton);
		panel.add(signoutButton);
		this.add(panel);
		
	}

	public void createTable(){

		model = new DefaultTableModel();
		model.addColumn("Product's Name");
		model.addColumn("Product's Price(Tk)");
		
		table = new JTable(model);
		table.setFont(new Font("Segoe UI",Font.BOLD,15));
		table.setBackground(new Color(174,247,255));
		table.setRowHeight(30);
		table.setSelectionBackground(new Color(255, 153, 51));
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,20));
		table.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent me){

				try{
					row = table.getSelectedRow();
					productsName = table.getModel().getValueAt(row,0).toString();
					String productPrice = table.getModel().getValueAt(row,1).toString();
					text1.setText(productsName);
					text2.setText(productPrice);
				}
				catch(Exception exp){}	
			}
		});

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(40,328,420,240);
		try{

			Scanner sc = new Scanner(new File("All Text Files/ProductInfo.txt"));
			
			while(sc.hasNextLine()){

				String sp[] = sc.nextLine().split("/");
				model.addRow(new Object[]{
					sp[0],
					sp[2]
				});
					
			}
			sc.close();
		}
		catch(Exception ex){}
		
		panel.add(scroll);
	}

	public void actionPerformed(ActionEvent e){

		if(e.getSource() == button1){

			if(table.getSelectedRow() != -1){

				if(!text1.getText().equals("") && !text2.getText().equals("")){

					int option = JOptionPane.showConfirmDialog(this,"Are you Sure to Confirm Update??");
					if(option == JOptionPane.YES_OPTION){
						model.setValueAt(text1.getText(),row,0);
			            model.setValueAt(text2.getText(),row,1);
						
						boolean flag = false;
						String productName = "";
						String productPrice ="";
						String productSerial ="";
						try{

							File newfile = new File("All Text Files/TempProductInfo.txt");
							File oldfile = new File("All Text Files/ProductInfo.txt");
							FileWriter fw = new FileWriter(newfile,true);
							try{

							    Scanner sc = new Scanner(oldfile);
							
                    			while(sc.hasNextLine()){

						        	String sp[] = sc.nextLine().split("/");
									if(sp[0].equals(productsName)){

										productName = text1.getText();
										productSerial = sp[1];
										productPrice = text2.getText();
										flag = true;
							
									}
									else{

										fw.write(sp[0]+"/"+sp[1]+"/"+sp[2]+"\n");
							
									}
				     			}
					 			sc.close();
				   			}
				   			catch(IOException ioe){}
				   			if(flag){

					   			fw.write(productName+"/"+productSerial+"/"+productPrice+"\n");
					   			fw.close();
				   			}
				   			oldfile.delete();
				   			File dump = new File("All Text Files/ProductInfo.txt");
				   			newfile.renameTo(dump);
						}
						catch(IOException ioe){}
				   		JOptionPane.showMessageDialog(this,"Update Successfull");
					}
				}
				else if(text1.getText().equals("") && !text2.getText().equals("")){

					JOptionPane.showMessageDialog(this,"Please Fill up the Product Name","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(!text1.getText().equals("") && text2.getText().equals("")){

					JOptionPane.showMessageDialog(this,"Please Fill up the Product Price","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(text1.getText().equals("") && text2.getText().equals("")){

					JOptionPane.showMessageDialog(this,"Please Fill up the Product Name and Price","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{

				if(!text1.getText().equals("") && !text2.getText().equals("")){

					int rowCount = table.getRowCount();
					int columnCount = table.getColumnCount();
					int searchRow = -1;
					int searchColumn = -1;
					boolean flag1 = false;
					int option = JOptionPane.showConfirmDialog(this,"Are you Sure to Confirm Update??");
					if(option==JOptionPane.YES_OPTION){
						for(int i=0; i<rowCount; i++){
							for(int j=0; j<columnCount; j++){

								Object cellValue = table.getModel().getValueAt(i,j);
								if(cellValue!=null && cellValue.toString().equals(text1.getText())){

									searchRow = i;
									searchColumn = j;
									flag1 = true;
							        boolean flag = false;
							        String productName = "";
							        String productPrice ="";
							        String productSerial ="";
									try{
										File newfile = new File("All Text Files/TempProductInfo.txt");
										File oldfile = new File("All Text Files/ProductInfo.txt");
										FileWriter fw = new FileWriter(newfile,true);
										try{

			         						Scanner sc = new Scanner(oldfile);
			
                    						while(sc.hasNextLine()){

										        String sp[] = sc.nextLine().split("/");
												if(sp[0].equals(text1.getText())){

													productName = text1.getText();
													productSerial = sp[1];
													productPrice = text2.getText();
													flag = true;
							
												}
												else
												{
													fw.write(sp[0]+"/"+sp[1]+"/"+sp[2]+"\n");
													
												}
				     						}
					 						sc.close();
				   						}
				   						catch(IOException ioe){}
										if(flag){

											fw.write(productName+"/"+productSerial+"/"+productPrice+"\n");
											fw.close();
										}
										oldfile.delete();
										File dump = new File("All Text Files/ProductInfo.txt");
										newfile.renameTo(dump);
									}
									catch(IOException ioe){}
									break;		
								}
							}
							if(flag1){

								break;
							}
		
						}
 					}
 					if(searchRow!=-1 && searchColumn!=-1){

						model.setValueAt(text1.getText(),searchRow,searchColumn);
						model.setValueAt(text2.getText(),searchRow,(searchColumn+1));
						JOptionPane.showMessageDialog(this,"Update Successfull");
					}
					else{

						JOptionPane.showMessageDialog(this,"Product not Match");
					}
				}
				else if(text1.getText().equals("") && !text2.getText().equals("")){

					JOptionPane.showMessageDialog(this,"Please Fill up the Product Name","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(!text1.getText().equals("") && text2.getText().equals("")){

					JOptionPane.showMessageDialog(this,"Please Fill up the Product Price","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(text1.getText().equals("") && text2.getText().equals("")){

					JOptionPane.showMessageDialog(this,"Please Fill up the Product Name and Price","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
	    }
	    if(e.getSource() == button2){

			text1.setText("");
			text2.setText("");
			table.clearSelection();
		}
		if(e.getSource() == backButton){

			this.setVisible(false);
			admin.setVisible(true);
		}
		if(e.getSource() == signoutButton){

			this.setVisible(false);
			login.setVisible(true);
		}
	}
}
		
