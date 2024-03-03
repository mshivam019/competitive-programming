// You are given a 0-indexed n x n grid where n is odd, and grid[r][c] is 0, 1, or 2.

// We say that a cell belongs to the Letter Y if it belongs to one of the following:

// The diagonal starting at the top-left cell and ending at the center cell of the grid.
// The diagonal starting at the top-right cell and ending at the center cell of the grid.
// The vertical line starting at the center cell and ending at the bottom border of the grid.
// The Letter Y is written on the grid if and only if:

// All values at cells belonging to the Y are equal.
// All values at cells not belonging to the Y are equal.
// The values at cells belonging to the Y are different from the values at cells not belonging to the Y.
// Return the minimum number of operations needed to write the letter Y on the grid given that in one operation you can change the value at any cell to 0, 1, or 2.

// Example 1:

// Input: grid = [[1,2,2],[1,1,0],[0,1,0]]
// Output: 3
// Explanation: We can write Y on the grid by applying the changes highlighted in blue in the image above. After the operations, all cells that belong to Y, denoted in bold, have the same value of 1 while those that do not belong to Y are equal to 0.
// It can be shown that 3 is the minimum number of operations needed to write Y on the grid.

// Example 2:
// Input: grid = [[0,1,0,1,0],[2,1,0,1,2],[2,2,2,0,1],[2,2,2,2,2],[2,1,2,2,2]]
// Output: 12
// Explanation: We can write Y on the grid by applying the changes highlighted in blue in the image above. After the operations, all cells that belong to Y, denoted in bold, have the same value of 0 while those that do not belong to Y are equal to 2. 
// It can be shown that 12 is the minimum number of operations needed to write Y on the grid.

public class MinOperationsY {

    public static int minOperations(int[][] grid) {
        int n = grid.length;
        int[] y = new int[3];
        int[] nony = new int[3];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || j == n - i - 1)
                    y[grid[i][j]]++;
                else
                    nony[grid[i][j]]++;
            }
        }
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n / 2)
                    y[grid[i][j]]++;
                else
                    nony[grid[i][j]]++;
            }
        }
        int res = n * n;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;
                res = Math.min(res, n * n - y[i] - nony[j]);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] grid1 = { { 1, 2, 2 }, { 1, 1, 0 }, { 0, 1, 0 } };
        System.out.println(minOperations(grid1)); // Output: 3

        int[][] grid2 = { { 0, 1, 0, 1, 0 }, { 2, 1, 0, 1, 2 }, { 2, 2, 2, 0, 1 }, { 2, 2, 2, 2, 2 },
                { 2, 1, 2, 2, 2 } };
        System.out.println(minOperations(grid2)); // Output: 12
    }
}
