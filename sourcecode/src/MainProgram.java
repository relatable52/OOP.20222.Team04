
import controls.Game;
import gui.MainWindow;

public class MainProgram {
	public static void main(String[] args) {
		Game myGame = new Game();
		MainWindow myWindow = new MainWindow(myGame);
		
		while(true) {
			while(myWindow.getMode() == 2) {
				myWindow.redraw();
				myWindow.playGame();
			}
			for(int i=0; i<1000000; i++) {}
		}
	}
}
