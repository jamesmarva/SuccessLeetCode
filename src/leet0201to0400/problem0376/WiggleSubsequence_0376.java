package leet0201to0400.problem0376;

import java.util.Map;

/**
 * @author James
 * @date 2019-11-10 18:29
 **/
public class WiggleSubsequence_0376 {


    /**
     * dynamic
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int len = nums.length;
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            int tempUpValue = 0;
            int tempDownValue = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tempUpValue = Math.max(tempUpValue, down[j] + 1);
                }
                if (nums[i] < nums[j]) {
                    tempDownValue = Math.max(tempDownValue, up[j] + 1);
                }
                if (nums[i] == nums[j]) {
                    tempDownValue = Math.max(tempDownValue, down[j]);
                    tempUpValue = Math.max(tempUpValue, up[j]);
                }
            }
            up[i] = tempUpValue;
            down[i] = tempDownValue;
        }
        return Math.max(up[len - 1], down[len - 1]);
    }
}
