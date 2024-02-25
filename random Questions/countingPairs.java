import java.util.HashMap;
import java.util.Map;

public class countingPairs {
    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (map.containsKey(entry.getKey() + k)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2 };
        int k = 0;
        System.out.println(findPairs(arr, k));
    }
}
