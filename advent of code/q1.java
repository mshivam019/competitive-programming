import java.util.Scanner;
class q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String num = "";
        while (sc.hasNext()) {
            String numstring = sc.nextLine();
            num = "";
           for(int i = 0; i < numstring.length(); i++) {
              if(Character.isDigit(numstring.charAt(i))) {
                  num += numstring.charAt(i);
                  break;
              }
            }
            for(int i = numstring.length() - 1; i >= 0; i--) {
                if(Character.isDigit(numstring.charAt(i))) {
                    num += numstring.charAt(i);
                    break;
                }
            }
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);
        sc.close();
    }
}