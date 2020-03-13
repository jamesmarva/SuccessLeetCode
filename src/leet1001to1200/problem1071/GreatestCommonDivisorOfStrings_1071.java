package leet1001to1200.problem1071;

/**
 *
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 * 1071. 字符串的最大公因子
 *
 * @author Brilliant James
 * @date 2020-03-12 12:36
 **/
public class GreatestCommonDivisorOfStrings_1071 {

    public String gcdOfStrings(String str1, String str2) {
        String longStr;
        String shortStr;
        if (str1.length() > str2.length()) {
            longStr = str1;
            shortStr = str2;
        } else {
            longStr = str2;
            shortStr = str1;
        }
        while (longStr.length() != shortStr.length() ) {
            String tmp = longStr.substring(shortStr.length(), longStr.length());
            if (tmp.length() > shortStr.length()) {
                longStr = tmp;
            } else if (shortStr.length() >= tmp.length()) {
                longStr = shortStr;
                shortStr = tmp;
            }
        }
        if (longStr.equals(shortStr)) {
            return shortStr;
        } else {
            return "";
        }
    }

}
