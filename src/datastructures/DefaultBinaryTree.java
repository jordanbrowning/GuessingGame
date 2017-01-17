package datastructures;
/**
 * DefaulyBinaryTree implements BinaryTree for a basic binary tree
 * with root of try BinaryTreeNode<T>
 * 
 *  @author browning
 */

public class DefaultBinaryTree<T> implements BinaryTree<T> {

	// root of the tree
	private BinaryTreeNode<T> root; 

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 */
	public BinaryTreeNode<T> getRoot() {
		return root; 
	}

	/**
	 * Set the root node for this tree.
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root; 
	}

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 */
	public boolean isEmpty() {
		// if there's no root, the tree is empty
		if(root == null) {
			return true;
		}
		
		// if root isn't null, we have data in the tree then 
		else {
			return false; 
		}
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder List.
	 */
	public LinkedList<T> inorderTraversal() {
		// can't traverse an empty tree
		if(isEmpty()) {
			return null; 
		}
		
		// list that will have the inorder traversal
		LinkedList<T> traversal = new LinkedList<T>();
		
		// traverse the list 
		inorderTraversal(root, traversal);
		
		return traversal; 
	}
	
	/**
	 * Recursive method to perform inorder traversal 
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {

		// recursive case 1
		// set left children in list first 
		if(node.getLeftChild() != null) {
			inorderTraversal(node.getLeftChild(), traversal);
		}
		
		// set node's data in list second
		//don't need to worry about null data because the method shouldn't be called if null
		traversal.insertLast(node.getData());
		
		// recursive case 2
		// set right children in list last 
		if(node.getRightChild() != null) {
			inorderTraversal(node.getRightChild(), traversal);
		}	
	}

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder List.
	 */
	public LinkedList<T> preorderTraversal() {
		// can't traverse an empty tree
		if(isEmpty()) {
			return null; 
		}
		
		// list that will have the preorder traversal
		LinkedList<T> traversal = new LinkedList<T>();
		
		// traverse the list 
		preorderTraversal(root, traversal);
		
	
		
		return traversal; 
	}
	
	/**
	 * Recursive method to perform preorder traversal 
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		// set node's data in list first 
		//don't need to worry about null data because the method shouldn't be called if null
		traversal.insertLast(node.getData());
		
		// recursive case 1
		// set left children in list second 
		if(node.getLeftChild() != null) {
			preorderTraversal(node.getLeftChild(), traversal);
		}
		
		// recursive case 2
		// set right children in list last 
		if(node.getRightChild() != null) {
			preorderTraversal(node.getRightChild(), traversal);
		}
	}

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder List.
	 */
	public LinkedList<T> postorderTraversal() {
		// can't traverse an empty tree
		if(isEmpty()) {
			return null; 
		}
		
		// list that will have the postorder traversal
		LinkedList<T> traversal = new LinkedList<T>();
		
		// traverse the list 
		postorderTraversal(root, traversal);
		
		return traversal; 
	}
	
	/**
	 * Recursive method to perform postorder traversal 
	 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		// recursive case 1
		// set left children in list first  
		if(node.getLeftChild() != null) {
			postorderTraversal(node.getLeftChild(), traversal);
		}
		
		// recursive case 2
		// set right children in list second 
		if(node.getRightChild() != null) {
			postorderTraversal(node.getRightChild(), traversal);
		}
		
		// set node's data in list last 
		//don't need to worry about null data because the method shouldn't be called if null
		traversal.insertLast(node.getData());
	}

	
	/**
	 * 
	 */
	public static void main(String[] args) {
		// tree in which we will put dwarves
		DefaultBinaryTree<String> dwarves = new DefaultBinaryTree<String>(); 

		// create nodes for dwarves and set data
		DefaultBinaryTreeNode<String> bashful = new DefaultBinaryTreeNode<String>();
		bashful.setData("bashful");
		DefaultBinaryTreeNode<String> doc = new DefaultBinaryTreeNode<String>();
		doc.setData("doc");
		DefaultBinaryTreeNode<String> dopey = new DefaultBinaryTreeNode<String>();
		dopey.setData("dopey");
		DefaultBinaryTreeNode<String> happy = new DefaultBinaryTreeNode<String>();
		happy.setData("happy");
		DefaultBinaryTreeNode<String> sleepy = new DefaultBinaryTreeNode<String>();
		sleepy.setData("sleepy");
		DefaultBinaryTreeNode<String> sneezy = new DefaultBinaryTreeNode<String>();
		sneezy.setData("sneezy");
		DefaultBinaryTreeNode<String> grumpy = new DefaultBinaryTreeNode<String>();
		grumpy.setData("grumpy");
		
		// create arrangement of tree
		dwarves.setRoot(bashful);
		bashful.setLeftChild(doc);
		bashful.setRightChild(dopey);
		doc.setLeftChild(happy);
		doc.setRightChild(sleepy);
		dopey.setLeftChild(sneezy);
		dopey.setRightChild(grumpy);
		
		

	}

}
