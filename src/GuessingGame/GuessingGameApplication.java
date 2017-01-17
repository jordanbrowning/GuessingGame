package GuessingGame;
/**
* Runs the guessing game application
* @author browning
*/

import javax.swing.JFrame;

public class GuessingGameApplication {
	
	/**
	 * Creates the ice cream application
	 */
	public static void main(String[] args) {


		// create a new JFrame to hold ice cream maker 
		JFrame guiFrame = new JFrame("Guessing Game");
	
		// set size
		guiFrame.setSize( 900, 500 );

		
		guiFrame.add(new MakeCardLayout());
		
		
		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		// show frame
		guiFrame.setVisible( true );
	}
}
