package sward;

import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @author Brilliant James
 * @date 2020-03-07 01:18
 **/
public class Problem_051 {

    private int ans = 0;

    /**
     * 在排序中寻找。
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    private void mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = begin + (end - begin >> 1);
        mergeSort(nums, begin, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, begin, mid, end);
    }

    private void merge(int[] nums, int begin, int mid, int end) {
        int index1 = mid;
        int index2 = end;
        int len = end - begin + 1;
        int index  = len - 1;
        int[] tempArr = new int[len];
        while (index1 >= begin && index2 >= mid + 1) {
            if (nums[index1] > nums[index2]) {
                ans += index2 - mid;
                tempArr[index] = nums[index1];
                index1--;
            } else {
                tempArr[index] = nums[index2];
                index2--;
            }
            index--;
        }
        while (index1 >= begin) {
            tempArr[index] = nums[index1];
            index1--;
            index--;
        }
        while (index2 >= mid + 1) {
            tempArr[index] = nums[index2];
            index2--;
            index--;
        }
        for (int i = 0; i < len; i++) {
            nums[begin + i] = tempArr[i];
        }
        return;
    }

    public static void main(String[] args) {
        int[] test ={7,5,6,4};
        Problem_051 pro = new Problem_051();
        int res = pro.reversePairs(test);
        System.out.println(res);
        System.out.println(Arrays.toString(test));
    }
}
