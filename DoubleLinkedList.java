
public class DoubleLinkedList {
	
	Node head;

	public static class Node 
	{
		int data; // initialize integer for data contained in node
		Node next; // node that comes after current node
		Node prev; // previous node
		Node(int d) { data = d; next = null; } // create function for node with stored value
	}
	// will show all values in the list
	public void show() // function to display list of nodes
	{
		Node node = head; 
		
		while (node != null) // prints a list of nodes until null value (end of list) is reached
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	// inserts a value at beginning of list
	public void insertAtStart(int data) 
	{
		Node n = new Node(data);
		n.next = head;
		n.prev = null;
		if (head != null)
			head.prev = n;
		head = n;
	}
	
	public void insertAfter(Node prevNode, int data) // inserts a node after a specific value
	{
		if (prevNode == null) // you can't insert after if there is no previous node
		{
			System.out.println("Previous value cannot be null");
			return;
		}
		Node node = new Node(data); // if there is a previous node new node is inserted
		node.next = prevNode.next; // and links to other nodes are 
		prevNode.next = node;
		node.prev = prevNode;
		if (node.next != null)
			node.next.prev = node;
	}
	
	public void append(int data) // add a value to the end of a list
	{
		if (head == null) // you can't insert after if there is no previous node
		{
			System.out.println("Previous value cannot be null");
			return;
		}
		Node n = new Node(data);
		Node last = head;
		n.next = null;
		
		if (head == null) // if there is no value in head the new value becomes head
		{
			head = n;
			n.prev = null;
			return;
		}
		
		while (last.next != null) // otherwise traverse through list until no more values follow
		{
			last = last.next;
		}
		last.next = n; // add value to the end of list
		n.prev = last;
	}
	
	public void insertBefore(Node nextNode, int data) // insert value before a given node
	{
		if (nextNode == null)
		{
			System.out.println("Next node can't be null."); // can't be done if there is no next node
			return;
		}
		Node node = new Node(data); // new node will be inserted
		node.prev = nextNode.prev;
		nextNode.prev = node;
		node.next = nextNode; // re-linking values
		if (node.prev != null) // if there is a value before new node link new node as next
			node.prev.next = node;
	}
	
	public void insert(int index, int data) // function to insert a node at specific position
	{
		Node n = new Node(data); // node to be inserted
		n.data = data; // value associated with this node
		n.next = null; 
		
		if (index == 0)
		{
			insertAtStart(data); // calls insertAtStart function to insert node at beginning
		}
		else
		{
			Node node = head; // traverses through list until the specified position is reached
			for (int i = 0; i < index - 1; i++)
			{
				node = node.next;
			}
		n.next = node.next;
		node.next = n;
		n.prev = node;
		if (n.next != null)
			n.next.prev = n;
		// node is inserted
		}
	}
	
	public int getLength() // returns total number of values in list
	{
		Node node = head;
		int count = 0;
		
		while (node != null)
		{
			node = node.next;
			count++;
		}
		return count;
	}
	
	public void delete(int key) // deletes a specified value
	{
		if (head == null) return; // nothing to delete if list is empty
		
		Node nd = head;
		Node prev = null;
		
		if (nd != null && nd.data == key) // handles cases where the key is the head node, deletes the head
		{
			head = nd.next;
			nd.next.prev = null;
			return;
		}
		
		while (nd != null && nd.data != key) // the key hasn't been reached and list is traversed until it is
		{
			prev = nd;
			nd = nd.next;
		}
		if (nd == null) return; // list is traversed and key hasn't been reached so nothing is done
		
		prev.next = nd.next; // links the previous node with the node following the one deleted
		prev.next.prev = prev;
	}
	
	public void reverse()
	{
		Node ref = null;
		Node curr = head;
		
		while (curr != null)
		{
			ref = curr.prev;
			curr.prev = curr.next;
			curr.next = ref;
			curr = curr.prev;
		}
		
		if (ref != null)
		{
			head = ref.prev;
		}
		
	}
	// Driver code
	public static void main(String[] args) 
	{
		DoubleLinkedList mylist = new DoubleLinkedList();
		
		mylist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		mylist.head.next = second;
		second.next = third;
		second.prev = mylist.head;
		third.prev = second;
		third.next = null;
		
		mylist.insertAfter(second, 4);
		mylist.insertAtStart(5);
		mylist.insertBefore(third, 6);
		mylist.append(7);
		mylist.insert(2, 8);
		mylist.insert(0, 9);
		mylist.show();
		System.out.println();
		mylist.delete(3);
		mylist.show();
		System.out.println();
		mylist.delete(9);
		mylist.show();
		System.out.println();
		mylist.reverse();
		mylist.show();
		
		System.out.println();
		System.out.println("Total number of values in list is " + 
				mylist.getLength() + ".");
	}
}
