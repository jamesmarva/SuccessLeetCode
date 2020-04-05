package leet0001to0200.problem0008;

/**
 * @author Brilliant James
 * @date 2020-04-03 15:52
 **/
public class StringTonteger_0008 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.indexOf(' ') > 0) {
            str = str.substring(0, str.indexOf(' '));
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int index = 0;
        boolean negative = false;
        if (chars[index] == '-') {
            negative = true;
            index++;
        } else if (chars[index] < '0' || chars[index] > '9') {
            return 0;
        }

        long ans = 0;
        for (; index < len; index++) {
            char temp = chars[index];
            if (temp < '0' || temp > '9') {
               break;
            }
            int digit = Integer.parseInt(temp+"");
            ans = ans * 10 + digit;
            if (ans > Integer.MAX_VALUE) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if (negative) {
            return - ((int) ans);
        } else {
            return (int) ans;
        }
    }

    /**
     * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
     * @param str
     * @return
     */
    public int myAtoi00(String str) {
        str = str.trim();
        if (str.indexOf(' ') > 0) {
            str = str.substring(0, str.indexOf(' '));
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int index = 0;
        boolean negative = false;
        if (chars[index] == '-') {
            negative = true;
            index++;
        } else if (chars[index] < '0' || chars[index] > '9') {
            return 0;
        }

        long ans = 0;
        for (; index < len; index++) {
            char temp = chars[index];
            if (temp < '0' || temp > '9') {
                break;
            }
            int digit = temp - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
        }
        if (negative) {
            return - ((int) ans);
        } else {
            return (int) ans;
        }
    }

//    int ans = 0;
//        while (idx < n && Character.isDigit(chars[idx])) {
//        int digit = chars[idx] - '0';
//        if (ans > (Integer.MAX_VALUE - digit) / 10) {
//            // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
//            // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
//            return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
//        }
//        ans = ans * 10 + digit;
//        idx++;
//    }
//        return negative? -ans : ans;
//
//    链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
