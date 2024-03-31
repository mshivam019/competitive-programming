// You are given two integers numBottles and numExchange.

// numBottles represents the number of full water bottles that you initially have. In one operation, you can perform one of the following operations:

// Drink any number of full water bottles turning them into empty bottles.
// Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.
// Note that you cannot exchange multiple batches of empty bottles for the same value of numExchange. For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water bottles for 3 full bottles.

// Return the maximum number of water bottles you can drink.



// Example 1:
//     fullBottles, emptyBottles, numExchange, drankBottles
// init    13, 0, 6, 0
// drink   0, 13, 6, 13
// exchange 1, 7, 7, 13
// exchange 2, 0, 8, 13
// drink   0, 2, 8, 15


// Input: numBottles = 13, numExchange = 6
// Output: 15
// Explanation: The table above shows the number of full water bottles, empty water bottles, the value of numExchange, and the number of bottles drunk.


// Example 2:

//     fullBottles, emptyBottles, numExchange, drankBottles
// init    10, 0, 3, 0
// drink   0, 10, 3, 10
// exchange 1, 7, 4, 10
// exchange 2, 3, 5, 10
// drink   0, 5, 5, 12
// exchange 1, 0, 6, 12
// drink   0, 1, 6, 13


// Input: numBottles = 10, numExchange = 3
// Output: 13
// Explanation: The table above shows the number of full water bottles, empty water bottles, the value of numExchange, and the number of bottles drunk.

public class MaxWaterBottles {
    public static int maxWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int emptyBottles = numBottles;
        int exchangeCounter = numExchange;

        while (emptyBottles >= exchangeCounter) {
            total++;
            emptyBottles = emptyBottles - exchangeCounter + 1;
            exchangeCounter++;
        }

        return total;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(maxWaterBottles(13, 6)); // Output: 15
        System.out.println(maxWaterBottles(10, 3)); // Output: 13
    }
}
