
public class Queue 
{
	// create new class for nodes
	public static class Node
	{
		int data;
		Node next;
		Node(int d) { data = d; next = null; }
	}
	
	private Node head;
	private Node tail;
	
	/** returns false if list is empty and true if list contains values */
	public boolean isEmpty()
	{
		return head != null;
	}
	
	/** inserts a new node into the singly linked list */
	public void insert(int data)
	{
		Node node = new Node(data);
		if (head == null) // makes new node the head if list is empty
		{
			head = node;
		}
		if (tail != null) // adds node to tail if there are already values in the list
		{
			tail.next = node;
		}
		tail = node;
	}
	
	/** returns the first value added to the list */
	public int peek()
	{
		if (head == null) // if there are no values in list min value is returned
		{
			System.out.println("Queue is empty.");
			return Integer.MIN_VALUE;
		}
		else // if there is data in the list the head is returned
			return head.data;
	}
	
	/** pops the first value added to the list off */
	public int pop()
	{
		if (head == null) // returns min value if the list is empty
		{
			System.out.println("Queue is empty.");
			return Integer.MIN_VALUE;
		}
		else 
		{
			int data = head.data; // temporarily stores head value in int data
			head = head.next; // unlinks data stored in head from the list
			return data; // value that had been stored in the head is returned
		}
	}
	
	/** function that displays values stored in the list */
	public void show()
	{
		Node node = head;
		
		if (head == null) // prints list is empty if no values are stored in list
			System.out.println("List is empty.");
		
		while (node != null) // traverses list and prints each value
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	// driver code
	public static void main(String[] args) 
	{
		Queue myqueue = new Queue();
		
		System.out.println("Are there values in the list? " + myqueue.isEmpty());
		myqueue.insert(1);
		myqueue.insert(2);
		myqueue.insert(3);
		myqueue.insert(4);
		myqueue.insert(5);
		
		System.out.println("Are there values in the list? " + myqueue.isEmpty());
		myqueue.show();
		System.out.println();
		
		System.out.println("Peek value is " + myqueue.peek());
		System.out.println("Popped value is " + myqueue.pop());
		myqueue.show();
	}
}
