
public class Stack 
{
	// create new class for nodes
	public static class Node
	{
		int data;
		Node next;
		Node(int d) { data = d; next = null; }
	}
	
	private Node top;
	
	/** returns false if list is empty and true if list contains values */
	public boolean isEmpty()
	{
		return top != null;
	}
	
	/** returns the last value added to the list */
	public int peek()
	{
		if (top == null)
		{
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		}
		return top.data;
	}
	
	/** inserts a new node into the singly linked list */
	public void insert(int data)
	{
		Node node = new Node(data);
		
		if (top == null) // if there are no values yet new node will go here
		{
			top = node;
		}
		
		else // adds new node top of the list
		{
			Node temp = top;
			top = node;
			node.next = temp;
		}
	}
	
	/** pops off the top value of the list */
	public int pop()
	{
		int popped = Integer.MIN_VALUE;
		
		if (top == null) // if there are no values this will return min value
		{
			System.out.println("Stack is empty.");
		}
		else
		{
			popped = top.data; // stores value at the top node
			top = top.next; // unlinks value of top node from the list
		}
		return popped; // returns min value for empty list or stored value for top node
	}
	
	/** prints the values currently stored in teh list */
	public void show()
	{
		Node node = top;
		
		while (node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	// driver code
	public static void main(String[] args) 
	{
		Stack mystack = new Stack();
		
		System.out.println("Are there any values in the list? " + mystack.isEmpty());
		mystack.insert(1);
		mystack.insert(2);
		mystack.insert(3);
		mystack.insert(4);
		mystack.insert(5);
		
		System.out.println("Are there any values in the list? " + mystack.isEmpty());
		mystack.show();
		System.out.println();
		
		System.out.println("Peek value is " + mystack.peek());
		System.out.println("Popped value is " + mystack.pop());
		mystack.show();
	}

}
