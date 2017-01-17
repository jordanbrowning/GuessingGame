package UnrestrictedGuessingGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import GuessingGame.MakeCardLayout;
import questions.TraverseTree;

/**
* Creates the unrestricted guessing game add team panel
* @author browning
*/

public class UnrestrictedAddTeam extends JPanel{
	// lets us access the controller of the cards
	MakeCardLayout parent;
	
	// goes through the binary tree object of our questions/teams
	private TraverseTree traverser;
	
	// where the user inputs a new question
	JTextField questionTF;
	
	// where the user inputs a new team
	JTextField teamTF;

	/**
	 * Constructor for the unrestricted guessing game game over 
	 */
	public UnrestrictedAddTeam(UnrestrictedCardLayout parent, TraverseTree traverser) {
		
		// create the border layout 
		super(new BorderLayout()); 
		
		// add instructions
		add(createInstructions(), BorderLayout.NORTH);
		
		// add labels and text fields
		add(createFields(), BorderLayout.CENTER);
		
		// add submit button
		add(createSubmitButton(), BorderLayout.SOUTH);
		
		this.parent = parent;	
		this.traverser = traverser;
	}

	/**
	 * Creates the label that has the instructions
	 * @return instructionsLabel 
	 */
	private JLabel createInstructions() {
		JLabel instructionsLabel = new JLabel("<html>Below put in the new team and the new question<br>that "
				+ "will differentiate between your team and the team we guessed.</html>");
		
		instructionsLabel.setFont(new Font("Chalkduster", Font.BOLD, 30));
		
		return instructionsLabel;
	}
	
	/**
	 * Creates the panel that houses the labels for the new inputs
	 * @return label panel
	 */
	private JPanel createFields() {
		// create the labels
		JLabel teamLabel = new JLabel("New Team:");
		teamLabel.setFont(new Font("Chalkboard", Font.BOLD, 20));
		teamLabel.setForeground(Color.BLUE);
		
		JLabel questionLabel = new JLabel("New Question:");
		questionLabel.setFont(new Font("Chalkboard", Font.BOLD, 20));
		questionLabel.setForeground(Color.BLUE);
		
		// initialize the text fields
		teamTF = new JTextField(10);
		questionTF = new JTextField(10);
		
		// create the panel for the labels and text fields
		JPanel fieldsPanel = new JPanel(new GridLayout(2,2));
		fieldsPanel.add(teamLabel);
		fieldsPanel.add(teamTF);
		fieldsPanel.add(questionLabel);
		fieldsPanel.add(questionTF);
		
		return fieldsPanel;
	}
	
	/**
	 * Creates the button that lets the user submit new info
	 * @return submit button
	 */
	private JButton createSubmitButton() {
		// create submit button
		JButton submitButton = new JButton("submit new information");
		submitButton.setBackground(Color.pink);
		submitButton.setBorderPainted(false);
		submitButton.setOpaque(true);
		// add action listener
		submitButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	// add in new team/question
		    	traverser.addTeam(teamTF.getText(), questionTF.getText());
		    	
		    	// now restart the game with the new team
		    	parent.restartGame();
		    }
		});

		return submitButton;
	}
	
}
