package nowcoder;

import java.util.Scanner;

/**
 * @author Brilliant James
 * @date 2020-05-07 20:18
 **/
public class NumberConvert {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int fromBaseString = Integer.parseInt(str[0]);
        String number = str[1];
        int toBaseString = Integer.parseInt(str[2]);
        System.out.println(solution(fromBaseString, number, toBaseString));
//        System.out.println((int)  '0');
//        System.out.println((int)  '9');
    }

    private static String solution(int fromBase, String number, int toBase) {
        long tempSum = 0;
        char[] numChars = number.toLowerCase().toCharArray();
        for (int i = 0, len = numChars.length; i < len; i++) {
            char tempChar = numChars[len - 1 - i];
            int tempNum = 0;
            if (tempChar >= '0' && tempChar <= '9') {
                tempNum = tempChar - '0';
            }
            if (tempChar >= 'a' && tempChar <= 'z') {
                tempNum = tempChar - 'a' + 10;
            }
            tempSum += tempNum * Math.pow(fromBase, i);
        }
        StringBuilder sb = new StringBuilder();
        while (tempSum > 0) {
            sb.append(tempSum % toBase);
            tempSum /= toBase;
        }
        return sb.reverse().toString();
    }

}
