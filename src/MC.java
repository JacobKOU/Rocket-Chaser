import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;


public class MC {
	
	//used for movement
	private int dx;
	private int dy;
	
	//the amount of movement per key press
	private int changeX = 5;
	private int changeY = 5;
	
	//character position
	private int x = 0;
	private int y = 0;
	
	//width and height of image
	private int width;
	private int height;
	
	//image
	private Image image;
	
	public MC() {
		imageLoad();
	}
	
	private void imageLoad() {
		
		ImageIcon imageURL = new ImageIcon("src/data/rocket.png");
		image = imageURL.getImage();
		
		width = image.getWidth(null);
		height = image.getHeight(null);
		
		
	}
	
	public void move() {
		
		x += dx;
		y += dy;
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			dx = (-1 * changeX);
			//System.out.println("LEFT\t" + dx + "\t" + dy);
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = changeX;
			//System.out.println("RIGHT\t" + dx + "\t" + dy);
		}
		if (key == KeyEvent.VK_UP) {
			dy = (-1 * changeY);
			//System.out.println("UP\t" + dx + "\t" + dy);
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = changeY;
			//System.out.println("DOWN\t" + dx + "\t" + dy);
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		
		//System.out.println(dx + "\t" + dy);
		
	}

}
