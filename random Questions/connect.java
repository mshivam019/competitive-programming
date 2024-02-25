import java.util.Scanner;

public class connect {

    public static void visit(int[][] ar, boolean[][] v, int i, int j) {
        int size = ar.length;
        if (ar[i][j] == 1) {
            v[i][j] = true;
            if (j > 0 && i < size - 1) {
                visit(ar, v, i + 1, j - 1); // SouthWest
            }
            if (i < size - 1) {
                visit(ar, v, i + 1, j); // South
                if (j < size - 1)
                    visit(ar, v, i + 1, j + 1); // SouthEast
            }
            if (j < size - 1)
                visit(ar, v, i, j + 1); // East
        }
    }

    public static void main(String[] args) {
        int[][] ar;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        ar = new int[n][n];
        boolean[][] v = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = sc.nextInt();
                v[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ar[i][j] == 1 && !v[i][j]) {
                    count++;
                    visit(ar, v, i, j);
                }
            }
        }
        System.out.println(count);
    }
}