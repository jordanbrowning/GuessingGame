package GuessingGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* Creates the guessing game introduction panel
* @author browning
*/

public class GuessingGameIntro extends JPanel {
	
	// lets us access the controller of the cards
	MakeCardLayout parent;

	/**
	 * Constructor for the guessing game introduction 
	 */
	public GuessingGameIntro(MakeCardLayout parent) {
		
		// create the border layout 
		super(new BorderLayout()); 
		
		// creates label with title and picture
		add(createTitle(), BorderLayout.WEST);
		
		// create label with picture
		add(createBackground(), BorderLayout.EAST);
		
		// creates JPanel with start game and instructions buttons
		add(createButtonPanel(), BorderLayout.SOUTH);
		
		this.parent = parent;

		
	}

	/**
	 * Creates the title label 
	 * @return titleLabel with the title 
	 */
	private JLabel createTitle() {
		
		// create title label
		JLabel titleLabel = new JLabel("20 Questions: MLB Teams Edition");
		titleLabel.setFont(new Font("Chalkduster", Font.BOLD, 45));
		titleLabel.setForeground(new Color(240, 255, 255));
		
		return titleLabel; 
	}
	
	/**
	 * Creates the image label 
	 * @return imageLabel with the image 
	 */
	private JLabel createBackground() {
		// create image for title panel
		ImageIcon icon = new ImageIcon("images/field.jpg");
		JLabel pictureLabel = new JLabel(icon);
		
		return pictureLabel;
	}
	
	/**
	 * Creates the button that will let us start the game and see instructions
	 * @return buttonPanel that has start and instructions buttons
	 */
	private JPanel createButtonPanel() {
		
		// create start button
		JButton startButton = new JButton();
		startButton.setText("Start game!");
		startButton.setBackground(Color.GREEN);
		startButton.setBorderPainted(false);
		startButton.setOpaque(true);
		// add action listener
		startButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	parent.switchToQuestions();
		    }
		});
		
		// create button that displays instructions
		JButton instructionsButton = new JButton();
		instructionsButton.setText("Instructions");
		instructionsButton.setBackground(Color.YELLOW);
		instructionsButton.setBorderPainted(false);
		instructionsButton.setOpaque(true);
		// add action listener
		instructionsButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	parent.switchToInstructions();
		    }
		});
		
		//create panel to house buttons
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.add(startButton);
		buttonPanel.add(instructionsButton);
		
		return buttonPanel; 
	}
}
