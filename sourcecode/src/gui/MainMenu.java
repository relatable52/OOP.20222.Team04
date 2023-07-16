package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainMenu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton start;
	private JButton help;
	private JButton exit;
	private JLabel title;
	private MainWindow pa;
	private BackGroundDrawer bg;
	
	public MainMenu(MainWindow pa) {
		this.pa = pa;
		this.bg = new BackGroundDrawer(this);
		
		title = new JLabel("Ô Ăn Quan", JLabel.CENTER);
		title.setFont(new Font("SansSerif", Font.BOLD, 60));
		
		start = new JButton("New game");
		help = new JButton("Help");
		exit = new JButton("Exit");
		
		ActionListener startGame = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pa.newGame();
			}
		};
		
		ActionListener openHelp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pa.showHelp();
			}
		};
		
		ActionListener exitGame = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pa.exitGame();
			}
		};
		
		start.addActionListener(startGame);
		help.addActionListener(openHelp);
		exit.addActionListener(exitGame);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Insets in = new Insets(10, 10, 10, 10);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		//c.ipady = 50;
		add(title, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = in;
		add(start, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.insets = in;
		add(help, c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.insets = in;
		add(exit, c);
		
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		bg.setMyG(g);
		bg.draw();
	}
}
