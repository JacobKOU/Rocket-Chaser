import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

import javax.swing.JPanel;
import javax.swing.*;





public class Board extends JPanel implements ActionListener {
	
	private Timer timer;
	private MC mc;
	private final int DELAY = 10;
	private Dot target;
	
	private boolean collision = false;
	private int collision_close_enough;
	
	public Board() {
		
		initBoard();
		
	}
	
	private void initBoard() {
		
		addKeyListener( new TAdapter() );
		setBackground(Color.BLACK);
		setFocusable(true);
		
		mc = new MC();
		target = new Dot();
		
		collision_close_enough = mc.getWidth();
		
		timer = new Timer(DELAY, this);
		timer.start();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(mc.getImage(), mc.getX(), mc.getY(), this);
		g2d.drawImage(target.getImage(), target.getX(), target.getY(), this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
	
	private void step() {
		
		mc.move();
		
		repaint(mc.getX()-100, mc.getY()-100, mc.getWidth()+1000, mc.getHeight()+1000);
		
		// ( (mc.getX >= target.getX - 10) && (mc.getX <= target.getX + 10) && (mc.getY >= target.getY - 10) && (mc.getY <= target.getY + 10) )
		//System.out.println("MC:\t" + mc.getX() + "\t" + mc.getY() + "\nTarget:\t" + target.getX() + "\t" + target.getY() );
		if ( (mc.getX() >= target.getX() - collision_close_enough) && (mc.getX() <= target.getX() + collision_close_enough) && (mc.getY() >= target.getY() - collision_close_enough) && (mc.getY() <= target.getY() + collision_close_enough) ) {
			collision = true;
		}
		
		if (collision == true) {
			target.place();
		
			repaint(target.getX()-100, target.getY()-100, target.getWidth()+1000, target.getHeight()+1000);
			
			collision = false;
		}
		
		
		
	}
	
	private class TAdapter extends KeyAdapter {
		
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
