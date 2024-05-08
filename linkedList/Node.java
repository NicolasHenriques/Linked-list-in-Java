package linkedList;

public class Node {
	//declaring node atributes
	private float data;
	private Node next;
	
	//constructor methods
	public Node() {
		this.data = 0.0f;
		this.next = null;
	}
	
	public Node(float data) {
		this.data = data;
		this.next = null;
	}
	
	public Node(float data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	//getters and setters methods
	public float getData() {
		return data;
	}
	
	public void setData(float data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	//toString method
	@Override
	public String toString() {
		return "data: " + data + " | next: " + (next == null ? "null" : next.getData());
	}
}
