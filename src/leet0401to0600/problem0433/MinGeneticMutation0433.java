package leet0401to0600.problem0433;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * @author James
 * @date 2019-10-29 21:02
 **/
public class MinGeneticMutation0433 {

    /**
     * 广度优先搜索
     */
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        bankSet.add(start);
        if (!bankSet.contains(end)) {
            return 0;
        }
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String parent: bankSet) {
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<>());
            }
            for (String child : bankSet) {
                if (!parent.equals(child) && isChild(parent, child)) {
                    map.get(parent).add(child);
                }
            }
        }
        int ans  = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        bankSet.remove(start);
        while (queue.size() > 0) {
            int count = queue.size();
            ans++;
            while (count > 0) {
                String parent = queue.poll();
                if (parent.equals(end)) {
                    return ans;
                }
                ArrayList<String> listChild = map.get(parent);
                for (String child : listChild) {
                    if (bankSet.contains(child)) {
                        queue.offer(child);
                        bankSet.remove(child);
                    }
                }
                count--;
            }

        }
        return -1;
    }

    private boolean isChild(String parent, String child) {
        if (parent.length() != child.length()) {
            return false;
        }
        int countDiff = 0;
        for (int i = 0, len = parent.length(); i < len; ++i) {
            if (parent.charAt(i) != child.charAt(i)) {
                countDiff++;
            }
            if (countDiff > 1) {
                return false;
            }
        }
        return countDiff == 1;
    }


    /**
     * 单向广度优先搜索的比较好的写法。
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了91.26%的用户
     * 内存消耗 :33.9 MB, 在所有 java 提交中击败了68.18%的用户
     *
     */
    public int minMutation1(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (queue.size() > 0) {
            step++;
            for (int count = queue.size(); count > 0; --count) {
                char[] temStringChars = queue.poll().toCharArray();
                for (int i = 0, len = temStringChars.length; i < len; ++i) {
                    char oldChar = temStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        temStringChars[i] = four[j];
                        String newGenetic = new String(temStringChars);
                        if (end.equals(newGenetic)) {
                            return step;
                        } else if (set.contains(newGenetic)) {
                            set.remove(newGenetic);
                            queue.offer(newGenetic);
                        }
                    }
                    temStringChars[i] = oldChar;
                }
            }
        }
        return -1;
    }


    /**
     * 双向广度优先搜索
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation2(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        HashSet<String> positive = new HashSet<>(){{add(start);}};
        HashSet<String> negative = new HashSet<>(){{add(end);}};
        HashSet<String> tempNewSet = new HashSet<>();
        int step = 0;
        while (positive.size() > 0 && negative.size() > 0) {
            step++;
            if (positive.size() > negative.size()) {
                HashSet<String> temp = new HashSet<>(positive);
                positive = negative;
                negative = temp;
            }

            for (String item : positive) {
                String str;
                char[] tempStringChars = item.toCharArray();
                for (int i = tempStringChars.length - 1; i >= 0; --i) {
                    char oldChar = tempStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        tempStringChars[i] = four[j];
                        String newString = new String(tempStringChars);
                        if (negative.contains(newString)) {
                            return step;
                        } else if (set.contains(newString)) {
                            set.remove(newString);
                            tempNewSet.add(newString);
                        }
                    }
                    tempStringChars[i] = oldChar;
                }
            }
            positive = new HashSet<>(tempNewSet);
            tempNewSet.clear();
        }
        return -1;
    }

    /**
     * "AACCTTGG"
     * "AATTCCGG"
     * ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
     * String start = "AAAAACCC";
     * String end = "AACCCCCC";
     * String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
     * @param args
     */
    public static void main(String[] args) {
        String start = "AACCTTGG";
        String end = "AATTCCGG";
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        MinGeneticMutation0433 minGeneticMutation0433 = new MinGeneticMutation0433();
        minGeneticMutation0433.minMutation(start, end, bank);

    }
}