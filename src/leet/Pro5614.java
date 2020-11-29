package leet;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.11.29 10:34
 */
public class Pro5614 {

    public int[] mostCompetitive(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int l = nums.length;
        if (k > l) {
            return nums;
        }
        int[] result = new int[k];

        int smallerIndex = -1;
        boolean first = true;
        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
            if (i != 0 && first && result[i] < result[i - 1]) {
                smallerIndex = i;
                first = false;
            }
        }
        for (int i = k; i < l; i++) {
            if (smallerIndex != -1) {
//                for (int j = smallerIndex; j < k; j++) {
//                    result[j - 1] = result[j];
//                }
                System.arraycopy(result, smallerIndex, result, smallerIndex - 1, k - smallerIndex);
                result[k - 1] = nums[i];
                smallerIndex = findFirstIndex(result, k);
            } else {
                if (nums[i] < result[k - 1]) {
                    result[k - 1] = nums[i];
                    smallerIndex = findFirstIndex(result, k);
                }
            }
        }
        return result;
    }

    private int findFirstIndex(int[] res, int k) {
        for (int i = 0; i < k; i++) {
            if (i != 0 && res[i] < res[i - 1]) {
                return i;
            }
        }
        return -1;
    }
//[3,5,2,6]
//        2
    public static void main(String[] args) {
//        int[] n = {2,4,3,3,5,4,9,6};
        Pro5614 p = new Pro5614();
//        int[] n = {3,5,2,6};
        int[] n = {71,18,52,29,8,80,2};
        int[] r = p.mostCompetitive(n, 3);
        System.out.println(Arrays.toString(r));
    }



}
