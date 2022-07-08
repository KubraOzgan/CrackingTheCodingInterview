package treesAndGraphs;

public class CheckSubtree {

	// t1 is bigger than t2
	
	boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null) {
			return false;
		}
		else if(s.data == t.data && isSameTree(s, t)) {
			return true;
		}
		else {
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
	}
	
	boolean isSameTree(TreeNode s, TreeNode t) {
		if(s == null || t == null) {
			return s == null && t == null;
		}
		else if(s.data == t.data) {
			return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
		}
		else { 
			return false;
		}
	}
	
	/*boolean containsTree(TreeNode t1, TreeNode t2) {
		if(t2 == null) {
			return true; // The empty tree is always a subtree
		}
		return subTree(t1, t2);
	}
	
	boolean subTree(TreeNode r1, TreeNode r2) {
		if(r1 == null) {
			return false; // Big tree is empty
		}
		else if(r1.data == r2.data && matchTree(r1, r2)) {
			return true;
		}
		return subTree(r1.left, r2) || subTree(r1.right, r2);
	}
	
	boolean matchTree(TreeNode r1, TreeNode r2) {
		if(r1 == null && r2 == null) {
			return true; // Nothing left in the subtree
		}
		else if(r1 == null || r2 == null) {
			return false;
		}
		else if(r1.data != r2.data) {
			return false;
		}
		else {
			return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
		}
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
