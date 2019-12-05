package leet0601to0800.problem0796;

import leet.code2019.july.RomanToInteger13;

/**
 * @author James
 * @date 2019-12-05 13:43
 **/
public class RotateString_0796 {

    public boolean rotateString(String A, String B) {
        char[] chars = A.toCharArray();
        int len  = A.length();
        for (int i = 1; i <= len; i++) {
            String temp = A.substring(i, len) + A.substring(0, i);
            if (temp.equals(B)) {
                return true;
            }
        }
        return false;
    }
    public boolean rotateString_1(String A, String B) {
        String newString = A + A;
        return A.length()==B.length() && newString.contains(B);
    }

    public static void main(String[] args) {
        String test = "abcde";
        RotateString_0796 rr = new RotateString_0796();
        rr.rotateString(test, "");
    }
}
