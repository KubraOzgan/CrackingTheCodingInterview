package treesAndGraphs;

public class Successor {
	//Amac find dan buyuk en kucugu bulmak: find in saginin solunu almak, eger solu toksa sag ana node u almaj
	private static TreeNode inorderSuccessor(TreeNode node, TreeNode find) {
		
		if(node == null)
			return null;
		TreeNode next = null, curr = node;
		while(curr != null && curr.data != find.data) {
			if(curr.data > find.data) {
				next = curr; // Soldakinin sagi yoksa nexti gondermeliyiz, 20 nin sagi yok diyelim ozaman 40'ý vermeli
				curr = curr.left;
			}
			else {//burda next degismez cunku curr root'tan buyuk, bu yuzden rootu donduremeyiz
				curr = curr.right;
			}
		}
		if(curr == null) {
			return null;
		}
		if(curr.right != null) { // Root icin direk buraya gelir, sagi yoksa next = null oldugu icin null doner
			curr = curr.right;
			while(curr.left != null) { // 20 icin saga git 30 var. 30un solu var => 28, eger olmasaydi 30(sag ana node) olurdu
				curr = curr.left;
			}
			return curr;
		}
		else {
			return next;
		}
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
		
		TreeNode node = inorderSuccessor(root, root.right);
		
		if(node == null)
			System.out.println("null");
		else {
			System.out.println(node.data);
		}
		
	}

}
