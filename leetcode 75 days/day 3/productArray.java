import java.util.Scanner;

public class productArray {
    public int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int[] result = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        for (int i = numsLength - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[sc.nextInt()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        productArray obj = new productArray();
        int[] result = obj.productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}
