package SpaceGame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

public class spaceShip {

	private BufferedImage desing;

	private int x;
	private int velocity;
	private boolean enableShoot;
	private int time;

	public spaceShip() {
		try {
			desing = ImageIO.read(new File("images/Spaceship-PNG-File.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		x = 683;
		velocity = 5;
		enableShoot = true;
	}

	public void paint(Graphics2D g) {
		// image position x, y, sizeX, sizeY
		g.drawImage(desing, x, 500, x + 100, 500 + 100, 0, 0, desing.getWidth(), desing.getHeight(), null);

	}

	public shoot weapon() {
		
		enableShoot = false;
		time = 0;
		
		shoot bullet = new shoot(x + 49, 500);
		return bullet;
	}
	
	
	public void movement(int value) {

		if (value == 1) {
			x+= velocity;
		} else if (value == -1) {
			x-= velocity;
		}
		
		if(time >= 10) {
			enableShoot = true;
			time = 0;
		}
		
		time++;
				
	}
	public boolean enableShoot() {
		return enableShoot;
	}
}
