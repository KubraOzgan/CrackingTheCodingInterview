package treesAndGraphs;

public class CheckBalanced {
	
	static int height(TreeNode node) {
		
		if(node == null)
			return -1;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	static boolean isBalanced(TreeNode node) {
		
		if (node == null)
            return true;
		
		int diff = Math.abs(height(node.left) - height(node.right));
		
		return diff <= 1 && isBalanced(node.left) && isBalanced(node.right);
		
	}
	
	public static void main(String[] args) {

		TreeNode node = new TreeNode(15);
		node.insert(13);
		node.insert(8);
		node.insert(9);
		node.insert(17);
		
		TreeNode node2 = new TreeNode(15);
		node.insert(13);
		node.insert(8);
		node.insert(17);
		
		System.out.println(isBalanced(node));
		System.out.println(isBalanced(node2));

	}

}
