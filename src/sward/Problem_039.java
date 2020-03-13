package sward;

/**
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 数组中出现次数超过一半的数字
 * @author Brilliant James
 * @date 2020-03-11 06:25
 **/
public class Problem_039 {

    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        int start = 0;
        int end = nums.length - 1;
        int pivotIndex =  partition(nums, start, end);
        while (pivotIndex != mid) {
            if (pivotIndex > mid) {
                end = pivotIndex - 1;
            } else if (pivotIndex < mid) {
                start = pivotIndex + 1;
            }
            pivotIndex =  partition(nums, start, end);
        }
        return nums[pivotIndex];
    }

    private int partition(int[] arr, int start, int end) {
        int index = start;
        int value = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < value) {
                if (i == index) {
                    index++;
                } else if ( i != index) {
                    swap(arr, i, index);
                    index++;
                }
            }
        }
        swap(arr, index, end);
        return index;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
