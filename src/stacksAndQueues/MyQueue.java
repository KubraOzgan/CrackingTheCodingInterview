package stacksAndQueues;

import java.util.NoSuchElementException;

/*add (item): Add an item to the end of the list.
	remove (): Remove the first item in the list.
	peek () : Return the top of the queue.
	is Empty(): Return true if and only if the queue is empty.*/

public class MyQueue<T> {
	
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first, last;
	
	public void add(T item) {
		QueueNode<T> t = new QueueNode<T>(item);
		
		if(last != null) {
			last.next = t;
		}
		t = last; //iki if de ortak oldugu icin buraya yazdik
		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if(first == null)
			throw new NoSuchElementException();
		T data = first.data;
		first = first.next;
		if(first == null) { //Tek elemanliydiysa
			last = null;
		}
		
		return data;
	}
	
	public T peek() {
		if(first == null)
			throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
