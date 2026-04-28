package Projects;

public class LinkedList {
	private Node head;
	private Node tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void clearList() {
		this.head = null;
		this.tail = null;
	}
	
	public int size() {
		int counter = 0;
		Node currentNode = this.head;
		
		while(currentNode != null) {
			counter++;
			currentNode = currentNode.next;
		}
		
		return counter;
	}
	
	public void insertAtFront(Object obj) {
		Node newNode = new Node(obj);
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		}
		
		else {
			newNode.next = this.head;
			this.head.previous = newNode;
			this.head = newNode;
		}
	}
	
	public void insertAtBack(Object obj) {
		Node newNode = new Node(obj);
		
		if (this.isEmpty()) {
			this.head = newNode; 
			this.tail = newNode;
		}
		
		else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
	}
	
	public void insertAt(int index, Object obj) {
		if (index <= 0)
			this.insertAtFront(obj);
		else if (index >= this.size())
			this.insertAtBack(obj);
		
		else {
			Node newNode = new Node(obj);
			Node currentNode = head;
			
			for(int i = 0; i < index ; i++) {
				currentNode = currentNode.next;
			}
			
			Node previousNode = currentNode.previous;
			
			// previousNode <==> newNode <==> currentNode
			newNode.next = currentNode;
			currentNode.previous = newNode;
			newNode.previous = previousNode;
			previousNode.next = newNode;
		}
	}
	
	public void removeAtFront() throws NodeDoesntExistException {
		if(this.isEmpty()) {
			throw new NodeDoesntExistException("Empty List");
		}
		
		else if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
		}
		
		else {
			this.head = this.head.next;
			this.head.previous = null;
		}
	}
	
	public void removeAtBack() throws NodeDoesntExistException {
		
		if(this.isEmpty()) {
			throw new NodeDoesntExistException ("Empty List");
		}
		
		else if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
		}
		
		else {
			this.tail = this.tail.previous;
			this.tail.next = null;
		}
	}
	
	public void removeAtIndex(int index) throws NodeDoesntExistException {
		if(this.isEmpty()) {
			throw new NodeDoesntExistException("Empty List");
		}
		
		else if(index < 0 || index >= this.size()) {
			throw new NodeDoesntExistException("IndexOutOfBoundBoundaries");
		}
		
		else if(index == 0)
			this.removeAtFront();
		
		else {
			Node targetNode = head;
			
			for(int i = 0 ; i < index ; i++)
				targetNode = targetNode.next;
			
			if(targetNode.next == null)
				this.removeAtBack();
			
			else {
				Node previousNode = targetNode.previous;
				Node nextNode = targetNode.next;
				
				previousNode.next = nextNode; 
				nextNode.previous = previousNode; 
				targetNode = null;
			}
		}
	}
	
	public String display() {
		if (this.isEmpty())
			return "Empty";
		else {
			String linkedListBuild = "";
			Node currentNode = this.head;
			while(currentNode != null) {
				linkedListBuild += (currentNode.data + "<==>");
				currentNode = currentNode.next;
			}
			
			return linkedListBuild;
		}
	}
	
	@Override
	public String toString() {
		return this.display();
	}
}