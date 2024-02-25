import java.util.Arrays;

public class SplitArrayDistinct {

    public static boolean canSplit(int[] nums) {
        int n = nums.length;

        if (n % 2 != 0) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 3, 4};
        boolean output1 = canSplit(nums1);
        System.out.println(output1);  // Output: true

        int[] nums2 = {1, 1, 1, 1};
        boolean output2 = canSplit(nums2);
        System.out.println(output2);  // Output: false

        int[] nums3 = {2, 10, 2, 7, 8, 9, 7, 6, 6, 9};
        boolean output3 = canSplit(nums3);
        System.out.println(output3);  // Output: true

        int[] nums4 = {10, 1, 7, 4, 5, 1, 6, 4};
        boolean output4 = canSplit(nums4);
        System.out.println(output4);  // Output: true

        int[] nums5 = {6, 1, 3, 1, 1, 8, 9, 2};
        boolean output5 = canSplit(nums5);
        System.out.println(output5);  // Output: false
    }
}
