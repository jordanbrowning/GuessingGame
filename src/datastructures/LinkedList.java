package datastructures;
/**
* Creates the methods to be used for the linked list
* @author browning
*/

public class LinkedList<T> {
	
	private LinkedListNode<T> head; 
	
	// count number of nodes -- initialize to be 0
	private int size = 0;
	
	/**
	 * Get data stored in head node of list.
	 * @return data from the head
	 */
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		else {
			return head.getData();
		}
	}
	 
	/**
	 * Get the head node of the list.
	 * @return head node
	 */
	public LinkedListNode<T> getFirstNode() {
		return head;
	}
	 
	/**
	 * Get data stored in last node of list.
	 * @return data from tail
	 */
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		else {
			LinkedListNode<T> tail = getLastNode();
			return tail.getData(); 
		}
	}
	 
	/**
	 * Get the tail node of the list.
	 * @return tail node
	 */
	public LinkedListNode<T> getLastNode() {
		if(isEmpty()) {
			return null;
		}
		else {
			LinkedListNode<T> current = head;
			// traverse list until there is no next node -- then we are at tail
			while(current.getNext() != null) {
				current = current.getNext();
			}
			return current; 
		}
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 * @param data to be put in first node
	 */
	public void insertFirst( T data ) {
		// create new head to be put in 
		LinkedListNode<T> newHead = new LinkedListNode<T>();
		// put data into new head
		newHead.setData(data);
		// don't want to point to old head if empty
		if(!isEmpty()) {
			// point new head to old head
			newHead.setNext(head);
		}
		// make new data the new head
		head = newHead;
		// increase size
		size++;
	}
	 
	/**
	 * Insert a new node with data after currentNode
	 * @param currentNode to place new node after
	 * @param data to be put in new node after currentNode
	 */
	public void insertAfter( LinkedListNode<T> currentNode, T data ) {
		// create new node
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		// add data for new node
		newNode.setData(data);
		// make new node point to node after current head 
		newNode.setNext(currentNode.getNext());
		// put new node after current node
		currentNode.setNext(newNode);
		// increase size
		size++;
	}
	 
	/**
	 * Insert a new node with data at the end of the list.
	 * @param data to be put at end of list
	 */
	public void insertLast( T data ) {
		if(isEmpty()) {
			insertFirst(data);
		}
		else {
			// create new tail 
			LinkedListNode<T> newTail = new LinkedListNode<T>();
			// put data in tail
			newTail.setData(data);
			// traverse list to get to where there is no node after -- the old tail
			LinkedListNode<T> oldTail = getLastNode();
			// put the new tail after the old tail
			oldTail.setNext(newTail);
		}
		// increase size
		size++;
	}
	 
	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		if(isEmpty()) {
			return;
		}
		else {
			// stop pointing to old head
			head = head.getNext();
			// decrease size
			size--;
		}
	}
	 
	/**
	 * Remove the last node
	 */
	public void deleteLast() {
		if(isEmpty()) {
			return;
		}
		else {
			// start at beginning of list
			LinkedListNode<T> current = head;
			// traverse list until we are at the second to last node
			while(current.getNext().getNext() != null) {
				current = current.getNext();
			}
			// stop pointing to tail
			current.setNext(null);
			// decrease size
			size--;
		}
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 * @param currentNode that we delete the node after
	 */
	public void deleteNext( LinkedListNode<T> currentNode ) {
		// make sure currentNode isn't tail -- if it is tail, do nothing
		if(currentNode.getNext() != null) {
			// get the node to be deleted
			LinkedListNode<T> deletedNode = currentNode.getNext();
			// make the node before deleted node point to the node after deleted node
			currentNode.setNext(deletedNode.getNext());
			// decrease size
			size--;
		}
	}
	 
	/**
	 * Return the number of nodes in this list.
	 * @return size node count of this list
	 */
	public int size() {
		return size; 
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		// check if head doesn't exist 
		if(head == null) {
			return true;
		}
		else {
			return false; 
		}
	}
	 
	/**
	 * Return a String representation of the list.
	 * @return listString data in list made into a string
	 */
	public String toString() {
		// start at beginning of list
		LinkedListNode<T> current = head;
		// empty string to start
		String listString = ""; 
		// make sure list isn't not empty
		if(isEmpty()) {
			return listString;
		}
		// traverse list until there is no node after (we are at tail)
		while(current.getNext() != null) {
			// add in data to string
			listString += current.toString() + " -> "; 
			current = current.getNext();	
		}
		// add in string for tail -- without the arrow
		if(current.getData() != null) {
			listString += current.toString(); 
		}
		return listString;
	}
}
