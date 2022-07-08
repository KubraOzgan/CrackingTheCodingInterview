package treesAndGraphs;

public class TreeNode { //<T>
	
	public int data;
	public TreeNode left, right, parent;
	
	public TreeNode(int data) {
		this.data = data; 
	}
	
	public void insert(int value) {
		if(value <= data) {
			if(left == null) {
				left = new TreeNode(value);
			}
			else {
				left.insert(value); //If it has left, then go there and insert
			}
		}
		else {
			if(right == null) {
				right = new TreeNode(value);
			}
			else {
				right.insert(value);
			}
		}
	}
}
