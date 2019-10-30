package leet0001to0200.problem0127;

import java.util.*;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-26 10:40
 **/
public class WordLadder0127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!wordList.contains(beginWord) ) {
            wordList.add(beginWord);
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String item1 : wordList) {
            ArrayList<String> tempList = new ArrayList<>();
            for (String item2 : wordList) {
                if (item1 != item2 && isChangeOneLetter(item1, item2)) {
                    tempList.add(item2);
                }
            }
            map.put(item1, tempList);
        }
        HashSet<String> set = new HashSet<>(wordList);
        queue.add(beginWord);
        set.remove(beginWord);
        int count = 1;
        while (queue.size() > 0) {
            int countOfElements = queue.size();
            while (countOfElements > 0) {
                String temp = queue.poll();
                if (temp != null && temp.equals(endWord)) {
                    return count;
                }
                ArrayList<String> list = map.get(temp);
                for (String item : list) {
                    if (set.contains(item)) {
                        queue.add(item);
                        set.remove(item);
                    }
                }
                countOfElements--;
            }
            count++;
        }
        return 0;

    }

    private boolean isChangeOneLetter(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        int countOfDiff = 0;
        for (int i = 0, len = first.length(); i < len; ++i) {
            if (first.charAt(i) != second.charAt(i)) {
                if ((++countOfDiff) > 1) {
                    break;
                }
            }
        }
        return countOfDiff == 1;
    }

    /**
     在提交里看到的最优解，看懂了，解读一下分享出来：
     需要掌握的知识递进：
     1.BFS。
     2.双端BFS。
     3.临近点查找方式：
     首先将所有的字符存到结构为HashSet的dic字典里去，然后将字符串的每一位挨个从a变到z,
     在变化的时候实时去字典里查，因为是hashset，所以复杂度是O(1)，非常快。
     如果查到了，则就是找到了临近点。
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        //hashset的好处：去重也完成了
        //开始端
        HashSet<String> start = new HashSet<>();
        //结束端
        HashSet<String> end = new HashSet<>();
        //所有字符串的字典
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        if (!dic.contains(endWord)) {
            return 0;
        }
        //经历过上面的一系列判定，到这里的时候，若是有路径，则最小是2，所以以2开始
        return bfs(start, end, dic, 2);

    }

    public int bfs(HashSet<String> st, HashSet<String> ed, HashSet<String> dic, int l) {
        //双端查找的时候，若是有任意一段出现了“断裂”，也就是说明不存在能够连上的路径，则直接返回0
        if (st.size() == 0) {
            return 0;
        }

        //双端查找，为了优化时间，永远用少的去找多的，比如开始的时候塞进了1000个，而结尾只有3个，则肯定是从少的那一端开始走比较好
        if (st.size() > ed.size()) {
            return bfs(ed, st, dic, l);
        }
        //BFS的标记行为，即使用过的不重复使用
        dic.removeAll(st);
        //收集下一层临近点
        HashSet<String> next = new HashSet<>();
        for (String s : st) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                // 变化
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) {
                        continue;
                    }
                    arr[i] = c;
                    String nstr = new String(arr);
                    if (dic.contains(nstr)) {
                        if (ed.contains(nstr)) {
                            return l;
                        } else {
                            next.add(nstr);
                        }
                    }
                }
                //复原
                arr[i] = tmp;
            }
        }
        return bfs(next, ed, dic, l + 1);
    }

    public static void main(String[] args) {
        String test1 = "abcd";
        String test2 = "qwer";
        String test3 = "abcr";
        String test4 ="hit";
        String test5 = "cog";

        String[] testArr = {"hot","dot","dog","lot","log","cog"};
        ArrayList<String> testList = new ArrayList(Arrays.asList(testArr));
        WordLadder0127 wordLadder0127 = new WordLadder0127();
        System.out.println(wordLadder0127.ladderLength(test4, test5, testList));
//        System.out.println(wordLadder0127.isChangeOneLetter(test1, test2));
//        System.out.println(wordLadder0127.isChangeOneLetter(test1, test3));
//        System.out.println(wordLadder0127.isChangeOneLetter(test2, test3));


    }
}
