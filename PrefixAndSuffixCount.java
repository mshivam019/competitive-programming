import java.util.HashMap;
import java.util.List;

public class PrefixAndSuffixCount {
    
    public static long countPrefixSuffixPairs(String[] words) {
		Node root = new Node();
		long count = 0;
		for (String word : words) {
			Node node = root;
			for (int i = 0; i < word.length(); i++) {
				count += (node = node.map.computeIfAbsent(List.of(word.charAt(i), word.charAt(word.length() - i - 1)),
						t -> new Node())).count;
			}
			node.count++;
		}
		return count;
	}

	static class Node {
		private HashMap<List<Character>, Node> map = new HashMap<>();
		private int count;
	}

    public static void main(String[] args) {
        String[] words1 = {"a", "aba", "ababa", "aa"};
        System.out.println(countPrefixSuffixPairs(words1));  // Output: 4

        String[] words2 = {"pa", "papa", "ma", "mama"};
        System.out.println(countPrefixSuffixPairs(words2));  // Output: 2

        String[] words3 = {"abab", "ab"};
        System.out.println(countPrefixSuffixPairs(words3));  // Output: 0

        String[] words = {"a", "a"};
        System.out.println(countPrefixSuffixPairs(words));  // Output: 1
    }
}
