package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class HelpPage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow pa;
	private BackGroundDrawer bg;
	private JPanel pane;
	
	public HelpPage(MainWindow m) {
		this.pa = m;
		this.bg = new BackGroundDrawer(this);
		JLabel content = new JLabel("<html>"
				+ "<h1>How to play</h1>"
				+ "<p>"
				+ "Hover the cursor over one of five square in your side.<br>"
				+ "The square will turn blue if it's a valid move.<br>"
				+ "An arrow will appear depends on whether the cursor is to the left or the right of the square, indicating the direction of the move.<br>"
				+ "You click on the square to make your move.<br>"
				+ "The game ends when both big cells are emptied.<br>"
				+ "</p>"
				+ "<h1>Hướng dẫn chơi game</h1>"
				+ "<p>"
				+ "Đưa chuột lên một trong năm ô thuộc về bên của bạn.<br>"
				+ "Ô đó sẽ chuyển màu xanh dương.<br>"
				+ "Nếu bạn đưa chuột về bên phải ô sẽ hiện lên ▶, nếu đưa chuột về bên trái ô sẽ hiện lên ◀, tương ứng với chiều rải quân.<br>"
				+ "Bạn click chuột để thực hiện nước đi của mình.<br>"
				+ "Trò chơi kết thúc khi hai ô quan đã được ăn hết.<br>"
				+ "</html>");
		content.setBorder(new EmptyBorder(50, 50, 50, 50));
		
		JButton back = new JButton("Back");
		ActionListener goBack = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pa.backToMain();
				//System.out.println("2");
			}
		};
		back.addActionListener(goBack);
		
		content.setAlignmentX(CENTER_ALIGNMENT);
		back.setAlignmentX(CENTER_ALIGNMENT);	
		
		pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(content);
		pane.add(back);
		pane.setOpaque(false);
		
		setLayout(new FlowLayout());
		add(pane);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.bg.setMyG(g);
		this.bg.draw();
	}
}
