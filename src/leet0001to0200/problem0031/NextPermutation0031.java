package leet0001to0200.problem0031;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/next-permutation/
 * @date 2019-10-17 01:00
 **/
public class NextPermutation0031 {


    private Set<Integer> set = new HashSet<>();

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        dfs(nums, 0, nums.length);
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
//        int tmep =
//        list.


    }

    private void dfs(int[] nums, int index, int len) {
        if (index == nums.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; ++i) {
                sb.append(nums[i] + "");
            }
            set.add(Integer.valueOf(sb.toString()));
        }
        for (int i = index; i < len; ++i) {
            swap(nums, index, i);
            dfs(nums, i + 1, len);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
}
