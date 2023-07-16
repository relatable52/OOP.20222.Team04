package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackGroundDrawer extends Drawer{
	private BufferedImage bg = null;

	public BackGroundDrawer(JPanel myPa) {
		super(myPa);
		String path = new File("").getAbsolutePath();
		path += "\\Assets\\background.jpg";
		try {
			this.bg = ImageIO.read(new File(path));
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw() {
		this.myG.drawImage(bg, 0, 0, this.width, this.height, this.myPa);
	}

}
