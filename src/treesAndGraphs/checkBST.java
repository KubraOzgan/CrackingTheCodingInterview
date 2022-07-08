//BigO is O(n) and it efficient because we have to check all the nodes
//if it's a balanced tree space is logn because of recursive complexity

package treesAndGraphs;

class NodeB {
	int data;
	NodeB left, right;
}

public class checkBST {
	
	boolean check(NodeB root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.data < min || root.data > max) {
			return false;
		}
		
		return check(root.left, min, root.data - 1) && check(root.right, root.data + 1, max);
		
	}
	
	boolean check(NodeB root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
}

/*if(node.val <= min || node.val >= max)
    return false;

return check(node.left, min, node.val) && check(node.right, node.val, max);*/