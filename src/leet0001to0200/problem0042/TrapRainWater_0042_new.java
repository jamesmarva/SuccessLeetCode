package leet0001to0200.problem0042;

/**
 * @author Brilliant James
 * @date 2020-04-05 02:34
 **/
public class TrapRainWater_0042_new {

    public int trap2(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return 0;
        }
        int len = arr.length;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if (arr[l] < arr[r]) {
                if (arr[l] >= leftMax) {
                    leftMax = arr[l];
                } else {
                    ans += (leftMax - arr[l]);
                }
                l++;
            } else {
                if (arr[r] >= rightMax) {
                    rightMax = arr[r];
                } else {
                    ans += rightMax - arr[r];
                }
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] t = {5, 0, 4, 3};
        TrapRainWater_0042_new tt = new TrapRainWater_0042_new();
        System.out.println(tt.trap2(t));
    }
}
