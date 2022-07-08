package linkedLists;

import java.util.HashSet;

public class RemoveDups{
	
	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	static void insertEnd(Node head, int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			//head = new Node(data);
			head = newNode;
			head.next = null;
			return; // Don'd do the following
		}
		newNode.next = null;
		
		Node node = head;
		while(node.next != null)
			node = node.next;
		node.next = newNode;
		return;
	}
	
	static void printList(Node head) {
		
		Node node = head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	static void removeDuplicates(Node head) {
		HashSet<Integer> list = new HashSet<>();
		
		Node node = head;
		Node prev = null;
		
		while(node != null) {
			if(list.contains(node.data)) {
				prev.next = node.next;
			}
			else {
				list.add(node.data);
				prev = node;
			}
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(12);
		insertEnd(head, 11);
		insertEnd(head, 12);
		insertEnd(head, 21);
		insertEnd(head, 41);
		insertEnd(head, 43);
		insertEnd(head, 21);
		printList(head);
		
		removeDuplicates(head);
		System.out.println("\nAfter remove:");
		printList(head);
	}

}

//	void deleteDup s(LinkedListNode head) {
//		LinkedListNode current = head;
//		while (current != null) {
//			/* Remove all future nodes that have the same value */
//			LinkedListNode runner = current;
//			while (runner.next != null) {
//				if (runner.next.data == current.data) {
//					runner.next = runner.next.next;
//				} else {
//					runner = runner.next;
//				}
//			}
//			current current.next;
//		}
//	}
