// You are given a positive integer k. Initially, you have an array nums = [1].

// You can perform any of the following operations on the array any number of times (possibly zero):

// Choose any element in the array and increase its value by 1.
// Duplicate any element in the array and add it to the end of the array.
// Return the minimum number of operations required to make the sum of elements of the final array greater than or equal to k.

// Example 1:

// Input: k = 11

// Output: 5

// Explanation:

// We can do the following operations on the array nums = [1]:

// Increase the element by 1 three times. The resulting array is nums = [4].
// Duplicate the element two times. The resulting array is nums = [4,4,4].
// The sum of the final array is 4 + 4 + 4 = 12 which is greater than or equal to k = 11.
// The total number of operations performed is 3 + 2 = 5.

// Example 2:

// Input: k = 1

// Output: 0

// Explanation:

// The sum of the original array is already greater than or equal to 1, so no operations are needed.

// Constraints:

// 1 <= k <= 105

public class MinimumOperations {

    public static int minOperationsToSumK(int k) {
        int ans = Integer.MAX_VALUE;
        int x = 1;
        int ops = 0;
        
        for (int i = 0; i < k; i++) {
            int temp = ops;
            temp += k / x;
            if (k % x != 0) {
                temp += 1;
            }
            ans = Math.min(ans, temp);
            if (temp > ans) {
                break;
            }
            x++;
            ops++;
        }
        
        return ans-1;

    }

    public static void main(String[] args) {
        System.out.println(minOperationsToSumK(11)); // Output: 5
        System.out.println(minOperationsToSumK(1)); // Output: 0
        System.out.println(minOperationsToSumK(6)); // Output: 3
        System.out.println(minOperationsToSumK(8)); // Output: 4
        System.out.println(minOperationsToSumK(2)); // Output: 1
        System.out.println(minOperationsToSumK(3)); // Output: 2
        System.out.println(minOperationsToSumK(9)); // Output: 4
    }
}
