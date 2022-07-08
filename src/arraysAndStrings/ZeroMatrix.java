package arraysAndStrings;

public class ZeroMatrix {
	
	public static void zero(int [][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] row = new boolean[matrix .length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			if(row[i])
				rowZero(matrix, i);
		}
		
		for(int i=0; i<n; i++) {
			if(column[i])
				columnZero(matrix, i);
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j]+ "\t");
			}
			System.out.println();
		}
	}
	
	public static void rowZero(int matrix[][], int row) {
		for(int i=0; i<matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}
	
	public static void columnZero(int matrix[][], int col) {
		for(int i=0; i<matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public static void main(String[] args) {

		int matrix[][] = {
				{0, 7, 6, 5},
				{1, 1, 1, 1},
				{2, 2, 0, 2},
				{3, 3, 3, 3},
				{3, 3, 0, 3}
		};
		
		zero(matrix);

	}

}
