package view;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class marching extends JFrame {
 public marching() {
 	getContentPane().setBackground(new Color(0, 0, 51));
	 JTable xJTable=new JTable();
	 xJTable.setForeground(new Color(255, 0, 0));
	 xJTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
	 xJTable.setBackground(new Color(0, 0, 51));
	 getContentPane().setLayout(null);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 xJTable.setBounds(50, 50,200,200);
	 getContentPane().add(xJTable);
	 setVisible(true);
	 setSize(500,500);
	 revalidate();
	 repaint();
	 
 }
 public static void main(String[] args) {
	new marching();
}
}
