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

import questions.TraverseTree;

/**
* Creates the guessing game questions panel
* @author browning
*/

public class GuessingGameQuestions extends JPanel {
	
	// goes through the binary tree object of our questions/teams
	private TraverseTree traverser;
	
	// lets us access the controller of the cards
	MakeCardLayout parent;
	
	// where the current question is shown
	JLabel questionLabel;
	
	/**
	 * Constructor for the guessing game questions 
	 */
	public GuessingGameQuestions(MakeCardLayout parent, TraverseTree traverser) {
		
		// create the border layout 
		super(new BorderLayout()); 
		
		this.traverser = traverser;
		
		// show first question
		traverser.initGame();
		
		// create JButton for instructions 
		add(createInstructionsButton(), BorderLayout.NORTH);
		
		// create question 
		questionLabel = createQuestion();
		add(questionLabel, BorderLayout.WEST);
		
		// add background
		add(createBackground(), BorderLayout.EAST);
		
		// creates JPanel that has yes/no buttons
		add(createChoiceButtonPanel(), BorderLayout.SOUTH);	
		
		this.parent = parent;
	
	}
	
	/**
	 * Creates instructions button
	 * @return instructionsButton that goes to instructions
	 */
	private JButton createInstructionsButton() {
		
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
		
		return instructionsButton;
	}
	
	/**
	 * Creates the question label 
	 * @return questionLabel with the current question/team
	 */
	private JLabel createQuestion() {
		// create question label
		JLabel questionLabel = new JLabel(traverser.getCurrentQuestion());
		questionLabel.setFont(new Font("Chalkboard", Font.BOLD, 30));
		questionLabel.setForeground(new Color(240, 255, 255));
		
		return questionLabel; 
	}
	
	/**
	 * Creates the image label 
	 * @return imageLabel with the image 
	 */
	private JLabel createBackground() {
		ImageIcon icon = new ImageIcon("images/baseball.jpg");
		JLabel pictureLabel = new JLabel(icon);
		
		return pictureLabel;
	}
	
	/**
	 * Creates panel with the buttons to let user choose yes or no
	 * @return buttonPanel
	 */
	private JPanel createChoiceButtonPanel() {
		
		// create yes button
		JButton yesButton = new JButton("Yes");
		yesButton.setBackground(Color.GREEN);
		yesButton.setBorderPainted(false);
		yesButton.setOpaque(true);
		// add action listener
		yesButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	// if we're at a team -- go to game over page
		    	if(traverser.isTeam()) {
		    		parent.switchToGameOver(true);
		    	}
		    	
		    	// otherwise go to next question/team
		    	else {
			    	traverser.chooseYes();
			    	refreshDisplay();
		    	}
		    }
		});
		
		// create no button
		JButton noButton = new JButton("No");
		noButton.setBackground(Color.RED);
		noButton.setBorderPainted(false);
		noButton.setOpaque(true);
		// add action listener
		noButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	// if we're at a team -- go to game over page
		    	if(traverser.isTeam()) {
		    		parent.switchToGameOver(false);
		    	}
		    	
		    	// otherwise go to next question/team
		    	else {
			    	traverser.chooseNo();
			    	refreshDisplay();
		    	}
		    }
		});
		
		// create panel for buttons to go on
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		
		return buttonPanel;
	}

	
	/**
	 * Refreshes the question shown to user
	 */
	private void refreshDisplay() {
	    questionLabel.setText(traverser.getCurrentQuestion());
	}

}
