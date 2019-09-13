package leet1to200.problem0009;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/palindrome-number/
 * @author: James
 * @create: 2019-09-13 08:46
 **/
public class PalindromeNumber0009 {

    public boolean isPalindrome(int x) {
        String xString = "" + x;
        if (xString==null||xString.length()==0) {
            return false;
        }
        int length = xString.length();
        int length2 = xString.length() / 2;
        char[] newArray = xString.toCharArray();
        for (int i = 0; i < length; i++) {
            if (newArray[i] != newArray[length-i-1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeFunction(int x) {
        String xString = "" + x;
        if (xString==null||xString.length()==0) {
            return false;
        }
        int length = xString.length();
        int length2 = xString.length() / 2;
        char[] newArray = xString.toCharArray();
        for (int i = 0; i < length; i++) {
            if (newArray[i] != newArray[length-i-1]) {
                return false;
            }
        }
        return true;
    }
    //好的解答
    public boolean goodIsPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) { //x是10的倍数一定不是回文串
            return false;
        }
        int s = 0;
        while (s <= x) {
            s = s * 10 + x % 10;
            if (s == x || s == x / 10) { //分别处理整数长度是奇数或者偶数的情况
                return true;
            }
            x /= 10;
        }
        return false;
    }
}
