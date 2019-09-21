package leet0801to1000.problem0945;

import java.util.Arrays;

/**
 * @program: SuccessLeetCode
 * @description:https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * @author: James
 * @create: 2019-09-13 08:43
 **/
public class MinIncrementToMakeArrayUnique0945 {


    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        if (length == 0) {
            return 0;
        }
        int min = A[0];
        int result = 0;
        // 遍历的数组，并且注意j的值，j的值会在发现一个最小值的初始化为0。
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (A[i] < min + j) {
                result += (min + j) - A[i];
            } else {
                //当前值大于min+j的时候，说明发现了一个之后的数组的最小值。
                min = A[i];
                j = 0;
            }
        }
        return result;
    }
}
