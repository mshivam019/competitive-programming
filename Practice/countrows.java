import java.util.Scanner;

class countrows {
    public static void main(String[] args) {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.close();
        int i = 1;
        int ans = 0;
        while (cnt < t) {
            cnt = cnt + i;
            i++;
            if (cnt <= t) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}