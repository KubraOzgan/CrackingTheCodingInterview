package linkedLists;

import linkedLists.SumLists.Node;

public class Intersection {
	
	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
		
	static Node insertEnd(Node head, int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			//head = new Node(data);
			head = newNode;
			head.next = null;
			//return; // Don'd do the following
			newNode.next = null;
		}
		//newNode.next = null;
		
		else {
			Node node = head;
			while(node.next != null)
				node = node.next;
			node.next = newNode;
		}
		return head;
	}
	
	static int length(Node node) {
		int len = 0;
		
		while(node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
	
	static int getIntersect(Node l1, Node l2) {
		int diff = 0;
		
		if(length(l1) < length(l2)) {
			diff = length(l2) - length(l1);
			return findIntersect(l2, l1, diff);
		}
		else {
			diff = length(l1) - length(l2);
			return findIntersect(l1, l2, diff);
		}
		
	}
	
	static int findIntersect(Node node1, Node node2, int diff) {
		for(int i=0; i<diff; i++) {
			if(node1 == null) {
				return -1;
			}
			node1 = node1.next;
		}
		while(node1 != null && node2 != null) {
			if(node1.data == node2.data) {
				return node1.data;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		return -1;
	}

	public static void main(String[] args) {
		Node head = new Node(3);
		insertEnd(head, 6);
		insertEnd(head, 9);
		insertEnd(head, 15);
		insertEnd(head, 30);
		
		Node head2 = new Node(10);
		insertEnd(head2, 15);
		insertEnd(head2, 30);
        System.out.println(getIntersect(head, head2));

	}

}
