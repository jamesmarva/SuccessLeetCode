package leet801to1000.problem0941;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/valid-mountain-array/
 * @author: James
 * @create: 2019-09-09 07:34
 **/
public class ValidMountainArray941 {

    public boolean validMountainArray(int[] A) {
        int length = A.length;
        if (length <= 2) {
            return false;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            if (A[i] >= max) {
                max = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex == 0 || maxIndex == length - 1) {
            return false;
        }
        for (int i = 0; i < maxIndex; i++) {
            if (A[i] >= A[i + 1]) {
                return false;
            }
        }

        for (int i = maxIndex; i < length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
