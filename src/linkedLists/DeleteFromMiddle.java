package linkedLists;

public class DeleteFromMiddle {
	
	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}

	//Don't delete first or last
	static boolean delete(Node node) { //node that will be deleted
		if(node == null || node.next == null)
			return false;
		Node right = node.next;
		node.data = right.data;
		node.next = right.next;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*Note that this problem cannot be solved if the node to be deleted is the last node in the linked list. That's
okay-your interviewer wants you to point that out, and to discuss how to handle this case. You could, for
example, consider marking the node as dummy. */