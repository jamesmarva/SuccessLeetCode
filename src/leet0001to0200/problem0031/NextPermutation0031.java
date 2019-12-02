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



    public void nextPermutation_1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int len = nums.length;
        int index = len - 2;
        for (;index >= 0; --index) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, len - 1);
            return;
        }

        int firstBig = len - 1;
        for (; firstBig > index; firstBig++) {
            if (nums[firstBig] > nums[index]) {
                break;
            }
        }
        if (firstBig > index) {
            swap(nums, firstBig, index);
        }
        reverse(nums, index + 1, len - 1);
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
           swap(arr, start, end);
           start++;
           end--;
        }
    }

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    private Set<Integer> set = new HashSet<>();

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        dfs(nums, 0, nums.length);
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
//        int index = list.indexOf()
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


}
