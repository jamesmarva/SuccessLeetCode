package leet0401to0600.problem0453;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 * @author: James
 * @create: 2019-09-08 10:35
 **/
public class MinMovesToEqualArrEle453 {


    public int minMoves(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        int len = nums.length;
        for (int item : nums) {
            sum += item;
            max = Math.max(max, item);
        }
        int finaNum = max;
        int ans = 1;
        while (len * finaNum != sum + (len -1) * ans) {
            if (len * finaNum > sum + (len -1) * ans) {
                ++ans;
            } else if (len * finaNum < sum + (len -1) * ans) {
                ++finaNum;
            }
        }
        return ans;
    }


    public int minMovesBest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int min = Integer.MIN_VALUE;
        for (int item : nums) {
            min = Math.min(min, item);
        }
        for(int item : nums) {
            ans += item - min;
        }
        return ans;
    }
}
