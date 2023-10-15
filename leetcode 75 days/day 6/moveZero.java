import java.util.Scanner;
public class moveZero {
    public void moveZeroes(int[] arr) {
        int count = 0; 
        int n=arr.length;
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; 
        while (count < n)
            arr[count++] = 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        moveZero obj = new moveZero();
        obj.moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
    
}
