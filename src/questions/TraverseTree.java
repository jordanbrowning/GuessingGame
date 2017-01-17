package questions;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

public class TraverseTree {
	
	// created from xml file reader to contain questions and teams
	private DefaultBinaryTree<String> questionTree;
	
	// current question or team displayed to user
	private BinaryTreeNode<String> currentQuestion;	
	
	/**
	 * Constructor for the Traverse Tree that initializes game tree
	 */
	public TraverseTree() {
		// get the binary tree with questions/answers
		QuestionFileReader reader = new QuestionFileReader();

		questionTree = reader.getQuestionTree();
	}

	/**
	 * Pulls the binary tree from the xml file reader
	 * Initializes first question 
	 */
	public void initGame() {

		// first question to be displayed to user
		currentQuestion = questionTree.getRoot();
	
	}
	
	
	/**
	 * Update the currentQuestion if the user chooses yes
	 */
	public void chooseYes() {
		
		currentQuestion = currentQuestion.getLeftChild();
	}
	
	/**
	 * Update the currentQuestion if the user chooses no
	 */
	public void chooseNo() {
		currentQuestion = currentQuestion.getRightChild();
	}

	/**
	 * Allows us to get the String data from the currentQuestion's node
	 * @return currentQuestion string 
	 */
	public String getCurrentQuestion() {
		return currentQuestion.getData();
	}
	
	/**
	 * Tells us if we are currently at a team
	 * @return isTeam true if currentQuestion is a team, false if not
	 */
	public boolean isTeam() {
		// every tree in the tree is a leaf
		return currentQuestion.isLeaf();
	}
	
	/**
	 * Replaces data at currentQuestion node (that is a team) with a new question,
	 * then it adds the team that was there to the right node (no) and a new team to 
	 * the left node (yes). This lets a user add in new data.
	 * @param question that will be the new question asked
	 * @param team that will be that question's left child
	 */
	public void addTeam(String team, String question) {
		
		// create node for new team
		DefaultBinaryTreeNode<String> left = new DefaultBinaryTreeNode<String>();
		left.setData("<html>Is it the<br>" + team + "?</html>");
		
		// this is the team that will be the no answer to the new question
		String noTeam = currentQuestion.getData();
		
		// put the no answer into a node
		DefaultBinaryTreeNode<String> right = new DefaultBinaryTreeNode<String>();
		right.setData(noTeam);
		
		// make the currentQuestion's node now hold new question
		currentQuestion.setData(question);
		
		// set new question's answer's to yes and no
		currentQuestion.setLeftChild(left);
		currentQuestion.setRightChild(right);
	}
}
