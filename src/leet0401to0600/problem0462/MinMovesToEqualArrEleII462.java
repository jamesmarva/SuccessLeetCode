package leet0401to0600.problem0462;

import java.util.Arrays;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/
 * @author: James
 * @create: 2019-09-08 10:18
 **/
public class MinMovesToEqualArrEleII462 {

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int median = 0;
        if (len % 2 == 1) {
            median = nums[len / 2];
        } else {
            median = (nums[len / 2 - 1] + nums[len / 2]) / 2;
        }
        int ans = 0;
        for (int item : nums) {
            ans += Math.abs(item - median);
        }
        return ans;
    }
}
