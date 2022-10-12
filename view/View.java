package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.Color;

public class View extends JFrame {
	private JPanel pnlProducts;
	private JTextArea txtCart;
	 public JButton x1Button;
	 public JPanel panel;
	public View (){
		super("GAME");
		setBackground(new Color(0, 0, 51));
		getContentPane().setBackground(new Color(0, 0, 51));
		 panel = new JPanel();
		 panel.setBackground(new Color(0, 0, 51));
		this.setVisible(true);
		setTitle("Game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
	//	this.setLayout(	new Fl());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		revalidate();
		repaint();
		
	}
	public static void main(String[] args) {
		new View();
	}
	public void action() {
     x1Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("jgfkhghj");
			}
		});
		
	}

}
