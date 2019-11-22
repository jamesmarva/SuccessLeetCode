package leet0001to0200.problem0016;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author James
 * @date 2019-11-22 00:26
 **/
public class ThreeSumClosest_0016 {


    /**
     *
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i <= len - 3; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int tempSum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - tempSum) < dis) {
                    ans = tempSum;
                    dis = Math.abs(target - tempSum);
                }
                if (tempSum < target) {
                    start++;
                } else if (tempSum > target) {
                    end--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }

}
