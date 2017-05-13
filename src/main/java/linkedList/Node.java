package linkedList;

public class Node <T>{

	
	T t ;
	Node<T> next;
	
	public Node( T t ) {
		this.t = t;
		this.next = null;
	};
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}


}
