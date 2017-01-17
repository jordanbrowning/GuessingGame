package datastructures;
/**
 * DefaulyBinaryTreeNode implements BinaryTreeNode,
 * with data of type T and pointers to left and right children.
 * 
 *  @author browning
 */

public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T>
{
	
	private T data; 
	
	private BinaryTreeNode<T> left;
	
	private BinaryTreeNode<T> right;
	
	/**
	   * Get the data stored at this node.
	   * @return Object data.
	   */
	  public T getData() {
		  return data; 
	  }

	  /**
	   * Set the data stored at this node.
	   */
	  public void setData(T data) {
		  this.data = data; 
	  }

	  /**
	   * Get the left child.
	   * @return BinaryTreeNode that is left child,
	   * or null if no child.
	   */
	  public BinaryTreeNode<T> getLeftChild() {
		  return left;
	  }

	  /**
	   * Get the right child.
	   * @return BinaryTreeNode that is right child,
	   * or null if no child.
	   */
	  public BinaryTreeNode<T> getRightChild() {
		  return right; 
	  }

	  /**
	   * Set the left child.
	   */
	  public void setLeftChild( BinaryTreeNode<T> left ) {
		  this.left = left;
	  }

	  /**
	   * Set the right child.
	   */
	  public void setRightChild( BinaryTreeNode<T> right ) {
		  this.right = right; 
	  }

	  /**
	   * Tests if this node is a leaf (has no children).
	   * @return true if leaf node.
	   */
	  public boolean isLeaf() {
		  // both children must be null for it to be a leaf
		  if(left == null && right == null) {
			  return true;
		  }
		  
		  // return false if we didn't return true before since one of the children weren't null
		  else {
			  return false;
		  }
	  }
	  
}
