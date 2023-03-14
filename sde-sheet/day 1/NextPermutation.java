
import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
    // ArrayList
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        int n = permutation.size();
        if (n <= 1)
            return permutation;
        int i = n - 2;
        while (i >= 0 && permutation.get(i) >= permutation.get(i + 1))
            i--;
        if (i >= 0) {
            int j = n - 1;
            while (permutation.get(j) <= permutation.get(i))
                j--;
            Collections.swap(permutation, i, j);
        }
        Collections.reverse(permutation.subList(i + 1, n));
        return permutation;
    }

    // Arrays
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }
}
