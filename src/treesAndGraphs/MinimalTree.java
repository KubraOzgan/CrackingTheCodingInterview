package treesAndGraphs;

public class MinimalTree {
	
	static NodeBST minimalTree(int[] array, int start, int end) { 
		if(end < start) return null;
		
		int mid = (start + end) / 2;
		System.out.println("***" + array[mid]);
		NodeBST node = new NodeBST(array[mid]);
		node.left = minimalTree(array, start, mid - 1);
		node.right = minimalTree(array, mid + 1, end);
		
		return node;
	}
	
	static NodeBST minimalTree(int[] array) {
		return minimalTree(array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		
		int array[] = {1,3,5,7,9,10};
		
		NodeBST node= minimalTree(array);
		
		node.printInOrder();

	}

}
