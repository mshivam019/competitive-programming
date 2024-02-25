// You are given a m x n 0-indexed 2D matrix mat. From every cell, you can create numbers in the following way:

// There could be at most 8 paths from the cells namely: east, south-east, south, south-west, west, north-west, north, and north-east.
// Select a path from them and append digits in this path to the number being formed by traveling in this direction.
// Note that numbers are generated at every step, for example, if the digits along the path are 1, 9, 1, then there will be three numbers generated along the way: 1, 19, 191.
// Return the most frequent prime number greater than 10 out of all the numbers created by traversing the matrix or -1 if no such prime number exists. If there are multiple prime numbers with the highest frequency, then return the largest among them.

// Note: It is invalid to change the direction during the move.

 

// Input: mat = [[1,1],[9,9],[1,1]]
// Output: 19
// Explanation: 
// From cell (0,0) there are 3 possible directions and the numbers greater than 10 which can be created in those directions are:
// East: [11], South-East: [19], South: [19,191].
// Numbers greater than 10 created from the cell (0,1) in all possible directions are: [19,191,19,11].
// Numbers greater than 10 created from the cell (1,0) in all possible directions are: [99,91,91,91,91].
// Numbers greater than 10 created from the cell (1,1) in all possible directions are: [91,91,99,91,91].
// Numbers greater than 10 created from the cell (2,0) in all possible directions are: [11,19,191,19].
// Numbers greater than 10 created from the cell (2,1) in all possible directions are: [11,19,19,191].
// The most frequent prime number among all the created numbers is 19.
// Example 2:

// Input: mat = [[7]]
// Output: -1
// Explanation: The only number which can be formed is 7. It is a prime number however it is not greater than 10, so return -1.
// Example 3:

// Input: mat = [[9,7,8],[4,6,5],[2,8,6]]
// Output: 97
// Explanation: 
// Numbers greater than 10 created from the cell (0,0) in all possible directions are: [97,978,96,966,94,942].
// Numbers greater than 10 created from the cell (0,1) in all possible directions are: [78,75,76,768,74,79].
// Numbers greater than 10 created from the cell (0,2) in all possible directions are: [85,856,86,862,87,879].
// Numbers greater than 10 created from the cell (1,0) in all possible directions are: [46,465,48,42,49,47].
// Numbers greater than 10 created from the cell (1,1) in all possible directions are: [65,66,68,62,64,69,67,68].
// Numbers greater than 10 created from the cell (1,2) in all possible directions are: [56,58,56,564,57,58].
// Numbers greater than 10 created from the cell (2,0) in all possible directions are: [28,286,24,249,26,268].
// Numbers greater than 10 created from the cell (2,1) in all possible directions are: [86,82,84,86,867,85].
// Numbers greater than 10 created from the cell (2,2) in all possible directions are: [68,682,66,669,65,658].
// The most frequent prime number among all the created numbers is 97.
// ChatGPT
// To solve this problem, you can follow these steps:

// Create a helper function to check if a number is prime.
// Iterate through each cell in the matrix and explore all possible paths from that cell.
// For each path, generate the numbers and count their frequency.
// Keep track of the most frequent prime number greater than 10.
// Return the result.
// Here's a Python function to implement this:

// python
// Copy code
// def is_prime(num):
//     if num < 2:
//         return False
//     for i in range(2, int(num**0.5) + 1):
//         if num % i == 0:
//             return False
//     return True

// def find_most_frequent_prime(mat):
//     def explore_path(matrix, i, j, direction):
//         path = []
//         while 0 <= i < m and 0 <= j < n:
//             path.append(matrix[i][j])
//             i, j = i + direction[0], j + direction[1]
//         return path

//     m, n = len(mat), len(mat[0])
//     prime_count = {}

//     for i in range(m):
//         for j in range(n):
//             for direction in [(0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1)]:
//                 path = explore_path(mat, i, j, direction)
//                 num = int("".join(map(str, path)))
//                 if num > 10 and is_prime(num):
//                     prime_count[num] = prime_count.get(num, 0) + 1

//     result = -1
//     max_frequency = 0

//     for num, frequency in prime_count.items():
//         if frequency > max_frequency or (frequency == max_frequency and num > result):
//             result = num
//             max_frequency = frequency

//     return result

// # Example usage:
// mat1 = [[1, 1], [9, 9], [1, 1]]
// mat2 = [[7]]
// mat3 = [[9, 7, 8], [4, 6, 5], [2, 8, 6]]

// print(find_most_frequent_prime(mat1))  # Output: 19
// print(find_most_frequent_prime(mat2))  # Output: -1
// print(find_most_frequent_prime(mat3))  # Output: 97
// This function defines an is_prime helper function and a main function find_most_frequent_prime that explores all possible paths from each cell and finds the most frequent prime number greater than 10.


import java.util.HashMap;
import java.util.Map;

public class MatrixPrime {

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findMostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> primeCount = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
                for (int[] direction : directions) {
                    int ni = i, nj = j;
                    StringBuilder path = new StringBuilder();
                    while (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        path.append(mat[ni][nj]);
                        int num = Integer.parseInt(path.toString());
                        if (num > 10 && isPrime(num)) {
                            primeCount.put(num, primeCount.getOrDefault(num, 0) + 1);
                        }
                        ni += direction[0];
                        nj += direction[1];
                    }
                }
            }
        }

        int result = -1;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : primeCount.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxFrequency || (frequency == maxFrequency && num > result)) {
                result = num;
                maxFrequency = frequency;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 1}, {9, 9}, {1, 1}};
        int[][] mat2 = {{7}};
        int[][] mat3 = {{9, 7, 8}, {4, 6, 5}, {2, 8, 6}};

        System.out.println(findMostFrequentPrime(mat1)); // Output: 19
        System.out.println(findMostFrequentPrime(mat2)); // Output: -1
        System.out.println(findMostFrequentPrime(mat3)); // Output: 97
    }
}
