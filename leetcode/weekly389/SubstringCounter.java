public class SubstringCounter {
    public static long countSubstrings(String s, char c) {
        long count = 0;
        int n = s.length();
        int cCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                cCount++;
            }
        }

        count = (long) cCount * (cCount + 1) / 2;

        return count;
    }

    public static void main(String[] args) {
        String s1 = "abada";
        char c1 = 'a';
        System.out.println(countSubstrings(s1, c1)); // Output: 6

        String s2 = "zzz";
        char c2 = 'z';
        System.out.println(countSubstrings(s2, c2)); // Output: 6
    }
}
