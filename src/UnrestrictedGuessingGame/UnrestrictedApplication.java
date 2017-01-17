package UnrestrictedGuessingGame;
/**
* Runs the unrestricted guessing game application
* @author browning
*/

import javax.swing.JFrame;

public class UnrestrictedApplication {
	
	/**
	 * Creates the ice cream application
	 */
	public static void main(String[] args) {


		// create a new JFrame to hold ice cream maker 
		JFrame guiFrame = new JFrame( "Unrestricted Guessing Game");
	
		// set size
		guiFrame.setSize( 900, 500 );
		
		guiFrame.add(new UnrestrictedCardLayout());
		
		
		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		// show frame
		guiFrame.setVisible( true );
	}
}
