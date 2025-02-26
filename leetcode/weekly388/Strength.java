// You are given a 0-indexed array of integers nums of length n, and a positive odd integer k.

// The strength of x subarrays is defined as strength = sum[1] * x - sum[2] * (x - 1) + sum[3] * (x - 2) - sum[4] * (x - 3) + ... + sum[x] * 1 where sum[i] is the sum of the elements in the ith subarray. Formally, strength is sum of (-1)i+1 * sum[i] * (x - i + 1) over all i's such that 1 <= i <= x.

// You need to select k disjoint subarrays from nums, such that their strength is maximum.

// Return the maximum possible strength that can be obtained.

// Note that the selected subarrays don't need to cover the entire array.

// Example 1:

// Input: nums = [1,2,3,-1,2], k = 3
// Output: 22
// Explanation: The best possible way to select 3 subarrays is: nums[0..2], nums[3..3], and nums[4..4]. The strength is (1 + 2 + 3) * 3 - (-1) * 2 + 2 * 1 = 22.
// Example 2:

// Input: nums = [12,-2,-2,-2,-2], k = 5
// Output: 64
// Explanation: The only possible way to select 5 disjoint subarrays is: nums[0..0], nums[1..1], nums[2..2], nums[3..3], and nums[4..4]. The strength is 12 * 5 - (-2) * 4 + (-2) * 3 - (-2) * 2 + (-2) * 1 = 64.
// Example 3:

// Input: nums = [-1,-2,-3], k = 1
// Output: -1
// Explanation: The best possible way to select 1 subarray is: nums[0..0]. The strength is -1.

import java.util.Arrays;

public class Strength {
	public long maximumStrength(int[] a, int k) {
		int n = a.length;
		long[] dp = new long[n + 1];
		for (int z = 0; z < k; z++) {
			long v = (long) k - z;
			if (z % 2 == 1)
				v = -v;
			long[] ndp = new long[n + 1];
			Arrays.fill(ndp, Long.MIN_VALUE / 3);
			for (int i = 1; i <= n; i++) {
				ndp[i] = Math.max(ndp[i], Math.max(ndp[i - 1], dp[i - 1]) + a[i - 1] * v);
			}
			dp = ndp;

			for (int i = 1; i <= n; i++) {
				dp[i] = Math.max(dp[i], dp[i - 1]);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// Example 1
		int[] nums1 = { 1, 2, 3, -1, 2 };
		int k1 = 3;
		long output1 = new Strength().maximumStrength(nums1, k1);
		System.out.println("Example 1 Output: " + output1); // 22

		// Example 2
		int[] nums2 = { 12, -2, -2, -2, -2 };
		int k2 = 5;
		long output2 = new Strength().maximumStrength(nums2, k2);
		System.out.println("Example 2 Output: " + output2); // 64

		// Example 3
		int[] nums3 = { -1, -2, -3 };
		int k3 = 1;
		long output3 = new Strength().maximumStrength(nums3, k3);
		System.out.println("Example 3 Output: " + output3); // -1
	}
}
