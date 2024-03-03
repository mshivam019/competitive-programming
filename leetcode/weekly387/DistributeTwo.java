// You are given a 1-indexed array of integers nums of length n.

// We define a function greaterCount such that greaterCount(arr, val) returns the number of elements in arr that are strictly greater than val.

// You need to distribute all the elements of nums between two arrays arr1 and arr2 using n operations. In the first operation, append nums[1] to arr1. In the second operation, append nums[2] to arr2. Afterwards, in the ith operation:

// If greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]), append nums[i] to arr1.
// If greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]), append nums[i] to arr2.
// If greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]), append nums[i] to the array with a lesser number of elements.
// If there is still a tie, append nums[i] to arr1.
// The array result is formed by concatenating the arrays arr1 and arr2. For example, if arr1 == [1,2,3] and arr2 == [4,5,6], then result = [1,2,3,4,5,6].

// Return the integer array result.

 

// Example 1:

// Input: nums = [2,1,3,3]
// Output: [2,3,1,3]
// Explanation: After the first 2 operations, arr1 = [2] and arr2 = [1].
// In the 3rd operation, the number of elements greater than 3 is zero in both arrays. Also, the lengths are equal, hence, append nums[3] to arr1.
// In the 4th operation, the number of elements greater than 3 is zero in both arrays. As the length of arr2 is lesser, hence, append nums[4] to arr2.
// After 4 operations, arr1 = [2,3] and arr2 = [1,3].
// Hence, the array result formed by concatenation is [2,3,1,3].


// Example 2:

// Input: nums = [5,14,3,1,2]
// Output: [5,3,1,2,14]
// Explanation: After the first 2 operations, arr1 = [5] and arr2 = [14].
// In the 3rd operation, the number of elements greater than 3 is one in both arrays. Also, the lengths are equal, hence, append nums[3] to arr1.
// In the 4th operation, the number of elements greater than 1 is greater in arr1 than arr2 (2 > 1). Hence, append nums[4] to arr1.
// In the 5th operation, the number of elements greater than 2 is greater in arr1 than arr2 (2 > 1). Hence, append nums[5] to arr1.
// After 5 operations, arr1 = [5,3,1,2] and arr2 = [14].
// Hence, the array result formed by concatenation is [5,3,1,2,14].
// Example 3:

// Input: nums = [3,3,3,3]
// Output: [3,3,3,3]
// Explanation: At the end of 4 operations, arr1 = [3,3] and arr2 = [3,3].
// Hence, the array result formed by concatenation is [3,3,3,3].

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistributeTwo {

    public int[] resultArray(int[] nums) {
     int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int m = set.size();
        List<Integer> list = new ArrayList<>();
        for (int num: set) list.add(num);
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(list.get(i), i);
        }
        
        int[] tree1 = new int[m * 2 + 1];
        int[] tree2 = new int[m * 2 + 1];
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        list1.add(nums[0]);
        insert(tree1, map.get(nums[0]), m);
        
        list2.add(nums[1]);
        insert(tree2, map.get(nums[1]), m);
        
        for (int i = 2; i < n; i++) {
            int count1 = query(tree1, map.get(nums[i]), m);
            int count2 = query(tree2, map.get(nums[i]), m);
            if (count1 > count2) {
                list1.add(nums[i]);
                insert(tree1, map.get(nums[i]), m);
            } else if (count1 < count2) {
                list2.add(nums[i]);
                insert(tree2, map.get(nums[i]), m);
            } else if (list1.size() <= list2.size()) {
                list1.add(nums[i]);
                insert(tree1, map.get(nums[i]), m);
            } else {
                list2.add(nums[i]);
                insert(tree2, map.get(nums[i]), m);
            }
        }
        
        int[] res = new int[n];
        int i = 0;
        for (int num: list1) res[i++] = num;
        for (int num: list2) res[i++] = num;
        
        return res;
    }
    
    private void insert(int[] tree, int idx, int shift) {
        idx += shift + 1;
        while (idx > 0) {
            tree[idx]++;
            idx /= 2;
        }
    }
    
    private int query(int[] tree, int val, int shift) {
        int left = val + 1 + shift + 1;
        int right = shift + shift + 1;
        int res = 0;
        while (left < right) {
            if (left % 2 == 1) {
                res += tree[left];
                left++;
            }
            if (right % 2 == 1) {
                right--;
                res += tree[right];
            }
            left /= 2;
            right /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        DistributeTwo dt = new DistributeTwo();
        int[] nums = {2,1,3,3};
        int[] result = dt.resultArray(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        int [] nums1 = {5,14,3,1,2};
        int[] result1 = dt.resultArray(nums1);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
    }
    
}
