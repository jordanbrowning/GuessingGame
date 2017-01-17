package UnrestrictedGuessingGame;

import java.awt.CardLayout;
import GuessingGame.MakeCardLayout;

/**
* Makes the card layout which lets us
* switch from introduction to the question pages
* @author browning
*/

public class UnrestrictedCardLayout extends MakeCardLayout {
	
	/**
	 * Constructor for the making the card layout
	 */
	public UnrestrictedCardLayout() {
		// get the card panel
		super(); 
	}

	/**
	 * @override
	 * Switches the panel shown to unrestricted game over panel
	 */
	public void switchToGameOver(boolean rightTeam) {
		add(new UnrestrictedGameOver(this, rightTeam), "GameOver");
		
		CardLayout cardLayout = (CardLayout) this.getLayout();
		cardLayout.show(this, "GameOver");
	}	
	
	/**
	 * Switches the panel shown to add team panel
	 */
	public void switchToAddTeam() {
		add(new UnrestrictedAddTeam(this, traverser), "AddTeam");
		
		CardLayout cardLayout = (CardLayout) this.getLayout();
		cardLayout.show(this, "AddTeam");
	}	
	
}
