public class WordReversion {
    public static int minTimeToRevert(String s, int k) {
        int n = s.length(), v = 0, dp[] = new int[n];
        for (int i = 1; i < n; i++) { // kmp
            while (v > 0 && s.charAt(i) != s.charAt(v)) {
                v = dp[v - 1];
            }
            v = dp[i] = v + (s.charAt(i) == s.charAt(v) ? 1 : 0);
        }
        while (v > 0 && (n - v) % k > 0) {
            v = dp[v - 1];
        }
        return (n - v + k - 1) / k;
    }

    public static void main(String[] args) {
        // Example usage:
        String word1 = "abacaba";
        int k1 = 3;
        System.out.println(minTimeToRevert(word1, k1));  // Output: 2

        String word2 = "abacaba";
        int k2 = 4;
        System.out.println(minTimeToRevert(word2, k2));  // Output: 1

        String word3 = "abcbabcd";
        int k3 = 2;
        System.out.println(minTimeToRevert(word3, k3));  // Output: 4
    }
}
