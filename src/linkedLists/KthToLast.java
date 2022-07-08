package linkedLists;

public class KthToLast {
	
//	static class Node {
//		int data;
//		Node next;
//		
//		Node(int d) {
//			data = d;
//			next = null;
//		}
//	}
	
	static int findSize(LinkedList.Node node) {
		int len = 0;
		while(node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
	
	static int findKthToLast(LinkedList.Node node, int k) {
		LinkedList.Node curr = node;
		LinkedList.Node follower = node;
		int count = 1;
		
		int size = findSize(curr);
		if(size == k || curr == null) {
			return -1;	
		}
		
		while(curr.next != null) {
			if(count <=k) { //k adým git
				curr = curr.next;
				count++;
			} 	
			else { //curr son olana kadar c ve f hareket etsin, zaten arada k fark vardý, c son olunca f nin oldugu yer cevaptýr
				curr = curr.next;
				follower = follower.next;
			}			
		}
		
		return follower.data;
		
		/*// Iterate curr forward by n. If you reach the end of the list then it is 
	    // shorter than k, so you can't possible have an nth-to-last node
		 for(int i=0; i<k; i++) {
		 	if(curr == null) 
		 		return -1; //return null; 	Out of bonds
		 	curr = curr.next;
		 }
		 
		// If length is exactly k, the kth-to-last node would be null
		 //Ustte curr = curr.next yaptigimiz icin kontrol et
		 if (curr == null) 
			 return -1;
		 
		 while(curr.next != null) { //curr.next dersek son eleman icin calismiyor curr != null dersek k 2 icin 4 veriyot
		 	curr = curr.next;
		 	follower = follower.next;
		 }
		 
		 return follower.data;*/
		 
		
	}

	public static void main(String[] args) {

		LinkedList llist = new LinkedList();
		 
        llist.insertEnd(1);
        llist.insertEnd(2);
        llist.insertEnd(3);
        llist.insertEnd(4);
        llist.insertEnd(5);
       
       System.out.println(findKthToLast(llist.head, 3));

	}
	/* k 1 -> 4
	   k 2 -> 3
	   k 3 -> 2 */
}
