/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 *          Student Name: Mostapha A
 */

/**
 * Class for the main method
 * @author Mostapha A
 *
 */
class TestDLLApp {
	/**
	 * The main method that implements the doubly linked list and tests it 
	 * @param args Default arguments for main method
	 */
	public static void main(String[] args) {
		// create LL
		DoublyLinkedList newLL = new DoublyLinkedList();
		
		// insert 20, 42, 63, 93 at the front with method
		newLL.insertFirst(20);
		newLL.insertFirst(42);
		newLL.insertFirst(63);
		newLL.insertFirst(93);
		
		// insert 9, 34, 51 at the end with method
		newLL.insertLast(9);
		newLL.insertLast(34);
		newLL.insertLast(51);
		
		// display with print forward
		newLL.printForwards();
		
		// display with print backwards
		newLL.printBackwards();
		
		// delete first node
		newLL.deleteFirstNode();
		
		// delete last node
		newLL.deleteLastNode();
		
		// search and delete the number 9
		newLL.searchAndDelete(9);
		
		// display with print forward
		newLL.printForwards();
		
		// insert 69 after 20
		newLL.insertAfter(20, 69);
		
		// insert 77 after 34
		newLL.insertAfter(34, 77);
		
		// display with print forward
		newLL.printForwards();

	} 
} 
