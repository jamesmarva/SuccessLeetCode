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


    /**
     * 广度优先用来找最短路劲比较合适，但是这题要把所有的点都找出来。
     * 这里有个点需要注意，就是需要注意某个点在什么哪个层级，这样可以防止某个点在上一级但是仍然被当作子节点
     */
    private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return ans;
        }
        Queue<String> queue = new LinkedList<>();
        HashMap<String, HashSet<String>> parentsMap = new HashMap<>();
        Map<String, Integer> wordLevel = new HashMap<>();
        wordLevel.put(beginWord, 1);
        boolean hasPathToEnd = false;
        queue.offer(beginWord);
        set.remove(beginWord);
        int level = 0;
        while (queue.size() > 0 && !hasPathToEnd) {
            level++;
            int count = queue.size();
            while (count > 0 ) {
                String tempWord = queue.poll();
                char[] tempWordChars = tempWord.toCharArray();
                if (!parentsMap.containsKey(tempWord)) {
                    parentsMap.put(tempWord, new HashSet<>());
                }
                for (int i = 0, len = tempWordChars.length; i < len; ++i) {
                    char oldChar = tempWordChars[i];
                    for (char letterIndex = 'a'; letterIndex <= 'z'; letterIndex++) {
                        if (letterIndex == oldChar) {
                            continue;
                        }
                        tempWordChars[i] = letterIndex;
                        String tempWordAfterInstead = new String(tempWordChars);
                        if (endWord.equals(tempWordAfterInstead)) {
                            parentsMap.get(tempWord).add(tempWordAfterInstead);
                            hasPathToEnd = true;
                        } else if (wordLevel.containsKey(tempWordAfterInstead)
                                && level < wordLevel.get(tempWordAfterInstead)) {
                            parentsMap.get(tempWord).add(tempWordAfterInstead);
                        }
                        if (set.contains(tempWordAfterInstead)) {
                            set.remove(tempWordAfterInstead);
                            queue.offer(tempWordAfterInstead);
                            wordLevel.put(tempWordAfterInstead, wordLevel.get(tempWord) + 1);
                            parentsMap.get(tempWord).add(tempWordAfterInstead);
                        }
                    }
                    tempWordChars[i] = oldChar;
                }
                count--;
            }
        }

        if (hasPathToEnd) {
            LinkedList<String> beginList = new LinkedList<String>(){{add(beginWord);}};
            dfs(beginWord, endWord, beginList, parentsMap);
        }
        return ans;
    }

    private void dfs(String current, String endWord,LinkedList<String> tempList, Map<String, HashSet<String>> parentMap) {
        if (endWord.equals(current)) {
            ans.add((List<String>)tempList.clone());
            return;
        }
        HashSet<String> children =parentMap.get(current);
        if (children == null) {
            return;
        }
        for (String item : children) {
            tempList.addLast(item);
            dfs(item, endWord, tempList, parentMap);
            tempList.removeLast();
        }
    }

    /**
     * 单向广度优先搜素
     */
    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return ans;
        }
        HashSet<String> levelSet = new HashSet<>(), levelSetTemp = new HashSet<>();
        HashMap<String, HashSet<String>> parentToChildren = new HashMap<>();
        boolean hasPathToEnd = false;
        levelSet.add(beginWord);
        while (levelSet.size() > 0  && !hasPathToEnd) {
            set.removeAll(levelSet);
            for (String tempWord : levelSet) {
                if (!parentToChildren.containsKey(tempWord)) {
                    parentToChildren.put(tempWord, new HashSet<>());
                }
                if (!parentToChildren.containsKey(tempWord)) {
                    parentToChildren.put(tempWord, new HashSet<>());
                }
                char[] tempWordChars = tempWord.toCharArray();
                for (int j = 0, len = tempWordChars.length; j < len; ++j) {
                    char oldChar = tempWordChars[j];
                    for (char letterIndex = 'a'; letterIndex  <= 'z'; ++letterIndex) {
                        if (oldChar == letterIndex) {
                            continue;
                        }
                        tempWordChars[j] = letterIndex;
                        String newWord = new String(tempWordChars);
                        if (endWord.equals(newWord)) {
                            hasPathToEnd = true;
                            parentToChildren.get(tempWord).add(newWord);
                        } else if (set.contains(newWord) && !hasPathToEnd) {
                            levelSetTemp.add(newWord);
                            parentToChildren.get(tempWord).add(newWord);
                        }
                    }
                    tempWordChars[j] = oldChar;
                }
            }
            levelSet = (HashSet<String>) levelSetTemp.clone();
            levelSetTemp.clear();
        }
        if (hasPathToEnd) {
            LinkedList<String> beginList = new LinkedList<String>(){{add(beginWord);}};
            dfs(beginWord, endWord, beginList, parentToChildren);
        }
        return ans;
    }


    /**
     *  双向广搜索
     */
    public List<List<String>> findLadders3(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return ans;
        }
        HashSet<String> begin  = new HashSet<String>(){{add(beginWord);}};
        HashSet<String> end = new HashSet<String>(){{add(endWord);}};
        Map<String, HashSet<String>> parentToChildren = new HashMap<>();
        boolean hasPathToEnd = false;
        boolean isBack = false;
        while (begin.size() > 0 && end.size() > 0 && !hasPathToEnd) {
            if (begin.size() > end.size()) {
                HashSet<String> temp = new HashSet<>(begin);
                begin = new HashSet<>(end);
                end = temp;
                isBack = true;
            }
            set.removeAll(begin);
            set.removeAll(end);
            HashSet<String> tempSet = new HashSet<>();
            for (String itemString : begin) {
                char[] tempWordChars = itemString.toCharArray();

                for (int i = tempWordChars.length - 1; i >= 0; i--) {
                    char oldChar = tempWordChars[i];
                    for (char letterChar = 'a'; letterChar <= 'z'; ++letterChar) {
                        tempWordChars[i] = letterChar;
                        String tempNewWord = new String(tempWordChars);
                        String parent  = itemString;
                        String child = tempNewWord;
                        if (isBack) {
                            String tempParent = new String(parent);
                            parent = child;
                            child = tempParent;
                        }
                        if (end.contains(tempNewWord)) {
                            parentToChildren.get(parent).add(child);
                            hasPathToEnd = true;
                        } else if (set.contains(tempNewWord) && !hasPathToEnd) {
                            tempSet.add(tempNewWord);
                            parentToChildren.get(parent).add(child);
                        }
                    }
                    tempWordChars[i] = oldChar;
                }
            }
            begin = tempSet;
            if (isBack) {
                HashSet<String> temp = new HashSet<>(begin);
                begin = new HashSet<>(end);
                end = temp;
                isBack = false;
            }
        }
        if (hasPathToEnd) {
            LinkedList<String> beginList = new LinkedList<String>(){{add(beginWord);}};
            dfs(beginWord, endWord, beginList, parentToChildren);
        }
        return ans;
    }



    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<String>() {{
//                add("asdfasf");
//            }};
//        String begin = "hit";
//        String end = "cog";
//        String[] tests = {"hot","dot","dog","lot","log","cog"};
//        String begin = "a";
//        String end = "c";
//        String[] tests = {"a", "b", "c"};
        String begin = "hot";
        String end = "dog";
        String[] test = {"hot","dog"};

        ArrayList<String> testList = new ArrayList<>(Arrays.asList(test));
        WordLadderII0126 wordLadderII0126 = new WordLadderII0126();
        wordLadderII0126.findLadders3(begin, end, testList);

    }
}
