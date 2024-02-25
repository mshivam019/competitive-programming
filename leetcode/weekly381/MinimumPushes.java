// You are given a string word containing distinct lowercase English letters.

// Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .

// It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.

// Return the minimum number of pushes needed to type word after remapping the keys.

// An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.

// Input: word = "abcde"
// Output: 5
// Explanation: The remapped keypad given in the image provides the minimum cost.
// "a" -> one push on key 2
// "b" -> one push on key 3
// "c" -> one push on key 4
// "d" -> one push on key 5
// "e" -> one push on key 6
// Total cost is 1 + 1 + 1 + 1 + 1 = 5.
// It can be shown that no other mapping can provide a lower cost.
import java.util.Arrays;

public class MinimumPushes {

    public static int minimumKeypresses(String s) {
        int[] frequency = new int[26];
      
        for (char character : s.toCharArray()) {
            frequency[character - 'a']++;
        }
      
        Arrays.sort(frequency);
      
        int totalKeypresses = 0;
        int keypressesPerChar = 1;
      
        for (int i = 1; i <= 26; i++) {
            totalKeypresses += keypressesPerChar * frequency[26 - i];
          
            if (i % 8 == 0) {
                keypressesPerChar++;
            }
        }
      
        return totalKeypresses;
    }

    public static void main(String[] args) {
        String word = "abcde";
        int result = minimumKeypresses(word);
        String word2 = "xycdefghij";
        int result2 = minimumKeypresses(word2);
        System.out.println("result :" + result); // Output: 5
        System.out.println("result2 :" + result2); // Output: 12
    }
}
