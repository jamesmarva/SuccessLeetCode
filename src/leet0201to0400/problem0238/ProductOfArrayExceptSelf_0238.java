package leet0201to0400.problem0238;

import java.util.Arrays;

/**
 * @author James
 * @date 2019-11-28 17:47
 **/
public class ProductOfArrayExceptSelf_0238 {

    /**
     * 思想有点像动态规划
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return null;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        int[] ans = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
