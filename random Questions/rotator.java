import java.util.ArrayList;
import java.util.List;

class rotator {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        if (nums.length == 1) {
            return;
        }
        List<Integer> al = new ArrayList<>();
        for (int i = nums.length - k; i < nums.length; i++) {
            al.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            al.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = al.get(i);
        }
    }
}