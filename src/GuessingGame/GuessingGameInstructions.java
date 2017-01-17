package GuessingGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* Creates the guessing game instructions panel
* @author browning
*/

public class GuessingGameInstructions extends JPanel {
	
	// lets us access the controller of the cards
	MakeCardLayout parent;

	/**
	 * Constructor for the guessing game introduction 
	 */
	public GuessingGameInstructions(MakeCardLayout parent) {
		
		// create the border layout 
		super(new BorderLayout()); 
		
		// creates label with instructions
		add(createInstructions(), BorderLayout.NORTH);
		
		// create panel with list of teams
		add(createList(), BorderLayout.CENTER);
		
		// create button to resume game
		add(createResumeButton(), BorderLayout.SOUTH);
		
		this.parent = parent;

		
	}

	/**
	 * Creates the title label 
	 * @return titleLabel with the title 
	 */
	private JLabel createInstructions() {
		
		String instructions = "<html>Please choose a team from the list below and<br>answer the questions accordingly</html>";
	
		JLabel instructionsLabel = new JLabel(instructions);
		instructionsLabel.setFont(new Font("Chalkduster", Font.BOLD, 30));
		instructionsLabel.setForeground(Color.BLACK);
		
		return instructionsLabel; 
	}
	
	/**
	 * Creates the list of teams panel 
	 * @return listPanel 
	 */
	private JPanel createList() {
		
		JPanel listPanel = new JPanel(new GridLayout(1,3));
		
		// broken down into three different lists to best fit on panel
		String list1 = "<html> Arizona Diamondbacks <br> Atlanta Braves <br> Baltimore Orioles <br> Boston Red Sox <br> Chicago Cubs <br>"
				+ "Chicago White Sox <br> Cincinnati Reds <br> Cleveland Indians <br> Colorado Rockies <br> Detroit Tigers  </html>";
		String list2 = "<html> Houston Astros <br>Kansas City Royals <br> Los Angeles Angels <br> Los Angeles Dodgers <br> Miami Marlins <br>"
				+ "Milwaukee Brewers <br> Minnesota Twins <br> New York Mets <br> New York Yankees <br> Oakland Athletics </html>";
		String list3 = "<html> Philadelphia Phillies <br> Pittsburgh Pirates <br> San Diego Padres <br> San Francisco Giants <br> Seattle Mariners <br>"
				+ "St. Louis Cardinals <br> Tampa Bay Rays <br> Texas Rangers <br> Toronto Blue Jays <br>Washington Nationals </html>";

		JLabel listLabel1 = new JLabel(list1);
		listLabel1.setFont(new Font("Chalkboard", Font.BOLD, 15));
		listLabel1.setForeground(Color.BLUE);
		
		JLabel listLabel2 = new JLabel(list2);
		listLabel2.setFont(new Font("Chalkboard", Font.BOLD, 15));
		listLabel2.setForeground(Color.BLUE);
		
		JLabel listLabel3 = new JLabel(list3);
		listLabel3.setFont(new Font("Chalkboard", Font.BOLD, 15));
		listLabel3.setForeground(Color.BLUE);
		
		// add the three lists to the panel
		listPanel.add(listLabel1);
		listPanel.add(listLabel2);
		listPanel.add(listLabel3);
		
		return listPanel;
	}
	
	/**
	 * Creates the button that will let us resume the game
	 * @return resume button that switches to questions panel
	 */
	private JButton createResumeButton() {
		
		// create resume button
		JButton resumeButton = new JButton();
		resumeButton.setText("Resume game");
		resumeButton.setBackground(Color.YELLOW);
		resumeButton.setBorderPainted(false);
		resumeButton.setOpaque(true);
		// add action listener
		resumeButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	parent.switchToQuestions();
		    }
		});
		
		return resumeButton;
	}
}
