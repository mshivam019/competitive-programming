import java.util.Arrays;

public class WeeklyChallenge {

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
