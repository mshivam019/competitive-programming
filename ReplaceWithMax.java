public class ReplaceWithMax {
    public static int[][] replaceWithMax(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Find maximum value in each column
        int[] maxValues = new int[n];
        for (int j = 0; j < n; j++) {
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                maxVal = Math.max(maxVal, matrix[i][j]);
            }
            maxValues[j] = maxVal;
        }

        // Replace -1 with maximum value in respective column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = maxValues[j];
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        // Example 1
        int[][] matrix1 = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}};
        int[][] output1 = replaceWithMax(matrix1);
        printMatrix(output1);

        // Example 2
        int[][] matrix2 = {{3, -1}, {5, 2}};
        int[][] output2 = replaceWithMax(matrix2);
        printMatrix(output2);
    }

    // Helper method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


// Given a 0-indexed m x n integer matrix matrix, create a new 0-indexed matrix called answer. Make answer equal to matrix, then replace each element with the value -1 with the maximum element in its respective column.

// Return the matrix answer.

// example 1

// Input: matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
// Output: [[1,2,9],[4,8,6],[7,8,9]]
// Explanation: The diagram above shows the elements that are changed (in blue).
// - We replace the value in the cell [1][1] with the maximum value in the column 1, that is 8.
// - We replace the value in the cell [0][2] with the maximum value in the column 2, that is 9.

// example 2
// Input: matrix = [[3,-1],[5,2]]
// Output: [[3,2],[5,2]]
// Explanation: The diagram above shows the elements that are changed (in blue).
