package linkedList;

public class CircleLinkedList<T> extends LinkedList<T> {
	
	public void print(){
		Node<T> tempNode = null;
		if( ! isEmpty()){
			tempNode = first;
			while(true) {
				System.out.println("content:" + tempNode.t);
				if( tempNode != last ) {
					tempNode = tempNode.getNext();
				} else {
					break;
				}
			}
		
		}
	}


	
	public void insert(T t) {
		
		Node<T> insNode = new Node<T>(t);
		
		if ( this.isEmpty() ) {
			first = insNode;
			last = insNode;
			last.next = first;
		} else if ( insNode.next == null ) {
			last.next = insNode;
			last = insNode;
			insNode.next = first;
		} else {
			Node<T> temp = first;
			Node<T> newNode = first;
			while ( newNode.next != insNode.next ) {
				if ( temp.next == first ) {
					break;
				}
				temp = newNode;
				newNode = newNode.next;
			}
			temp.next = insNode;
			insNode.next = newNode;
		}
 		
	}
	
	public void delete(T t) {
		
		Node<T> temp = first;
		Node<T> newNode = first;
		Node<T> delNode = new Node<T>(t);
		if ( first.t == delNode.t ) {
			last.next = first.next;
			first = first.next;
		} else if ( last.t == delNode.t ) {
			newNode = first;
			while(newNode.next != last){
				newNode = newNode.next;
			}
				newNode.next = last.next;
				last = newNode;
				last.next = first;
		} else {
			while( newNode.t != delNode.t ) {
				temp = newNode;
				newNode = newNode.next;
			}
			temp.next = newNode.next;
		}
		
	}
	
	public static void main(String[] args) {

		LinkedList<Integer> list = new CircleLinkedList<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.delete(3);
		list.print();
	}

}
