
// Java program to implement
// the above approach
import java.util.*;

class paired {

    // Function to count distinct pairs
    // in array whose sum equal to K
    static int cntDisPairs(int arr[],
            int N, int K) {
        // Stores count of distinct pairs
        // whose sum equal to K
        int cntPairs = 0;

        // Sort the array
        Arrays.sort(arr);

        // Stores index of
        // the left pointer
        int i = 0;

        // Stores index of
        // the right pointer
        int j = N - 1;

        // Calculate count of distinct
        // pairs whose sum equal to K
        while (i < j) {

            // If sum of current pair
            // is equal to K
            if (arr[i] + arr[j] == K) {

                // Remove consecutive duplicate
                // array elements
                while (i < j && arr[i] == arr[i + 1]) {

                    // Update i
                    i++;
                }

                // Remove consecutive duplicate
                // array elements
                while (i < j && arr[j] == arr[j - 1]) {

                    // Update j
                    j--;
                }

                // Update cntPairs
                cntPairs += 1;

                // Update i
                i++;

                // Update j
                j--;
            }

            // if sum of current pair
            // less than K
            else if (arr[i] + arr[j] < K) {

                // Update i
                i++;
            } else {

                // Update j
                j--;
            }
        }

        return cntPairs;
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = { 5, 6, 5, 7, 7, 8 };
        int N = arr.length;
        int K = 13;
        System.out.print(cntDisPairs(arr, N, K));
    }
}

// This code is contributed by 29AjayKumar
