package view;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;   
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
public class Cityview extends JPanel{
	 private JLabel label;
	 private JButton b1;
	 private JButton b2;
	 private JButton b3;
	 private JButton b4;
	 private JComboBox comboBox;
	 private JComboBox comboBox2;
	public Cityview () {
		setBackground(new Color(0, 0, 51));
		 b1=new JButton("Military buildings ");
		 b1.setBackground(new Color(0, 204, 255));
		 b1.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		 b1.setHorizontalTextPosition(SwingConstants.LEFT);
		 b1.setIcon(new ImageIcon("icons\\icons8-military-tent-64(1).png"));
		 b1.setBorderPainted(false);
		     b2=new JButton("Economic buildings");
		     b2.setHorizontalTextPosition(SwingConstants.LEFT);
		     b2.setIcon(new ImageIcon("icons\\icons8-economic-64.png"));
		     b2.setFont(new Font("Segoe Print", Font.PLAIN,18));
		     b2.setBackground(new Color(255, 204, 204));
		     b2.setBorderPainted(false);
		     b3=new JButton("Relocate");
		     b3.setHorizontalTextPosition(SwingConstants.LEFT);
		     b3.setIcon(new ImageIcon("icons\\icons8-relocate-64.png"));
		     b3.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		     b3.setBackground(new Color(204, 204, 0));
		     b3.setBorderPainted(false);
		     b4=new JButton("initiateArmy");
		     b4.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		     b4.setHorizontalTextPosition(SwingConstants.LEFT);
		     b4.setIcon(new ImageIcon("Icons/icons8-soldier-48.png"));
		     b4.setBackground(new Color(204, 204, 255));
		     b4.setBorderPainted(false);
		     comboBox=new JComboBox();
		     comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		     comboBox2=new JComboBox();
		     
		    b1.setBounds(52,127,300,73);  
		    b2.setBounds(379,128,300,73);
		    b3.setBounds(52,261, 300, 70);
		    b4.setBounds(379, 261, 300, 70);
		    comboBox.setBounds(65,354, 120, 30);
		    comboBox2.setBounds(547, 354, 120, 30);
		    label = new JLabel();
		    label.setBounds(355, 0, 200, 200);
		    setLayout(null);
		    add(b1);
		    add(b2);
		    add(b3);
		    add(b4);
		    add(comboBox);
		    add(comboBox2);
		    setSize(800,700);
		   add(label); 
	}
public JButton getB4() {
		return b4;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JComboBox getComboBox2() {
		return comboBox2;
	}
public JLabel getLabel() {
		return label;
	}
	public JButton getB3() {
	return b3;
}
	public JButton getB1() {
		return b1;
	}
	public JButton getB2() {
		return b2;
	}
public JLabel getLabel1() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
public static void main (String[]args) {
	JFrame f=new JFrame("Buildings");  
    f.getContentPane().add(new Cityview());
    f.setVisible(true);
    f.setSize(800, 700);
    
    
    

    
}  
}

