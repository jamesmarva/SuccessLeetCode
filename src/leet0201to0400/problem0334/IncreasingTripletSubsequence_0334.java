package leet0201to0400.problem0334;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * @author James
 * @date 2019-11-16 10:24
 **/
public class IncreasingTripletSubsequence_0334 {


    /**
     * 双指针？？？
     *
     * 这个做法不行
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        int minLeft = nums[0];
        int maxRight = nums[len - 1];
        int leftIndex = 0;
        int rightIndex = len - 1;
        boolean moveLeft = true;
        while (leftIndex < rightIndex - 1) {
            if (moveLeft) {
                leftIndex++;
                int temp = nums[leftIndex];
                if (temp > minLeft && temp < maxRight) {
                    return true;
                }
                moveLeft = false;
            } else {
                rightIndex--;
                int temp = nums[rightIndex];
                if (temp < maxRight && temp > minLeft) {
                    return true;
                }
                moveLeft = true;
            }
        }

        return false;
    }


    /**
     * 用两个临时变量的方式
     * 因为每次遍历一个元素都要进行判断：
     * 1 如何比最小值还要小，那么替换最小值，且 continue
     * 2 如果比最小值大，但是比第二个只要小，那么就替换第二个值。
     * 3 如果比的第二值还要大，我们就确认了有三个递增的子序列
     */
    public boolean increasingTriplet1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int item : nums) {
            if (item < first) {
                first = item;
            } else if (item > first && item < second) {
                second = item;
            } else if (item > second) {
                return true;
            }
        }
        return false;
    }


    /**
     * 初始的大小为3的数组，然后填充这个数组就行了
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] arr = new int[3];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int item : nums) {
            for(int i = 0; i < 3; ++i) {
                if (arr[i] > item && i == 0) {
                    arr[i] = item;
                    break;
                } else if (arr[i] > item && item > arr[i - 1]) {
                    arr[i] = item;
                    if (i == 2) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }


}
