package linkedList;

public class LinkedList {
	//declaring linked list atributes
	private Node head;
	private int count;
	
	//constructor method
	public LinkedList() { //O(1)
		head = null;
		count = 0;
	}
	
	//method that receives a float value
	//and inserts it at the start of the
	//linked list. Doesn't return anything
	public void insert(float value) { //O(1)
		Node node = new Node(value, head);
		head = node;
		count++;
	}
	
	//method that receives a float value
	//and inserts it at the end of the
	//linked list. Doesn't return anything
	public void append(float value) { //O(1)
		Node node = new Node(value, null);
		
		if(isEmpty()) {
			head = node;
		}
		else {
			Node tail = getTail();
			tail.setNext(node);
		}
		
		count++;
	}
	
	//method that receives a float value
	//and inserts it in the list in 
	//ascending order. Doesn't return anything
	public void insertAsc(float value) { //O(n)
		if(isEmpty()) {
			Node node = new Node(value, null);
			head = node;
		}
		else {
			if(value <= head.getData()) {
				Node node = new Node(value, head);
				head = node;
			}
			else {
				Node search = head;
				while(search != null) {
					if(search.getNext() != null) {
						if(search.getData() <= value && search.getNext().getData() >= value) {
							Node node = new Node(value, search.getNext());
							search.setNext(node);
							break;
						}
					}
					search = search.getNext();
				} 
				if(search == null) {
					append(value);
					count--;
				}
			}
		}
		count++;
	}
	
	//method that receives a float value
	//and inserts it in the list in ascending 
	//order if the value is not already int the
	//list. Returns true if the value was inserted
	//and false if not
	public boolean insertAscNoDup(float value) { //O(n)
		Node aux = head;
		while(aux != null && aux.getData() != value) {
			aux = aux.getNext();
		}
		if(aux == null) {
			insertAsc(value);
			return true;
		}
		else {
			return false;
		}
	}
	
	//method that receives a float value
	//and inserts it in the list in 
	//descending order. Doesn't return anything
	public void insertDesc(float value) { //O(n)
		if(isEmpty()) {
			Node node = new Node(value, null);
			head = node;
		}
		else {
			if(value >= head.getData()) {
				Node node = new Node(value, head);
				head = node;
			}
			else {
				Node search = head;
				while(search != null) {
					if(search.getNext() != null) {
						if(search.getData() >= value && search.getNext().getData() <= value) {
							Node node = new Node(value, search.getNext());
							search.setNext(node);
							break;
						}
					}
					search = search.getNext();
				} 
				if(search == null) {
					append(value);
					count--;
				}
			}
		}
		count++;
	}
	
	//method that receives a float value
	//and inserts it in the list in descending 
	//order if the value is not already int the
	//list. Returns true if the value was inserted
	//and false if not
	public boolean insertDescNoDup(float value) { //O(n)
		Node aux = head;
		while(aux != null && aux.getData() != value) {
			aux = aux.getNext();
		}
		if(aux == null) {
			insertDesc(value);
			return true;
		}
		else {
			return false;
		}
	}
	
	//method that receives no parameters,
	//removes the head and returns it's value,
	//returns null if the list is empty
	public Node removeHead() { //O(1)
		if(isEmpty()) return null;
		Node node = new Node(head.getData(), null);
		head = head.getNext();
		count--;
		return node;
	}
	
	//method that receives no parameters,
	//removes the tail and returns it's value,
	//returns null if the list is empty
	public Node removeTail() { //O(n)
		if(isEmpty()) return null;
		if(count == 1) return removeHead();
		
		Node node = new Node();		
		Node aux = head;
		
		while(aux.getNext() != getTail()) {
			aux = aux.getNext();
		}
		
		node = getTail();
		aux.setNext(null);
		
		count--;
		return node;
	}
	
	//method that receives a value, searches
	//for it in the list, removes and returns
	//it if found. If the value is not found,
	//returns null.
	public Node removeNode(float value) { //O(n)
		if(isEmpty()) return null;
		if(value == head.getData()) return removeHead();
		if(value == getTail().getData()) return removeTail();
		
		Node node = new Node();
		Node aux = head;
		
		while(aux.getNext() != null  && aux.getNext().getData() != value) {
			aux = aux.getNext();
		}
		
		if(aux.getNext() == null)
			return null;
		
		if(aux.getNext().getData() == value) {
			node = aux.getNext();
			aux.setNext(node.getNext());
			node.setNext(null);
		}
		count--;
		return node;
	}
	
