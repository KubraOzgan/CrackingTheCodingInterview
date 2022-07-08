package treesAndGraphs;

public class NodeBST {
	
	int data;
	NodeBST left, right;
	
	public NodeBST(int data) {
		this.data = data;
	}
	
	public void insert(int value) {
		if(value <= data) {
			if(left == null) {
				left = new NodeBST(value);
			}
			else {
				left.insert(value); //If it has left, then go there and insert
			}
		}
		else {
			if(right == null) {
				right = new NodeBST(value);
			}
			else {
				right.insert(value);
			}
		}
	}
	
	
	public boolean contains(int value) {
		if(data == value) {
			return true;
		}
		else if(value < data) {
			if(left == null) {
				return false;
			}
			else {
				return left.contains(value);
			}
		}
		else {
			if(right == null) {
				return false;
			}
			else {
				return right.contains(value);
			}
		}
	}
	
	public void printInOrder() { //root.printOrder
		if(left != null) {
			left.printInOrder();
		}
		System.out.println(data);
		if(right != null) {
			right.printInOrder();
		}
	}
	
}
