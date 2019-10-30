package leet0001to0200.problem0126;

import java.util.*;

/**
 *  https://leetcode-cn.com/problems/word-ladder-ii/
 * @author James
 * @date 2019-10-26 15:54
 **/
public class WordLadderII0126 {

    PriorityQueue<ArrayList<String>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.size() - o2.size());

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        ArrayList<String> startList = new ArrayList<>() {{
            add(beginWord);
        }};
        dfs(beginWord, endWord, set, startList);
        if (priorityQueue.size() == 0) {
            return new ArrayList<>();
        }
        int minCount = priorityQueue.peek().size();
        List<List<String>> ans = new ArrayList<>();
        while (priorityQueue.size() > 0) {
            ArrayList<String> temp = priorityQueue.poll();
            if (minCount < temp.size()) {
                break;
            }
            ans.add(temp);
        }
        return ans;
    }


    public void dfs(String begin, String end, HashSet<String> set, ArrayList<String> tempList) {
        if (begin.equals(end)) {
            priorityQueue.add((ArrayList<String>)tempList.clone());
            return;
        }
        char[] chars = begin.toCharArray();
        for (int i = 0, len = chars.length; i < len; ++i) {
            char old = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                chars[i] = j;
                String newString = new String(chars);
                if (set.contains(newString)) {
                    set.remove(newString);
                    tempList.add(newString);
                    dfs(newString, end, set, tempList);
                    tempList.remove(newString);
                    set.add(newString);
                }
            }
            chars[i] = old;
        }
    }


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>() {{
                add("asdfasf");
            }};
    }
}
