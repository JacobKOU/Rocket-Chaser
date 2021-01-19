import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;


public class Dot {
	
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private Image image;

	public Dot() {
		loadImage();
		
		place();
	}
	
	private void loadImage() {
		
		ImageIcon imageURL = new ImageIcon("src/data/dot.png");
		image = imageURL.getImage();
		
		width = image.getWidth(null);
		height = image.getHeight(null);
		
	}
	
	public void place() {
		
		Random rng = new Random();
		
		x = rng.nextInt(700);
		y = rng.nextInt(700);
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	
}
