import java.util.Scanner;
public class increasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < first)
                first = nums[i];
            else if (nums[i] > first && nums[i] < second)
                second = nums[i];
            else if (nums[i] > second)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[sc.nextInt()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        increasingTripletSubsequence obj = new increasingTripletSubsequence();
        System.out.println(obj.increasingTriplet(nums));
        sc.close();
    }
}
