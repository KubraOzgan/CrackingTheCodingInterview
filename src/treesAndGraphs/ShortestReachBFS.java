/*package treesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;

public class ShortestReachBFS {
	
	public static class Graph {
		private Node[] nodes;
		private static int EDGE_DISTANCE = 6;
		
		public Graph(int size) {
			
		}
		private class Node {
			
		}
		
		private Node getNode(int id) {
			
		}
		
		public void addEdge(int first, int second) {
			
		}
		
		public int[] shortestReach(int startId) {
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(startId);
			
			//boolean[] visited = new boolean[nodes.length];
			int[] distances = new int[nodes.length];
			Arrays.fill(distances, -1);
			distances[startId] = 0; //distance to itself
			
			while(!queue.isEmpty()) {
				int node = queue.poll();
				
				if(neighbor : nodes[node].neighbors) {
					if(distances[neighbor] == -1) {
						distances[neighbor] = distances[node] + EDGE_DISTANCE; //where we are right now + edge
						queue.add(neighbor);
					}
				}
			}
			
			return distances;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}*/
