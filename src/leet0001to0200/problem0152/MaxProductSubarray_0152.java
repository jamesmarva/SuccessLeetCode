package leet0001to0200.problem0152;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.net.Inet4Address;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/submissions/
 * @author Brilliant James
 * @date 2020-03-10 19:41
 **/
public class MaxProductSubarray_0152 {



    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int len = nums.length;
        int[] maxDP = new int[len + 1];
        int[] minDP = new int[len + 1];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                maxDP[i] = Math.max(maxDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(minDP[i - 1] * nums[i], nums[i]);
            } else {
                maxDP[i] = Math.max(minDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(maxDP[i - 1] * nums[i], nums[i]);
            }
            res = Math.max(res, maxDP[i]);
        }
        return res;
    }


    /**
     * https://leetcode-cn.com/problems/maximum-product-subarray/solution/zui-da-zi-xu-lie-cheng-ji-jian-zhi-offerzhong-zui-/
     *
     * @param nums
     * @return
     */
    public int maxProduct_01(int[] nums) {
        //最大的子序列乘积
        int max = Integer.MIN_VALUE;
        //以当前元素结尾的，最大的，子序列乘积
        int iMax = 1;
        //以当前元素结尾的，最小的，子序列乘积
        int iMin = 1;

        for (int i : nums){
            if (i < 0){
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }

            iMax = Math.max(iMax* i, i);
            iMin = Math.min(iMin* i, i);
            max = Math.max(max, iMax);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] test = {2,-5,-2,-4,3};
        MaxProductSubarray_0152 max = new MaxProductSubarray_0152();
        System.out.println(max.maxProduct(test));
    }
}
