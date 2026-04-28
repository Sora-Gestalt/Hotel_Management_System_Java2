package Projects;

public class Node {
	Object data;
	Node next;
	Node previous;
	
	Node(Object data){
		this.data = data;
	}
	
	
	public Object getData() {return this.data;}
	public Node getNext() {return this.next;}
	public Node getPrevious() {return this.previous;}

	@Override
	public String toString() { return (this.previous + " <---Previous---Head---Next---> " + this.next);}
	
}
