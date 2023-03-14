public class maxSubarraySum {

    public int maxSubArray(int[] nums) {
        int size = nums.length;
        if (size == 0)
            return 0;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + nums[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        return max_so_far;
    }
}
