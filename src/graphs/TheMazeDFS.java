package graphs;

public class TheMazeDFS {
	
	public static boolean hasPath(int[][] maze, int[] start, int[] end) {
		
		int row = maze.length, column = maze[0].length;
		boolean visited[][] = new boolean[row][column];
		return dfs(maze, start, end, visited);
	    
	}
	
	public static boolean dfs(int[][] maze, int[] position, int[] end, boolean[][] visited) {
		
		if(visited[position[0]][position[1]]) { //If it's visited, can't go there
			return false;
		}
		if(position[0] == end[0] && position[1] == end[1]) {
			return true;
		}
		visited[position[0]][position[1]] = true;
		
		int[][] dirs = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
		
		for(int[] dir : dirs) {
			int x = position[0], y = position[1];
			
			while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
				x += dir[0];
				y += dir[1];
			}
			if(dfs(maze, new int[] {x - dir[0], y - dir[1]}, end, visited)) {
				return true;
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
