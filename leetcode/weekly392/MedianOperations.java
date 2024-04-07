import java.util.Arrays;

public class MedianOperations {

    public long minOperations(long[] nums, long k) {
        Arrays.sort(nums);
        long operations = 0;
        int medianIndex = nums.length / 2;
        long median = nums[medianIndex];

        if (median == k) {
            return 0;
        }

        if (median < k) {
            for (int i = medianIndex; i < nums.length && nums[i] < k; i++) {
                operations += k - nums[i];
            }
        } else {
            for (int i = medianIndex; i >= 0 && nums[i] > k; i--) {
                operations += nums[i] - k;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        MedianOperations medianOperations = new MedianOperations();

        long[] nums1 = {2, 5, 6, 8, 5};
        long k1 = 4;
        System.out.println("Output for nums1: " + medianOperations.minOperations(nums1, k1));

        long[] nums2 = {2, 5, 6, 8, 5};
        long k2 = 7;
        System.out.println("Output for nums2: " + medianOperations.minOperations(nums2, k2));

        long[] nums3 = {1, 2, 3, 4, 5, 6};
        long k3 = 4;
        System.out.println("Output for nums3: " + medianOperations.minOperations(nums3, k3));
    }
}
