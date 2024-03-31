// You are given a 0-indexed array points representing integer coordinates of some points on a 2D plane, where points[i] = [xi, yi].

// The distance between two points is defined as their Manhattan distance.

// Return the minimum possible value for maximum distance between any two points by removing exactly one point.

// Example 1:

// Input: points = [[3,10],[5,15],[10,2],[4,4]]
// Output: 12
// Explanation: The maximum distance after removing each point is the following:
// - After removing the 0th point the maximum distance is between points (5, 15) and (10, 2), which is |5 - 10| + |15 - 2| = 18.
// - After removing the 1st point the maximum distance is between points (3, 10) and (10, 2), which is |3 - 10| + |10 - 2| = 15.
// - After removing the 2nd point the maximum distance is between points (5, 15) and (4, 4), which is |5 - 4| + |15 - 4| = 12.
// - After removing the 3rd point the maximum distance is between points (5, 15) and (10, 2), which is |5 - 10| + |15 - 2| = 18.
// It can be seen that 12 is the minimum possible maximum distance between any two points after removing exactly one point.

// Example 2:

// Input: points = [[1,1],[1,1],[1,1]]
// Output: 0
// Explanation: It can be seen that removing any of the points results in the maximum distance between any two points of 0

// Constraints:

// 3 <= points.length <= 105
// points[i].length == 2
// 1 <= points[i][0], points[i][1] <= 108

import java.util.TreeMap;

public class MinMaxDistance {

    public static int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        for (int[] point : points) {
            int val = point[0] + point[1];
            int count = map1.getOrDefault(val, 0);
            count++;
            map1.put(val, count);

            val = point[0] - point[1];
            count = map2.getOrDefault(val, 0);
            count++;
            map2.put(val, count);
        }

        int res = Integer.MAX_VALUE;
        for (int[] point : points) {
            remove(map1, point[0] + point[1]);
            remove(map2, point[0] - point[1]);

            int val1 = map1.lastKey() - map1.firstKey();
            int val2 = map2.lastKey() - map2.firstKey();

            res = Math.min(res, Math.max(val1, val2));

            add(map1, point[0] + point[1]);
            add(map2, point[0] - point[1]);
        }

        return res;
    }

    private static void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        count--;
        if (count > 0)
            map.put(val, count);
        else
            map.remove(val);
    }

    private static void add(TreeMap<Integer, Integer> map, int val) {
        int count = map.getOrDefault(val, 0);
        count++;
        map.put(val, count);
    }

    public static void main(String[] args) {
        int[][] points1 = { { 3, 10 }, { 5, 15 }, { 10, 2 }, { 4, 4 } };
        System.out.println(minimumDistance(points1)); // Output: 12

        int[][] points2 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        System.out.println(minimumDistance(points2)); // Output: 0

        int[][] points3 = { { 3, 2 }, { 3, 9 }, { 7, 10 }, { 4, 4 }, { 8, 10 }, { 2, 7 } };
        System.out.println(minimumDistance(points3)); // Output: 10
    }
}
