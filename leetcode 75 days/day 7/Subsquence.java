import java.util.Scanner;

public class Subsquence {
    public boolean isSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j))
                i++;
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        Subsquence obj = new Subsquence();
        System.out.println(obj.isSubsequence(s1, s2));
        sc.close();
    }
}
