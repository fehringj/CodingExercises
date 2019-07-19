
public class SingleLinkedList 
{
	Node head; // head of list
	
	/** makes new class for nodes */
	public static class Node 
	{
		int data; // initialize integer for data contained in node
		Node next; // node that comes after current node
		Node prev;
		Node(int d) { data = d; next = null; } // create function for node with stored value
	}
	
	/** function to display list of nodes */
	public void show() 
	{
		Node node = head; 
		
		while (node != null) // prints a list of nodes until null value (end of list) is reached
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	/** returns true if the list is empty and false if it contains stored values */
	public boolean isEmpty()
	{
		if (head == null)
		{
			return true;
		}
		else
			return false;
	}
	
	/** inserts a value at the beginning of the list */
	public void insertAtStart(int newData) 
	{
		Node n = new Node(newData); // node being created to put at head of list
		n.next = head;
		head = n;
	}
	
	/** function to insert a node at specific position */
	public void insert(int index, int data) 
	{
		Node node = new Node(data); // node to be inserted
		node.data = data; // value associated with this node
		node.next = null; 
		
		if (index == 0)
		{
			insertAtStart(data); // calls insertAtStart function to insert node at beginning
		}
		else
		{
			Node n = head; // traverses through list until the specified position is reached
			for (int i = 0; i < index - 1; i++)
			{
				n = n.next;
			}
		node.next = n.next;
		n.next = node; // node is inserted
		}
	}
	
	/** function to insert a node after a specific value */
	public void insertAfter(Node prevNode, int data) 
	{
		if (prevNode == null) // you can't insert after if there is no previous node
		{
			System.out.println("Previous value cannot be null");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode; // inserts the new node after previous node
	}
	
	/** adds a new node to the end of current list */
	public void append(int newData) 
	{
		Node newNode = new Node(newData);
		if (head == null) // in the case that there is not data currently in the list, node is placed at head
		{
			head = newNode;
			return;
		}
		newNode.next = null; // creates new node as head and sets next to null
		
		Node last = head;
		while (last.next != null)
			last = last.next;
		
		last.next = newNode; // traverses the list and adds node at the end
	}
	
	/** function to delete a node at a specified value */
	public void delete(int key) 
	{
		if (head == null) return; // nothing to delete if list is empty
		
		Node nd = head;
		Node prev = null;
		
		if (nd != null && nd.data == key) // handles cases where the key is the head node, deletes the head
		{
			head = nd.next;
			return;
		}
		
		while (nd != null && nd.data != key) // the key hasn't been reached and list is traversed until it is
		{
			prev = nd;
			nd = nd.next;
		}
		if (nd == null) return; // list is traversed and key hasn't been reached so nothing is done
		
		prev.next = nd.next; // links the previous node with the node following the one deleted
	}
	
	/** function to delete a node at a specified position */
	public void deleteAt(int position) 
	{
		if (head == null) return; // nothing to delete if the list is empty
		
		Node node = head;
		
		if (position == 0) // deletes the head node if first position was specified
		{
			head = node.next;
			return;
		}
		for (int i = 0; node != null && i < position - 1; i++) 
			// goes through the list until the position is reached
		{
			node = node.next;
		}
		if (node == null || node.next == null)
			return; // if the position was not reached nothing is done
		
		Node next = node.next.next; 
		
		node.next = next; // gets rid of the node at the specified position
	}
	
	/** gives total number of entries in the list */
	public int getLength() 
	{
		int count = 0;
		Node node = head;
		
		while (node != null) // while there are still nodes the count increases each time through the loop
		{
			count++;
			node = node.next;
		}
		return count;
	}
	
	/** function to swap int x and int y in single linked list
	 */
	public void swap(int x, int y)
	{
		if (x == y) return; // if nodes are equal do not swap
		
		Node ref = head;
		
		Node a = null, b = null; // create new placeholder nodes
		
		while (ref.next != null) // traverse through the list until x or y is reached
		{
			if (ref.next.data == x)
			{
				a = ref;
			}
			else if (ref.next.data == y)
			{
				b = ref;
			}
			ref = ref.next; 
		}
		if (a != null && b != null) // move nodes such that a and b are swapped
		{
			Node n = a.next;
			a.next = b.next;
			b.next = n;
			n = a.next.next;
			a.next.next = b.next.next;
			b.next.next = n;
		}	
	}
	
	/** converts singly linked list to a circular linked list */
	public void circular()
	{
		Node start = head;
		
		while (start.next != null)
		{
			start = start.next;
		}
		start.next = head;
	}
	
	/** displays values stored in a circular linked list */
	public void circshow()
	{
		Node start = head;
		
		if (start != null)
		{
			do
			{
				System.out.print(start.data + " ");
				start = start.next;
			}
			while (start != head);
		}
	}
	
	// Driver code
	public static void main(String[] args)
	{
		SingleLinkedList mylist = new SingleLinkedList();
		
		mylist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		
		mylist.head.next = second;
		second.next = third;
		third.next = fourth;
		
		mylist.append(56);
		mylist.insertAfter(second, 20);
		mylist.insert(3, 33);
		mylist.insertAtStart(12);
		mylist.insert(4, 67);
		mylist.insertAtStart(34);
		mylist.insert(3, 21);
		mylist.insert(0, 90);
		mylist.delete(4);
		mylist.delete(44);
		mylist.deleteAt(4);
		mylist.swap(33, 12);
		mylist.show();
		
		System.out.println();
		System.out.println("Total number of values in list is " + 
				mylist.getLength() + ".");
		System.out.println();
		System.out.println("Same list but in cicular version.");
		
		mylist.circular();
		mylist.circshow();
	}
}
