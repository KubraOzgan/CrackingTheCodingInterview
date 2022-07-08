package graphs;

import java.util.*;

public class TheMazeBFS {
	
	public static boolean hasPath(int[][] maze, int[] start, int[] end) {
			
		int row = maze.length, column = maze[0].length;
		boolean visited[][] = new boolean[row][column];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		
		int[][] dirs = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
		
		while(!queue.isEmpty()) {
			int[] position = queue.poll();
			if(position[0] == end[0] && position[1] == end[1]) {
				return true;
			}
			
			for(int[] dir : dirs) {
				int x= position[0], y = position[1];
				
				while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
				}
				
				x -= dir[0];
				y -= dir[1];
				
				if(!visited[x][y]) {
					visited[x][y] = true;
					queue.add(new int[] {x, y});
				}
			}
		}
		
		return false;
			
	}
	
	
	public static void main(String[] args) {
			
		int[][] maze = {
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0}
		};
			
		int start[] = {0,4};
		int end[] = {4,4};
		System.out.println(hasPath(maze, start, end));
	
	}

}
