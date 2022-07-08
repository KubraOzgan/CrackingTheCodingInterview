package linkedLists;

import java.util.Stack;

import linkedLists.RemoveDups.Node;

public class SumLists {
	
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
	
	static Node insertBefore(Node list, int data) {
		Node newNode = new Node(data);
		newNode.next = list;
		list = newNode;
		
		return list;
	}

	static Node addZero(Node node, int process) {
		Node temp = node;
		for(int i=0; i<process; i++) {
			//temp = insertBefore(temp, 0);
			temp = insertEnd(temp, 0);
		}
		return temp;
	}
	
	static Node sum(Node l1, Node l2) {
		
		Node newNode = null, temp = null, result=null;
		int carry = 0;
		
		int len1 = length(l1), len2 = length(l2);
		
		if(len1 < len2) {
			l1 = addZero(l1, len2 - len1);
		}
		else {
			l2 = addZero(l2, len1 - len2);
		}
		
		while(l1 != null) { // || l2 != null gerek yok cunku boyutlarini esitledik
			newNode = new Node((l1.data + l2.data + carry) % 10);
			if(temp == null) { //Ilk toplami head yap
				temp = newNode;
				result = temp; //resulta tempi(HEAD) attýk, temp'te yapilan tum islemler resulta gider.
			}
			else {//Gelenleri sona ekle
				temp.next = newNode;
				temp = temp.next;
			}
			carry = (l1.data + l2.data + carry) / 10;
			l1 = l1.next;
			l2 = l2.next;
			
		}
		if(carry != 0) { 
			Node last = new Node(carry);
			temp.next = last;
			//last.next = null;
		}
		return result;
	}
	
	static Node forwardSum(Node l1, Node l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Node result=null, newNode = null, now = new Node(0);
		int sum = 0;
		
		while(l1 != null) {
			s1.push(l1.data);
			l1 = l1.next;
		}
		while(l2 != null) {
			s2.push(l2.data);
			l2 = l2.next;
		}
		while(!s1.empty() || !s2.empty()) {
			if(!s1.empty()) {
				sum += s1.pop();
			}
			if(!s2.empty()) {
				sum += s2.pop();
			}
			System.out.println(sum);
			//Her seferinde now degeri degistigi isin now = new Node(sum%10); OLMAZ. Bu yuzden basta da now'i null yerine 0'a atadik.
			now.data = (sum%10);
			
			newNode = new Node(sum/10); 
			newNode.next = now; 
			now = newNode;
			sum = sum/10; 
			//newNode un degerini degistirerek gidiyoruz, en son icine 1 yazildi (carry) 1 308
			//newNode carry icin bir fazladan gidiyor diyebiliriz
		}
		
		//return now;
		if(now.data == 0) {
			return now.next; //aksi halde 716 + 192icin 0908 yazar (newNode sum/10 dan dolayý)
		}
		else {
			return now;
	}
	}
	
	static void printList(Node head) {
		
		Node node = head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(7);
		insertEnd(head, 1);
		insertEnd(head, 6);
		Node head2 = new Node(5);
		insertEnd(head2, 9);
		insertEnd(head2, 2);
		//head2 = insertBefore(head2, 1);
		//printList(head2);
		Node list = forwardSum(head, head2);
		printList(list);
	}

}
