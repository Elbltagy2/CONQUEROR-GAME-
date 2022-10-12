package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Random;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import buildings.ahmed;
import engine.City;
import engine.Game;
import engine.GameListener;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.MaxCapacityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Army;
import units.Status;
import units.Unit;
import view.BattleView;
import view.Cityview;
import view.EB;
import view.Gameinfo;
import view.MB;
import view.Notifications;
import view.View;
import view.WorldVeiw;
import view.marching;
import view.BattleView;
import view.playername;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameGUI implements ahmed,ActionListener, GameListener {
	private View view;
	private Game game;
	public JButton x1Button;
	public JButton x2;
	int a=0;
	private Army currentArmy;
	private Army definding;
	private BattleView battelview;
	private playername player;
	private WorldVeiw w;
	private JComboBox<String> box;
	private JPanel xJPanel;
	private Gameinfo gameinfo;
	private Notifications Not;
	private EB eb;
	private MB mb;
	private JPanel idle;
	private JPanel Marching;
	private JPanel seigingJPanel;
	private EconomicBuilding currentEconomicBuilding;
	private MilitaryBuilding currentMilitaryBuilding;
	private String playerName = "";
	private String playerCity = "";
	private ArrayList<JButton> btnsProduct;
	private ArrayList<JButton> Idles = new ArrayList<JButton>();
	private ArrayList<JButton> Marchings = new ArrayList<JButton>();
	private ArrayList<JButton> Seigings = new ArrayList<JButton>();
	private ArrayList<Army> idleArmies = new ArrayList<Army>();
	private ArrayList<Army> MarchingArmies = new ArrayList<Army>();
	private ArrayList<Army> seigingArmies = new ArrayList<Army>();
	private City currentCity;
	private Cityview cityview;
	private ArrayList<String> unit = new ArrayList<String>();

	public GameGUI() throws IOException {
		// game=new Game("", "");
		btnsProduct = new ArrayList<JButton>();
		view = new View();
		view.setBounds(new Rectangle(0, 0, 1366, 675));
		view.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowOpened(WindowEvent we) {
		        playSound("BackSound.wav",true);
		    }

		    @Override
		    public void windowActivated(WindowEvent we) {
		        System.out.println("this window or a subframe was focused");
		    }
		});
		view.panel.setBackground(new Color(0, 0, 51));
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		x1Button = new JButton("Start Game");
		x1Button.setBounds(475, 353, 400, 150);
		x1Button.setHorizontalTextPosition(SwingConstants.LEFT);
		x1Button.setIcon(new ImageIcon("C:\\Users\\YOUSEF\\Desktop\\New folder (3)\\EmpireM2\\Icons\\icons8-play-48.png"));
		x1Button.setForeground(new Color(0, 0, 0));
		x1Button.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		x1Button.setBackground(new Color(255, 0, 102));
		x1Button.setBorderPainted(false);
		x1Button.setContentAreaFilled(false);
		x1Button.setOpaque(true);
		x1Button.addActionListener(this);
		btnsProduct.add(x1Button);
		view.setVisible(true);
		view.panel.setLayout(null);
		view.panel.add(x1Button);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(375, 11, 600, 260);
		view.panel.add(panel);
		
		JLabel lblNewLabel = new JLabel("Empire");
		lblNewLabel.setForeground(new Color(204, 102, 0));
		lblNewLabel.setBounds(72, 0, 398, 193);
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 92));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("M2");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(388, 99, 163, 88);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 47));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(lblNewLabel_1);
		GroupLayout groupLayout_1 = new GroupLayout(view.getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1350, Short.MAX_VALUE)
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 637, Short.MAX_VALUE)
		);
		view.getContentPane().setLayout(groupLayout_1);
		x1Button.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	x1Button.setBackground(new Color(153,0,51));
		    	x1Button.setForeground(Color.decode("#82aa94"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	x1Button.setBackground(Color.decode("#82aa94"));
		    	x1Button.setForeground(new Color(153,0,51));
		    }
		});
	}
	

	public void actionPerformed(ActionEvent e) {
		playSound("pessEvent.wav",false);
		if (e.getActionCommand().equals("auto resolve")) {
			Not.getL4().setText("");

			try {
				game.autoResolve(currentArmy, definding);
				battelview.getTxtCart3().setText(game.getAuto());
				updatemanula();
			} catch (FriendlyFireException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (currentArmy.getUnits().size() == 0) {
				Not.getL4().setText("You lose your Army");
			} else {
				Not.getL4().setText("Battle WON ");
			}
			if (definding.getUnits().size()==0) {
				for (City a : game.getAvailableCities()) {
				if (a.getName().equals(definding.getCurrentLocation()))
				{
					game.occupy(currentArmy,a.getName());
				}
				
			}
				
				
			}
		}
		if (e.getActionCommand().equals("Farm")) {

			JPanel f = new JPanel();
			boolean flag = false;
			for (EconomicBuilding building : this.currentCity.getEconomicalBuildings()) {
				if (building instanceof Farm) {
					flag = true;
					currentEconomicBuilding = building;
				}
			}
			JButton fButton;
			JLabel fl;
			if (flag) {
				fButton = new JButton("Upgrade Farm");
				fButton.addActionListener(this);
				fl = new JLabel("Upgrading Cost is "+currentEconomicBuilding.getUpgradeCost()+"$");
				fl.setBackground(Color.decode("#ff5cbc"));
				fButton.setBackground(Color.decode("#8efff6"));
				fl.setForeground(Color.decode("#8efff6"));
				fButton.setIcon(new ImageIcon("Icons/icons8-upgrade-64.png"));
				} else {
				fButton = new JButton("Build Farm");
				fButton.addActionListener(this);
				fl = new JLabel("Building Cost is 1000$");
				fButton.setBackground(Color.decode("#ff0064"));
				fButton.setIcon(new ImageIcon("Icons/icons8-build-64.png"));
				fl.setForeground(Color.decode("#ff0064"));
				fButton.setHorizontalTextPosition(SwingConstants.LEFT);
				fButton.setFont(new Font("Segoe Print", Font.BOLD, 20));
				
			}
			f.setLayout(null);
			fButton.setBounds(250, 130, 220, 80);
			fButton.setBorder(null);
			fl.setBounds(480, 130, 400, 80);
			fl.setFont(new Font("Segoe Print", Font.BOLD, 20));
			f.add(fButton);
			f.setBackground(new Color(0,0,51));
			f.add(fl);
			add(f, eb);
			view.revalidate();
			view.repaint();
		}
		if (e.getActionCommand().equals("Market")) {

			JPanel f = new JPanel();
			boolean flag = false;
			for (EconomicBuilding building : this.currentCity.getEconomicalBuildings()) {
				if (building instanceof Market) {
					flag = true;
					currentEconomicBuilding = building;
				}
			}
			JButton fButton;
			JLabel fl;
			if (flag) {
				fButton = new JButton("Upgrade Market");
				fButton.addActionListener(this);
				fl = new JLabel("Upgrading Cost is "+currentEconomicBuilding.getUpgradeCost()+"$");
				fl.setBackground(Color.decode("#ff5cbc"));
				fButton.setBackground(Color.decode("#8efff6"));
				fl.setForeground(Color.decode("#8efff6"));
				fButton.setIcon(new ImageIcon("Icons/icons8-upgrade-64.png"));
			} else {
				fButton = new JButton("Build Market");
				fButton.addActionListener(this);
				fl = new JLabel("Building Cost is 1500$");
				fButton.setBackground(Color.decode("#ff0064"));
				fButton.setIcon(new ImageIcon("Icons/icons8-build-64.png"));
				fl.setForeground(Color.decode("#ff0064"));
				fButton.setHorizontalTextPosition(SwingConstants.LEFT);
				fButton.setFont(new Font("Segoe Print", Font.BOLD, 20));
			}
			f.setLayout(null);
			fButton.setBounds(250, 130, 220, 80);
			fButton.setBorder(null);
			fl.setBounds(480, 130, 400, 80);
			fl.setFont(new Font("Segoe Print", Font.BOLD, 20));
			f.setBackground(new Color(0,0,51));
			f.add(fButton);
			f.add(fl);
			add(f, eb);
			view.revalidate();
			view.repaint();
		}

		// ArcheryRange Doesnot Work
		if (e.getActionCommand().equals("Archery Range")) {
			boolean flag = false;
			JPanel f = new JPanel();
			for (MilitaryBuilding building : this.currentCity.getMilitaryBuildings()) {
				if (building instanceof ArcheryRange) {
					flag = true;
					currentMilitaryBuilding = building;
				}
			}
			JButton fButton;
			JButton recButton;
			JLabel fl;
			JLabel rec = null;
			JComboBox<String> ArmiesInCity = null;
			if (flag) {
				fButton = new JButton("Upgrade Archery Range");
				recButton = new JButton("Recruit Archer Unit");
				// recButton.addActionListener(this);
				fl = new JLabel("Upgrading Cost is"+currentMilitaryBuilding.getUpgradeCost()+"$");
				rec = new JLabel("Recruitment Cost is "+currentMilitaryBuilding.getRecruitmentCost()+"$");
				recButton.addActionListener(this);
				fButton.addActionListener(this);
				recButton.setBounds(250, 230, 220, 80);
				rec.setBounds(480, 230, 400, 80);
				fButton.setBackground(Color.decode("#8efff6"));
				fButton.setIcon(new ImageIcon("Icons/icons8-upgrade-64.png"));
				rec.setHorizontalTextPosition(SwingConstants.LEFT);
				rec.setFont(new Font("Segoe Print", Font.BOLD, 24));
				rec.setForeground(Color.decode("#ff5cbc"));
				recButton.setIcon(new ImageIcon("Icons/icons8-recruitment-64.png"));
				fl.setForeground(Color.decode("#8efff6"));
				recButton.setBorder(null);
				recButton.setBackground(Color.decode("#ff5cbc"));
				f.add(rec);
				f.add(recButton);

			} else {
				fButton = new JButton("Build Archery Range");
				fButton.addActionListener(this);
				fl = new JLabel("Building Cost is 1500$");
				fButton.setBackground(Color.decode("#ff0064"));
				fButton.setIcon(new ImageIcon("Icons/icons8-build-64.png"));
				fl.setForeground(Color.decode("#ff0064"));
				fButton.setHorizontalTextPosition(SwingConstants.LEFT);
				fButton.setFont(new Font("Segoe Print", Font.BOLD, 13));
			}
			f.setBackground(new Color(0,0,51));
			fButton.setBounds(250, 130, 220, 80);
			fButton.setBorder(null);
			fl.setBounds(480, 130, 400, 80);
			fl.setFont(new Font("Segoe Print", Font.BOLD, 24));
			f.setLayout(null);
			f.setBounds(0,0,view.getWidth(),500);
			f.add(fButton);
			f.add(fl);
			// fButton.addActionListener(this);

			add(f, mb);
			view.revalidate();
			view.repaint();
		}

		if (e.getActionCommand().equals("Barracks")) {
			JPanel f = new JPanel();
			boolean flag = false;
			for (MilitaryBuilding building : this.currentCity.getMilitaryBuildings()) {
				if (building instanceof Barracks) {
					flag = true;
					currentMilitaryBuilding = building;
				}
			}
			JButton fButton;
			JButton recButton;
			JLabel fl;
			JLabel rec = null;
			JComboBox<String> ArmiesInCity = null;
			if (flag) {
				fButton = new JButton("Upgrade Barracks");
				recButton = new JButton("Recruit Infantry Unit");
				recButton.addActionListener(this);
				fl = new JLabel("Upgrading Cost is "+currentMilitaryBuilding.getUpgradeCost()+"$");
				rec = new JLabel("Recruitment Cost is "+currentMilitaryBuilding.getRecruitmentCost()+"$");
				recButton.setBounds(250, 230, 220, 80);
				rec.setBounds(480, 230, 400, 80);
				fButton.setBackground(Color.decode("#8efff6"));
				fButton.setIcon(new ImageIcon("Icons/icons8-upgrade-64.png"));
				rec.setHorizontalTextPosition(SwingConstants.LEFT);
				rec.setFont(new Font("Segoe Print", Font.BOLD, 24));
				rec.setForeground(Color.decode("#ff5cbc"));
				recButton.setIcon(new ImageIcon("Icons/icons8-recruitment-64.png"));
				recButton.setBorder(null);
				recButton.setBackground(Color.decode("#ff5cbc"));
				fl.setForeground(Color.decode("#8efff6"));
				f.add(rec);
				f.add(recButton);

			} else {
				fButton = new JButton("Build Barracks");
				fButton.addActionListener(this);
				fButton.setBackground(Color.decode("#ff0064"));
				fButton.setIcon(new ImageIcon("Icons/icons8-build-64.png"));
				fButton.setFont(new Font("Segoe Print", Font.BOLD, 19));
				fl = new JLabel("Building Cost is 2000");
				fl.setForeground(Color.decode("#ff0064"));
				fButton.setHorizontalTextPosition(SwingConstants.LEFT);
			}
			f.setBackground(new Color(0,0,51));
			fButton.setBounds(250, 130, 220, 80);
			fButton.setBorder(null);
			fl.setBounds(480, 130, 400, 80);
			fl.setFont(new Font("Segoe Print", Font.BOLD, 24));
			f.setLayout(null);
			f.setBounds(0,0,view.getWidth(),500);
			f.add(fButton);
			f.add(fl);

			add(f, mb);
			view.revalidate();
			view.repaint();
		}

		if (e.getActionCommand().equals("Stable")) {

			JPanel f = new JPanel();
			boolean flag = false;
			for (MilitaryBuilding building : this.currentCity.getMilitaryBuildings()) {
				if (building instanceof Stable) {
					flag = true;
					currentMilitaryBuilding = building;
				}
			}
			JButton fButton;
			JButton recButton;
			JLabel fl;
			JLabel rec = null;
			f.setBackground(new Color(0,0,51));
			if (flag) {
				fButton = new JButton("Upgrade Stable");
				recButton = new JButton("Recruit Cavalry Unit");
				fButton.addActionListener(this);
				recButton.addActionListener(this);
				fl = new JLabel("Upgrading Cost is "+currentMilitaryBuilding.getUpgradeCost()+"$");
				rec = new JLabel("Recruitment Cost is "+currentMilitaryBuilding.getRecruitmentCost()+"$");
				recButton.setBounds(250, 230, 220, 80);
				rec.setBounds(480, 230, 400, 80);
				fButton.setBackground(Color.decode("#8efff6"));
				fButton.setIcon(new ImageIcon("Icons/icons8-upgrade-64.png"));
				rec.setHorizontalTextPosition(SwingConstants.LEFT);
				rec.setFont(new Font("Segoe Print", Font.BOLD, 24));
				rec.setForeground(Color.decode("#ff5cbc"));
				recButton.setIcon(new ImageIcon("Icons/icons8-recruitment-64.png"));
				recButton.setBorder(null);
				recButton.setBackground(Color.decode("#ff5cbc"));
				fl.setForeground(Color.decode("#8efff6"));
				f.add(rec);
				f.add(recButton);
			} else {
				fButton = new JButton("Build Stable");
				// fButton.addActionListener(this);
				fButton.setBackground(Color.decode("#ff0064"));
				fButton.setIcon(new ImageIcon("Icons/icons8-build-64.png"));
				fButton.setFont(new Font("Segoe Print", Font.BOLD, 24));
				fl = new JLabel("Building Cost is 2500");
				fl.setForeground(Color.decode("#ff0064"));
				fButton.addActionListener(this);
				fButton.setHorizontalTextPosition(SwingConstants.LEFT);
			}

			f.setBackground(new Color(0,0,51));
			fButton.setBounds(250, 130, 220, 80);
			fButton.setBorder(null);
			fl.setBounds(480, 130, 400, 80);
			fl.setFont(new Font("Segoe Print", Font.BOLD, 24));
			f.setLayout(null);
			f.setBounds(0,0,view.getWidth(),500);
			f.add(fButton);
			f.add(fl);

			add(f, mb);
			view.revalidate();
			view.repaint();
		}
		if (e.getActionCommand().equals("Military buildings ")) {
			mb = new MB();
			mb.getB1().addActionListener(this);
			mb.getB3().addActionListener(this);
			mb.getB2().addActionListener(this);
			add(mb, cityview);
			view.revalidate();
			view.repaint();
		}

		if (e.getActionCommand().equals("Economic buildings")) {
			eb = new EB();
			eb.setBounds(250,0,view.getWidth(),500);
			eb.getB2().addActionListener(this);
			eb.getB3().addActionListener(this);
			add(eb, cityview);
			view.revalidate();
			view.repaint();
		}
		if (e.getActionCommand().equals("Player's Army")) {
			String s[][] = currentArmy.display();
			String s1 = "";
			for (int i = 0; i < s.length; i++) {
				s1 += s[i][0] + "   " + s[i][1] + "   " + s[i][2] + "   " + s[i][3] + "\n";
			}
			battelview.getTxtCart2().setText(s1);

		}
		if (e.getActionCommand().equals("Defiending's Army")) {
			for (City a : game.getAvailableCities()) {
				if (a.getName().equals(currentArmy.getCurrentLocation()))
					definding = a.getDefendingArmy();
			}
			String s[][] = definding.display();
			String s1 = "";
			for (int i = 0; i < s.length; i++) {
				s1 += s[i][0] + "   " + s[i][1] + "   " + s[i][2] + "   " + s[i][3] + "\n";
			}
			battelview.getTxtCart().setText(s1);
		}

		if (e.getActionCommand().equals("Start Game")) {
			view.remove(view.panel);
			player = new playername();
			view.panel = player;
			btnsProduct.add(player.getZ1());
			player.getZ1().addActionListener(this);
			view.getContentPane().add(player);
			view.revalidate();
			view.repaint();
		}
		if (e.getActionCommand().equals("manual")) {

			int i = (int) (Math.random() * definding.getUnits().size());
			Unit a = definding.getUnits().get(i);

			int b1 = battelview.getvBox().getSelectedIndex();
			int i2 = a.getCurrentSoldierCount();
			Unit b = currentArmy.getUnits().get(b1);
			int i3 = b.getCurrentSoldierCount();
			try {
				b.attack(a);
				a.attack(b);
			} catch (FriendlyFireException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int i4 = a.getCurrentSoldierCount();
			int i5 = b.getCurrentSoldierCount();
			String s = battelview.getTxtCart3().getText()+"you kill " + (i2 - i4) + " unit from definding Army \n";
			s += "you lose " + (i3 - i5) + " unit \n ";
			
			battelview.getTxtCart3().setText(s);
			updatemanula();
			if (currentArmy.getUnits().size()==0) {
				game.getPlayer().getControlledArmies().remove(currentArmy);
			}
			if (definding.getUnits().size()==0) {
				game.occupy(currentArmy,definding.getCurrentLocation());
			}
			

		}
		if (e.getActionCommand().equals("Enter")) {
			currentArmy = null;
			// playername player=(playername)view.panel;
			playerCity = player.geteBox().getSelectedItem().toString();
			playerName = player.getX1().getText();
			// view.setVisible(false);
			if (playerName.equals("")) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "please enter Name");
			}
			else {
			gameinfo = new Gameinfo();
			Not = new Notifications();
			w = new WorldVeiw();
			try {
				game = new Game(playerName, playerCity);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.getContentPane().setLayout(null);
			gameinfo.setBounds(0, 0, view.getWidth(), 70);
			gameinfo.setBackground(new Color(0, 79, 134 ));
			gameinfo.getB2().addActionListener(this);
			Not.getB1().addActionListener(this);
			Not.setBounds(300, 460, view.getWidth(), 75);
			w.setBounds(250, 75, view.getWidth(), 600);
			view.getContentPane().add(Not);
			view.getContentPane().add(w);
			view.getContentPane().add(gameinfo);
			view.remove(this.player);
			if (w.getCity1() != null)
				w.getCity1().addActionListener(this);
			if (w.getCity2() != null)
				w.getCity2().addActionListener(this);
			if (w.getCity3() != null)
				w.getCity3().addActionListener(this);
			if (w.getIdle() != null)
				w.getIdle().addActionListener(this);
			if (w.getMarching() != null)
				w.getMarching().addActionListener(this);
			if (w.getSeiging() != null)
				w.getSeiging().addActionListener(this);
			gameinfo.getL1().setText("player name:  " + playerName);
			gameinfo.getL2().setText("turncount:  " + game.getCurrentTurnCount());
			gameinfo.getL3().setText(
					"Treasury:  " + game.getPlayer().getTreasury() + "      food:  " + game.getPlayer().getFood());
			view.repaint();
			view.revalidate();
		}}
		if (e.getActionCommand().equals("Cairo")) {
			currentCity = null;
			view.setVisible(true);
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equals("Cairo")) {
					currentCity = c;
				}
			}
			if (currentCity == null) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "You don't allow to enter to this City");
			} else {

				cityview = new Cityview();
				cityview.setBounds(0, 75, view.getWidth(), 50);
				cityview.getB1().addActionListener(this);
				cityview.getB2().addActionListener(this);
				cityview.getB3().addActionListener(this);
				cityview.getB4().addActionListener(this);
				int i = 1;
				for (Army a : game.getPlayer().getControlledArmies()) {
					if (a.getCurrentLocation().equals(currentCity.getName())) {
					cityview.getComboBox().addItem("Army" + i);
					i++;}
				}
				i = 1;
				for (Unit u : currentCity.getDefendingArmy().getUnits()) {
					cityview.getComboBox2().addItem("Unit" + i);
					i++;
				}
				cityview.getLabel1().setText("Cairo");
				// view.setLayout(null);
				add(cityview, w);
				view.repaint();
				view.revalidate();
			}
		}
		if (e.getActionCommand().equals("Sparta")) {
			// view.setVisible(false);
			currentCity = null;
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equals("Sparta")) {
					currentCity = c;
				}
			}
			if (currentCity == null) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "You don't allow to enter to this City");
			} else {

				cityview = new Cityview();
				cityview.getB1().addActionListener(this);
				cityview.getB2().addActionListener(this);
				cityview.getB3().addActionListener(this);
				cityview.getB4().addActionListener(this);
				int i = 1;
				for (Army a : game.getPlayer().getControlledArmies()) {
					cityview.getComboBox().addItem("Army" + i);
					i++;
				}
				i = 1;
				for (Unit u : currentCity.getDefendingArmy().getUnits()) {
					cityview.getComboBox2().addItem("Unit" + i);
					i++;
				}

				cityview.getLabel1().setText("Sparta");
				add(cityview, w);

				view.repaint();
				view.revalidate();
			}
		}
		if (e.getActionCommand().equals("Rome")) {
			currentCity = null;
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equals("Rome")) {
					currentCity = c;
				}
			}
			if (currentCity == null) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "You don't allow to enter to this City");
			} else {
				cityview = new Cityview();
				cityview.getLabel1().setText("Rome");
				cityview.getB1().addActionListener(this);
				cityview.getB2().addActionListener(this);
				cityview.getB3().addActionListener(this);
				cityview.getB4().addActionListener(this);
				int i = 1;
				for (Army a : game.getPlayer().getControlledArmies()) {
					cityview.getComboBox().addItem("Army" + i);
					i++;
				}
				i = 1;
				for (Unit u : currentCity.getDefendingArmy().getUnits()) {
					cityview.getComboBox2().addItem("Unit" + i);
					i++;
				}
				add(cityview, w);
				view.revalidate();
				view.repaint();
			}
		}
		if (e.getActionCommand().equals("Relocate")) {
			int i = cityview.getComboBox().getSelectedIndex();
			int j = cityview.getComboBox2().getSelectedIndex();
			if (i == -1) {
				Not.getL4().setText("you should select Army");
			} else {
				if (j == -1) {
					Not.getL4().setText("you should select Unit");

				} else {

					try {
						game.getPlayer().getControlledArmies().get(i)
								.relocateUnit(currentCity.getDefendingArmy().getUnits().get(j));
						updaterelocate();
					} catch (MaxCapacityException e1) {
						Not.getL4().setText("Army is full");
					}
				}
			}

		}
		if (e.getActionCommand().equals("initiateArmy")) {
			int i = cityview.getComboBox().getSelectedIndex();
			int j = cityview.getComboBox2().getSelectedIndex();
			if (j == -1) {
				Not.getL4().setText("you should select Unit");
			} else {
				game.getPlayer().initiateArmy(currentCity, currentCity.getDefendingArmy().getUnits().get(j));
				updaterelocate();
			}
		}
		if (e.getActionCommand().equals("Idle Armies")) {
			// view.getContentPane().remove(this.w);
			// view.setVisible(false);
			idle = new JPanel();
			idle.setLayout(new FlowLayout());
			idle.setBackground(new Color(0,0,51));
			
			int i = 1;
			int W=0;
			int MarL=500;
			if (game.getPlayer().getControlledArmies() != null) {
				idle.setLayout(null);
				for (Army army : game.getPlayer().getControlledArmies()) {
					Army army1 = army;
					String[][] data = army1.displayIdle();
					if (army1.getCurrentStatus() == Status.IDLE) {
						if(i==7) {
							W=0;
							MarL=270;
						}else if(i==13) {
							W=0;
							MarL=60;
						}
						JButton xButton = new JButton("IdleArmy" + i);
						xButton.setBounds(MarL,(W*50)+(10*W),220,50);
						xButton.addActionListener(this);
						xButton.setBorder(null);
						xButton.setFont(new Font("Segoe Print", Font.PLAIN, 30));
						// xButton.setBounds(x, y, width, height);
						int x[]= {0,1,3};
						int c=new Random().nextInt(x.length);
						if(data[1][0]=="Archer") {
							xButton.setBackground(Color.decode("#c64260"));
							xButton.setIcon(new ImageIcon("Icons/icons8-archery-48(1).png"));
						}else if(data[1][0]=="Infantry") {
							xButton.setBackground(Color.decode("#cff649"));
							xButton.setIcon(new ImageIcon("Icons/icons8-medieval-48(1).png"));
						}else {
							xButton.setBackground(Color.decode("#2bfeee"));
							xButton.setIcon(new ImageIcon("Icons/icons8-medieval-48.png"));
						}
						i++;
						W++;
						idle.add(xButton);
						Idles.add(xButton);
						idleArmies.add(army1);
						idle.setSize(500, 500);

					}
				}
			}
			add(idle, w);
			// view.add(idle);
			view.revalidate();
			view.repaint();
		}
		if (e.getActionCommand().equals("Marching Armies")) {
			Marching = new JPanel();
			Marching.setLayout(new FlowLayout());
			Marching.setBackground(new Color(0, 0, 51));
			int i = 1;
			for (Army army : game.getPlayer().getControlledArmies()) {
				if (army.getCurrentStatus() == Status.MARCHING) {
					JButton xButton = new JButton("MarchingArmy" + i);
					xButton.addActionListener(this);
					xButton.setHorizontalTextPosition(SwingConstants.LEFT);
					xButton.setIconTextGap(1);
					xButton.setFont(new Font("Segoe Print", Font.PLAIN, 24));
					xButton.setBackground(new Color(0, 153, 255));
					xButton.setBorderPainted(false);
					i++;
					Marching.add(xButton);
					Marchings.add(xButton);
					MarchingArmies.add(army);
				}
			}
			add(Marching, w);
			view.revalidate();
			view.repaint();

		}
		if (e.getActionCommand().equals("Seiging Armies")) {
			seigingJPanel = new JPanel();
			seigingJPanel.setLayout(null);
			seigingJPanel.setBackground(new Color(0,0,51));
			int i = 1;
			for (Army army : game.getPlayer().getControlledArmies()) {
				if (army.getCurrentStatus() == Status.BESIEGING) {
					JButton xButton = new JButton("SeigingArmy" + i);
					xButton.addActionListener(this);
					i++;
					seigingJPanel.add(xButton);
					Seigings.add(xButton);
					seigingArmies.add(army);
				}
			}
			add(seigingJPanel, w);
			view.revalidate();
			view.repaint();
		}
		JButton xButton = (JButton) e.getSource();
