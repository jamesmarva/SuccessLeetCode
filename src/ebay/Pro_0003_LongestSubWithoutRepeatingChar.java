package ebay;

import java.util.Arrays;

/**
 * 3. 无重复字符的最长子串
 * @author Brilliant James
 * @date 2020-04-22 05:59
 **/
public class Pro_0003_LongestSubWithoutRepeatingChar {


    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        Arrays.fill(map, -1);
        char[] arr = s.toCharArray();
        int left = 0;
        int ans = 0;
        for (int right = 0, len = arr.length; right < len; right++) {
            char temp = arr[right];
            if (map[temp] >= 0) {
                left = Math.max(left, map[temp] + 1);
            }
            map[temp] = right;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Pro_0003_LongestSubWithoutRepeatingChar l = new Pro_0003_LongestSubWithoutRepeatingChar();
        int i = l.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
