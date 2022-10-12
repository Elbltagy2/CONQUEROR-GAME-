package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;

public class Idle extends JFrame {
	JPanel idleArmiesJPanel;
public Idle() {
	setBackground(new Color(0, 0, 51));
	getContentPane().setBackground(new Color(0, 0, 51));
	this.setBounds(50, 70, 525, 485);
	this.setVisible(true);
	getContentPane().setLayout(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	idleArmiesJPanel=new JPanel();
//	idleArmiesJPanel.setBounds(20,10, 505, 475);
//	idleArmiesJPanel.setLayout(new FlowLayout());
//	
//	JButton marchingDataButton = new JButton();
//	marchingDataButton.setBounds(5, 5, 5, 3);
//	marchingDataButton.setText("Marching Info");
//	idleArmiesJPanel.add(marchingDataButton);
//	JButton seigingDataButton = new JButton();
//	seigingDataButton.setBounds(0, 0, 505, 90);
//	seigingDataButton.setText("Seiging Info");
//	idleArmiesJPanel.add(seigingDataButton);
	JTable xJTable=new JTable();
	xJTable.setBounds(50, 50, 200, 200);
	getContentPane().add(idleArmiesJPanel);
	repaint();
	revalidate();
}
public static void main(String[] args) {
	new Idle();
}
}
