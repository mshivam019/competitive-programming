import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var sum = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            var calibNums = getCalibNums(line);
            sum += Integer.parseInt(calibNums);
        }

        System.out.println("Output: " + sum);
        scanner.close();

    }

    private static String getCalibNums(String line) {
        String[] digits = { "-", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine" };
        var nums = "";
        var chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                nums += chars[i];
                continue;
            }
            var substr = line.substring(i, Math.min(5 + i, line.length()));
            for (int j = 0; j < digits.length; j++) {
                if (substr.startsWith(digits[j])) {
                    i += digits[j].length() - 2;
                    nums += j;
                    break;
                }
            }
        }
        return "" + nums.charAt(0) + nums.charAt(nums.length() - 1);
    }
}
