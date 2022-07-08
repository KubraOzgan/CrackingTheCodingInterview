package treesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {
	
	private int V; //Number of vertices
	
	// Array  of lists for adjacency List Representation
	private LinkedList<Integer> adj[];
	
	DFSGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i ) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.println(v + " ");
		
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
		
	}
	
	void DFS(int v) {
		// Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
	}
	

	public static void main(String[] args) {
		
		DFSGraph g = new DFSGraph(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        g.DFS(2);
   
	}

}
