
public class SingleLinkedList 
{
	Node head; // head of list
	
	public static class Node 
	{
		int data; // initialize integer for data contained in node
		Node next; // node that comes after current node
		Node(int d) { data = d; next = null; } // create function for node with stored value
	}
	
	public void show() // function to display list of nodes
	{
		Node node = head; 
		
		while (node != null) // prints a list of nodes until null value (end of list) is reached
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	public void insertAtStart(int newData) // inserts a value at the beginning of the list
	{
		Node n = new Node(newData); // node being created to put at head of list
		n.next = head;
		head = n;
	}
	
	public void insert(int index, int data) // function to insert a node at specific position
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
	
	public void insertAfter(Node prevNode, int data) // inserts a node after a specific value
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
	
	public void append(int newData) // adds a new node to the end of current list
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
	
	public void delete(int key) // deletes a specified value
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
	
	public void deleteAt(int position) // deletes a value at a specific position
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
	
	public int getLength() // gives total number of entries in the list
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
	
	public void swap(int x, int y)
	{
		/** function to swap int x and int y in single linked list
		 */
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
	}
}
