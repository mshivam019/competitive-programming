// You are given a binary array nums.

// We call a subarray alternating if no two adjacent elements in the subarray have the same value.

// Return the number of alternating subarrays in nums.

 

// Example 1:

// Input: nums = [0,1,1,1]

// Output: 5

// Explanation:

// The following subarrays are alternating: [0], [1], [1], [1], and [0,1].

// Example 2:

// Input: nums = [1,0,1,0]

// Output: 10

// Explanation:

// Every subarray of the array is alternating. There are 10 possible subarrays that we can choose.

public class AlternatingSubarrays {
    public static long countAlternatingSubarrays(int[] nums) {
        int length = 1;  
        long total = 1;  

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            total += length;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 1, 1};
        System.out.println(countAlternatingSubarrays(nums1));  // Output: 5

        int[] nums2 = {1, 0, 1, 0};
        System.out.println(countAlternatingSubarrays(nums2));  // Output: 10
    }
}
