// You are given an array happiness of length n, and a positive integer k.

// There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.

// In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.

// Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.

 

// Example 1:

// Input: happiness = [1,2,3], k = 2
// Output: 4
// Explanation: We can pick 2 children in the following way:
// - Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].
// - Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.
// The sum of the happiness values of the selected children is 3 + 1 = 4.
// Example 2:

// Input: happiness = [1,1,1,1], k = 2
// Output: 1
// Explanation: We can pick 2 children in the following way:
// - Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].
// - Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].
// The sum of the happiness values of the selected children is 1 + 0 = 1.
// Example 3:

// Input: happiness = [2,3,4,5], k = 1
// Output: 5
// Explanation: We can pick 1 child in the following way:
// - Pick the child with the happiness value == 5. The happiness value of the remaining children becomes [1,2,3].
// The sum of the happiness values of the selected children is 5.

import java.util.Arrays;

public class MaxHappiness {
    public static long maxHappiness(int[] happiness, int k) {
        // Create an array to store the original indices of the elements
        Arrays.sort(happiness);
        reverse(happiness);
        int totalHappiness = 0;
        for (int i = 0; i < k; i++) {
          int currentHappiness = Math.max(happiness[i] - i, 0); 
          totalHappiness += currentHappiness;
        }
        return totalHappiness;
    }

    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example 1
        int[] happiness1 = { 1, 2, 3 };
        int k1 = 2;
        long output1 = maxHappiness(happiness1, k1);
        System.out.println("Example 1: " + output1); // Output: 4

        // Example 2
        int[] happiness2 = { 1, 1, 1, 1 };
        int k2 = 2;
        long output2 = maxHappiness(happiness2, k2);
        System.out.println("Example 2: " + output2); // Output: 1

        // Example 3
        int[] happiness3 = { 2, 3, 4, 5 };
        int k3 = 1;
        long output3 = maxHappiness(happiness3, k3);
        System.out.println("Example 3: " + output3); // Output: 5

        // Example 4
        int[] happiness4 = { 12, 1, 42 };
        int k4 = 3;
        long output4 = maxHappiness(happiness4, k4);
        System.out.println("Example 4: " + output4); // Output: 53
    }
}
