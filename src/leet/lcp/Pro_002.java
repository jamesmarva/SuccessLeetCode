package leet.lcp;

import java.util.*;

/**
 * @author Brilliant James
 * @date 2020-04-18 16:03
 **/
public class Pro_002 {

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] i : relation) {
            if (adj.containsKey(i[0])) {
                adj.get(i[0]).add(i[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i[1]);
                adj.put(i[0], set);
            }
        }
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        k++;
        while (queue.size() > 0 && k > 0) {
            int count = queue.size();
            k--;
            while (count > 0) {
                int temp = queue.poll();
                if (k == 0 && temp == n - 1) {
                    ans++;
                }
                if (adj.containsKey(temp)) {
                    queue.addAll(adj.get(temp));
                }
                count--;
            }
        }
        return ans;
    }
}
