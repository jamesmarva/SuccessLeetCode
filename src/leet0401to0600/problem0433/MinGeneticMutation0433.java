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