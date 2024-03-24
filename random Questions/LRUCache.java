
// 1. LRU Cache
// Implement an LRU(Least Recently Used) cache of max size N
// with get(key) and set(key, value) operations. Cache should be
// divided into two partitions, single-touch and multi-touch. Any
// entry which is touched single time should stay in single-touch
// partition. Any entry which is touched more than once should be
// moved to the multi-touch partition. Any set or get operation is
// considered as a touch. Limit the size of single-touch partition to
// 30% of the cache size (Consider the floor of 30% ). Allocate
// remaining size to multi-touch partition. Both the
// partitions should follow LRU. Given a series of get and set
// operations, you have to print the final state of the LRU cache
// (Most recent to least recent order) after those operations. If a
// get operation is done for a key which is not present in the cache,
// then the cache remains un-changed. You can use predefined
// structures like map, list, set etc. For simplicity, lets assume both
// keys and values to be integers.
// First line of the input has two integers separated by space where the
// integers denote N(Size of cache) and X(Number of operations)
// respectively. Next X lines have operations where each operation can
// either be get denoted by 'g <key>' or set denoted by 's <key> <value>
// The output should be printed in the following manner:
// The first line should contain the number of entries in single touch
// partition; followed by space separated values in single-touch
// partition (Ex: 3 <v1> <v2> <v3>).
// In the second line, print the number of entries in the multi-touch
// partition; followed by space separated values in multi-touch partition
// The values should be printed in the most-recent to least-recent
// order.
// 12
// Example:
// 5 7
// s 5 5
// s 6 6
// g 6
// s 10 10
// s 10 10
// g 6
// s 15 15
// Result:
// 1 15
// 2 6 10

import java.util.*;

class LRUCache {
    int capacity, singleTouchCapacity;
    HashMap<Integer, Integer> singleTouch, multiTouch;
    LinkedList<Integer> singleTouchList, multiTouchList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.singleTouchCapacity = (int) Math.floor(capacity * 0.3);
        singleTouch = new HashMap<>();
        multiTouch = new HashMap<>();
        singleTouchList = new LinkedList<>();
        multiTouchList = new LinkedList<>();
    }

    public int get(int key) {
        if (singleTouch.containsKey(key)) {
            int value = singleTouch.get(key);
            singleTouch.remove(key);
            singleTouchList.removeFirstOccurrence(key);
            setMultiTouch(key, value);
            return value;
        } else if (multiTouch.containsKey(key)) {
            int value = multiTouch.get(key);
            multiTouchList.removeFirstOccurrence(key);
            multiTouchList.addFirst(key);
            return value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (singleTouch.containsKey(key)) {
            singleTouch.remove(key);
            singleTouchList.removeFirstOccurrence(key);
            setMultiTouch(key, value);
        } else if (multiTouch.containsKey(key)) {
            multiTouch.put(key, value);
            multiTouchList.removeFirstOccurrence(key);
            multiTouchList.addFirst(key);
        } else {
            if (singleTouch.size() >= singleTouchCapacity) {
                int lastKey = singleTouchList.removeLast();
                singleTouch.remove(lastKey);
            }
            singleTouch.put(key, value);
            singleTouchList.addFirst(key);
        }
    }

    private void setMultiTouch(int key, int value) {
        if (multiTouch.size() >= capacity - singleTouchCapacity) {
            int lastKey = multiTouchList.removeLast();
            multiTouch.remove(lastKey);
        }
        multiTouch.put(key, value);
        multiTouchList.addFirst(key);
    }

    public void printCacheState() {
        System.out.print(singleTouchList.size());
        for (int key : singleTouchList) {
            System.out.print(" " + key);
        }
        System.out.println();

        System.out.print(multiTouchList.size());
        for (int key : multiTouchList) {
            System.out.print(" " + key);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        scanner.nextLine(); // consume newline

        LRUCache cache = new LRUCache(N);

        for (int i = 0; i < X; i++) {
            String[] operation = scanner.nextLine().split(" ");
            if (operation[0].equals("s")) {
                int key = Integer.parseInt(operation[1]);
                int value = Integer.parseInt(operation[2]);
                cache.set(key, value);
            } else if (operation[0].equals("g")) {
                int key = Integer.parseInt(operation[1]);
                cache.get(key);
            }
        }

        cache.printCacheState();
        scanner.close();
    }
}