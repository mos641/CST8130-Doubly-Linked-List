/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 *          Student Name: Mostapha A
 */

/**
 * A class for Doubly linked nodes, a data member and a node before it and after it with their own data members and linked nodes.
 * @author Instructor
 *
 */
class Node {
	/** The data item */
	public int mData; // data item
	/** The next node with it's own data and linked nodes */
	public Node next; // next node in list
	/** The previous node with it's own data and linked nodes */
	public Node previous; // previous node in list

	/**
	 * A constructor that creates a node with a supplied data member
	 * @param d The data to set as the node data
	 */
	public Node(int d) // constructor
	{
		mData = d;
	}

	/**
	 * Prints the nodes data member and a space afterwards
	 */
	public void displayNode() {
		System.out.print(mData + " ");
	}
}

/**
 * A class for a doubly Linked list, sets the first and last node of the list, each node is linked to the surrounding nodes.
 * @author Instructor and Mostapha A
 *
 */
class DoublyLinkedList {
	/** The first node in the list */
	private Node first;
	/** The last node in the list */
	private Node last;

	/**
	 * A constructor for the class that sets the first and last node to null values indicating the list is empty
	 */
	public DoublyLinkedList() {
		// set first and last to null
		first = null;
		last = null;
	}

	/**
	 * Checks if the first node in the list is still null which would indicate it is empty
	 * @return Returns true or false whether the node is null or not
	 */
	public boolean isEmpty() {
		// return true if the first node is empty
		return first == null;
	}

	/**
	 * Inserts a node at the beginning of the list, and re links the other elements accordingly
	 * @param num The data member to have as the node data
	 */
	public void insertFirst(int num) {
		// create a new node for the data member
		Node newNode = new Node(num);
		
		// if the first node is empty set last to the inputed data member, otherwise set the first one
		if (isEmpty())
			last = newNode;
		else
			first.previous = newNode;
		newNode.next = first;
		first = newNode;
	}

	/**
	 * Inserts a node at the end of the list and re links the other elements accordingly
	 * @param num The data member to have as the node data
	 */
	public void insertLast(int num) {
		// create node for the data member
		Node newNode = new Node(num);
		
		// if the first node is empty set data member
		if (isEmpty())
			first = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}

	/**
	 * Finds a data member of a node and inserts data after the found node
	 * @param numToFind The number you wish to insert data afterwards
	 * @param newNumber The number you wish to insert into the list
	 * @return Whether it was successful and the number was found
	 */
	public boolean insertAfter(int numToFind, int newNumber) { // (assumes non-empty list)
		Node current = first;
		
		while (current.mData != numToFind) {
			current = current.next;
			if (current == null)
				return false;
		}
		Node newNode = new Node(newNumber);

		if (current == last) {
			newNode.next = null;
			last = newNode;
		} else {
			newNode.next = current.next;

			current.next.previous = newNode;
		}
		newNode.previous = current;
		current.next = newNode;
		return true;
	}
	
	/**
	 * Deletes the first node in the list and re links the other elements accordingly
	 * @return The node that was deleted
	 */
	public Node deleteFirstNode() {
		Node node = new Node(0);
		
		// if it is not empty, change the first node
		if (!isEmpty()) {
			node = first.next;
			node.previous = null;
			
			// set new first node
			first = node;
		}
		
		return node;

	}

	/**
	 * Deletes the last node in the list and re links the other elements accordingly
	 * @return The node that was deleted
	 */
	public Node deleteLastNode() {
		Node node = new Node(0);

		// if it is not empty, change the last node
		if (!isEmpty()) {
			node = last.previous;
			node.next = null;

			// set new first node
			last = node;
		}

		return node;
	}

	/**
	 * Searches the list for a number and deletes the specific node, re links the other elements accordingly
	 * @param number The number to be deleted
	 * @return The node that was deleted
	 */
	public Node searchAndDelete(int number) {
		Node node = first;
		
		// loop through nodes until found
		while (node.mData != number) {
			node = node.next;
			
			if (node.mData == number) {
				// remove links
				node.next.previous = node.previous;
				node.previous.next = node.next;
			}
		}
		
		return node;
	}

	/**
	 * Prints all the elements of the list in order from first to last
	 */
	public void printForwards() {
		Node node = new Node(0);;
		System.out.print("Linked List: [From first_to_last]: ");
		
		// if it is not null, print the first
		if (!isEmpty()) {
			System.out.print(first.mData + " ");
			// set node to the next element
			node = first.next;
			// loop through until empty
			while (node != null) {
				// print element
				node.displayNode();
				// set node to next element
				node = node.next;
			}
			System.out.print("\n");
		}
	}

	/**
	 * Prints all the elements of the list in order from last to first
	 */
	public void printBackwards() {
		Node node = new Node(0);
		System.out.print("Linked List: [From last_to_first]: ");

		// if it is not null, print the last
		if (!isEmpty()) {
			System.out.print(last.mData + " ");
			// set node to the previous element
			node = last.previous;
			// loop through until empty
			while (node != null) {
				// print element
				node.displayNode();
				// set node to previous element
				node = node.previous;
			}
			System.out.print("\n");
		}

	}
} 
