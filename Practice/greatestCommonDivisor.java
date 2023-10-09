import java.util.Scanner;
public class greatestCommonDivisor {
    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (str2.length() == 0) {
            return str1;
        }
        if (str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
        return "";
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(gcdOfStrings(str1, str2));
        sc.close();
    }
}
