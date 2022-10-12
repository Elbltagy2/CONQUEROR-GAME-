package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Notifications extends JPanel{
	JButton b1;
	 JLabel l4;
	
	 public Notifications() {
	 	setBackground(new Color(0, 0, 51));
		 b1=new JButton("endturn");
		 b1.setFont(new Font("Segoe Print", Font.BOLD, 17));
		 b1.setHorizontalTextPosition(SwingConstants.LEFT);
		 b1.setIcon(new ImageIcon("Icons\\icons8-end-48.png"));
		 b1.setBorderPainted(false);
		 b1.setBackground(new Color(204, 153, 255));
		 b1.setBounds(659,0, 156, 68);
		 l4=new JLabel();
		 l4.setBounds(10, 5, 400, 50);
		 setLayout(null);
		add(l4);
		add(b1);
	}
	 public JButton getB1() {
		return b1;
	}
	public JLabel getL4() {
		return l4;
	}
	public static void main(String[] args) {
		 JFrame xFrame=new JFrame();
			xFrame.getContentPane().add(new Notifications());
			xFrame.setSize(1000,15000);
			xFrame.setVisible(true);
	}

}
