package linkedLists;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class SumLists2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode temp = null, result = null;
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int value1 = (l1 == null) ? 0 : l1.val;
            int value2 = (l2 == null) ? 0 : l2.val;
            
            ListNode newNode = new ListNode((value1 + value2 + carry) %10);
            
            if(temp == null) {
                temp = newNode;
                result = temp;
            }
            else {
                temp.next = newNode;
                temp = temp.next;
            }
            carry = (value1 + value2 + carry) / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry != 0) {
            ListNode last = new ListNode(carry);
            temp.next = last;
            
        }
        
        return result;
    }
}