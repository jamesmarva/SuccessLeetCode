package leet0001to0200.problem0046;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * https://leetcode-cn.com/problems/permutations/
 * @date 2019-10-17 07:31
 **/
public class Permutations0046 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] nums, int j) {
        if (j == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
        }
        for (int i = j, len = nums.length; i < len; ++i) {
            swap(nums, i, j);
            dfs(res, nums, j+1);
            swap(nums, i, j);
        }
    }
    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
