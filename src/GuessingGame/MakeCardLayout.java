package GuessingGame;

import java.awt.CardLayout;
import javax.swing.JPanel;

import questions.TraverseTree;

/**
* Makes the card layout which lets us
* switch from introduction to the question pages
* @author browning
*/

public class MakeCardLayout extends JPanel{
	
	// goes through the binary tree object of our questions/teams
	protected TraverseTree traverser = new TraverseTree();
	
	/**
	 * Constructor for the making the card layout
	 */
	public MakeCardLayout() {
		// create the card layout 
		super(new CardLayout()); 
	
		add(new GuessingGameIntro(this), "Intro");
		add(new GuessingGameInstructions(this), "Instructions");
		add(new GuessingGameQuestions(this, traverser), "Question");
		
	}
	
	/**
	 * Switches the panel shown to intro panel
	 */
	public void switchToIntro() {
		CardLayout cardLayout = (CardLayout) this.getLayout();
		cardLayout.show(this, "Intro");
	}	
	
	
	/**
	 * Switches the panel shown to instructions panel
	 */
	public void switchToInstructions() {
		CardLayout cardLayout = (CardLayout) this.getLayout();
		cardLayout.show(this, "Instructions");
	}	
	
	/**
	 * Switches the panel shown to questions panel
	 */
	public void switchToQuestions() {
		CardLayout cardLayout = (CardLayout) this.getLayout();
		cardLayout.show(this, "Question");
	}	
	
	/**
	 * Switches the panel shown to game over panel
	 */
	public void switchToGameOver(boolean rightTeam) {
		add(new GuessingGameGameOver(this, rightTeam), "GameOver");
		
		CardLayout cardLayout = (CardLayout) this.getLayout();
		cardLayout.show(this, "GameOver");
	}	
	
	/**
	 * Restarts the game
	 */
	public void restartGame() {
		add(new GuessingGameQuestions(this, traverser), "Question");
		
		switchToIntro();
	}
	
}
