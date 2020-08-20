package leet0001to0200.problem0042;




/**
 * @author Brilliant James
 * @date 2020-04-18 01:11
 **/
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int len = height.length;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int l = 1;
        int r = len - 2;
        int ans = 0;
        while (l <= r ) {
            if (leftMax > rightMax) {
                ans += Math.max(rightMax - height[r] , 0);
                if (height[r] > rightMax) {
                    rightMax = height[r];
                }
                r--;
            } else {
                ans += Math.max(leftMax - height[l], 0);
                if (height[l] > leftMax) {
                    leftMax = height[l];
                }
                l++;
            }
        }
        return ans;
    }


    /**
     * 错的。。。。
     * @param height
     * @return
     */
    public int trapWrong00(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int len = height.length;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int l = 1;
        int r = len - 2;
        int ans = 0;
        while (l <= r ) {
            if (height[l] > height[r]) {
                if (height[r] < rightMax) {
                    ans += Math.min(Math.max(height[l], leftMax), rightMax) - height[r];    
                } else {
                    rightMax = height[r];
                }
                r--;
            } else {
                if (height[l] < leftMax) {
                    ans += Math.min(Math.max(height[r], rightMax), leftMax) - height[l];
                } else {
                    leftMax = height[l];
                }
                l++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] t = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater tt = new TrappingRainWater();
        int r  = tt.trap(t);
        System.out.println(r);
    }
}
