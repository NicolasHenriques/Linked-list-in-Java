package linkedList;

public class LinkedList {
	//declaring linked list atributes
	private Node head;
	private int count;
	
	//constructor method
	public LinkedList() { 
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
	public boolean insertAscNoDup(float value) {
		boolean inserted = false;
		if(isEmpty()) {
			Node node = new Node(value, null);
			head = node;
			inserted = true;
		}
		else {
			if(value < head.getData()) {
				Node node = new Node(value, head);
				head = node;
				inserted = true;
			}
			else {
				Node search = head;
				while(search != null) {
					if(search.getNext() != null) {
						if(search.getData() < value && search.getNext().getData() > value) {
							Node node = new Node(value, search.getNext());
							search.setNext(node);
							inserted = true;
							break;
						}
					}
					search = search.getNext();
				} 
				if(search == null && value > getTail().getData()) {
					append(value);
					count--;
					inserted = true;
				}
			}
		}
		if(inserted) count++;
		return inserted;
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
	public boolean insertDescNoDup(float value) {
		boolean inserted = false;
		if(isEmpty()) {
			Node node = new Node(value, null);
			head = node;
			inserted = true;
		}
		else {
			if(value > head.getData()) {
				Node node = new Node(value, head);
				head = node;
				inserted = true;
			}
			else {
				Node search = head;
				while(search != null) {
					if(search.getNext() != null) {
						if(search.getData() > value && search.getNext().getData() < value) {
							Node node = new Node(value, search.getNext());
							search.setNext(node);
							inserted = true;
							break;
						}
					}
					search = search.getNext();
				} 
				if(search == null && value < getTail().getData()) {
					append(value);
					count--;
					inserted = true;
				}
			}
		}
		if(inserted) count++;
		return inserted;
	}
	
	//method that receives no parameters,
	//removes the head and returns it's value
	public Node removeHead() { 
		if(isEmpty()) return null;
		Node node = new Node(head.getData(), null);
		head = head.getNext();
		count--;
		return node;
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