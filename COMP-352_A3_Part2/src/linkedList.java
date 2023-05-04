/**
 * @author Amin Kadawala - 40200998
 * @author Maxime Arseneau - 40207886
 * 
 * Assignment 3, Part 2 - COMP352
 * 
 * Date: December 5th, 2022
 *
 */

class Node{
	
	int data;
	String val;
	Node next;
	
	/**
	 * @param data
	 * @param val
	 * Constructor
	 */
	public Node(int data, String val) {
		this.data = data;
		this.next = null;
		this.val = val;
	}
	
	/**
	 * @param data
	 * @param n
	 * @param val
	 * Constructor
	 */
	public Node(int data, Node n, String val) {
		this.data = data;
		this.next = n;
		this.val = val;
	}
	
	/**
	 * @return data
	 * Get method
	 */
	public int getData() {
		return data;
	}
	/**
	 * @return value
	 * Get method
	 */
	public String getVal() {
		return val;
	}
	/**
	 * @param data
	 * Set method for data
	 */
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @param val
	 * Set method for value
	 */
	public void setVal(String val) {
		this.val = val;
	}
	
}

/**
 * linkedList class implementing ADT
 * Where all the methods are located
 */
public class linkedList implements ADT{
	
	Node head;
	int size = 0;
	
	/**
	 * Constructor
	 */
	public linkedList() {
		head = null;
	}
	/**
	 * @param l1
	 * Constructor
	 */
	public linkedList(linkedList l1) {
		if (l1.head == null) {
			head = null;
		}
		else {
			head = null;
			Node t1, t2, t3;
			t2 = t3 = null;
			t1 = l1.head;
			while(t1 != null) {
				if (head == null) {
					t2 = new Node(t1.getData(), null);
					head = t2;
				}
				else {
					t3 = new Node(t1.getData(), null);
					t2.next = t3;
					t2 = t3;
				}
				t1 = t1.next;
			}
			t2 = t3 = null;
		}
	}
	
	/**
	 * Clone method for linkedList
	 */
	public linkedList clone() {
		return new linkedList(this);
	}
	
	/**
	 * @return integer of size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @param key
	 * @return finds whether a key is located and returns the key
	 */
	public Node find(int key) {
		if (head == null) {
			System.out.println("No nodes exist.");
			return null;
		}
		if (head.getData() == key) {
			return head;
		}
		else {
			Node current = head;
			while (current != null) {
				if (current.getData() == key) {
					return current;
				}
				current = current.next;
			}
			return null;
		}
	}
	
	@Override
	/**
	 * Outputs all the keys in the list
	 */
	public void allKeys() {
		Node current = head;
		while(current != null) {
			System.out.println(current.getData());
			current = current.next;
		}
	}
	
	@Override
	/**
	 * Adds the key and value to the list
	 */
	public void add(int key, String value) {
		if (head == null) {
			head = new Node(key, value);
		}
		else {
			if (head.getData() > key) {
				Node node = new Node(key, head, value);
				head = node;
				size++;
			}
			else {
				Node tempNode = head;
				while(tempNode.next != null && tempNode.next.getData() < key) {
					tempNode = tempNode.next;
				}
				Node temp1 = tempNode.next;
				Node temp = new Node(key, null, value);
				tempNode.next = temp;
				temp.next = temp1;
				size++;
			}
		}
	}
	
	@Override
	/**
	 * Removes a key from list which user provided
	 */
	public void remove(int key) {
		Node temp = head, prev = null;
		if (temp != null && temp.data == key) {
			head = temp.next;
			size--;
			System.out.println("Removed " + key + " sucessfully.");
			return;
		}
		while(temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("Key " + key + " not found.");
			return;
		}
		prev.next = temp.next;
		size--;
		System.out.println("Removed " + key + " sucessfully.");
	}
	
	@Override
	/**
	 * Gets a value from the key user provided
	 */
	public String getValues(int key) {
		Node temp = this.find(key);
		if (temp != null) {
			return temp.getVal();
		}
		else {
			System.out.println("Value is not found with EIN#: " + key + ".");
			return null;
		}
	}

	@Override
	/**
	 * returns the next key of the key user provides
	 */
	public int nextKey(int key) {
		Node current = head;
		while(current != null && current.getData() != key) {
			current = current.next;
		}
		if(current != null && current.next == null) {
			System.out.println("Key: " + key + " does not exist.");
			return -1;
		}
		return current == null || current.next == null? -1 : current.next.getData();
	}

	@Override
	/**
	 * returns the previous key of the key user provides
	 */
	public int prevKey(int key) {
		Node current = head;
		while(current != null && current.next != null && current.next.getData() != key) {
			current = current.next;
		}
		if(current != null && current.next == null) {
			System.out.println("Key: " + key + " does not exist.");
			return -1;
		}
		return current == null ? -1 : current.getData();
	}

	@Override
	/**
	 * returns an integer of how many keys are between two keys
	 */
	public int rangeKey(int key1, int key2) {
		Node current = head;
		int flag = 0;
		int count = 0;
		while(current != null && current.getData() != key2) {
			if(current.getData() == key1) {
				flag = 1;
			}
			current = current.next;
			if (flag == 1) {
				count++;
			}
		}
		if ((current != null) && (current.next == null)) {
			System.out.println("Key: " + key1 + " or " + key2 + " not found.");
			return -1;
		}
		return count - 1;
	}

	@Override
	/**
	 * returns true/false depending on whether the key exists or not
	 */
	public boolean contains(int key) {
		return find(key) != null;
	}
	
}