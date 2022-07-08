package linkedLists;

public class Palindrome {
	
	class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	static Node head;
	
	void insert(int data) {
		
		Node newNode = new Node(data);
		newNode.next = null;
		if(head == null) {
			head = newNode;
			return;
		}
		Node node = head;
		while(node.next != null)
			node = node.next;
		node.next = newNode;
	}
	
	void print() {
		Node node = head;
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	static Node reverse(Node head) {
		Node prev = null, right = null;
		
		while(head != null) {
			right = head.next;
			head.next = prev;
			prev = head;
			head = right;
		}
		return prev;
	}
	
	static boolean isPalindrome(Node node) {
		Node rev = reverse(node);
		while(node != null) {
			if(node.data != rev.data)
				return false;
			node = node.next;
			rev = rev.next;
		}
		return node == null && rev == null;
	}

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		p.insert(6);
		p.insert(7);
		p.insert(7);
		p.insert(6);
		p.print();
		//head = Palindrome.reverse(head);
		//System.out.println("\nReverse");
		//p.print();
		
		System.out.println(Palindrome.isPalindrome(head));
				
	}

}
