package arraysAndStrings;
//sol üst, üst sað, sað alt, alt sol
public class RotateMatrix {
	
	public static boolean rotate(int [][] matrix) {
		
		if(matrix.length != matrix[0].length)
			return false;
		int n = matrix.length;
		int [][] newMatrix = new int [n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				newMatrix[i][j] = matrix[n-1-j][0];
			}
		}
		
		//matrix = newMatrix;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(newMatrix[i][j]+ "\t");
			}
			System.out.println();
		}

		return true;
		
	}
	
//	static boolean rotate(int[][] matrix) {
		/*for i = 0 to n
				temp= top[i];
				top[i] = left[i]
				left[i] = bottom[i]
				bottom[i] = right[i]
				right[i] = temp*/
//		
//		if (matrix.length== 0 || matrix.length != matrix[0].length) return false;
//		int n = matrix.length;
//		for (int layer = 0; layer < n / 2; layer++) {
//			int first= layer;
//		 	int last= n - 1 - layer;
//		 	for(int i = first; i < last; i++) {
//		 		int offset = i - first;
//		 		int top= matrix[first][i];
//		 		matrix[first][i] =  matrix[last-offset][first];
//		 		
//		 		matrix[last-offset][first] = matrix[last][last - offset];
//		 		
//		 		matrix[last][last - offset] = matrix[i][last];
//		 		
//		 		matrix[i][last]= top; 
//		 	}
//		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(matrix[i][j]+ "\t");
//			}
//			System.out.println();
//		}
//		
//		return true;
//		
//}

	public static void main(String[] args) {
		int matrix[][] = {
				{0, 0, 0, 0},
				{1, 1, 1, 1},
				{2, 2, 2, 2},
				{3, 3, 3, 3}
		};
		
		rotate(matrix);

	}

}
