// Given an array of Os and 1s, find the ascending order of the positions of zeros which when flipped, will produce maximum continuous series of 1s. No more than 'm' zeros can be flipped. Assume that the array positions start from zero. You can only flip Os. If more than one solutions are possible, print all of them in ascending order of their position/index number.

// Input

// The first line of the input is the number of test cases.

// Each line from the second corresponds to one test case in the following format:

// <number of array elements> <space separated list of array elements> <maximum number of zeros that can be flipped(m)>

// Example:

// 2

// 4 1 0 0 0 2

// 6 0 1 1 1 0 0 2

// This means that there are 2 test cases:

// 1. Length of the array = 4, Elements of the array are 1,0,0,0. Maximum number of zeros that can be flipped = 2

// 2. Length of the array = 6, Elements of the array are 0,1,1,1,0,0. Maximum number of zeros that can be flipped = 2

// Output

// A For each test case, the first line is the number of possible solutions (say n). Each of the next n lines must consist of 1 list of possible positions to flip (print the space separated elements in the list in ascending order). The lists should be printed in the lexicographical order (The list with the least position/index number should be printed first).

// 2

// Example:

// For the above input, the output will be

// 1

// 1 2

// 2

// 0 4

// 4 5

import java.util.*;

public class MaximumContinuousSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();
            List<List<Integer>> results = findPositions(arr, m);
            System.out.println(results.size());
            for (List<Integer> result : results) {
                for (int pos : result) {
                    System.out.print(pos + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    private static List<List<Integer>> findPositions(int[] arr, int m) {
        int left = 0, right = 0, zeroCount = 0, maxLength = 0;
        Queue<Integer> zeroIndex = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        while (right < arr.length) {
            if (arr[right] == 0) {
                zeroCount++;
                zeroIndex.add(right);
            }
            while (zeroCount > m) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
                zeroIndex.poll();
            }
            if (right - left + 1 == maxLength) {
                results.add(new ArrayList<>(zeroIndex));
            }
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                results.clear();
                results.add(new ArrayList<>(zeroIndex));
            }
            right++;
        }
        return results;
    }
}