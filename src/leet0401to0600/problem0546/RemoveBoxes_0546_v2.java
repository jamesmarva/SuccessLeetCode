package leet0401to0600.problem0546;

/**
 * https://leetcode-cn.com/problems/remove-boxes/
 * 1,3,2,2,2,3,4,3,1
 *
 * 这是个消消乐的游戏
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-19 02:14
 **/
public class RemoveBoxes_0546_v2 {

    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int[][][] dp = new int[len][len][len];
        return cal(boxes, dp, 0, len - 1, 0);
    }

    private int cal(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        //
        dp[l][r][k] = cal(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                int tmp = cal(boxes, dp, l, i, k + 1)  + cal(boxes, dp, i + 1, r - 1, 0);
                dp[l][r][k] = Math.max(dp[l][r][k], tmp);
            }
        }
        return dp[l][r][k];
    }
}
