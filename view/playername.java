package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.FileInputStream;
import java.net.URL;

import engine.Game;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class playername  extends JPanel implements ActionListener{
private JButton z;
public JButton getZ1() {
	return z;
}
public JTextField getX1() {
	return x;
}

public JComboBox geteBox() {
	return eBox;
}
private JTextField x;
private JComboBox eBox;
	public playername() {
		setBackground(new Color(0, 0, 51));
		z=new JButton("Enter");
		z.setFont(new Font("Segoe Print", Font.BOLD, 26));
		z.setHorizontalTextPosition(SwingConstants.LEFT);
		z.setIcon(new ImageIcon("Icons/icons8-enter-48.png"));
		z.setBounds(286,263, 183, 64);
		z.setBorderPainted(false);
		z.setBackground(new Color(255, 153, 102));
		x=new JTextField();
		x.setBackground(new Color(255, 204, 255));
		JLabel y=new JLabel("Player Name: ");
		y.setForeground(new Color(255, 102, 255));
		y.setBackground(new Color(255, 102, 255));
		y.setFont(new Font("Segoe Print", Font.BOLD, 24));
		JLabel y1=new JLabel("Player City:");
		y1.setForeground(new Color(255, 102, 0));
		y1.setFont(new Font("Segoe Print", Font.BOLD, 23));
		eBox=new JComboBox();
		eBox.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		eBox.setForeground(new Color(204, 0, 0));
		eBox.setBackground(new Color(102, 204, 255));
		eBox.setBorder(null);
		y1.setBounds(80, 178, 159, 40);
		eBox.setBounds(233, 179, 200, 40);
		y.setBounds(10,61,229, 64);
		x.setBounds(183,66,397,64);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		this.setVisible(true);
		eBox.addItem("Cairo");
		eBox.addItem("Rome");
		eBox.addItem("Sparta");
		setSize(800,700);
		add(x);
		add(y);
		add(y1);
		add(eBox);
		add(z);
		revalidate();
		repaint();
	}
	public static void main(String[] args) {
		
	JFrame x=new JFrame();
	
	x.getContentPane().add(new playername());
	x.setVisible(true);
	x.setSize(500,500);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
