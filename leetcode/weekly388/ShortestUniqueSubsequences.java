// You are given an array arr of size n consisting of non-empty strings.

// Find a string array answer of size n such that:

// answer[i] is the shortest substring of arr[i] that does not occur as a substring in any other string in arr. If multiple such substrings exist, answer[i] should be the lexicographically smallest. And if no such substring exists, answer[i] should be an empty string.
// Return the array answer.

// Example 1:

// Input: arr = ["cab","ad","bad","c"]
// Output: ["ab","","ba",""]
// Explanation: We have the following:
// - For the string "cab", the shortest substring that does not occur in any other string is either "ca" or "ab", we choose the lexicographically smaller substring, which is "ab".
// - For the string "ad", there is no substring that does not occur in any other string.
// - For the string "bad", the shortest substring that does not occur in any other string is "ba".
// - For the string "c", there is no substring that does not occur in any other string.
// Example 2:

// Input: arr = ["abc","bcd","abcd"]
// Output: ["","","abcd"]
// Explanation: We have the following:
// - For the string "abc", there is no substring that does not occur in any other string.
// - For the string "bcd", there is no substring that does not occur in any other string.
// - For the string "abcd", the shortest substring that does not occur in any other string is "abcd".

import java.util.Arrays;

public class ShortestUniqueSubsequences {

    public static String[] findShortestUniqueSubsequences(String[] arr) {
        int n = arr.length;
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            String best = null;
            for (int j = 0; j < arr[i].length(); j++) {
                inner: for (int k = j + 1; k <= arr[i].length(); k++) {
                    String t = arr[i].substring(j, k);
                    for (int l = 0; l < n; l++) {
                        if (l == i)
                            continue;
                        if (arr[l].contains(t)) {
                            continue inner;
                        }
                    }
                    if (best == null || t.length() < best.length()
                            || (t.length() == best.length() && t.compareTo(best) < 0)) {
                        best = t;
                    }
                }
            }
            if (best == null)
                best = "";
            ret[i] = best;
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] arr1 = { "cab", "ad", "bad", "c" };
        String[] result1 = findShortestUniqueSubsequences(arr1);
        System.out.println("Test Case 1: " + Arrays.toString(result1)); // Output: [ab, "", ba, ""]

        String[] arr2 = { "abc", "bcd", "abcd" };
        String[] result2 = findShortestUniqueSubsequences(arr2);
        System.out.println("Test Case 2: " + Arrays.toString(result2)); // Output: ["", "", "abcd"]

        String[] arr3 = { "gfnt", "xn", "mdz", "yfmr", "fi", "wwncn", "hkdy" };
        String[] result3 = findShortestUniqueSubsequences(arr3);
        System.out.println("Test Case 3: " + Arrays.toString(result3)); // Output: ["g","x","z","r","i","c","h"]
    }
}
