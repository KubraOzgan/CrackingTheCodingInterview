package treesAndGraphs;

public class FirstCommonAncestor {
	//RECURSION IS GOING BOTTOM TO TOP
	private static TreeNode lca(TreeNode root, TreeNode first, TreeNode second) {
		
		if(root == null) {
			return null;
		}
		if(root == first || root == second) {
			return root;
		}
		TreeNode leftSearch = lca(root.left, first, second);
		TreeNode rightSearch = lca(root.right, first, second);
		
		if(leftSearch == null) {
			return rightSearch;
		}
		if(rightSearch == null) {
			return leftSearch;
		}
		System.out.println(leftSearch.data + "***" + rightSearch.data);
		// If neither of left and right is null, then it means the node I'm holding is the lca
		return root;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(40); 
		root.left = new TreeNode(20); 
		root.left.left = new TreeNode(10); 
		root.left.left.left = new TreeNode(5); 
		root.left.right = new TreeNode(30); 
		root.right = new TreeNode(50); 
		root.right.right = new TreeNode(60); 
		root.left.right.left = new TreeNode(28); 
		root.left.right.right = new TreeNode(32);
		
		//TreeNode node = lca(root, root.left.right.right, root.right.right);
		TreeNode node = lca(root, root.left.left.left, root.left.right.right);
		
		System.out.println(node.data);

	}

}
