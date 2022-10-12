package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class BattleView extends JPanel{
	public JButton getB() {
		return b;
	}
	private JButton x;
	private JButton x1;
	private JButton x2;
	private JButton b;
	private JButton a;
	
	private JTextArea txtCart ;
	private JTextArea txtCart2 ;
	private JTextArea txtCart3;
	JComboBox vBox;
	public JComboBox getvBox() {
		return vBox;
	}
	public JButton getXz() {
		return x;
	}
	public JButton getX1() {
		return x1;
	}
	public JButton getX2() {
		return x2;
	}
	public JButton getA() {
		return a;
	}
	public JTextArea getTxtCart() {
		return txtCart;
	}
	public JTextArea getTxtCart2() {
		return txtCart2;
	}
	public JTextArea getTxtCart3() {
		return txtCart3;
	}
	public BattleView() {
		setBackground(new Color(0, 0, 51));
		x=new JButton();
		x.setBounds(200, 100, 100, 50);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(900, 500);
		this.setVisible(true);
		x1=new JButton("Player's Army");
		x1.setFont(new Font("Segoe Print", Font.BOLD, 16));
		x1.setBorder(null);
		x1.setForeground(Color.BLUE);
		x1.setBackground(new Color(102, 204, 153));
		x1.setBounds(40,20,150 ,67);
		x2=new JButton("Defiending's Army");
		x2.setFont(new Font("Segoe Print", Font.BOLD, 15));
		x2.setBorder(null);
		x2.setBackground(new Color(204, 51, 102));
		x2.setBounds(300,20,150,67);
		 txtCart = new JTextArea();
		 txtCart.setFont(new Font("Segoe Print", Font.BOLD, 9));
		 txtCart.setBackground(new Color(204, 51, 102));
		 txtCart2 = new JTextArea();
		 txtCart2.setFont(new Font("Segoe Print", Font.BOLD, 9));
		 txtCart2.setForeground(new Color(0, 51, 255));
		 txtCart2.setBackground(new Color(102, 204, 153));
		 txtCart3 = new JTextArea();
		 txtCart3.setBackground(new Color(204, 204, 51));
		txtCart.setBounds(280,98,200,150);
		txtCart2.setBounds(22,98,183,150);
		txtCart3.setBounds(550, 50, 214, 298);
		vBox=new JComboBox();
		vBox.setForeground(new Color(204, 0, 0));
		vBox.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		vBox.setBackground(new Color(204, 204, 51));
		vBox.setBorder(null);
		//JCheckBox vBox=new JCheckBox();
		vBox.setBounds(40, 259,130,44);
		 a=new JButton("manual");
		 a.setForeground(new Color(102, 204, 204));
		 a.setIcon(new ImageIcon("C:\\Users\\YOUSEF\\Desktop\\New folder (3)\\EmpireM2\\Icons\\icons8-setting-48.png"));
		 a.setFont(new Font("Segoe Print", Font.BOLD, ٢١));
		 a.setBackground(new Color(102, 102, 0));
		 a.setBorder(null);
		 b=new JButton("auto resolve");
		 b.setForeground(new Color(153, 153, 153));
		 b.setIcon(new ImageIcon("Icons\\icons8-automatic-contrast-48.png"));
		 b.setFont(new Font("Segoe Print", Font.BOLD, ١٥));
		 b.setBackground(new Color(255, 153, 153));
		 b.setBorder(null);
		JLabel l=new JLabel("flow of battle");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		l.setForeground(new Color(255, 0, 0));
		l.setBounds(550, 0, 214, 50);
		b.setBounds(357, 302,150, 58);
		a.setBounds(185,303, 150, 60);
		setLayout(null);
	    add(x1);
		add(x2);
		add(txtCart);
		add(txtCart2);
		add(a);
		add(b);
		add(l);
		add(vBox);
		add(txtCart3);
		revalidate();
		repaint();
		
		
	}
	public static void main(String[] args) {
		JFrame xFrame=new JFrame();
		BattleView v=new BattleView();
		xFrame.getContentPane().add(v);
		v.getTxtCart3().setText("dfsadfsad");
		xFrame.setSize(500,500);
		xFrame.setVisible(true);
		
	}

}
