import java.util.Scanner;
public class vowelReverse {

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if(isVowel(arr[i]) && isVowel(arr[j])){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            else if(isVowel(arr[i])){
                j--;
            }
            else if(isVowel(arr[j])){
                i++;
            }
            else{
                i++;
                j--;
            }
        }
        return new String(arr);
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        vowelReverse obj = new vowelReverse();
        System.out.println(obj.reverseVowels(s));
        sc.close();
    }
}
