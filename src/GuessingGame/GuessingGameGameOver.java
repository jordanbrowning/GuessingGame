package GuessingGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* Creates the guessing game game over panel
* @author browning
*/

public class GuessingGameGameOver extends JPanel {
	// lets us access the controller of the cards
	MakeCardLayout parent;

	/**
	 * Constructor for the guessing game game over 
	 */
	public GuessingGameGameOver(MakeCardLayout parent, boolean rightTeam) {
		
		// create the border layout 
		super(new BorderLayout()); 
		
		
		// creates the label with the message if the computer won or lost
		add(createMessage(rightTeam), BorderLayout.WEST);
		
		// creates the background
		add(createBackground(rightTeam), BorderLayout.EAST);
		
		// creates the button to restart the game
		add(createRestartButton(), BorderLayout.SOUTH);
		
		this.parent = parent;	
	}
	
	/**
	 * Creates a message if the computer got the user's team right or wrong
	 * @param rightTeam true if computer got it right, false if wrong
	 * @return messageLabel for the message shown to user
	 */
	private JLabel createMessage(boolean rightTeam) {
		JLabel messageLabel;
		
		if(rightTeam) {
			messageLabel = new JLabel("<html>Nice, we knew what<br>you were thinking.</html>");
		}
		
		else {
			messageLabel = new JLabel("Oops! Couldn't figure it out.");
		}
		
		messageLabel.setFont(new Font("Chalkboard", Font.BOLD, 30));
		messageLabel.setForeground(new Color(240, 255, 255));
		
		return messageLabel;
	}
	
	/**
	 * Creates the image label 
	 * @return imageLabel with the image 
	 */
	private JLabel createBackground(boolean rightTeam) {
		
		ImageIcon icon = new ImageIcon();
		JLabel pictureLabel = new JLabel();
		
		// celebration background if we got the right team
		if(rightTeam) {
			icon = new ImageIcon("images/happy.jpg");
			pictureLabel = new JLabel(icon);
		}
		
		// sad background if not
		else {
			icon = new ImageIcon("images/sad.jpg");
			pictureLabel = new JLabel(icon);
		}
		
		return pictureLabel;
	}
	
	
	
	/**
	 * Creates the button that will let us restart the game
	 * @return restart button
	 */
	private JButton createRestartButton() {
		// create restart button
		JButton restartButton = new JButton();
		restartButton.setText("restart game");
		restartButton.setBackground(Color.BLUE);
		restartButton.setBorderPainted(false);
		restartButton.setOpaque(true);
		// add action listener
		restartButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	parent.restartGame();
		    }
		});
		
		return restartButton; 
	}
	
}
