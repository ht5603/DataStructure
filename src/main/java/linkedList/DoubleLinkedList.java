package linkedList;



public class DoubleLinkedList<T> extends LinkedList<T>  {
	
	public static void main(String[] args) {

	}
	
	class Node<T> {
		
		T data;
		Node rnext;
		Node lnext;
		public Node( T data ) {
			this.data = data;
			this.rnext = null;
			this.lnext = null;
		}
	}
	
	public Node first;
	public Node last;
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insert ( T t ) {
		
		Node<T> newN = new Node<T>(t);
		Node<T> tmp;
		Node<T> newNode;
		
		if ( this.isEmpty() ) {
			first = newN;
			first.rnext = last;
			last = newN;
			last.lnext = first;
		}
		else {
			if ( newN.lnext == null ) {
				//插入串列首
				first.lnext = newN;
				newN.rnext = first;
				first = newN;
			} else {
				if ( newN.rnext == null ) {
					//插入串列尾
					last.rnext = newN;
					newN.lnext = last;
					last = newN;
				} else {
					//插入中間節點位置
					newNode = first;
					tmp = first;
					while(newN.rnext != newNode.rnext) {
						tmp = newNode;
						newNode = newNode.rnext;
					}
					tmp.rnext = newN;
					newN.rnext = newNode;
					newNode.lnext = newNode;
					newN.lnext = tmp;
				}
			}
		}
	}
	
	public void delete(T t) {
		Node<T> delNode= new Node<T>(t);
		Node<T> tmp;
		Node<T> newNode;
		if (first == null) {
			System.out.println("this linkedList is null");
			return;
		}
		if(first.data.equals(delNode.data)){
			first = first.rnext;
			first.lnext = null;
		} else if (last.data.equals(delNode.data)) {
			newNode = first;
			while (newNode.rnext != last) {
				newNode = newNode.rnext;
			}
			newNode.rnext = null;
			last = newNode;
		} else {
			newNode = first;
			tmp = first;
			while(! newNode.data.equals(delNode.data)) {
				tmp = newNode;
				newNode=newNode.rnext;
			}
			tmp.rnext = delNode.rnext;
			tmp.lnext = delNode.lnext;
		}
		
	}
	
	

}
