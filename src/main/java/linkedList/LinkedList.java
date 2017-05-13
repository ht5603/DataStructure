package linkedList;

public class LinkedList<T> {
	
	public Node<T> first;
	public Node<T> last;

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
//		list.delete(3);
		list.myReverse();
		list.print();
		

	}
	
	public boolean isEmpty(){
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void print(){
		Node<T> tempNode = null;
		if( ! isEmpty()){
			tempNode = first;
			while(true) {
				System.out.println("content:" + tempNode.t);
				if( tempNode.next != null ) {
					tempNode = tempNode.getNext();
				} else {
					break;
				}
			}
		
		}
	}
	
	public void insert(T t) {
		Node<T> node = new Node<T>(t);
		if ( isEmpty() ) {
			first = node;
			last = node;
		} else {
			last.setNext(node);
			last = node;
		}
	}
	
	public void delete(T deleteData) {
		Node<T> node = new Node<T>(deleteData);
		System.out.println("deleteData:"+deleteData);
		System.out.println("first.t:"+ first.t);
		System.out.println("last.t:"+last.t);
		
		System.out.println("newNode.t:"+node.t);
		
		if ( first.t == deleteData ) {
			first = first.next;
			return;
		}
		if ( last.t == node.t ) {
			node = first;
		 while (node.next != last) {
			 node = node.next;
		 }
		 node.next = null;
		 last = node;
		 return;
		}
		Node<T> newNode = first;
		Node<T> temp = first;
		while( node.t != newNode.t ) {
			temp = newNode;
			newNode = newNode.next;
		}
		temp.next = newNode.next;
	}
	
	public void reverse(){
		
		if (isEmpty()) {
			return;
		}
		Node previous = null;
		Node current = first;
		Node preceding = first.next;
		
		while( preceding != null ) {
			current.next = previous;
			previous = current;
			current = preceding;
			preceding = preceding.next;
		}
		current.next = previous;
		first = current;
	}
	
public void myReverse(){
		
		if (isEmpty()) {
			System.out.println("list is empty");
			return;
		}
		Node prev = null;
		Node curr = first;
		while(curr != null ) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			first = prev;
		}
		
		
}

}
