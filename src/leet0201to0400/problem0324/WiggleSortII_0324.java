package leet0201to0400.problem0324;

import java.util.Arrays;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/wiggle-sort-ii/
 * 荷兰国旗的问题
 * @date 2019-11-10 11:24
 **/
public class WiggleSortII_0324 {


    public void wiggleSort(int[] nums) {
        int[] numsBackUp = nums.clone();
        Arrays.sort(numsBackUp);
        int len = nums.length;
        int begin = 0;
        if (len % 2 == 0) {
            begin = len / 2;
        } else {
            begin = len / 2 + 1;
        }
        int right = len - 1;
        boolean isLeft = true;
        for (int i = 0; i < len; i++) {
            if (isLeft) {
                nums[i] = numsBackUp[right - begin];
                isLeft = false;
            } else {
                nums[i] = numsBackUp[right];
                right--;
                isLeft = true;
            }
        }
    }


}
