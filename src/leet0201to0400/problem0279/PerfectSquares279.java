package leet0201to0400.problem0279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 * @author James
 * @date 2019/5/3
 *
 */
public class PerfectSquares279 {

    public int numSquares(int n) {
        ArrayList<Integer> list= new ArrayList<>();
        for (int i = 1; i * i < n; i++) {
            list.add(i * i);
        }
        Queue<Integer> queue = new LinkedList(Arrays.asList(n));
        int lenList = list.size();
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while (size > 0) {
                int temp = queue.poll();
                for (int i = lenList - 1; i >= 0; i--) {
                    int tempRes = temp - list.get(i);
                    if (tempRes == 0) {
                        return res;
                    } else if (tempRes > 0) {
                        queue.offer(temp - list.get(i));
                    }
                }
                size--;
            }
        }
        return res;
    }

    /**
     * 动态规划思想解决
     * @param n
     * @return
     */
    public int numSquaresBetter(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i * i < n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j * j < i; ++j) {
                minVal = Math.min(minVal, dp[i - j * j]);
            }
            dp[i] = ++minVal;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        PerfectSquares279 perfectSquares279= new PerfectSquares279();
        perfectSquares279.numSquares(12);
    }
}
