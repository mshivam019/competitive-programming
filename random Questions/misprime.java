import java.util.*;

class misprime {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int index = 0;
        int a = s.nextInt();
        s.close();
        int flag = 0, sum = 2;
        // System.out.println("2");
        for (int i = 3; i <= num; i++) {
            flag = 0;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (i % j == 0) {
                    flag = 1;
                }
            }
            if (flag != 1) {
                // System.out.println(i);
                index++;
                if (index % a == 0) {
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }
}