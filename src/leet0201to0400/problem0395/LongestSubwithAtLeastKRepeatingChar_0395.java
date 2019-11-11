package leet0201to0400.problem0395;

import leet.code2019.april.ContainerWithMostWater11;

import javax.print.DocFlavor;
import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * @date 2019-11-10 12:34
 **/
public class LongestSubwithAtLeastKRepeatingChar_0395 {


    /**
     * 这种做法错的
     */
    public int longestSubstring(String s, int k) {
        Map<Character,Integer> allCharMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char item : chars) {
            allCharMap.put(item, allCharMap.getOrDefault(item, 0) + 1);
        }
        int len = chars.length;
        Map<Character, Integer> tempMap = new HashMap<>();
        int right = 0;
        int left = 0;
        int maxLen = 0;
        while (right < len) {
            if (allCharMap.get(chars[right]) < k) {
                while (left != right) {
                    tempMap.put(chars[left], tempMap.get(chars[left]) - 1);
                    if (checkTempMap(tempMap, k)) {
                        maxLen = Math.max(maxLen, (right - left) - 1);
                    }
                    left++;
                }
                tempMap.clear();
                while (right < len) {
                    if (allCharMap.get(chars[right]) >= k) {
                        left = right;
                        tempMap.put(chars[right], 1);
                        break;
                    }
                    right++;
                }
                continue;
            }

            tempMap.put(chars[right], tempMap.getOrDefault(chars[right], 0) + 1);
            if (checkTempMap(tempMap, k)) {
                maxLen = Math.max(maxLen, (right - left) + 1);
            }
            right++;
            if (right == len) {
                while (left != right) {
                    tempMap.put(chars[left], tempMap.get(chars[left]) - 1);
                    if (checkTempMap(tempMap, k)) {
                        maxLen = Math.max(maxLen, (right - left) - 1);
                    }
                    left++;
                }
            }
        }
        return maxLen;
    }

    private boolean checkTempMap(Map<Character, Integer> map, int target) {
        for (Character charItem : map.keySet()) {
            if (map.get(charItem) != 0 && map.get(charItem) < target) {
                return false;
            }
        }
        return true;
    }

    public int longestSubstring_1(String s, int k) {
        char[] chars = s.toCharArray();
        return longestSubStringCore(chars, 0, chars.length - 1, k);
    }
    private int longestSubStringCore(char[] chars, int start, int end, int k) {
        int[] charMap = new int[26];
        for (int i = start; i <= end; i++) {
            charMap[chars[i] - 'a'] ++;
        }
        if (end - start - 1 >= k && charMap[chars[start] - 'a'] < k) {
            start++;
        }

        if (end - start + 1 >= k && charMap[chars[end] - 'a'] < k) {
            end--;
        }

        if (end - start + 1 < k) {
            return 0;
        }

        for (int i = start; i < end; i++) {
            if (charMap[chars[i] - 'a'] < k) {
                return Math.max(longestSubStringCore(chars, start, i, k), longestSubStringCore(chars, i + 1, end, k));
            }
        }
        return end - start + 1;
    }




    /**
     * "ababacb"
     * 3
     *
     * "bbaaacbd"
     * 3
     *
     * "aaabb"
     * 3
     */
    public static void main(String[] args) {
        String test ="ababacb";
        int k = 3;

        LongestSubwithAtLeastKRepeatingChar_0395 longestSubwithAtLeastKRepeatingChar_0395 = new LongestSubwithAtLeastKRepeatingChar_0395();

        longestSubwithAtLeastKRepeatingChar_0395.longestSubstring(test, 3);
    }


}
