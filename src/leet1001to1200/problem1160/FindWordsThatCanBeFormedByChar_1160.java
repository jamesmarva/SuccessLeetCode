package leet1001to1200.problem1160;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author James
 * @date 2019-11-26 16:32
 **/
public class FindWordsThatCanBeFormedByChar_1160 {

    public int countCharacters(String[] words, String chars) {
        if (chars == null || chars.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map =new HashMap<>();
        for (char item : chars.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        int ans = 0;
        for (String item : words) {
            char[] tempArr = item.toCharArray();
            HashMap<Character, Integer> tempMap= (HashMap<Character, Integer>) map.clone();
            boolean all = true;
            for (char charItem : tempArr) {
                if (tempMap.getOrDefault(charItem, 0) < 1) {
                    all = false;
                    break;
                } else {
                    tempMap.put(charItem, tempMap.getOrDefault(charItem, 0) - 1);
                }
            }
            if (all) {
                ans += item.length();
            }
        }
        return ans;
    }

    /**
     * 执行用时 :8 ms, 在所有 java 提交中击败了91.03%的用户
     * 内存消耗 :37.6 MB, 在所有 java 提交中击败了100.00%的用户
     */
    public int countCharacters_1(String[] words, String chars) {
        if (chars == null || chars.length() == 0) {
            return 0;
        }
        int[] arr = new int[26];
        HashMap<Character, Integer> map =new HashMap<>();
        for (char item : chars.toCharArray()) {
            arr[item-'a'] += 1;
        }
        int ans = 0;
        for (String item : words) {
            char[] tempArr = item.toCharArray();
            int[] tempMap = arr.clone();
            boolean all = true;
            for (char charItem : tempArr) {
                if (tempMap[charItem-'a'] < 1) {
                    all = false;
                    break;
                } else {
                    tempMap[charItem-'a'] -= 1;
                }
            }
            if (all) {
                ans += item.length();
            }
        }
        return ans;
    }
}
