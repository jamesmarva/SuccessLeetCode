package leet0001to0200.problem0003;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author James
 * @date 2019-11-25 18:42
 **/
public class LongestSubstringWithoutRepeatingChar_0003 {

    /**
     * 执行用时: 12 ms, 在所有 java 提交中击败了70.51%的用户
     * 内存消耗: 39.5 MB, 在所有 java 提交中击败了80.01%的用户
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0, len = chars.length; i < len; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                ans = Math.max(i - left + 1, ans);
            } else {
                while (set.contains(chars[i])) {
                    set.remove(chars[left]);
                    left++;
                }
                set.add(chars[i]);
            }
        }
        return ans;
    }


    public int lengthOfLongestSubstring_2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring_1(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
