package sward;

import java.util.Arrays;

/**
 * @author Brilliant James
 * @date 2020-03-27 23:12
 **/
public class Problem_066 {

    public int[] constructArr(int[] a) {
        int[] res = new int[0];
        if (a == null || a.length == 0) {
            return res;
        }
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
