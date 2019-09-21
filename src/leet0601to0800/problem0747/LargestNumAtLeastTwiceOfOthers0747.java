package leet0601to0800.problem0747;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * @author: James
 * @create: 2019-09-13 13:24
 **/
public class LargestNumAtLeastTwiceOfOthers0747 {

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int maxIndex = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (maxIndex != i && nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < len; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }


    public int dominantIndexBetter(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int maxIndex = nums[0] > nums[1] ? 0 : 1;
        int secondMaxIndex = nums[0] > nums[1] ? 1 : 0;;

        int len = nums.length;
        for (int i = 2; i < len; ++i) {
            if (nums[maxIndex] < nums[i]) {
                secondMaxIndex = maxIndex;
                maxIndex = i;
            } else if (nums[secondMaxIndex] < nums[i]) {
                secondMaxIndex = i;
            }
        }
        if (nums[maxIndex] >= 2 * nums[secondMaxIndex]) {
            return maxIndex;
        } else {
            return -1;
        }
    }
}
