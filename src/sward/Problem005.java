package sward;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @author Brilliant James
 * @date 2020-05-02 05:21
 **/
public class Problem005 {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char item : chars) {
            if (item == ' ') {
                ans.append("%20");
                continue;
            }
            ans.append(item);
        }
        return ans.toString();
    }
}



