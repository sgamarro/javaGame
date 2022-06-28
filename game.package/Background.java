package SpaceGame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Backgroung {

	private BufferedImage image;
	private int y;
	
	
	public Backgroung() {
		try {
			image = ImageIO.read(new File("images/space.jpg"));
		} catch (IOException e) {
			System.out.println("Cant process background");
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics2D g) {
		
		
		g.drawImage(image, 0, y, 1366, image.getHeight(), null);
		
		y += 3;
		
		if(y< 768 * 2 )
			y=0;
	}
	
	
}
