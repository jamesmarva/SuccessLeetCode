package leet0001to0200.problem0049;

import java.util.*;

/**
 * @author James
 * @date 2019-11-29 02:58
 **/
public class GroupAnagrams_0049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return ans;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String word : strs) {
            String temp = getToCharNum(word);
            ArrayList<String> list = map.getOrDefault(temp, new ArrayList<String>());
            list.add(word);
            map.put(temp, list);
        }
        for (ArrayList<String> item : map.values()) {
            ans.add(item);
        }
        return ans;
    }

    private String getToCharNum(String word) {
        int[] ans = new int[26];
        char[] chars = word.toCharArray();
        for (char item : chars) {
            ans[item - 'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            char temp = (char) ('a' + i);
            sb.append(temp + ans[i] + " ");
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams_1(String[] strs) {
        Set<Integer> set = new HashSet<Integer>();
        List<List<String>> res = new LinkedList<>();
        for (int i = 0, len = strs.length; i < len; ++i) {
            if (set.contains(i)) {
                continue;
            }
            List<String> tempList = new LinkedList<>();
            for (int j = i; j < len; ++j) {
                if (!set.contains(j)) {
                    boolean result = hashBetterIsAnagram(strs[i], strs[j]);
                    if (result) {
                        set.add(j);
                        tempList.add(strs[j]);
                    }
                }
            }
            res.add(tempList);
        }
        return res;
    }

    public boolean hashBetterIsAnagram(String s, String t) {
        int[] first = new int[26];
        for (int i = 0, len = s.length(); i < len; ++i) {
            first[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0, len = t.length(); i < len; ++i) {
            first[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; ++i) {
            if (first[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param strs
     * @return
     */
    public List<List<String>> betterGroupAnagrams(String[] strs) {
        // 查找表法
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 将每个字符串对应字符数组经排序后得到的字符串作为该字符串的分类标志
            String flag = String.valueOf(chars);
            List<String> list = map.getOrDefault(flag, new ArrayList<>());
            list.add(str);
            map.put(flag, list);
        }
        return new ArrayList<>(map.values());
    }
}
