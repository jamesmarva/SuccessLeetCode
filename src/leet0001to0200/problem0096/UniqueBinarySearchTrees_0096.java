package leet0001to0200.problem0096;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brilliant James
 * @date 2020-03-25 01:46
 **/
public class UniqueBinarySearchTrees_0096 {


    public int numTrees(int n) {

        return dfs(3);
    }
    private Map<Integer, Integer> map = new HashMap<>();

    private int dfs(int nums) {
        if (nums == 1) {
            return 1;
        }
        if (nums == 0) {
            return 1;
        }
        if (nums == 2) {
            return 2;
        }
        if (map.containsKey(nums)) {
            return map.get(nums);
        }
        int res = 0;
        for (int i = 1; i <= nums; i++) {
            int left = dfs(i - 1);
            int right = dfs(nums - i);
            res += left * right;
        }
        map.put(nums, res);
        return res;
    }

    private int dfs(int start, int end) {
        if (start > end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees_0096 u = new UniqueBinarySearchTrees_0096();
        int t = u.numTrees(3);
        System.out.println(t);
    }

}
