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
     * 新的BFS
     * V+N
     * 执行用时: 89 ms, 在所有 java 提交中击败了77.17%的用户
     * 内存消耗: 40.6 MB, 在所有 java 提交中击败了69.39%的用
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int ans = 0;
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                char[] tempWordChars = queue.poll().toCharArray();
                for (int j = 0, len = tempWordChars.length; j < len; ++j) {
                    char oldChar = tempWordChars[j];
                    for (char index = 'a'; index <= 'z'; index++) {
                        tempWordChars[j] = index;
                        String tempWord = new String(tempWordChars);
                        if (endWord.equals(tempWord)) {
                            return ans + 1;
                        }
                        if (set.contains(tempWord)) {
                            set.remove(tempWord);
                            queue.offer(tempWord);
                        }
                    }
                    tempWordChars[j] = oldChar;
                }
                count--;
            }
            ans++;
        }
        return 0;
    }



    /**
     * 新的BFS 单向搜索优化，没啥用。。。不用理会
     * ×××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Map<String, Integer> fromPos = new HashMap<>();
        int level = 0;
        fromPos.put(beginWord, -1); // we can change all positions for the begin word
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);
        while (queue.size() > 0) {
            level++;
            int count = queue.size();
            while (count > 0) {
                String tempWord = queue.poll();
                char[] tempWordChars = tempWord.toCharArray();
                for (int i = 0, len = tempWordChars.length; i < len; ++i) {
                    // every word only in once, use?
                    if (fromPos.get(tempWord) != null && i == fromPos.get(tempWord)) {
                        continue;
                    }
                    char oldChar = tempWordChars[i];
                    for (char letterIndex = 'a'; letterIndex <= 'z'; ++letterIndex) {
                        tempWordChars[i] = letterIndex;
                        String afterInsteadWord = new String(tempWordChars);
                        if (endWord.equals(afterInsteadWord)) {
                            return level + 1;
                        }
                        if (set.contains(afterInsteadWord)) {
                            set.remove(afterInsteadWord);
                            queue.offer(afterInsteadWord);
                            fromPos.put(tempWord, i);
                        }
                    }
                    tempWordChars[i] = oldChar;
                }
                count--;
            }
        }
        return 0;
    }

//    ×××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××


    /**
     * 双向广搜
     * 执行用时 :27 ms, 在所有 java 提交中击败了95.11%的用户
     * 内存消耗 : 38.5 MB, 在所有 java 提交中击败了87.33%的用户
     */
    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        int level = 0;
        Queue<String> positiveQueue = new LinkedList<>(Arrays.asList(beginWord));
        Queue<String> negativeQueue = new LinkedList<>(Arrays.asList(endWord));
        while (positiveQueue.size() > 0 && negativeQueue.size() > 0) {
            level++;
            if (positiveQueue.size() > negativeQueue.size()) {
                Queue<String> temp = new LinkedList<>(positiveQueue);
                positiveQueue = new LinkedList<>(negativeQueue);
                negativeQueue = temp;
            }
            int count = positiveQueue.size();
            Queue<String> tempNewPositiveQueue = new LinkedList<>();
            HashSet<String> tempNegativeSet = new HashSet<>(negativeQueue);
            while (count > 0) {
                String tempWord = positiveQueue.poll();
                char[] tempWordChars = tempWord.toCharArray();
                for (int i = 0, len = tempWordChars.length; i < len; ++i) {
                    char oldChar = tempWordChars[i];
                    // traversing  26 letter.
                    for (char letterIndex = 'a'; letterIndex <= 'z'; ++letterIndex) {
                        tempWordChars[i] = letterIndex;
                        String tempWordAfterInstead = new String(tempWordChars);
                        if (tempNegativeSet.contains(tempWordAfterInstead)) {
                            return level + 1;
                        }
                        if (set.contains(tempWordAfterInstead)) {
                            tempNewPositiveQueue.offer(tempWordAfterInstead);
                            set.remove(tempWordAfterInstead);
                        }
                    }
                    tempWordChars[i] = oldChar;
                }
                count--;
            }
            positiveQueue = tempNewPositiveQueue;
        }
        return 0;
    }

/**
 *  while (!q.empty()) {
 *             ++level;
 *
 *             // queue size is changing, take it out now! otherwise we don't know
 *             // how many items are in the current level.
 *             int level_items = q.size();
 *             for (int i = 0; i < level_items; ++i) {
 *                 string word = q.front();
 *                 q.pop();
 *                 for (int pos = 0; pos < word_len; ++pos) {
 *                     if (pos == from_pos[word])
 *                         continue;
 *
 *                     char orig_char = word[pos];
 *                     for (char c = 'a'; c <= 'z'; ++c) {
 *                         word[pos] = c;
 *                         if (word == end_word)
 *                             return level + 1;
 *
 *                         if (dic.find(word) == dic.end())
 *                             continue;
 *
 *                         from_pos[word] = pos;
 *
 *                         // we don't want to have a path like ... -> hot -> ... -> hot -> ...
 *                         dic.erase(word);
 *
 *                         // queue word to the next level
 *                         q.push(word);
 *                     }
 *                     word[pos] = orig_char;
 *                 }
 *                 from_pos.erase(word);
 *             }
 *         }
 *
 */
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
