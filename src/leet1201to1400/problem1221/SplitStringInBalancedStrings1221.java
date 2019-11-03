package leet1201to1400.problem1221;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * @author James
 * @date 2019-11-02 01:22
 **/
public class SplitStringInBalancedStrings1221 {

    public int balancedStringSplit(String s) {
        if (s == null || s.length() <= 1){
            return 0;
        }
        char[] chars = s.toCharArray();
        int leftCount = 0;
        int rightCount = 0;
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            if (chars[i] == 'L') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
                ans++;
                leftCount = 0;
                rightCount = 0;
            }
        }
        return ans;
    }
}
