package datastructures;
/**
* Creates the methods to be used for the nodes of the linked list
* @author browning
*/

public class LinkedListNode<T> {
	
	private T data; 
	
	private LinkedListNode<T> next;
	
	/**
	 * Set the data stored at this node.
	 * @param data to be set in this node
	 */
	public void setData( T data ) {
		this.data = data;
	}
	 
	/**
	 * Get the data stored at this node.
	 * @return data from this node
	 */
	public T getData() {
		return data; 
	}
	 
	/**
	 * Set the next pointer to passed node.
	 * @param node that is set after this node
	 */
	public void setNext( LinkedListNode<T> node ) {
		this.next = node; 
	}
	 
	/**
	 * Get (pointer to) next node.
	 * @return next node after this node
	 */
	public LinkedListNode<T> getNext() {
		return next; 
	}
	 
	/**
	 * Returns a String representation of this node.
	 * @return string of this node 
	 */
	public String toString() {
		return data.toString(); 
	}
}
