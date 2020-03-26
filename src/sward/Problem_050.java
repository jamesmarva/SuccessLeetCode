package sward;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/submissions/
 * 面试题50. 第一个只出现一次的字符
 *
 * @author Brilliant James
 * @date 2020-03-26 02:50
 **/
public class Problem_050 {

    public char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int[] map = new int[128];
        for (char c : arr) {
            map[c]++;
        }
        for (char c : arr) {
            if (map[c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
