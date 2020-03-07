package sward;

/**
 * @author Brilliant James
 * @date 2020-03-06 11:03
 **/
public class Problem_057_I {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("nums is wrong.");
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (right > left) {
            int tempSum = nums[left] + nums[right];
            if (tempSum > target) {
                right--;
            } else if (tempSum < target) {
                left++;
            } else {
                int[] res = {nums[left], nums[right]};
                return res;
            }
        }
        throw new IllegalArgumentException();
    }
}
