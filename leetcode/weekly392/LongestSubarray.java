public class LongestSubarray {

    public static int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maxLength = 1;
        int currentLength = 1;
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (decreasing) {
                    currentLength = 2; 
                } else {
                    currentLength++;
                }
                increasing = true;
                decreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                if (increasing) {
                    currentLength = 2; 
                } else {
                    currentLength++;
                }
                increasing = false;
                decreasing = true;
            } else {
                currentLength = 1;
                increasing = decreasing = true;
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 3, 3, 2};
        int[] nums2 = {3, 3, 3, 3};
        int[] nums3 = {3, 2, 1};

        System.out.println("Example 1: " + longestSubarray(nums1)); // Output: 2
        System.out.println("Example 2: " + longestSubarray(nums2)); // Output: 1
        System.out.println("Example 3: " + longestSubarray(nums3)); // Output: 3
    }
}
