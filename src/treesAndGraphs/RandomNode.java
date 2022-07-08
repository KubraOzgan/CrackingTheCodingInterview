package treesAndGraphs;

import java.util.Random;

class TreeNodeR {
	
	private int data, size = 0;
	public TreeNodeR left, right;
	
	public TreeNodeR(int d) {
		data = d;
		size = 1;
	}
	
	public void insertInOrder(int d) {
		
		if(d < data) { // <= ??
			if(left == null) {
				left = new TreeNodeR(d);
			}
			else {
				left.insertInOrder(d);
			}
		}
		else {
			if(right == null) {
				right = new TreeNodeR(d);
			}
			else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public int data() {
		return data;
	}
	
	public TreeNodeR find(int d) {
		if(d == data) {
			return this;
		}
		else if(d < data) { // <= ??
			return left != null ? left.find(d) : null;
		}
		else if(d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	public TreeNodeR getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		
		if(index < leftSize) {
			return left.getRandomNode();
		}
		else if(index == leftSize) {
			return this;
		}
		else {
			return right.getRandomNode();
		}
	}
	
}

public class RandomNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
