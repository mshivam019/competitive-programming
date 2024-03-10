// You are given an array apple of size n and an array capacity of size m.

// There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

// Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.

// Note that, apples from the same pack can be distributed into different boxes.

 

// Example 1:

// Input: apple = [1,3,2], capacity = [4,3,1,5,2]
// Output: 2
// Explanation: We will use boxes with capacities 4 and 5.
// It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.
// Example 2:

// Input: apple = [5,5,5], capacity = [2,4,2,7]
// Output: 4
// Explanation: We will need to use all the boxes.
import java.util.Arrays;

public class MinBoxes {

    public static int minBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }
        Arrays.sort(capacity);
        int count = 0;
        for(int i = capacity.length - 1; i >= 0; i--) {
            if(sum <= 0) {
                break;
            }
            sum -= capacity[i];
            count++;
        }
        return count;
    }
   
    public static void main(String[] args) {
        // Example 1
        int[] apple1 = {1, 3, 2};
        int[] capacity1 = {4, 3, 1, 5, 2};
        int output1 = minBoxes(apple1, capacity1);
        System.out.println("Example 1 Output: " + output1); // 2

        // Example 2
        int[] apple2 = {5, 5, 5};
        int[] capacity2 = {2, 4, 2, 7};
        int output2 = minBoxes(apple2, capacity2);
        System.out.println("Example 2 Output: " + output2); // 4

        // Example 3
        int[] apple3 = {9, 8, 8, 2, 3, 1, 6};
        int[] capacity3 = {10, 1, 4, 10, 8, 5};
        int output3 = minBoxes(apple3, capacity3);
        System.out.println("Example 3 Output: " + output3); // 5
    }
}
