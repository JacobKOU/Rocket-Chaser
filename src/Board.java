import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

import javax.swing.JPanel;
import javax.swing.*;





public class Board extends JPanel implements ActionListener {
	
	private Timer timer;
	private MC mc; //main rocket ship
	private final int DELAY = 10;
	private Dot target; //target object
	
	//used for detecting collisions
	private boolean collision = false;
	private int collision_close_enough;
	
	public Board() {
		
		initBoard();
		
	}
	
	private void initBoard() {
		
		addKeyListener( new TAdapter() ); //used to notice buttons
		setBackground(Color.BLACK); //black background
		setFocusable(true);
		
		//makes the two playable objects
		mc = new MC();
		target = new Dot();
		
		//how close does the rocket need to get to set off a collision?
		collision_close_enough = mc.getWidth();
		
		//used for moving (moves every timer)
		timer = new Timer(DELAY, this);
		timer.start();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing(Graphics g) { //used to update the screen
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(mc.getImage(), mc.getX(), mc.getY(), this);
		g2d.drawImage(target.getImage(), target.getX(), target.getY(), this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
	
	private void step() { //move the rocket and figure out if a collision is happening
		
		mc.move(); //move player
		
		//"clean" up the player's movement
		repaint(mc.getX()-100, mc.getY()-100, mc.getWidth()+1000, mc.getHeight()+1000);
		
		// ( (mc.getX >= target.getX - 10) && (mc.getX <= target.getX + 10) && (mc.getY >= target.getY - 10) && (mc.getY <= target.getY + 10) )
		//System.out.println("MC:\t" + mc.getX() + "\t" + mc.getY() + "\nTarget:\t" + target.getX() + "\t" + target.getY() );
		
		//did a collision happen?
		if ( (mc.getX() >= target.getX() - collision_close_enough) && (mc.getX() <= target.getX() + collision_close_enough) && (mc.getY() >= target.getY() - collision_close_enough) && (mc.getY() <= target.getY() + collision_close_enough) ) {
			collision = true;
		}
		
		if (collision == true) { //if collision is happening
			target.place(); //put target in a different place
		
			//clean up where target was previously
			repaint(target.getX()-100, target.getY()-100, target.getWidth()+1000, target.getHeight()+1000);
			
			//don't want a million collisions every second now don't we?
			collision = false;
		}
		
		
		
	}
	
	private class TAdapter extends KeyAdapter { //used to detect button pressed and releases
		
		@Override
		public void keyReleased(KeyEvent e) {
			mc.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			mc.keyPressed(e);
		}
		
	}
	
}
