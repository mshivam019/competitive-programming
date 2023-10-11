import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class kidsWiththeGreatestNumberofCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = candies[0];
        int n = candies.length;
        for(int i=1; i<n; i++){
            if(candies[i]>max){
                max = candies[i];
            }
        }
        for(int i=0; i<n; i++){
                list.add(candies[i]+extraCandies >=max);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int candies[] = new int[n];
        for(int i=0;i<n;i++){
            candies[i] = sc.nextInt();
        }
        int extraCandies = sc.nextInt();
        List<Boolean> ans = kidsWithCandies(candies, extraCandies);
        System.out.println(ans);
        sc.close();
    }
}
