// Print BFS traversal from a given source vertex.
package treesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {
	
	private int V; // Number of vertices
	private LinkedList<Integer> adj[]; 	// Array  of lists for adjacency List Representation
	
	BFSGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	
	//Add an edge into graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	//Prints BFS traversal from a given source s
	void BFS(int s) {
		// Mark all the vertices as not visited (By default set as false)
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		// Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
        
        while(queue.size() != 0) {
        	s = queue.poll();
        	System.out.println(s + " ");
        	
        	// Get all adjacent vertices of the dequeued vertex s, If a adjacent has not been visited, then mark it
            // visited and enqueue it
        	
        	Iterator<Integer> i = adj[s].listIterator();
        	
        	while(i.hasNext()) {
        		int n = i.next();
        		if(!visited[n]) {
        			visited[n] = true;
        			queue.add(n);
        		}
        	}
        }
		
	}
	
	boolean isReachable(int s, int d) {
		/*Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
		Space Compelxity: O(V). 
		There can be atmost V elements in the queue. So the space needed is O(V).*/
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		
		Iterator<Integer> i;
		while(queue.size() != 0) {
			s = queue.poll();
			
			i = adj[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(n == d)
					return true;
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return false;
	}
	

	public static void main(String[] args) {

		BFSGraph g = new BFSGraph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		 System.out.println("Following is Breadth First Traversal "+
                 "(starting from vertex 2)");

		 g.BFS(2);
		 
		 int u = 1, v = 3;
	     System.out.println(g.isReachable(u, v));
	        
	     u = 3; v = 1;
	     System.out.println(g.isReachable(u, v));
	}

}
