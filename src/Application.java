import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Application extends JFrame {
	
	//width and height of window
	public int width = 1000;
	public int height = 1000;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });

	}
	
	public Application() {
		
		user_interface();
		
	}
	
	private void user_interface() {
		
		add(new Board() );
		
		setSize( width, height);
		
		setTitle("Game 1");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
	}

}
