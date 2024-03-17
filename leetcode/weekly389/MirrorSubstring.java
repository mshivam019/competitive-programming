public class MirrorSubstring {
    public static boolean hasMirrorSubstring(String s) {
        // Function to reverse a string
        StringBuilder reverse = new StringBuilder(s).reverse();
        String reversedString = reverse.toString();
        for (int i = 0; i < s.length() - 1; i++) {
            String substring = s.substring(i, i + 2);
            if (reversedString.contains(substring)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(hasMirrorSubstring("leetcode")); // Output: true
        System.out.println(hasMirrorSubstring("abcba"));    // Output: true
        System.out.println(hasMirrorSubstring("abcd"));     // Output: false
    }
}
