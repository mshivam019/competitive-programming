import java.util.Scanner;
class alternateStrings {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder word3=new StringBuilder();
        int k=0;
        while(k<word1.length()||k<word2.length()){
            if(k<word1.length()){
                word3.append(word1.charAt(k));
            }
            if(k<word2.length()){
                word3.append(word2.charAt(k));
            }
            k++;
        }
        return word3.toString();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String word1=sc.nextLine();
        String word2=sc.nextLine();
        sc.close();
        alternateStrings as=new alternateStrings();
        System.out.println(as.mergeAlternately(word1, word2));
    }

}