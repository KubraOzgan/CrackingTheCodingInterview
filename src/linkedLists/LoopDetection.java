package linkedLists;

import linkedLists.LinkedList.Node;

public class LoopDetection {
	
	boolean detectLoop(Node head) {
		Node first = head;
		Node second = head;
		
		while(first != null && first.next != null && second != null) {
			
			/*if(first == second) Eger basta first = head.next dersek olur, aksi halde ikiside headi gosterdigi icin true doner
				return true;*/
			first = first.next.next;
			second = second.next;
			
			if(first == second)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
