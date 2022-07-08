package treesAndGraphs;

public class PathsWithSum {
	
	int countPathsWithSum(TreeNode root, int targetSum) {
		if(root == null) {
			return 0;
		}
		
		int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
		int pathsOnLeft = countPathsWithSum(root.left, targetSum);
		int pathsOnRight = countPathsWithSum(root.right, targetSum);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	
	int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
		if(node == null) {
			return 0;
		}
		
		currentSum += node.data;
		int totalPaths = 0;
		if(currentSum == targetSum) {
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
		totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
		
		return totalPaths;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
