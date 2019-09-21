package leet0201to0400.problem0315;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * 315. 计算右侧小于当前元素的个数
 *
 * @author: James
 * @create: 2019-09-03 00:00
 **/
public class CountOfSmallerNumAfter315 {


    private int ans = 0;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0, len = nums.length; i <= len - 2; ++i) {
            int count = 0;
            for (int j = i + 1; j <= len - 1; ++j) {
                if (nums[i] > nums[j] ) {
                    count++;
                }
            }
            ans.add(count);
        }
        return ans;
    }

    private void partition(int[] arr, int startIndex, int endIndex)  {


    }
}
