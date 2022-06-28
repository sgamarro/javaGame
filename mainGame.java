package SpaceGame;

import javax.swing.JFrame;

public class mainGame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Space Invaders");
		frame.setSize(1366, 768);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpaceInvaders newGame = new SpaceInvaders();
		newGame.setBounds(0, 0, 1366, 768);
		frame.add(newGame);
		frame.addKeyListener(newGame);
		frame.setVisible(true);
		
		
	}

}
