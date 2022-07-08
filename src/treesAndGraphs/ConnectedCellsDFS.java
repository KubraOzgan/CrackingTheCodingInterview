package treesAndGraphs;

public class ConnectedCellsDFS {
	
	public static int getRegionSize(int[][] matrix, int row, int column) {
		if(row<0 || column<0 || row>=matrix.length || column>=matrix[row].length) {
			return 0;
		}
		if(matrix[row][column] == 0) {
			return 0; //give size 0 in the bottom for loop search
		}
		int size = 1;
		matrix[row][column] = 0; //Visited
		
		// horizontal vertical cross
		for(int r=row-1; r<=row+1; r++) { // one up one down
			for(int c=column-1; c<=column+1; c++) { //one left one right
				if(r != row || c != column) { //Don't search yourself, let say we sent 1,1 to this func so don't check that but check 1,0 1,2 ..... 0,1 0,2.....
					size += getRegionSize(matrix, r, c);
				}
			}
		}
		return size;
	}
	
	
	public static int getBiggestRegion(int[][] matrix) {
		int maxRegion = 0;
		
		for(int row=0; row<matrix.length; row++) {
			for(int column=0; column<matrix[0].length; column++) {
				if(matrix[row][column] == 1) {
					int size = getRegionSize(matrix, row, column);
					maxRegion = Math.max(size, maxRegion);
				}
			}
		}
		return maxRegion;
	}

	public static void main(String[] args) {
		
		int[][] matrix = {
				{0, 0, 0, 1, 1, 0, 0},
				{0, 1, 0, 0, 1, 1, 0},
				{1, 1, 0, 1, 0, 0, 1},
				{0, 0, 0, 0, 0, 1, 0},
				{1, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
		};
		
		System.out.println(getBiggestRegion(matrix));
				

	}

}
