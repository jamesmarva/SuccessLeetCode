package leet0001to0200.problem0139;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break/
 * @author James
 * @date 2019-12-01 16:40
 **/
public class WordBreak_0139 {


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int sLen = s.length();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        HashSet<Integer> set = new HashSet<>();
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                int tempIndex = queue.poll();
                if (tempIndex == sLen) {
                    return true;
                }
                for (String item : wordDict) {
//                    for (int i = 0; i < len; ++i) {
//                        if (arr[tempIndex + i] != item.charAt(0)) {
//                            isMatched = false;
//                            break;
//                        }
//                    }
                    int len = item.length();
                    if (!set.contains(tempIndex + len) && tempIndex + len < sLen
                            && item.equals(s.substring(tempIndex, tempIndex + len)))  {
                        queue.offer(tempIndex + len);
                        set.add(tempIndex+ len);
                    }
                }
                count--;
            }
        }
        return false;
    }


    private boolean ans = false;
    public boolean wordBreak_1(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        dfs(0, set, s.length(), s);
        return ans;
    }


    private void dfs(int index, HashSet<String> set, int len, String s) {
        if (ans) {
            return;
        }
        if (index == len) {
            ans = true;
        }

        for (String item : set) {
            int tempLen = index + item.length();
            if (tempLen <= len && set.contains(s.substring(index, tempLen))) {
                dfs(tempLen, set, len, s);
            }
        }
    }


    /**
     * 回溯递归 + 记忆化剪枝备忘录）
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        HashSet<Integer> visited = new HashSet<>();
        dfs_1(0, set, s.length(), s, visited);
        return ans;
    }


    private void dfs_1(int index, HashSet<String> set, int len, String s, HashSet<Integer> visited) {
        if (ans) {
            return;
        }
        if (index == len) {
            ans = true;
        }

        for (String item : set) {
            int tempLen = index + item.length();
            if (visited.contains(tempLen)) {
                continue;
            }
            if (tempLen <= len && set.contains(s.substring(index, tempLen))) {
                visited.add(tempLen);
                dfs_1(tempLen, set, len, s, visited);
            }
        }
    }


    /**
     *  动态规划执行用时 :
     * 4 ms, 在所有 java 提交中击败了92.58%的用户
     * 内存消耗 :35.6 MB, 在所有 java 提交中击败了85.24%的用户
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_3(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for (int i = 0; i <= len; i++) {
            for (String item : wordDict) {
                // 提前退出
                if (dp[i]) {
                    break;
                }
                int tempIndex = i - item.length();
                if (tempIndex >= 0 && item.equals(s.substring(tempIndex, i)) && dp[tempIndex]) {
                    dp[i] = true;

                }
            }
        }
        return dp[len];
    }
    public static void main(String[] args) {
        String s = "catlong";
        System.out.println(s.substring(0, 3));
        System.out.println(s.substring(3, 7));
    }

}
