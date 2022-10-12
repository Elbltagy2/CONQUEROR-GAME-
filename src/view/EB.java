package view;
import javax.swing.*;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class EB extends JPanel {
	JButton b2;
	public JButton getB2() {
		return b2;
	}
	public JButton getB3() {
		return b3;
	}
	JButton b3;
	public EB() {
		setBackground(new Color(0, 0, 51));
		b2=new JButton("Farm");
		b2.setFont(new Font("Segoe Print", Font.BOLD, 24));
		b2.setHorizontalTextPosition(SwingConstants.LEFT);
		b2.setBackground(new Color(255, 255, 51));
		b2.setIcon(new ImageIcon("Icons\\icons8-farm-48.png"));
		b2.setBorderPainted(false);
	    b3=new JButton("Market");
	    b3.setIcon(new ImageIcon("Icons\\icons8-shop-48.png"));
	    b3.setBackground(new Color(204, 102, 0));
	    b3.setHorizontalTextPosition(SwingConstants.LEFT);
	    b3.setFont(new Font("Segoe Print", Font.BOLD, 17));
	    b3.setBorderPainted(false);
	    GroupLayout groupLayout = new GroupLayout(this);
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addComponent(b2, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
	    			.addGap(32)
	    			.addComponent(b3, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(117, Short.MAX_VALUE))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(104)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(b2, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
	    				.addComponent(b3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
	    			.addContainerGap())
	    );
	    setLayout(groupLayout);
	   // add(b4);
	}
	public static void main(String[]args) {
	JFrame s=new JFrame("Economic buidlings");
	  s.getContentPane().add(new EB());
	    s.setSize(600,400);  
	    s.setVisible(true); 
	   
	 
	}  
}
