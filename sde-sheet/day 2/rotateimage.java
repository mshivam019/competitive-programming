
import java.util.ArrayList;

public class rotateimage {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = m - 1;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = mat.get(i).get(j);
            }

        }
        while (((endX - startX + 1) * (endY - startY + 1) > 1) && (endX - startX) >= 1 && (endY - startY) >= 1) {
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (i == startX || i == endX || j == startY || j == endY) {
                        if (i == startX && j != startY) {
                            result[i][j] = mat.get(i).get(j - 1);

                        }
                        if (i == endX && j != endY) {
                            result[i][j] = mat.get(i).get(j + 1);

                        }
                        if (j == endY && i != startX) {
                            result[i][j] = mat.get(i - 1).get(j);

                        }
                        if (j == startY && i != endX) {
                            result[i][j] = mat.get(i + 1).get(j);

                        }
                    }
                }
            }

            startX++;
            startY++;
            endX--;
            endY--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat.get(i).set(j, result[i][j]);
            }
        }
    }

    static void swap(ArrayList<ArrayList<Integer>> mat, Integer i1, Integer j1, Integer i2, Integer j2) {
        Integer t = mat.get(i1).get(j1);
        mat.get(i1).set(j1, mat.get(i2).get(j2));
        mat.get(i2).set(j2, t);

        // wasn't sure if I should take int or Integer so I took Integer as variable;
    }

    public void rotate(int[][] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][n - 1 - j];
                arr[i][n - 1 - j] = temp;
            }
        }
    }
}
