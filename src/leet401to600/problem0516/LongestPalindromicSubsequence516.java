package leet401to600.problem0516;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * @author: James
 * @create: 2019-09-13 15:31
 **/
public class LongestPalindromicSubsequence516 {


    private int res = 0;
    private int len = 0;
    private String globalS = null;
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        len = s.length();
        globalS = s;
        dfs(0, new StringBuilder());
        return res;
    }


    public int longestPalindromeSubseqBetter(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        Set<String> set = new HashSet<>();
        set.add("");
        int res = 0;
        for (int i = len - 1; i >= 0; --i) {
            Set<String> tempSet = new HashSet<>();
            for (String  item : set) {
                String tempString = s.charAt(i) + item;
                if (set.contains(tempString)) {
                    continue;
                }
                tempSet.add(s.charAt(i) + item);
                if (tempString.length() > res && tempString.equals(new StringBuilder(tempString).reverse().toString())) {
                    res = tempString.length();
                }
            }
            set.addAll(tempSet);
            set.add(s.charAt(i) + "");
        }
        return res;
    }

    public int longestPalindromeSubseqDP(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len - 1];
    }


    private void dfs(int index, StringBuilder sb ) {
        if (index == len) {
            String one = sb.toString();
            String two = sb.reverse().toString();
            System.out.println(one);
            sb.reverse();
            if (one.equals(two)) {
                res = Math.max(res, one.length());
                System.out.println("--- " + one);
            }
            System.out.println("--------------------");
            return;
        }
        dfs(index + 1, sb);
        sb.append(globalS.charAt(index));
        dfs(index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("123456789");
//        System.out.println(sb.reverse().toString());
//        System.out.println(sb.toString());
//        System.out.println(sb.deleteCharAt(sb.length() - 1));
//        System.out.println(sb);

        String test = "bbbab";
        LongestPalindromicSubsequence516 longestPalindromicSubsequence516 =new LongestPalindromicSubsequence516();
        int result = longestPalindromicSubsequence516.longestPalindromeSubseq(test);
        System.out.println(result);
    }
}
