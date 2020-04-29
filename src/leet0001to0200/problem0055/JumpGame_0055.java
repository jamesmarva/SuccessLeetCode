package leet0001to0200.problem0055;

/**
 * @author Brilliant James
 * @date 2020-04-17 01:52
 **/
public class JumpGame_0055 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (max < i) {
                return false;
            }
            if (max >= len - 1) {
                return true;
            }
            max = Math.max(max, i + nums[i]);
        }
        return max >= len - 1;
    }

    public static void main(String[] args) {
        
    }
}
