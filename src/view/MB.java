package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.validator.PublicClassValidator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MB extends JPanel  {
	private JButton b2;
	private JButton b1;
	private JButton b3;
	public MB() {
		setBackground(new Color(0, 0, 51));
		
		    b1=new JButton("Archery Range");
		    b1.setBackground(new Color(204, 255, 153));
		    b1.setFont(new Font("Segoe Print", Font.BOLD, 15));
		    b1.setIcon(new ImageIcon("Icons\\icons8-archery-50.png"));
		    b1.setBorderPainted(false);
		    b2=new JButton("Barracks");
		    b2.setIcon(new ImageIcon("Icons\\icons8-army-62.png"));
		    b2.setFont(new Font("Segoe Print", Font.BOLD, 15));
		    b2.setBackground(new Color(255, 204, 51));
		    b2.setBorderPainted(false);
		     b3=new JButton("Stable");
		     b3.setFont(new Font("Segoe Print", Font.BOLD, 15));
		     b3.setBackground(new Color(51, 255, 153));
		     b3.setIcon(new ImageIcon("Icons\\icons8-horse-stable-50.png"));
		     b3.setBorderPainted(false);
		    b1.setBounds(65,48,205,124);
		    b2.setBounds(280,47,205,124);
		    b3.setBounds(495,47,227,124);
		    
		
		    setLayout(null);
		    add(b1);
		    add(b2);
		    add(b3);
	}
	public JButton getB2() {
		return b2;
	}
	public JButton getB1() {
		return b1;
	}
	public JButton getB3() {
		return b3;
	}
	public static void main(String[]args) {
		
		JFrame x=new JFrame("Economic buidlings");
			x.getContentPane().add(new MB());
		    x.setSize(1000,1000);  
		    x.setVisible(true);
		    x.repaint();
		    x.revalidate();
	}
}
