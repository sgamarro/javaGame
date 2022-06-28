package SpaceGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener {

	private Font myFont = new Font ("WIN", Font.BOLD, 20);
	private spaceShip spaceShip;
	private int direction;
	private ArrayList<shoot> actualShoot;
	private ArrayList<Enemy> enemy;
	private Backgroung backgound;
	private boolean win;
	private boolean loose;

	// constructor
	public SpaceInvaders() {

		spaceShip = new spaceShip();
		actualShoot = new ArrayList<shoot>();
		enemy = new ArrayList<Enemy>();
		backgound = new Backgroung(); 
		win = false;
		loose = false;
		for (int i = 0; i < 60; i++) {
			enemy.add(new Enemy(50 + i % 20 * 50, 50 + i / 20 * 50, 1));
		}

		Thread gameLoop = new Thread(this);
		gameLoop.start();

	}

	@Override
	public void run() {
		while (true) {
		
			update();
			repaint();
			sleep();
			
			
		}
	}

	private void update() {
		
		if (enemy.size() == 0) {
			win = true ;
		}

		spaceShip.movement(direction);
		for (int i = 0; i < enemy.size(); i++) {
			enemy.get(i).updateE();
			
			if(enemy.get(i).getY() >= 768 - 100) {
				loose = true;
			}
		}

		for (int i = 0; i < actualShoot.size(); i++) {
			actualShoot.get(i).updating();

			if (actualShoot.get(i).destroy()) {
				actualShoot.remove(i);
				i--;
			}else {

			for (int j = 0; j < enemy.size(); j++) {
				if (actualShoot.get(i).damage(enemy.get(j))) {
					enemy.remove(j);
					j--;
					actualShoot.remove(i);
				   break;
				}
				
			}
		}
		}
		
		for (int i = 0; i < enemy.size(); i++) {

			if (enemy.get(i).getX() < 0 || enemy.get(i).getX() >= 1290 - 50) {
				for (int j = 0; j < enemy.size(); j++) {
					enemy.get(j).chooseDirection();
				}
				break;
			}
		}
	}

	int x = 0;

	public void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		
	

		Graphics2D g = (Graphics2D) g2.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		backgound.paint(g);
		
		for (int i = 0; i < enemy.size(); i++) {

			enemy.get(i).paint(g);
		}
		spaceShip.paint(g);
		for (int i = 0; i < actualShoot.size(); i++) {
			actualShoot.get(i).paint(g);
		}
		
		if (win) {
			g.setColor(Color.white);
			g.setFont(myFont);
			g.drawString("YOU WON THE GAME!!!", 1336/2 - 100, 768 /2);
		}
		
		if (loose) {
			g.setColor(Color.white);
			g.setFont(myFont);
			g.drawString("GAME OVER", 1336/2 - 100, 768 /2);
		}
	
	}

	private void sleep() {

		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_D) {
			direction = 1;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			direction = -1;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE && spaceShip.enableShoot()) {
			actualShoot.add(spaceShip.weapon());

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_D) {
			direction = 0;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			direction = 0;
		}

	}

}