//	if (Idles.contains(xButton)) {
//		JPanel xJPanel=new JPanel();
//		int i=Idles.indexOf(xButton);
//		Army army=idleArmies.get(i);
//		String[][]date=army.display();
//		String []columnNames= {"Type","Level","CurrentCount","MaxCount"};
//		JTable table=new JTable(date,columnNames);
//		table.setBounds(30, 40, 200, 300);
//		xJPanel.add(table);
//		
//		//view.add(xJPanel);
//		add(xJPanel,idle);
//		
//	}

		if (e.getActionCommand().equals("Attack")) {

			// Seigings.remove(seigingArmies.indexOf(currentArmy));
			// seigingArmies.remove(currentArmy);
			battelview = new BattleView();
			// currentArmy.setCurrentStatus(Status.IDLE);
			// idleArmies.add(currentArmy);
			Not.getL4().setText("Attacking Enemy ...");
			// Idles.add(new JButton("IdleArmy"+idleArmies.indexOf(currentArmy)));
//	for (City city : game.getAvailableCities()) {
//		if(city.getName().equals(currentArmy.getCurrentLocation())) {
//			city.setUnderSiege(false);
//			city.setTurnsUnderSiege(0);
//		}
//
//	}
			int i = 1;
			for (Unit u : currentArmy.getUnits()) {
				battelview.getvBox().addItem("Unit" + i);
				i++;
			}
			for (City a : game.getAvailableCities()) {
				if (a.getName().equals(currentArmy.getCurrentLocation())) {
					definding = a.getDefendingArmy();
				}
			}
			battelview.getX1().addActionListener(this);
			battelview.getX2().addActionListener(this);
			battelview.getXz().addActionListener(this);
			battelview.getB().addActionListener(this);
			battelview.getA().addActionListener(this);
			view.getContentPane().removeAll();
			add(battelview, idle);
			view.revalidate();
			view.repaint();
		}
		if (e.getActionCommand().equals("endturn")) {
			for (City c:game.getPlayer().getControlledCities()) {
				System.out.println(c.getName());
			}
			

			game.endTurn();
			if (game.isGameOver()) {
				if (game.getPlayer().getControlledCities().size()==3) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "You won the Game");
					System.exit(0);
				}
				else {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "You lose the Game");
					System.exit(0);
				}
			}
			// gameinfo.getL1().setText("player name "+playerName);

			gameinfo.getL2().setText("turncount  " + game.getCurrentTurnCount());
			gameinfo.getL3().setText(
					"Treasury   " + game.getPlayer().getTreasury() + "      food  " + game.getPlayer().getFood());
		}
		if (e.getActionCommand().equals("World Map")) {
			view.getContentPane().removeAll();
			view.remove(Not);
			view.remove(gameinfo);
			view.remove(w);
			gameinfo.setBounds(0, 0, view.getWidth(), 70);
			gameinfo.setBackground(new Color( 0, 79, 134 ));
			Not.setBounds(300, 460, view.getWidth(), 75);
			w.setBounds(250, 75, view.getWidth(), 600);
			view.getContentPane().add(Not);
			view.getContentPane().add(w);
			view.getContentPane().add(gameinfo);
			view.revalidate();
			view.repaint();

		}
		if (e.getActionCommand().equals("March")) {
//	if(box.getSelectedItem().toString().equals(currentArmy.getCurrentLocation()))
//		Not.getL4().setText("Marching to "+currentArmy.getTarget()+" ...");
			game.targetCity(currentArmy, box.getSelectedItem().toString());

//	currentArmy.setTarget(box.getSelectedItem().toString());
//	currentArmy.setCurrentStatus(Status.MARCHING);
//	if(seigingArmies.contains(currentArmy)) {
//	Seigings.remove(seigingArmies.indexOf(currentArmy));
//	seigingArmies.remove(currentArmy);
//	}
//	if(idleArmies.contains(currentArmy)) {
//		Idles.remove(idleArmies.indexOf(currentArmy));
//		idleArmies.remove(currentArmy);a
//		}
//	if(MarchingArmies.contains(currentArmy)) {
//		Marchings.remove(MarchingArmies.indexOf(currentArmy));
//		MarchingArmies.remove(currentArmy);
//		}
//	
//	MarchingArmies.add(currentArmy);
//	Marchings.add(new JButton("MarchingArmy"+MarchingArmies.indexOf(currentArmy)));
			if (currentArmy.getTarget().equals(""))
				Not.getL4().setText("Already There");
			else
				Not.getL4().setText("Marching to " + currentArmy.getTarget() + " ...");

		}
		if (e.getActionCommand().equals("Seige")) {

			City tmp = null;
			// System.out.println(currentArmy.getCurrentStatus() + " " +
			// currentArmy.getCurrentLocation());

			for (City city1 : game.getAvailableCities()) {
				if (city1.getName().equals(currentArmy.getCurrentLocation())) {
					tmp = city1;

				}
			}

			try {
				game.getPlayer().laySiege(currentArmy, tmp);
				Not.getL4().setText("Seiging " + currentArmy.getCurrentLocation());
				// System.out.println(currentArmy.getCurrentStatus() + " " +
				// currentArmy.getCurrentLocation());

			} catch (TargetNotReachedException | FriendlyCityException e1) {

			}

//	for (City city : game.getAvailableCities()) {
//		if(city.getName().equals(currentArmy.getCurrentLocation()))
//			city.setUnderSiege(true);
//	}
//	currentArmy.setCurrentStatus(Status.BESIEGING);
//	Idles.remove(idleArmies.indexOf(currentArmy));
//	idleArmies.remove(currentArmy);
//	seigingArmies.add(currentArmy);
//	Seigings.add(new JButton("SeigingArmy"+seigingArmies.indexOf(currentArmy)));
//	
		}
		if (Idles.contains(xButton)) {
			xJPanel = new JPanel();
			int i = Idles.indexOf(xButton);
			Army army = idleArmies.get(i);
			System.out.print(army.toString());
			currentArmy = army;
			xJPanel.setBackground(new Color(0,0,51));
			xJPanel.setLayout(null);
			box = new JComboBox<String>();
			box.setBounds(490, 0, 100, 50);
			for (City city : game.getAvailableCities()) {
				// if(!game.getPlayer().getControlledCities().contains(city))
				box.addItem(city.getName());
			}
			String[][] date = army.displayIdle();
			String[] columnNames = { "Type", "Level", "CurrentCount", "MaxCount" };
			//new panel as table================================================================
			JPanel table = new JPanel();
			JLabel Type = new JLabel("Type:");
			JLabel Level = new JLabel("Level:");
			JLabel Ccount = new JLabel("CurrentCount:");
			JLabel MaxC = new JLabel("MaxCount:");
			//results-------
			JLabel Type_r= new JLabel(date[1][0]);
			JLabel Level_r= new JLabel(date[1][1]);
			JLabel Ccount_r= new JLabel(date[1][2]);
			JLabel MaxC_r= new JLabel(date[1][3]);
			//--------Positions------
			table.setLayout(null);
			
			Type.setBounds(20,0,200,100);
			Type_r.setBounds(150,0,200,100);
			Type.setForeground(new Color(  0, 255, 151  ));
			Type_r.setForeground(new Color(  0, 216, 128  ));
			
			Level.setBounds(20,50,200,100);
			Level_r.setBounds(190,50,200,100);
			Level.setForeground(new Color( 255, 37, 37 ));
			Level_r.setForeground(new Color( 197, 35, 35 ));
			
			
			Ccount.setBounds(20,100,200,100);
			Ccount_r.setBounds(240,100,200,100);
			Ccount.setForeground(new Color(164, 255, 0));
			Ccount_r.setForeground(new Color( 110, 171, 0 ));
			
			
			MaxC.setBounds(20,150,200,100);
			MaxC_r.setBounds(240,150,200,100);
			MaxC.setForeground(new Color( 0, 128, 255 ));
			MaxC_r.setForeground(new Color( 0, 97, 194 ));
			
			//Font_______________________________Style__________________________
			Type.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
			Type_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,34));
			
			Level.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
			Level_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,34));
			
			Ccount.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
			Ccount_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,22));
			
			MaxC.setFont(new Font(Font.MONOSPACED,Font.BOLD,35));
			MaxC_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
			
			
			//_____________________________ADD______________________________
			table.add(Type_r);
			table.add(Type);
			table.add(Level);
			table.add(Level_r);
			table.add(Ccount);
			table.add(Ccount_r);
			table.add(MaxC);
			table.add(MaxC_r);
			
			//==================================================================================
			table.setBounds(0,0,320,250);
			table.setBorder(BorderFactory.createLineBorder(new Color( 75, 98, 145 ), 4));
			table.setBackground(new Color( 0, 0, 0 ));
			String locat = army.getCurrentLocation();
			City curr;
			boolean found = false;
			for (City city : this.game.getPlayer().getControlledCities()) {
				if (locat.equals(city.getName())) {
					found = true;
					curr = city;
					break;
				}
			}
			if (!found) {

				JButton attk = new JButton("Attack");
				attk.setBounds(330, 170, 150, 75);
				attk.setBorder(null);
				attk.setBackground(new Color(245, 255, 121));
				attk.setIcon(new ImageIcon("Icons/icons8-attack-64.png"));
				attk.setFont(new Font("Segoe Print",Font.BOLD,22));
				attk.setHorizontalTextPosition(SwingConstants.LEFT);
				
				JButton siig = new JButton("Seige");
				siig.setBounds(330, 85, 150, 75);
				siig.setBorder(null);
				siig.setBackground(new Color( 129, 255, 171 ));
				siig.setFont(new Font("Segoe Print",Font.BOLD,22));
				siig.setIcon(new ImageIcon("Icons/icons8-catapult-48.png"));
				siig.setHorizontalTextPosition(SwingConstants.LEFT);
				// xJPanel.add(table);
				xJPanel.add(attk);
				xJPanel.add(siig);
				attk.addActionListener(this);
				siig.addActionListener(this);

			}
			JButton mar = new JButton("March");
			mar.setBounds(330, 0, 150, 75);
			mar.setHorizontalTextPosition(SwingConstants.LEFT);
			mar.setIconTextGap(1);
			mar.setFont(new Font("Segoe Print", Font.PLAIN, 28));
			mar.setBackground(new Color(201, 61, 197));
			mar.setBorderPainted(false);
			mar.addActionListener(this);

			xJPanel.add(box);
			xJPanel.add(mar);
			xJPanel.add(table);
			add(xJPanel, idle);
			// view.add(xJPanel);
			view.revalidate();
			view.repaint();

		}
		if (Marchings.contains(xButton)) {
			// view.setVisible(false);
			JPanel xJPanel0 = new JPanel();
//xJPanel0.setLayout(null);
			int i = Marchings.indexOf(xButton);
			Army army = MarchingArmies.get(i);
			currentArmy = army;
			String[][] date = army.displayMarching();
			String[] columnNames = { "Type", "Level", "CurrentCount", "MaxCount", "Target City", "Turns to reach" };
			//new panel as table================================================================
			JPanel table1 = new JPanel();
			JLabel Type = new JLabel("Type:");
			JLabel Level = new JLabel("Level:");
			JLabel Ccount = new JLabel("CurrentCount:");
			JLabel MaxC = new JLabel("MaxCount:");
			JLabel TCity = new JLabel("Target City:");
			JLabel T_T_reach = new JLabel("Turns to reach:");
			//results-------
			JLabel Type_r= new JLabel(date[1][0]);
			JLabel Level_r= new JLabel(date[1][1]);
			JLabel Ccount_r= new JLabel(date[1][2]);
			JLabel MaxC_r= new JLabel(date[1][3]);
			JLabel TCity_r = new JLabel(date[1][4]);
			JLabel T_T_reach_r = new JLabel(date[1][5]);
			//--------Positions------
			
			table1.setLayout(null);
			
			Type.setBounds(20,0,200,100);
			Type_r.setBounds(150,0,200,100);
			Type.setForeground(new Color(  0, 255, 151  ));
			Type_r.setForeground(new Color(  0, 216, 128  ));
			
			Level.setBounds(20,50,200,100);
			Level_r.setBounds(190,50,200,100);
			Level.setForeground(new Color( 255, 37, 37 ));
			Level_r.setForeground(new Color( 197, 35, 35 ));
			
			
			Ccount.setBounds(20,100,200,100);
			Ccount_r.setBounds(240,100,200,100);
			Ccount.setForeground(new Color(164, 255, 0));
			Ccount_r.setForeground(new Color( 110, 171, 0 ));
			
			
			MaxC.setBounds(20,150,200,100);
			MaxC_r.setBounds(240,150,200,100);
			MaxC.setForeground(new Color( 0, 128, 255 ));
			MaxC_r.setForeground(new Color( 0, 97, 194 ));
			
			TCity.setBounds(20,200,200,100);
			TCity_r.setBounds(210,200,200,100);
			TCity.setForeground(new Color( 0, 128, 255 ));
			TCity_r.setForeground(new Color( 0, 97, 194 ));
			
			T_T_reach.setBounds(20,250,200,100);
			T_T_reach_r.setBounds(200,250,200,100);
			T_T_reach.setForeground(new Color( 0, 128, 255 ));
			T_T_reach_r.setForeground(new Color( 0, 97, 194 ));
			
			//Font_______________________________Style__________________________
			
			Type.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
			Type_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,34));
			
			Level.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
			Level_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,34));
			
			Ccount.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
			Ccount_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,22));
			
			MaxC.setFont(new Font(Font.MONOSPACED,Font.BOLD,35));
			MaxC_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
			
			TCity.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
			TCity_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,22));
			
			T_T_reach.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
			T_T_reach_r.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
			
			//_____________________________ADD______________________________
			
			table1.add(Type_r);
			table1.add(Type);
			table1.add(Level);
			table1.add(Level_r);
			table1.add(Ccount);
			table1.add(Ccount_r);
			table1.add(MaxC);
			table1.add(MaxC_r);
			table1.add(TCity);
			table1.add(TCity_r);
			table1.add(T_T_reach);
			table1.add(T_T_reach_r);
			
			//==================================================================================
			xJPanel0.setLayout(null);
			table1.setBounds(0,0,320,400);
			table1.setBorder(BorderFactory.createLineBorder(new Color( 75, 98, 145 ), 4));
			table1.setBackground(new Color( 0, 0, 0 ));
			JButton mar = new JButton("March");
			mar.setBounds(330, 0, 150, 75);
			mar.setHorizontalTextPosition(SwingConstants.LEFT);
			mar.setIconTextGap(1);
			mar.setFont(new Font("Segoe Print", Font.PLAIN, 24));
			mar.setBackground(new Color(201, 61, 197));
			mar.setBorderPainted(false);
			mar.addActionListener(this);
			xJPanel0.add(mar);

			mar.addActionListener(this);
			xJPanel0.add(table1);
			xJPanel0.setBackground(new Color(0,0,51));
			add(xJPanel0, Marching);
			view.revalidate();
			view.repaint();
		}

		if (Seigings.contains(xButton)) {
			JPanel xJPanel = new JPanel();
			int i = Seigings.indexOf(xButton);
			Army army = seigingArmies.get(i);
			currentArmy = army;
			City c1=null;
			for (City c:game.getAvailableCities()) {
				if (c.getName().equals(currentArmy.getCurrentLocation())) {
					c1=c;
				}
			}
			
			String[][] date = army.displaySeige(game.getAvailableCities());
			
			for (int j = 1; j < currentArmy.getUnits().size()+1; j++) {
				date[j][5]=c1.getTurnsUnderSiege()+"";
				
			}
			String[] columnNames = { "Type", "Level", "CurrentCount", "MaxCount", "City under Seige",
					"Turns to reach" };
			JTable table = new JTable(date, columnNames);
			table.setBounds(30, 40, 200, 300);
			JButton mar = new JButton("March");
			mar.setBounds(200, 150, 80, 40);
			xJPanel.add(mar);
			box = new JComboBox<String>();
			box.setBounds(200, 200, 80, 40);
			for (City city : game.getAvailableCities()) {
				// if(!game.getPlayer().getControlledCities().contains(city))
				box.addItem(city.getName());
			}
			mar.addActionListener(this);
			JButton attk = new JButton("Attack");
			attk.setBounds(200, 200, 80, 40);
			xJPanel.add(attk);
			attk.addActionListener(this);
//JButton siig=new JButton("Seige");
//siig.setBounds(200, 250, 80, 40);
//xJPanel.add(siig);
//siig.addActionListener(this);
			xJPanel.add(table);
//view.add(xJPanel);
			add(xJPanel, seigingJPanel);
			view.revalidate();
			view.repaint();
		}
		if (e.getActionCommand().equals("Build Farm")) {
			boolean flag = false;
			for (EconomicBuilding building : this.currentCity.getEconomicalBuildings()) {
				if (building instanceof Farm) {
					flag = true;
					currentEconomicBuilding = building;
				}
			}
			if (flag)
				Not.getL4().setText("Failed: You already have a Farm");
			else {
				try {
					game.getPlayer().build("farm", currentCity.getName());
					updatetreasury();
					Not.getL4().setText("a Farm was Built Successfully");
				} catch (NotEnoughGoldException e1) {
					Not.getL4().setText("Failed: Not enough Gold");
				}
			}
		}
		if (e.getActionCommand().equals("Build Market")) {
			boolean flag = false;
			for (EconomicBuilding building : this.currentCity.getEconomicalBuildings()) {
				if (building instanceof Market) {
					flag = true;
					currentEconomicBuilding = building;
				}
			}
			if (flag)
				Not.getL4().setText("Failed: You already have a Market");
			else {
				try {
					game.getPlayer().build("market", currentCity.getName());
					updatetreasury();
					Not.getL4().setText("a Market was Built Successfully");
				} catch (NotEnoughGoldException e1) {
					Not.getL4().setText("Failed: Not enough Gold");
				}
			}
		}
		if (e.getActionCommand().equals("Build Archery Range")) {
			boolean flag = false;
			for (MilitaryBuilding building : this.currentCity.getMilitaryBuildings()) {
				if (building instanceof ArcheryRange) {
					flag = true;
					currentMilitaryBuilding = building;
				}
			}
			if (flag)
				Not.getL4().setText("Failed: You already have a an Archery Range");
			else {
				try {
					game.getPlayer().build("archeryrange", currentCity.getName());
					updatetreasury();
					Not.getL4().setText("an Archery Range has Built Successfully");
				} catch (NotEnoughGoldException e1) {
					Not.getL4().setText("Failed: Not Enough Gold");
				}
			}
		}
		if (e.getActionCommand().equals("Build Barracks")) {
			boolean flag = false;
			for (MilitaryBuilding building : this.currentCity.getMilitaryBuildings()) {
				if (building instanceof Barracks) {
					flag = true;
					currentMilitaryBuilding = building;
				}
			}
			if (flag)
				Not.getL4().setText("Failed: You already have a Barracks");
			else {
				try {
					game.getPlayer().build("barracks", currentCity.getName());
					updatetreasury();
					Not.getL4().setText("a Barracks has Built Successfully");

				} catch (NotEnoughGoldException e1) {
					Not.getL4().setText("Failed: Not Enough Gold");
				}
			}
		}
		if (e.getActionCommand().equals("Build Stable")) {
			boolean flag = false;
			for (MilitaryBuilding building : this.currentCity.getMilitaryBuildings()) {
				if (building instanceof Stable) {
					flag = true;
					currentMilitaryBuilding = building;
				}
			}
			if (flag)
				Not.getL4().setText("Failed: You already have a Stable");
			else {
				try {
					game.getPlayer().build("stable", currentCity.getName());
					updatetreasury();
					Not.getL4().setText("a Stable has beeen Built Successfully");
				} catch (NotEnoughGoldException e1) {
					Not.getL4().setText("Failed: Not Enough Gold");
				}
			}
		}

		if (e.getActionCommand().equals("Upgrade Farm")) {
			try {
				game.getPlayer().upgradeBuilding(currentEconomicBuilding);
				updatetreasury();
				Not.getL4().setText("Farm Updated Successfully");
			} catch (NotEnoughGoldException e1) {
				Not.getL4().setText("failed: Not Enough Gold");
			} catch (BuildingInCoolDownException e2) {
				Not.getL4().setText("failed: Building is on CoolDown");
			} catch (MaxLevelException e3) {
				Not.getL4().setText("failed: Max level Upgrade");
			}
		}

		if (e.getActionCommand().equals("Upgrade Market")) {

			try {
				game.getPlayer().upgradeBuilding(currentEconomicBuilding);
				updatetreasury();
				Not.getL4().setText("The Market has Upgraded Successfully");
			} catch (NotEnoughGoldException e1) {
				Not.getL4().setText("Failed: Not Enough Gold");
			} catch (BuildingInCoolDownException e2) {
				Not.getL4().setText("Failed: Market is In Cool Down");
			} catch (MaxLevelException e3) {
				Not.getL4().setText("Failed: Market is already in Max Level");
			}
		}

		if (e.getActionCommand().equals("Upgrade Archery Range")) {

			try {
				game.getPlayer().upgradeBuilding(currentMilitaryBuilding);
				updatetreasury();
				Not.getL4().setText("The Archery Range has Upgraded Successfully");
			} catch (NotEnoughGoldException e1) {
				Not.getL4().setText("Failed: Not Enough Gold");
			} catch (BuildingInCoolDownException e2) {
				Not.getL4().setText("Failed: Archery Range is In Cool Down");
			} catch (MaxLevelException e3) {
				Not.getL4().setText("Failed: Archery Range is already in Max Level");
			}
		}

		if (e.getActionCommand().equals("Upgrade Barracks")) {

			try {
				game.getPlayer().upgradeBuilding(currentMilitaryBuilding);
				updatetreasury();
				Not.getL4().setText("The Barracks has Upgraded Successfully");
			} catch (NotEnoughGoldException e1) {
				Not.getL4().setText("Failed: Not Enough Gold");
			} catch (BuildingInCoolDownException e2) {
				Not.getL4().setText("Failed: Barracks is In Cool Down");
			} catch (MaxLevelException e3) {
				Not.getL4().setText("Failed: Barracks is already in Max Level");
			}
		}

		if (e.getActionCommand().equals("Upgrade Stable")) {

			try {
				game.getPlayer().upgradeBuilding(currentMilitaryBuilding);
				updatetreasury();
				Not.getL4().setText("The Stable has Upgraded Successfully");
			} catch (NotEnoughGoldException e1) {
				Not.getL4().setText("Failed: Not Enough Gold");
			} catch (BuildingInCoolDownException e2) {
				Not.getL4().setText("Failed: Stable is In Cool Down");
			} catch (MaxLevelException e3) {
				Not.getL4().setText("Failed: Stable is already in Max Level");
			}
		}

		if (e.getActionCommand().equals("Recruit Archer Unit")) {
			try {
				game.getPlayer().recruitUnit("archer", currentCity.getName());
				updatetreasury();
				Not.getL4().setText("an Archer Unit has recruited Successfully");
			} catch (BuildingInCoolDownException x) {
				Not.getL4().setText("Failed: Archery Range is In Cool Down");
			} catch (MaxRecruitedException y) {
				Not.getL4().setText("Failed: the Max Number Of Recuruitment has been Reached");
			} catch (NotEnoughGoldException z) {
				Not.getL4().setText("Failed: Not Enough Gold");
			}
		}
		if (e.getActionCommand().equals("Recruit Infantry Unit")) {
			try {
				game.getPlayer().recruitUnit("infantry", currentCity.getName());
				updatetreasury();
				Not.getL4().setText("an Infantry Unit has recruited Successfully");
			} catch (BuildingInCoolDownException x) {
				Not.getL4().setText("Failed: Barracks is In Cool Down");
			} catch (MaxRecruitedException y) {
				Not.getL4().setText("Failed: the Max Number Of Recuruitment has been Reached");
			} catch (NotEnoughGoldException z) {
				Not.getL4().setText("Failed: Not Enough Gold");
			}
		}
		if (e.getActionCommand().equals("Recruit Cavalry Unit")) {
			try {
				game.getPlayer().recruitUnit("cavalry", currentCity.getName());
				updatetreasury();
				Not.getL4().setText("an Cavalry Unit has recruited Successfully");
			} catch (BuildingInCoolDownException x) {
				Not.getL4().setText("Failed: Stable is In Cool Down");
			} catch (MaxRecruitedException y) {
				Not.getL4().setText("Failed: the Max Number Of Recuruitment has been Reached");
			} catch (NotEnoughGoldException z) {
				Not.getL4().setText("Failed: Not Enough Gold");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		GameGUI zGameGUI=new GameGUI();

	}

	public void add(JPanel p, JPanel w) {

		view.remove(Not);
		view.remove(gameinfo);
		view.remove(w);
		gameinfo.setBounds(0, 0, view.getWidth(), 70);
		gameinfo.setBackground(new Color( 0, 79, 134 ));
		Not.setBounds(300, 500, view.getWidth(), 75);
		p.setBounds(250, 75, view.getWidth(), 600);
		view.getContentPane().add(Not);
		view.getContentPane().add(p);
		view.getContentPane().add(gameinfo);

	}

	public void updatetreasury() {
		gameinfo.getL3()
				.setText("Treasury:  " + game.getPlayer().getTreasury() + "      food:  " + game.getPlayer().getFood());

	}

	public void updaterelocate() {
		int i = 1;
		cityview.getComboBox().removeAllItems();
		cityview.getComboBox2().removeAllItems();

		for (Army a : game.getPlayer().getControlledArmies()) {
			cityview.getComboBox().addItem("Army" + i);
			i++;
		}
		i = 1;
		for (Unit u : currentCity.getDefendingArmy().getUnits()) {
			cityview.getComboBox2().addItem("Unit" + i);
			i++;
		}
	}

	public void updatemanula() {
		int i = 1;
		battelview.getvBox().removeAllItems();
		for (Unit u : currentArmy.getUnits()) {
			battelview.getvBox().addItem("Unit" + i);
			i++;
		}

	}

	@Override
	public void ahmed1() {
		// TODO Auto-generated method stub
		
	}
	public void playSound(String sounName,boolean x)
	 {
	   try 
	   {
		   AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sounName).getAbsoluteFile( ));
		   Clip clip = AudioSystem.getClip( );
		   clip.open(audioInputStream);
		   clip.start( );
		   if(x) {
			   clip.loop(clip.LOOP_CONTINUOUSLY);
		   }
	   }
	   catch(Exception ex)
	   {
	     System.out.println("Error with playing sound.");
	     ex.printStackTrace( );
	   }
	 }
}

