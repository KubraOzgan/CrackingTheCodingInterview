package treesAndGraphs;

import java.util.*;

public class ListOfDepts {
	
	//BFS & QUEUE
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); 
        
        if(root == null)
            return result;
        
        if(root != null) {
            queue.add(root);
            while(!queue.isEmpty()) {
                List<Integer> current = new ArrayList<>();
                int size = queue.size();
                while(size > 0) {
                    TreeNode node = queue.remove();
                    current.add(node.data);
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                   size--;
                }
                result.add(current);
            }
        }
       
        return result;
    }
	
	
	//BFS
	static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		//Visit the root
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null) {
			current.add(root);
		}
		while(current.size() > 0) {
			result.add(current); //Add previous level
			
			//Tuttugun node un sol ve sagina git.
			LinkedList<TreeNode> parents = current; //Go to next level
			current = new LinkedList<TreeNode>(); //Sifirla
			for(TreeNode parent : parents) {
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	
	//DFS
	void createLevelLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		
		if(root == null) { //Base case
			return;
		}
		
		LinkedList<TreeNode> list = null;
		if(lists.size() == level) { //Level not contained in list
			list = new LinkedList<TreeNode>();
			/* Levels are always traversed in order. So, if this is the first time we've visited level i, 
			 * we must have seen levels 0 through i-1. We can therefore safely add the level at the end.*/
			lists.add(list);
		}
		else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedListDFS(root.left, lists, level + 1);
		createLevelLinkedListDFS(root.right, lists, level + 1);
	}
	ArrayList<LinkedList <TreeNode>> createLevelLinkedListDFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		return lists;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.insert(7);
		node.insert(1);
		node.insert(24);
		node.insert(3);
		node.insert(2);
		node.insert(16);
		node.insert(0);
		node.insert(6);
		ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(node);
		
		for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j).data + " ");
            }
            System.out.println();
        }
	}

}
