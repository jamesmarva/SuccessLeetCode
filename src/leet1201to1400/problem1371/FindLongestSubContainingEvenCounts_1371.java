package leet1201to1400.problem1371;

import java.util.Arrays;

/**
 *
 *  https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 *  1371. 每个元音包含偶数次的最长子字符串
 *
 * @author Brilliant James
 * @date 2020-06-06 11:34
 **/
public class FindLongestSubContainingEvenCounts_1371 {


    /**
     *  暴力枚举，时间超过限制
     * 超出时间限制
     * @param s
     * @return
     */
    public static int findTheLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int aNum = 0;
        int eNum = 0;
        int iNum = 0;
        int oNum = 0;
        int uNum = 0;
        int ans = 0;
        for (int i = 0, len = chars.length; i < len; i++) {
            aNum = 0;
            eNum = 0;
            iNum = 0;
            oNum = 0;
            uNum = 0;
            for (int j = i; j < len; j++) {
                if (chars[j] == 'a') {
                    if (aNum == 0) {
                        aNum++;
                    } else {
                        aNum--;
                    }
                } else if (chars[j] == 'e') {
                    if (eNum == 0) {
                        eNum++;
                    } else {
                        eNum--;
                    }
                } else if (chars[j] == 'i') {
                    if (iNum == 0) {
                        iNum++;
                    } else {
                        iNum--;
                    }
                } else if (chars[j] == 'o') {
                    if (oNum == 0) {
                        oNum++;
                    } else {
                        oNum--;
                    }
                } else if (chars[j] == 'u') {
                    if (uNum == 0) {
                        uNum++;
                    } else {
                        uNum--;
                    }
                }
                if (aNum + eNum + iNum + oNum + uNum == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }


    /**
     * 执行用时: 19 ms, 在所有 Java 提交中击败了 40.08% 的用户
     *
     *
     * @param s
     * @return
     */
    public static int findTheLongestSubstring_01(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int allState = (int) Math.pow(2, 5);
        int[] stateAndIndex = new int[allState + 1];
        Arrays.fill(stateAndIndex, -1);
        int state = 0;
        int ans = 0;
        stateAndIndex[0] = 0;
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] == 'a') {
                state ^= 1;
            } else if (chars[i] == 'e') {
                state ^= (1 << 1);
            } else if (chars[i] == 'i') {
                state ^= (1 << 2);
            } else if (chars[i] == 'o') {
                state ^= (1 << 3);
            } else if (chars[i] == 'u') {
                state ^= (1 << 4);
            }

            if (stateAndIndex[state] == -1) {
                stateAndIndex[state] = i;
            } else {
                if (state == 0) {
                    ans = Math.max(ans, i + 1);
                } else {
                    ans = Math.max(ans, i - stateAndIndex[state]);
                }
            }
//            if (stateAndIndex[state] >= 0) {
//                ans = Math.max(ans, i + 1 - stateAndIndex[state]);
//            } else {
//                stateAndIndex[state] = i + 1;
//            }

        }
        return ans;
    }


//    public static int findTheLongestSubstring_02(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        char[] chars = s.toCharArray();
//        int[] stateAndIndex = new int[(1 << 5) + 1];
//
//    }


        public static void main(String[] args) {
//        String s = "leetcodeisgreat";
        String s = "eleetminicoworoep";
        findTheLongestSubstring_01(s);
    }
}
