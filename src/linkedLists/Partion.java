package linkedLists;

import linkedLists.LinkedList.Node;

public class Partion {
	
	static Node partion(Node node, int x) {
		
		Node head = node, tail = node;
		
		while(node != null) {
			Node next = node.next; //Cunku if de node.next degisiyor!!!!!!!
			if(node.data < x) { //Add fron
				node.next = head;
				head = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		return head;
	}

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		 
        llist.insertEnd(3);
        llist.insertEnd(5);
        llist.insertEnd(8);
        llist.insertEnd(5);
        llist.insertEnd(10);
        llist.insertEnd(2);
        llist.insertEnd(1);
 
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
        
        System.out.println("\nAfter partion:");
        llist.head = partion(llist.head, 5);
        llist.printList();
        
        System.out.println("\nAfter sort:");
        llist.sort(llist.head);
        llist.printList();
	}


}

/*Consider that the elements don't have to stay in the same relative order. We only need
to ensure that elements less than the pivot must be before elements greater than the
pivot. Does that help you come up with more solutions? */