	//method that receives no parameters, removes
	//duplicate elements and returns the amount
	//of removed nodes 
	public int removeDup() { // O(n²)
		if(isEmpty()) return 0;
		if(count == 1) return 0;
		
		Node i = head;
		Node j = head;
		Node current = head;		
		int dupCount = 0;
		
		while(j != null) {
			current = i;
			while(i.getNext() != null) {
				i = i.getNext();
				
				if(current.getData() == i.getData()) {
					removeNode(current.getData());
					dupCount++;
					break;
				}
			}
			j = j.getNext();
			i = j;
		}
		
		return dupCount;
	}
	
	//method that receives no parameters
	//and returns the head node
	public Node getHead() { // O(1)
		return head;
	}
	
	//method that receives no parameters
	//and returns the head node
	public Node getTail() { // O(n)
		if(isEmpty()) return null;
		
		Node tail = head;
		
		while(tail.getNext() != null) {
			tail = tail.getNext();
		}
		
		return tail;
	}
	
	//method that receives a float as a
	//parameters, searches for that value in
	//the list and returns the node if found.
	//Returns null if not.
	public Node getNode(float value) { //O(n)
		if(isEmpty()) return null;
		if(value == head.getData()) return getHead();
		if(value == getTail().getData()) return getTail();
		
		Node aux = head;
		
		while(aux.getNext() != null  && aux.getNext().getData() != value) {
			aux = aux.getNext();
		}
		
		if(aux.getNext() == null)
			return null;
		
		return aux.getNext();
	}
	
	//method that receives no parameters
	//and returns the count atribute
	public int count() { // O(1)
		return count;
	}
	
	//method that receives no parameters
	//and returns a boolean. Returns true
	//if the list is empty and false if the
	//list has any values in it.
	public boolean isEmpty() { //O(1)
		return count == 0 ? true : false;
	}
	
	//method that receives no parameters and
	//doesn't return anything. It clears the 
	//list and removes conections of the nodes
	public void clear() { //O(n)
		if(isEmpty()) { 
			return;
		}
		Node aux = head;
		Node i = head.getNext();
		
		while(i != null) { 
			aux.setNext(null);
			aux = i;
			i = i.getNext();
		}
		
		head = null;
		count = 0;
	}
	
	//method that receives no parameters
	//and doesn't return anything. It sorts
	//the linked list in ascending order
	public void sort() { //O(n²)
		if(isEmpty()) return;
		if(count == 1) return;
		
		Node i = head;
		Node j = head;
		Node min = head;
		float aux;
		
		while(j != null) {
			min = i;
			while(i != null) {
				if(i.getData() < min.getData()) {
					aux = min.getData();
					min.setData(i.getData());
					i.setData(aux);
				}
				i = i.getNext();
			}
			j = j.getNext();
			i = j;
		}
	}
	
	//method that receives no parameters
	//and doesn't return anything. It 
	//reverses the linked list
	public void reverse() { //O(n) 
		if(isEmpty()) return;
		if(count == 1) return;
		
		Node previous = null;
		Node current = head;
		Node next = head.getNext();
		
		while(current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	//method that receives a linked list
	//and compares it to this list. Returns
	//true if they're equal and false if not
	public boolean isEqual(LinkedList list) { // O(n)
		if(list.isEmpty() && isEmpty()) return true;
		
		Node i = head;
		Node j = list.head;
		while(i != null) {
			if(i != j) {
				return false;
			}
			i = i.getNext();
			j = j.getNext();
		}
		return true;
	}
	
	//toString method
	@Override
	public String toString() { //O(n)
		StringBuilder sb = new StringBuilder();
		
		sb.append("(count = " + count + ")\n");
		
		if(isEmpty()) { 
			sb.append("List is empty!\n");
		}
		else {
			Node aux = head;
			sb.append(aux + "\n");
			while(aux.getNext() != null) {
				aux = aux.getNext();
				sb.append(aux + "\n");
			} 
		}
		
		return sb.toString();
	}
}