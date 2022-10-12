package view;

import java.awt.BorderLayout;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorldVeiw extends JPanel {
	private JButton city1;
	private JButton city2;
	private JButton city3;
	private JButton idle;
	private JButton marching;
	private JButton seiging;
public JButton getCity1() {
		return city1;
	}
	public JButton getCity2() {
		return city2;
	}
	public JButton getCity3() {
		return city3;
	}
	public JButton getIdle() {
		return idle;
	}
	public JButton getMarching() {
		return marching;
	}
	public JButton getSeiging() {
		return seiging;
	}
public WorldVeiw () {
	setAlignmentY(Component.TOP_ALIGNMENT);
	setAlignmentX(Component.LEFT_ALIGNMENT);
	setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	setBackground(new Color(0, 0, 51));
	//this.setBounds(50, 70, 800, 490);
	this.setVisible(true);
	setLayout(null);
	//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 city1 =new JButton();
	 city1.setHorizontalTextPosition(SwingConstants.LEFT);
	 city1.setIconTextGap(1);
	 city1.setIcon(new ImageIcon("Icons/icons8-egypt-100.png"));
	 city1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
	 city1.setBackground(new Color(0, 153, 255));
	 city1.setBorderPainted(false);
	 city2 =new JButton();
	 city2.setHorizontalTextPosition(SwingConstants.LEFT);
	 city2.setIcon(new ImageIcon("Icons/icons8-rome-64.png"));
	 city2.setBackground(new Color(204, 102, 0));
	 city2.setBorderPainted(false);
	 city2.setFont(new Font("Segoe Print", Font.PLAIN, 30));
	 city3 =new JButton();
	 city3.setFont(new Font("Segoe Print", Font.PLAIN, 30));
	 city3.setHorizontalTextPosition(SwingConstants.LEFT);
	 city3.setIcon(new ImageIcon("Icons/icons8-sparta-60.png"));
	 city3.setBackground(new Color(153, 204, 0));
	 city3.setBorderPainted(false);
	//JButton city4 =new JButton();
	city1.setText("Cairo");
	city1.setBounds(50, 100, 213, 80);
	city1.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
	this.add(city1);
	city2.setText("Rome");
	city2.setBounds(310, 100, 218, 80);
	this.add(city2);
	city3.setText("Sparta");
	city3.setBounds(570, 100, 218, 80);
	this.add(city3);
	JLabel jLabel = new JLabel();
	jLabel.setIcon(new ImageIcon("Icons/icons8-world-62.png"));
	jLabel.setForeground(new Color(0, 153, 204));
	jLabel.setHorizontalAlignment(SwingConstants.CENTER);
	jLabel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
	//Font f = new Font();
	jLabel.setText("World Cities");  //to get a larger size font
	//jLabel.setFont(12);
	jLabel.setBounds(183, 0, 416, 100);
	this.add(jLabel);
	
	JLabel jLabel2 = new JLabel();
	jLabel2.setForeground(new Color(51, 204, 0));
	jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	jLabel2.setFont(new Font("Segoe Print", Font.PLAIN, 40));
	jLabel2.setText(" My Armies");  //to get a larger size font
	jLabel2.setBounds(200, 160, 400, 100);
	this.add(jLabel2);
	
	
	 idle =new JButton();
	 idle.setFont(new Font("Segoe Print", Font.PLAIN, 22));
	 idle.setHorizontalTextPosition(SwingConstants.LEFT);
	 idle.setIcon(new ImageIcon("Icons/icons8-armies-51.png"));
	 idle.setBackground(new Color(189, 183, 107));
	 idle.setBorderPainted(false);
	 marching =new JButton();
	 marching.setBackground(new Color(255, 153, 102));
	 marching.setFont(new Font("Segoe Print", Font.BOLD, 17));
	 marching.setHorizontalTextPosition(SwingConstants.LEFT);
	 marching.setIcon(new ImageIcon("Icons/icons8-three-soldiers-marching-48.png"));
	 marching.setBorder(null);
	 seiging =new JButton();
	 seiging.setFont(new Font("Segoe Print", Font.PLAIN, 26));
	 seiging.setBackground(new Color(255, 102, 204));
	 seiging.setBorder(null);
	//JButton city4 =new JButton();
	idle.setText("Idle Armies");
	idle.setBounds(50, 260, 213, 80);
	this.add(idle);
	marching.setText("Marching Armies");
	marching.setBounds(310, 260, 218, 80);
	this.add(marching);
	seiging.setText("Seiging Armies");
	seiging.setBounds(570, 260, 218, 80);
	this.add(seiging);
//	JTextArea jTextArea = new JTextArea();
//	jTextArea.setBounds(50, 360, 520, 280);
//	jTextArea.setText("Army info");
//	this.add(jTextArea);
//	JButton marchingDataButton = new JButton();
//	marchingDataButton.setBounds(590, 380, 130, 60);
//	marchingDataButton.setText("Marching Info");
//	this.add(marchingDataButton);
	//JButton playerInfo = new JButton();
	//playerInfo.setBounds(620, 370, 130, 60);
	//playerInfo.setText("Player Info");
	//this.add(playerInfo);
	revalidate();
	repaint();
	
}
public static void main(String[] args) {
	JPanel info=new JPanel();
	JLabel l1=new JLabel("label 1");
	JLabel l2=new JLabel("label 2");
	JLabel l3 =new JLabel("label 3");
	JButton b1=new JButton("endturn");
	JButton b2=new JButton("World Map");
	
	l1.setBounds(30, 5, 130, 80);
	l2.setBounds(330, 5, 130, 80);
	l3.setBounds(550, 5, 200, 80);
	
	b2.setBounds(650,5, 100, 30);
	
	
	info.setLayout(null);
	info.add(l1);
	info.add(l2);
	info.add(l3);
	l1.setBackground(Color.blue);
	//info.add(b1);
	info.add(b2);
	//info.add(l1);
	JPanel warningJPanel =new JPanel();
	warningJPanel.setLayout(null);
	warningJPanel.add(b1);
	warningJPanel.setBackground(Color.red);
	warningJPanel.setBounds(0,675,1000,75);
	JFrame xFrame=new JFrame();
	info.setBounds(0, 0, 1000, 75);
	info.setBackground(Color.black);
	WorldVeiw worldVeiw=new WorldVeiw();

	worldVeiw.setBounds(0,75,1000,600);
	worldVeiw.setBackground(Color.BLUE);
	xFrame.getContentPane().setLayout(null);
	xFrame.getContentPane().add(info);
	xFrame.setSize(800, 600);
	xFrame.getContentPane().add(worldVeiw);
	xFrame.getContentPane().add(warningJPanel);
	xFrame.setVisible(true);
	xFrame.revalidate();
	xFrame.repaint();
}
}
