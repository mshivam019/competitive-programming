// You are given a 0-indexed integer matrix grid and an integer k.

// Return the number of submatrices that contain the top-left element of the grid, and have a sum less than or equal to k.

// Example 1:
// Input: grid = [[7,6,3],[6,6,1]], k = 18
// Output: 4
// Explanation: There are only 4 submatrices, [[7]],[[7,6]],[[7],[6]],[[7,6,3]] that contain the top-left element of grid, and have a sum less than or equal to 18.

// Example 2:
// Input: grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
// Output: 6
// Explanation: There are only 6 submatrices,[[7]],[[7,2]],[[7,2,9]],[[7,2],[1,5]],[[7],[1]],[[7],[1],[2]] that contain the top-left element of grid, and have a sum less than or equal to 20.
public class SubmatricesWithSum {

    public static int numSubmat(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j-1] + grid[i][j];
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += matrix[i][j];
                if (sum <= k) res++;
                else break;
            }
        }
        return res;
       
    }

    public static void main(String[] args) {
        // Example 1
        int[][] grid1 = { { 7, 6, 3 }, { 6, 6, 1 } };
        int k1 = 18;
        int output1 = numSubmat(grid1, k1);
        System.out.println(output1); // Output: 4

        // Example 2
        int[][] grid2 = { { 7, 2, 9 }, { 1, 5, 0 }, { 2, 6, 6 } };
        int k2 = 20;
        int output2 = numSubmat(grid2, k2);
        System.out.println(output2); // Output: 6
    }
}
