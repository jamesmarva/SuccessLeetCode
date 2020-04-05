package leet0001to0200.problem0042;

/**
 * @author Brilliant James
 * @date 2020-04-04 21:16
 **/
public class TrappingRainWater_0042 {

    public int trap0(int[] height) {
        int len = height.length;
        int ans = 0;
        for (int i = 1; i <= len - 2; i++) {
            int tempLeft = height[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                tempLeft = Math.max(tempLeft, height[j]);
            }
            int tempRight = height[i + 1];
            for (int j = i + 1; j < len; j++) {
                tempRight = Math.max(tempRight, height[j]);
            }
            int temp = Math.min(tempRight, tempLeft);
            if (temp > height[i]) {
                ans += temp - height[i];
            }
        }
        return ans;
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int ans = 0;
        for (int i = 1; i <= len - 2; i++) {
            int temp = Math.min(leftMax[i - 1], rightMax[i + 1]);
            if (temp > height[i]) {
                ans += temp - height[i];
            }
        }
        return ans;
    }


    /**
     * 这里的代码是错的，原因就在于，不能根据当前的两端的最小值进行更新值，
     *
     *
     * @param arr
     * @return
     */
    public int trap2_wrong(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return 0;
        }
        int len = arr.length;
        int ans = 0;
        int leftMax = arr[0];
        int rightMax = arr[len - 1];
        int l = 1;
        int r = len - 2;
        while (l <= r) {
            int temp = Math.min(leftMax, rightMax);
            if (arr[l] < arr[r]) {
                if (temp > arr[l]) {
                    ans += temp - arr[l];
                }
                leftMax = Math.max(arr[l], leftMax);
                l++;
            } else {
                if (temp > arr[r]) {
                    ans += temp - arr[r];
                }
                rightMax = Math.max(arr[r], rightMax);
                r--;
            }
        }
        return ans;
    }

    /**
     * 最优解
     * @param height
     * @return
     */
    public int trap_best(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int res = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 1;
        int right = height.length - 2;
        while (left <= right) {
            // 注意，这里需要注意的是，你要注意的是， 要比较两个
            // 左右值的大小，取小值来进行运算
            if (leftMax <= rightMax) {
                res  += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(leftMax, height[left]);
                left++;
                //
            } else {
                res += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] t = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater_0042 tt = new TrappingRainWater_0042();
        System.out.println(tt.trap2_wrong(t));
    }
}
