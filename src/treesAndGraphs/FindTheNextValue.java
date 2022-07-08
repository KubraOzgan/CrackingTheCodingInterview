package treesAndGraphs;

import java.util.*;

public class FindTheNextValue {
	
	private static void inOrder(TreeNode node, List<Integer> list) {
		if (node == null)
            return;
		
		inOrder(node.left, list);
		list.add(node.data);
		inOrder(node.right, list);
	}
	
	private static int findNext(List<Integer> list, int value) {
		if(list.isEmpty())
			return -1;
		for(int i=0; i<list.size()-1; i++) {
			if(list.get(i) == value)
				return list.get(i + 1);
		}
		
		return -1;
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
		
		List<Integer> list = new ArrayList<>();
		
		inOrder(root, list);
		System.out.println(findNext(list, 50));;
		
	}

}
