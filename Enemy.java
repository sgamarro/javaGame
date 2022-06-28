package SpaceGame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {

	private BufferedImage desing;
	private int x;
	private int y;
	private double velocity;
	private int direction;

	public Enemy(int intX, int intY, int direction) {
		try {
			desing = ImageIO.read(new File("images/invader.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.x = intX;
		this.y = intY;
		this.direction = direction;
		this.velocity = 3.5;
	}

	public void updateE() {
		x += velocity * direction;

	}

	public void chooseDirection() {
		direction = direction * -1;
		y += 25;

	}
	
	public int getX() {
		return x;
	}

	
	public int getY() {

		return y;
	}


	public void paint(Graphics2D g) {
		g.drawImage(desing, x, y, x + 50, y + 50, 0, 0, desing.getWidth(), desing.getHeight(), null);
	}


	public int getSize() {
		return 50;
	}

	
}
