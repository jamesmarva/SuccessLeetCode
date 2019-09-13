package leet1to200.problem0078;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/subsets/
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author: James
 * @create: 2019-09-10 05:33
 **/
public class Subsets0078 {


    /**
     * 错的方法。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsBetter2(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums == null || nums.length ==0) {
            return result;
        }
        result.add(new ArrayList<>());
        for (int i = 0, len = nums.length; i < len; ++i) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j < len; ++j) {
                temp.add(j);
                result.add((List<Integer>) temp.clone());
            }
        }
        return result;

    }

    public List<List<Integer>> subsets(int[] nums) {
        Queue<LinkedList<Integer>> queue = new LinkedList<LinkedList<Integer>>();//待搜索队列
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int length  = nums.length;
        for (int i = 0; i < length; i++) {
            LinkedList<Integer> tempList = new LinkedList<Integer>();
            tempList.add(i);
            queue.add(tempList);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = queue.poll();
            List<Integer> resultTemp = returnList(temp, nums);
            result.add(resultTemp);
            int lastIndex = temp.getLast();
            for (int i = lastIndex + 1; i < length; i ++) {
                LinkedList<Integer> insertTemp = (LinkedList<Integer>) temp.clone();
                insertTemp.addLast(i);
                queue.add(insertTemp);
            }
        }
        result.add(new LinkedList<Integer>());
        return result;
    }

    public List<List<Integer>> subsetsBetter(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res,
                       ArrayList<Integer> temp, int index) {
        if (index == nums.length) {
            res.add(new ArrayList(temp));
        } else {
            temp.add(nums[index]);
            helper(nums, res, temp, index + 1);
            temp.remove(temp.size() - 1);
            helper(nums, res, temp, index + 1);
        }
    }
    public static List<Integer> returnList(List<Integer> args, int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int item : args){
            result.add(nums[item]);
        }
        return result;
    }
}
