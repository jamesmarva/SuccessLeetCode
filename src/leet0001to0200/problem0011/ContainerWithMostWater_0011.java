package leet0001to0200.problem0011;

/**
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author Brilliant James
 * @date 2020-04-18 00:59
 **/
public class
ContainerWithMostWater_0011 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
