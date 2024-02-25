import java.util.Scanner;

public class stringCompression {
    public int compress(char[] c) {
        int l = c.length;
        if (l == 1)
            return 1;

        int k = 0;
        for (int i = 0; i < l; i++) {
            int end = i + 1;
            int n = 1;
            c[k++] = c[i];
            while (end < l && c[end] == c[i]) {
                n++;
                end++;
            }
            i = end - 1;
            if (n > 1) {

                String s = n + "";
                for (char e : s.toCharArray()) {
                    c[k] = e;
                    k++;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = new char[sc.nextInt()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = sc.next().charAt(0);
        }
        stringCompression obj = new stringCompression();
        System.out.println(obj.compress(chars));
        sc.close();
    }
}
