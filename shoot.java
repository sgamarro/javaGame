package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class shoot {

	private int x;
	private int y;
	private int velocity;
	private int sizeX = 3;
	private int sizeY = 15;

	public shoot(int intX, int intY) {
		this.x = intX;
		this.y = intY;
		velocity = 10;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(x, y, sizeX, sizeY);
	}

	public void updating() {
		y -= velocity;

	}

	public boolean destroy() {
		return y < 0;
	}

	public boolean damage(Enemy enemy) {
		if (x >= enemy.getX() && x + sizeX <= enemy.getX() + enemy.getSize()) {
			if (y <= enemy.getY() + enemy.getSize()) {
				return true;
			}
		}
		return false;
	}

}
