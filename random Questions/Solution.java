// You are given three integers N, M and K.
// It is given that two integers X and Y are called perfectly even if and only if X + Y - X - Y is an even integer.
// An array A of length L is called K-Perfectly Even if there exists exactly K positions i where 1 <= i < L such that the integers A[i] and A[i + 1] ar perfectly even.
// Find the total number of K-Perfectly Even arrays of length N such that each element of that array has a value between 1 and M (both inclusive).
// Since the answer can be very large, return it modulo 10 ^ 9 + 7
// Input Format
// The first line contains an integer, N, denoting one the three given integer.
// The next line contains an integer, M, denoting one the three given integer.
// The next line contains an integer, K, denoting one the three given integer.

// Sample Test Cases
// Case 1
// Input:
// 2
// 2
// 0
// Output:
// 3
// Explanation:
// Given N = 2 M = 2 K = 0
// There exists 3 array which are [1, 1], [1, 2] and [2, 1].
// Hence, the answer for this case is equal to 3.
// Case 2
// Input:
// 2
// 2
// 1
// Output:
// 1
// Explanation:
// Given N = 2 M = 2 K = 1
// There exists only one array which is [2,2].
// Hence, the answer for this case is equal to 1.

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {
    private static final int MOD = 1000000007; // 10^9 + 7

    public static int getArrayCount(int N, int M, int K) {
        // solution here
        int[][] dp = new int[N + 1][M + 1];

        // Base cases
        for (int j = 1; j <= M; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= M; k++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][j]) % MOD; // Without perfectly even condition
                    if ((j + k) % 2 == 0 && K > 0) {
                        dp[i][k] = (dp[i][k] + (dp[i - 1][j] * M) % MOD) % MOD; // With perfectly even condition
                    }
                }
            }
        }

        // Sum the possibilities for all ending elements
        int result = 0;
        for (int j = 1; j <= M; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine().trim());
        int M = Integer.parseInt(scan.nextLine().trim());
        int K = Integer.parseInt(scan.nextLine().trim());
        int result = getArrayCount(N, M, K);
        System.out.println(result);
    }
}