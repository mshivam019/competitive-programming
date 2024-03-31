public class HarshadNumber {
    public static int sumOfDigits(int x) {
        // Calculate sum of digits
        int sum = 0;
        int num = x;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        // Check if x is divisible by the sum of its digits
        if (x % sum == 0) {
            return sum;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Example 1:");
        System.out.println("Input: x = 18");
        System.out.println("Output: " + sumOfDigits(18)); // Output: 9
        
        System.out.println("\nExample 2:");
        System.out.println("Input: x = 23");
        System.out.println("Output: " + sumOfDigits(23)); // Output: -1
    }
}
