package leet0001to0200.problem0076;

import java.util.*;

//import javax.util.Pair;


/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 76. 最小覆盖子串
 * @author Brilliant James
 * @date 2020-03-06 13:10
 **/
public class MinWindowSubstring_0076 {

    public static String minWindow(String s, String t) {
        if (t == null || "".equals(t)) {
            return "";
        }
        char[] sChars = s.toCharArray();
        int[] sFrequency = new int[128];
        int[] tFrequency = new int[128];
        int sLen = s.length();
        int tLen = t.length();
        Set<Character> set = new HashSet<>();
        char[] tChars = t.toCharArray();
        for (char item : tChars) {
            tFrequency[item] ++;
            set.add(item);
        }
        int left = 0;
        int right = 0;
        int beginIndex = 0;
        int minDis = s.length();
        boolean exist = false;
        sFrequency[sChars[right]] ++;
        while (left <= right && right < sLen) {
            if (right - left + 1 < tLen) {
                if (++right < sLen) {
                    sFrequency[sChars[right]]++;
                }
            } else {
                if (isInclude(sFrequency, tFrequency, set)) {
                    exist = true;
                    if (minDis > right - left + 1) {
                        minDis = right - left + 1;
                        beginIndex = left;
                    }
                    sFrequency[sChars[left]]--;
                    left++;
                } else {
                    if (++right < sLen) {
                        sFrequency[sChars[right]]++;
                    }
                }
            }
        }
        if (exist) {
            return s.substring(beginIndex, beginIndex + minDis);
        } else {
            return "";
        }
    }

    private static boolean isInclude(int[] sFrequency, int[] tFrequency, Set<Character> set) {
        for (char item : set) {
            if (sFrequency[item] < tFrequency[item]) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow_01(String s, String t) {
        if (t == null || "".equals(t)) {
            return "";
        }
        int numsOfEnough = 0, numsOfNeed = 0, sLen = s.length(), minDis =  s.length();
        int right = 0, left = 0, begin = -1;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] window = new int[128];
        int[] tMap = new int[128];
        for (char item : tChars) {
            if (tMap[item] == 0) {
                numsOfNeed ++;
            }
            tMap[item]++;
        }
        while (right < sLen) {
            int tempChar = sChars[right];
            window[tempChar]++;
            if (tMap[tempChar] > 0 && tMap[tempChar] == window[tempChar]) {
                numsOfEnough++;
            }
            while (left <= right && numsOfEnough == numsOfNeed) {
                if (begin == -1 || minDis > right - left + 1) {
                    minDis =  right - left + 1;
                    begin = left;
                }
                window[sChars[left]]--;
                if (window[sChars[left]] < tMap[sChars[left]]) {
                    numsOfEnough--;
                }
                left++;
            }
            right++;
        }
        if (begin != -1) {
            return s.substring(begin, begin+minDis);
        } else {
            return "";
        }
    }

    public static String minWindow_02(String s, String t) {
        if (t == null || "".equals(t)) {
            return "";
        }
        Set<Character> set = new HashSet<>();
        int numsOfEnough = 0, numsOfNeed = 0, sLen = s.length(), minDis =  s.length();
        int right = 0, left = 0, begin = -1;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] window = new int[128];
        int[] tMap = new int[128];
        for (char item : tChars) {
            if (tMap[item] == 0) {
                numsOfNeed ++;
            }
            tMap[item]++;
        }
        for (char item : tChars) {
            set.add(item);
        }
        List<CharAndInt>  list = new ArrayList<>();
        for (int i = 0; i < sLen; i++) {
            if (set.contains(sChars[i])) {
                list.add(new CharAndInt(sChars[i], i));
            }
        }
        int size =  list.size();
        while (right < size) {
            CharAndInt rightTemp = list.get(right);
            window[rightTemp.charValue]++;

            // 注意，这里必须要用到 “=” 号，为了防止超过重复累加的问题
            if (tMap[rightTemp.charValue] > 0 && tMap[rightTemp.charValue] == window[rightTemp.charValue]) {
                numsOfEnough++;
            }
            while (left <= right && numsOfEnough == numsOfNeed) {
                CharAndInt leftTemp = list.get(left);
                int tempDis = rightTemp.intValue - leftTemp.intValue + 1;
                if (begin == -1 || minDis > tempDis) {
                    minDis = tempDis;
                    begin = leftTemp.intValue;
                }
                char c = leftTemp.charValue;
                window[c]--;
                if (window[c] < tMap[c]) {
                    numsOfEnough--;
                }
            }
            right++;
        }
        if (begin == -1) {
            return "";
        } else {
            return s.substring(begin, begin + minDis);
        }
    }

    static class  CharAndInt {
        public char charValue;
        public int intValue;
        CharAndInt(char charValue, int intValue) {
            this.charValue = charValue;
            this.intValue = intValue;
        }
    }

    class Solution {
        public String minWindow(String s, String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            // Dictionary which keeps a count of all the unique characters in t.
            Map<Character, Integer> dictT = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
                int count = dictT.getOrDefault(t.charAt(i), 0);
                dictT.put(t.charAt(i), count + 1);
            }

            // Number of unique characters in t, which need to be present in the desired window.
            int required = dictT.size();

            // Left and Right pointer
            int l = 0, r = 0;

            // formed is used to keep track of how many unique characters in t
            // are present in the current window in its desired frequency.
            // e.g. if t is "AABC" then the window must have two A's, one B and one C.
            // Thus formed would be = 3 when all these conditions are met.
            int formed = 0;

            // Dictionary which keeps a count of all the unique characters in the current window.
            Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

            // ans list of the form (window length, left, right)
            int[] ans = {-1, 0, 0};

            while (r < s.length()) {
                // Add one character from the right to the window
                char c = s.charAt(r);
                int count = windowCounts.getOrDefault(c, 0);
                windowCounts.put(c, count + 1);

                // If the frequency of the current character added equals to the
                // desired count in t then increment the formed count by 1.
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    formed++;
                }

                // Try and co***act the window till the point where it ceases to be 'desirable'.
                while (l <= r && formed == required) {
                    c = s.charAt(l);
                    // Save the smallest window until now.
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    // The character at the position pointed by the
                    // `Left` pointer is no longer a part of the window.
                    windowCounts.put(c, windowCounts.get(c) - 1);
                    if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                        formed--;
                    }

                    // Move the left pointer ahead, this would help to look for a new window.
                    l++;
                }

                // Keep expanding the window once we are done co***acting.
                r++;
            }

            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
//        String s = "a";
//        String t= "aa";
        String res = minWindow_01(s, t);
        System.out.println("res : " + res);
    }
}