package leet.lcp;

import utils.TreeNode;

import java.util.*;

/**
 * @author Brilliant James
 * @date 2020-04-18 16:21
 **/
public class Pro_008 {

    /**
     * https://leetcode-cn.com/contest/season/2020-spring/problems/ju-qing-hong-fa-shi-jian-UGC/
     * @param increase
     * @param requirements
     * @return
     */
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] ans = new int[0];
        if (requirements == null || requirements.length == 0) {
            return ans;
        }
        int len  = requirements.length;
        ans = new int[len];
        Arrays.fill(ans, -1);
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            int sum = requirements[i][0] + requirements[i][1] + requirements[i][2];
            if (map.containsKey(sum)) {
                map.get(sum).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(sum, set);
            }
        }
        int c = 0;
        int r = 0;
        int h = 0;
        check(map, c, r, h, requirements, ans, 0);
        for (int i = 0, len2 = increase.length; i < len2; i++) {
            c += increase[i][0];
            r += increase[i][1];
            h += increase[i][2];
            check(map, c, r, h, requirements, ans, i);
        }
        return ans;
    }

    private void check(TreeMap<Integer, Set<Integer>> map, int c, int r, int h, int[][] re, int[] ans, int day) {
        int sum = c + r + h;
        Integer key = map.floorKey(sum);
        while (key != null) {
            Set<Integer> temp = map.get(key);
            Iterator<Integer> iterator = temp.iterator();
            while (iterator.hasNext()) {
                int index = iterator.next();
                if (ans[index] == -1 && re[index][0] <= c && re[index][1] <= r && re[index][2] <= h) {
                    ans[index] = day;
                    iterator.remove();
                }
            }
            if (temp.isEmpty()) {
                map.remove(key);
            }
            key -= 1;
            key = map.floorKey(key);
        }
    }
}
