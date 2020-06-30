package sward;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Brilliant James
 * @date 2020-03-06 01:49
 **/
public class Problem_057_II {

    public static int[][] findContinuousSequence(int target) {
        if (target < 1) {
            throw new IllegalArgumentException("target is wrong");
        } else if (target == 1) {
            int[][] ans = {{1}};
            return ans;
        }
        ArrayList<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        int size = target / 2 + 1;
        int maxLen = 1;
        while (right <= size) {
            if (left == right) {
                if (left == target) {
                    int[] temp = {left};
                    res.add(temp);
                    maxLen = Math.max(1, maxLen);
                    break;
                }
                right ++;
            } else {
                int tempSum = (right - left + 1) * (right + left) / 2;
                int tempArrLen = right -left + 1;
                if (tempSum == target) {
                    int[] tempRes = new int[tempArrLen];
                    for (int i = left; i <= right; ++i) {
                        tempRes[i - left] = i;
                    }
                    res.add(tempRes);
                    maxLen = Math.max(maxLen, tempArrLen);
                    right++;
                } else if (tempSum > target) {
                    left++;
                } else if (tempSum < target) {
                    right++;
                }
            }
        }
        int len = res.size();
        int[][] ans = new int[len][maxLen];
        for (int i = 0; i < len; ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] testRes = findContinuousSequence(9);
        for (int[] item : testRes) {
            System.out.println(Arrays.toString(item));
        }

    }
}


