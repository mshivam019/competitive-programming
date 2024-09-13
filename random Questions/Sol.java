
// You have an array A of size N.
// You are currently standing at index 0 and want to go to index N + 1 . To move between indices you can perform the following moves:
// • if you are currently present at index 0 then you can go to any index in range [1,N].
// • If you are currently present at index i, where i is in range [1, N] then you can go to any index j such that A[j] is the only maximum element in range [i, j]. Otherwise, you can go to the index N + 1
// Find the total number of possible paths from index 0 to index N + 1 such that the god of all the elements in the path except index 0 and index N + 1 iş equal to 1.
// Since the answer can be very large, return it modulo 10 ^ 9 + 7
// Input Format
// The first line contains an integer, N, denoting the number of elements in A.
// Each line i of the N subsequent lines (where 0 <= i < N) contains an integer describing A[i].

// Sample Test Cases
// Case 1
// Input:
// 1
// 1
// Output:
// 1
// Explanation:
// Given N 1, A- [1].
// There exists only one path as we can move from index 0->1->2.
// Hence, the answer for this case is equal to 1.
// Case 2
// Input:
// 1
// 2
// Output:
// 0
// Explanation:
// Given N 1, A [2].
// There do not exists any path from index 0 to index 2 with gcd equal to 1.
// Hence, the answer for this case is equal to 0.

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Sol {
    private static final int MOD = 1000000007;

    public static int get_ans(int N, List<Integer> A) {
        long[] dp = new long[N + 2];
        dp[0] = 1; // Base case: one way to start at index 0

        for (int i = 1; i <= N; i++) {
            int maxElement = A.get(i - 1);
            int gcd = maxElement;
            
            for (int j = i; j >= 1; j--) {
                gcd = gcd(gcd, A.get(j - 1));
                if (gcd == 1) {
                    dp[i] = (dp[i] + dp[j - 1]) % MOD;
                }
                if (A.get(j - 1) > maxElement) {
                    break;
                }
            }
        }

        // Calculate paths to N+1
        for (int i = 1; i <= N; i++) {
            dp[N + 1] = (dp[N + 1] + dp[i]) % MOD;
        }

        return (int) dp[N + 1];
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine().trim());
        List<Integer> A = new ArrayList<>(N);
        for (int j = 0; j < N; j++) {
            A.add(Integer.parseInt(scan.nextLine().trim()));
        }
        int result = get_ans(N, A);
        System.out.println(result);
    }
}