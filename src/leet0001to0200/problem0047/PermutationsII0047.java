package leet0001to0200.problem0047;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * https://leetcode-cn.com/problems/permutations-ii/
 * @date 2019-10-17 07:35
 **/
public class PermutationsII0047 {

    private List<List<Integer>> res = new ArrayList<>();
    private HashSet<String> set = new HashSet<String>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, nums.length, 0);
        return res;
    }

    private void dfs(int[] nums, int len, int j) {
        if (j == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int num : nums) temp.add(num);
            if (set.add(temp.toString())) {
                res.add(temp);
            }
        }
        for (int i = j; i < len; ++i) {
            swap(nums, i, j);
            dfs(nums, len, j+1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] num, int first, int second) {
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }
}
