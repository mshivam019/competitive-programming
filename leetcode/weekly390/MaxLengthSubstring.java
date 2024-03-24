// Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
 

// Example 1:

// Input: s = "bcbbbcba"

// Output: 4

// Explanation:

// The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".
// Example 2:

// Input: s = "aaaa"

// Output: 2

// Explanation:

// The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".


public class MaxLengthSubstring {
    public static int maxLengthSubstring(String s) {
        int n = s.length();
        int[] count = new int[128];
        int start = 0, end = 0, maxLen = 0;
        while (end < n) {
            count[s.charAt(end)]++;
            while (!isValid(count)) {
                count[s.charAt(start)]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }

    private static boolean isValid(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthSubstring("bcbbbcba"));  // Output: 4
        System.out.println(maxLengthSubstring("aaaa"));      // Output: 2
    }
}
