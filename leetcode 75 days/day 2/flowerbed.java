import java.util.Scanner;
public class flowerbed {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        int m = flowerbed.length;
        while(i<m){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==m-1 || flowerbed[i+1]==0)){
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count>=n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int flowerbed[] = new int[n];
        for(int i=0;i<n;i++){
            flowerbed[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        flowerbed obj = new flowerbed();
        boolean ans = obj.canPlaceFlowers(flowerbed, m);
        System.out.println(ans);
        sc.close();
    }
    
}
