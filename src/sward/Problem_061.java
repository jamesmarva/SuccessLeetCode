package sward;

import java.util.Arrays;

/**
 * @author Brilliant James
 * @date 2020-03-31 02:09
 **/
public class Problem_061 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        int lastIndex = -1;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                lastIndex = i;
            }
        }
        if (zeroCount >= 4) {
            return true;
        }
        int dis = 0;
        for (int i = lastIndex + 1; i <= 5 - 2; i++) {
            int temp =  nums[i + 1] - nums[i] - 1;
            if (temp < 0) {
                return false;
            }
            dis += nums[i + 1] - nums[i] - 1;
        }
        if (zeroCount - dis >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
