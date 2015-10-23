import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class carObject {
	BufferedImage carImage;
	String color;
	int x;
	int y;
	int sizeW;
	int sizeH; 
	int speed;
	int direction;
	int IMAGE;

	carObject(int X, int Y, int sizew, int sizeh) {
		//carImage = carImg;
		x = X;
		y = Y;
		sizeW = sizew; 
		sizeH = sizeh; 

	}

	public void xMove() {

		x++;

	}
	
}
