package queue;


class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class Queue {

	public static void main(String[] args) {

		Queue que = new Queue();
		
		que.in(1);
		que.in(2);
		que.in(3);
		que.in(4);
		que.in(5);
		while (que.front != null){
			int val = que.out();
			System.out.println("out:" + val);
		}
		
	}
	
	public Node front;
	public Node rear;
	
	public Queue() {
		front = null;
		rear = null;
	}
	
	public void in(int data) {
		Node newNode = new Node(data);
		if (rear == null){
			front = newNode;
		}else{
			rear.next = newNode;
		}
		rear = newNode;
	}
	
	public int out(){
		int value = 0;
		if(front != null){
			if(front == rear){
				rear = null;
			}
			value = front.data;
			front = front.next;
			return value;
		}else {
			return -1;
		}
	}

}
