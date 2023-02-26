import java.util.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int sum=0;
            sum=a+1*b;
            int j=1;
            System.out.print(sum);
            for(int k=1;k<n;k++){
                j=j*2;
                sum=sum+j*b;
                System.out.print(" ");
                System.out.print(sum);
            }
            System.out.println();
        }
        in.close();
    }
}