import java.util.Scanner;

public class stringCompression {
    public int compress(char[] chars) {
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        char curr = chars[0];
        int count = 1;
        int op = 1;

        outer: while (op < len) {
            if (curr == chars[op]) {
                op++;
                count++;
                continue outer;
            } else {
                sb.append(curr);
                if (count > 1)
                    sb.append(count);

                if (op < len)
                    curr = chars[op];
                count = 0;
            }
        }

        sb.append(curr);
        if (count > 1)
            sb.append(count);

        int lo = sb.length(), idx = 0;

        for (; idx < lo; idx++) {
            chars[idx] = sb.charAt(idx);
        }

        return idx;
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
