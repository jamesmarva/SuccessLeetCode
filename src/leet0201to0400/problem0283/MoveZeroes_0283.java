package leet0201to0400.problem0283;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 283. Move Zeroes
 * 283. 移动零
 * @author James
 * @date 2019-12-03 19:57
 **/
public class MoveZeroes_0283 {

    /**
     * 双指针的思想,但是代码不够简单
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int zeroIndex = 0;
        boolean hasZero = false;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!hasZero) {
                if (nums[zeroIndex] == nums[i] && nums[i] != 0) {
                    zeroIndex ++;
                } else if (nums[zeroIndex] == nums[i] && nums[i] == 0) {
                    hasZero = true;
                }

            } else {
                if (nums[i] != 0) {
                    nums[zeroIndex] = nums[i];
                    zeroIndex++;
                }
            }
        }

        for (int i = zeroIndex + 1; i < len; ++i) {
            nums[i] = 0;
        }
    }

    /**
     *
     * @param nums
     */
    public void moveZeroes_1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int zeroIndex = 0;
        int len  = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] != 0){
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }
        }
        for (int i = zeroIndex + 1; i < len; ++i) {
            nums[i] = 0;
        }
    }
}
