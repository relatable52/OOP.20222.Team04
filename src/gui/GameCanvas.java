package gui;

import controls.board.*;
import controls.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameCanvas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoardDrawer myBD;
	private PlayerDrawer myPD;
	private JButton back;
	private JPanel p;
	private MainWindow pa;
	private BackGroundDrawer bg;
	
	public GameCanvas(Board myBoard) {
		this.myBD = new BoardDrawer(myBoard, this);
	}
	public GameCanvas(Game myGame, MainWindow pa) {
		this.pa = pa;
		this.myBD = new BoardDrawer(myGame, this);
		this.myPD = new PlayerDrawer(myGame, this);
		this.bg = new BackGroundDrawer(this);
		
		ActionListener goBack = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confirm quit", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
					pa.backToMain();
				}
			}
		};
		
		setLayout(new BorderLayout());
		
		this.back = new JButton("Quit");
		this.back.addActionListener(goBack);
		
		this.p = new JPanel();
		p.setLayout(new FlowLayout());
		p.setOpaque(false);
		
		this.p.add(this.back);
		add(this.p, BorderLayout.EAST);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.setBackground(new Color(0,0,0,0));
		
		this.myBD.setMyG(g);
		this.myPD.setMyG(g);
		this.bg.setMyG(g);
		
		this.bg.draw();
		this.myBD.draw();
		this.myPD.draw();

	}
}
