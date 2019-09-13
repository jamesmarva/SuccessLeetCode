package leet1to200.problem0027;

import java.util.Arrays;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/remove-element/
 * @author: James
 * @create: 2019-09-13 08:49
 **/
public class RemoveElement0027 {

    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int length = nums.length;
        int beginVal = 0;
        int countVal = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                if (countVal == 0) {
                    beginVal = i;
                }
                countVal ++;
            }
        }

        for (int j = 0; j < countVal; j++) {
            int temp = nums[length - 1 -j];
            nums[length - 1 -j] = nums[beginVal + j];
            nums[beginVal + j] = temp;
        }
        return length - countVal;
    }

}
