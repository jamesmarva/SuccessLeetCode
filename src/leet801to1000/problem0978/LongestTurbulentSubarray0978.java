package leet801to1000.problem0978;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * @author: James
 * @create: 2019-09-13 08:20
 **/
public class LongestTurbulentSubarray0978 {

    /**
     * 这个能跑倒是能跑，不过效果奇差
     * @param A
     * @return
     */
    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        boolean beforeBigger = true;
        int max = 2;
        if (len == 1) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            int tempMax = 1;
            for ( int j = i; j < len - 1; j++) {
                if (j == i) {
                    if (A[j] > A[j + 1]) {
                        tempMax ++;
                        beforeBigger = true;
                    } else if (A[j] < A[j + 1]) {
                        tempMax ++;
                        beforeBigger = false;
                    } else {
                        break;
                    }
                } else {
                    if (beforeBigger) {
                        if (A[j] < A[j + 1]) {
                            tempMax ++;
                            beforeBigger = false;
                        } else {
                            break;
                        }
                    } else {
                        if (A[j] > A[j + 1]) {
                            tempMax ++;
                            beforeBigger = true;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }
}
