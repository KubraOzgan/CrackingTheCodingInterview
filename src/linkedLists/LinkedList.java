package linkedLists;

import linkedLists.LinkedList.Node;

public class LinkedList {
	
	class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	static Node head;
	
	//Insert a new node at FRONT
	public void insertFront(int data) {
		
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	//Insert a new node AFTER A GIVEN NODE
	public void insertAfter(Node prevNode, int data) {
		
		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}
	
	public void insertEnd(int data) {
		
		Node newNode = new Node(data);
		newNode.next = null;
		
		if(head == null) {
			head = newNode;
			return; // Don't do the rest (instead of else)
		}
		
		Node node = head;
		while(node.next != null)
			node = node.next;
		node.next = newNode;
	}
	
	public Node reverse() { //Node node
		Node prev = null, right = null;
		
		while(head != null) {
			right = head.next;
			head.next = prev;
			prev = head;
			head = right;
		}
		return prev;
	}
	
	public void printList() {
		
		Node node = head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	static void sort(Node head) {
		int temp;
		Node node = head;
		Node right;
		while(node != null) {
			right = node.next;
			while(right != null) {
				if(node.data > right.data) {
					temp = node.data;
					node.data = right.data;
					right.data = temp;
				}
				right = right.next;
			}
			node = node.next;
		}
		//return node;
	}
	
	public static void main(String[] args) {
		 /* Start with the empty list */
        LinkedList llist = new LinkedList();
 
        llist.insertEnd(6);
 
        // 7->6->NUllist
        llist.insertFront(7);
 
        // 1->7->6->NUllist
        llist.insertFront(1);
 
        // 1->7->6->4->NUllist
        llist.insertEnd(4);
 
        // 1->7->8->6->4->NUllist
        llist.insertAfter(LinkedList.head.next, 8); //head is static, that's why didn't use llist.head.next
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
        
        System.out.println("\nReverse:");
        head = llist.reverse();
        llist.printList();
	}
	
}


//	/* Start with the empty list */
//	LinkedList llist = new LinkedList();
//	
//	// Insert 6.  So linked list becomes 6->NUllist
//	llist.append(6);
//	
//	// Insert 7 at the beginning. So linked list becomes
//	// 7->6->NUllist
//	llist.push(7);
//	
//	// Insert 1 at the beginning. So linked list becomes
//	// 1->7->6->NUllist
//	llist.push(1);
//	
//	// Insert 4 at the end. So linked list becomes
//	// 1->7->6->4->NUllist
//	llist.append(4);
//	
//	// Insert 8, after 7. So linked list becomes
//	// 1->7->8->6->4->NUllist
//	llist.insertAfter(llist.head.next, 8);
//	
//	System.out.println("\nCreated Linked list is: ");
//	llist.printList();
