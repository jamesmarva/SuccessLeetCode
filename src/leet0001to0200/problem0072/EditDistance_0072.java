package leet0001to0200.problem0072;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brilliant James
 * @date 2020-04-06 20:15
 **/
public class EditDistance_0072 {

    private int s1 = 0;
    private int s2 = 0;
    private char[] c1;
    private char[] c2;
    private Map<String, Integer> memory;
    /**
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        c1 = word1.toCharArray();
        c2 = word2.toCharArray();
        s1 = c1.length;
        s2 = c2.length;
        memory = new HashMap<>();
        return dfs(0,0);
    }

    /**
     *
     * @param i1
     * @param i2
     * @return
     */
    public int dfs(int i1, int i2) {
        String key = i1 + " " + i2;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        if (i1 == s1) {
            memory.put(key, s2 - i2);
            return s2 - i2;
        }
        if (i2 == s2) {
            memory.put(key, s1 - i1);
            return s1 - i1;
        }
        int ans = 0;
        if (c1[i1] == c2[i2]) {
            ans = dfs(i1 + 1, i2 + 1);
        } else {
            // delete
            // aabc
            // aaabc
            int disInDelete = dfs(i1 + 1, i2) + 1;

            // add
            int disInAdd = dfs(i1, i2 + 1) + 1;

            // replace
            int disInReplace = dfs(i1+1, i2 + 1) + 1;

            ans = Math.min(Math.min(disInDelete, disInAdd), disInReplace);
        }
        memory.put(key, ans);
        return ans;
    }


}
