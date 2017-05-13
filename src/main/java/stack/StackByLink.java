package stack;

public class StackByLink {

	public static void main(String[] args) {
		StackByLink stack = new StackByLink();
		stack.put(1);
		stack.put(2);
		stack.put(3);
		stack.pop();
		stack.put(4);
		stack.put(5);
		stack.printStack();

		
	}
	
	public Node front;
	public Node rear;
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public void printStack(){
		Node current = front;
		while(current != null) {
			System.out.println("current data: " + current.data );
			current = current.next;
		}
	}
	
	public void put (int data){
		System.out.println("put: " + data);
		Node newNode = new Node(data);
		if (this.isEmpty()){
			front = newNode;
			rear = newNode;
		}else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public void pop() {
		System.out.println("pop" );
		if (this.isEmpty()){
			System.out.println("===目前為空堆疊===\n");
			return;
		}
		Node newNode = front;
		if (newNode == rear) {
			front = null;
			rear = null;
		}else {
			while(newNode.next != rear){
				newNode = newNode.next;
			}
			newNode.next = null;
			rear = newNode;
		}
		
	}
	

}
