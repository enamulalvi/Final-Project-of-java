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

public class Start extends JFrame implements ActionListener {
    private Font fontstyle1;
    private Font fontstyle2;
    private JButton startButton;
    private JFrame frame;
    
    public Start() {
        
        frame = new JFrame("Simulating Online Shopping Management System ");
        frame.setLayout(null);
        frame.setSize(800, 533);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        fontstyle1 = new Font("Chesna Grotesk", Font.BOLD, 24);
        fontstyle2 = new Font("Chesna Grotesk", Font.BOLD, 18);

        JLabel BackgroundImage_label;
        ImageIcon img = new ImageIcon("JavaGUI/Resources/cn.png");
        BackgroundImage_label = new JLabel("",img,JLabel.CENTER);
        BackgroundImage_label.setBounds(0,0,800,530);
    
        startButton = new JButton("Get Started");
        startButton.setBounds(640, 430, 100, 30);
		startButton.setFocusable(false);
        frame.add(startButton);
        startButton.addActionListener(this);

        frame.add(BackgroundImage_label);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == startButton) {
            frame.setVisible(false);
            new Account();
        }
    }
}
