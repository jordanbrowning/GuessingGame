package questions;

/**
* Reads the questions.xml file with the
* guessing game questions
* @author browning
*/

import javax.xml.parsers.*;

import org.xml.sax.SAXException;

import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

import org.w3c.dom.*;

import java.io.*;

public class QuestionFileReader {

	// the tree that the xml file is parsed into
	// has questions and answers
	private DefaultBinaryTree<String> questionTree = new DefaultBinaryTree<String>();
	
	/**
	 * Getter for the binary tree with questions
	 * @return questionTree that will be used in GUI
	 */
	public DefaultBinaryTree<String> getQuestionTree() {
		// create the tree first
		initTree();
		
		return questionTree;
	}

	/**
	 * Reads the XML file and puts it in tree
	 */
	private void initTree() {
		// Setup XML Document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// to prevent exceptions
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File("questions.xml");
			Document document = builder.parse(xmlFile);
			
			parseQuestionFile(document);
		}

		catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

		catch (ParserConfigurationException e) {
			System.err.println("Caught ParserConfigurationException: " + e.getMessage());
		}

		catch (SAXException e) {
			System.err.println("Caught SAXException: " + e.getMessage());
		}
	}

	/**
	 * Navigate through major document structure
	 * 
	 * @param the document to be parsed
	 * @return questionTree with the questions and answers put in a binary tree
	 */
	private DefaultBinaryTree<String> parseQuestionFile(Document document) {
		Node docRoot = document.getDocumentElement();
		
		// currently parent is null because we need to put in root first
		parseNode(docRoot, questionTree, null);
		return questionTree;
	}

	
	/**
	 * Navigate through major document structure
	 * @param n Node that is either a question node or a node that is parent of question node
	 * @param questionTree binary tree that we put questions/answers into
	 * @param parent binary tree node that is the parent to the next children 
	 */
	private void parseNode(Node n, DefaultBinaryTree<String> questionTree,
			DefaultBinaryTreeNode<String> parent) {
		
		// if we're not at a question node, iterate through children until we get to a question
		// at that question node, call this method again
		if(!n.getNodeName().equals("question")) {
			NodeList nodeList = n.getChildNodes();
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node currentNode = nodeList.item(i);
				
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					
					if (currentNode.getNodeName().equals("question")) {
						parseNode(currentNode, questionTree, parent);
					}
				}
			}
		}
	
		// so that we don't do this to a non-question node
		else {
			// if tree is empty -- put in root
			if (questionTree.isEmpty()) {
				DefaultBinaryTreeNode<String> rootQuestion = new DefaultBinaryTreeNode<String>();
				rootQuestion.setData(((Element) n).getAttribute("text"));
				questionTree.setRoot(rootQuestion);

				// root becomes parent so we can add child nodes to it
				parent = rootQuestion;
			}

			// create left child node for yes answer
			Node leftChild = findAnswerNode(n, "yes");
			DefaultBinaryTreeNode<String> left = new DefaultBinaryTreeNode<String>();
			
			// recursive case
			// if that child is a question, call this method again on it to look for answers
			if (leftChild.getNodeName().equals("question")) {
				left.setData(((Element) leftChild).getAttribute("text"));
				parent.setLeftChild(left);

				parseNode(leftChild, questionTree, left);
			}

			// base case -- the child is a team
			else {
				left.setData("<html>Are you thinking of the<br>" + leftChild.getTextContent() + "?</html>");
				parent.setLeftChild(left);
			}
			
			// create right child node for no answer
			Node rightChild = findAnswerNode(n, "no");
			DefaultBinaryTreeNode<String> right = new DefaultBinaryTreeNode<String>();

			// recursive case
			// if that child is a question, call this method again on it to look for answers
			if (rightChild.getNodeName().equals("question")) {
				right.setData(((Element) rightChild).getAttribute("text"));
				parent.setRightChild(right);

				parseNode(rightChild, questionTree, right);
			}

			// base case -- the child is a team
			else {
				right.setData("<html>Are you thinking of the<br>" + rightChild.getTextContent() + "?</html>");
				parent.setRightChild(right);
			}
		}

		
	}
	
	
	
	/**
	 * Return the node corresponding to the answer yes/no 
	 * that is the next question or team
	 * 
	 * @param n Node that is the question node
	 * @param answer String to know if we want to look for the yes or no child
	 * @return currentNode2 binary tree node that is 
	 * the question/team that corresponds to the answer 
	 */
	private Node findAnswerNode(Node n, String answer) {

		NodeList nodeList = n.getChildNodes();
		
		// go through question's children
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				
				// looking for child node that is an answer
				if (currentNode.getNodeName().equals("answer")) {
					
					// does that answer node have the yes or no that we want?
					if (((Element) currentNode).getAttribute("useranswer").equals(answer)) {

						NodeList nodeList2 = currentNode.getChildNodes();
						
						// go through answer's children
						for (int j = 0; j < nodeList2.getLength(); j++) {
							
							Node currentNode2 = nodeList2.item(j);
							
							if (currentNode2.getNodeType() == Node.ELEMENT_NODE) {

								// contains the next question/team 
								if ( currentNode2.getNodeName().equals("question")
										|| currentNode2.getNodeName().equals("team") ) {
									
									return currentNode2;
								}
							}
						}

					}

				}
			}
		}

		// we shouldn't get here 
		return null;
	}

	
}