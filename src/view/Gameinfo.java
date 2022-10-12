package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Gameinfo extends JPanel{
	JLabel l1=new JLabel("label 1");
	JLabel l2=new JLabel("label 2");
	JLabel l3 =new JLabel("label 3");
	JButton b2=new JButton("World Map");
	
	public Gameinfo() {
		l1.setForeground(new Color(204, 0, 0));
		l1.setFont(new Font("Segoe Print", Font.BOLD, 16));
		l1.setBounds(303, 14, 183, 50);
		l2.setForeground(new Color(51, 204, 153));
		l2.setFont(new Font("Segoe Print", Font.BOLD, 16));
		l2.setBounds(548, 14, 166, 50);
		l3.setForeground(new Color(0, 204, 0));
		l3.setFont(new Font("Segoe Print", Font.BOLD, 12));
		l3.setBounds(776, 16, 271, 50);
		b2.setForeground(new Color(0, 0, 204));
		b2.setHorizontalTextPosition(SwingConstants.LEFT);
		b2.setIcon(new ImageIcon("Icons/icons8-world-62.png"));
		b2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		b2.setBackground(new Color(204, 153, 255));
		b2.setBorder(null);
		b2.setBounds(1073,11, 211, 53);
		setLayout(null);
		add(l1);
		add(l2);
		add(l3);
		add(b2);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 1362, 85);
		
	}
	public JLabel getL1() {
		return l1;
	}
	public JLabel getL2() {
		return l2;
	}
	public JLabel getL3() {
		return l3;
	}
	public JButton getB2() {
		return b2;
	}
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame xFrame=new JFrame();
		xFrame.getContentPane().add(new Gameinfo());
		xFrame.setSize(screenSize.width,screenSize.height);
		xFrame.setVisible(false);
	}

}
