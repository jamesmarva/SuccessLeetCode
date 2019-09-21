package leet0001to0200.problem0001;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author james reall008@163.com  11/16/2018
 */
public class MySolution {

    public int[] mySolutionTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = (i + 1); j < length; j++) {
                int temp = nums[i] + nums[j];
                if (temp == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }

            }
        }
        return result;
    }

    public int[] goodSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }



}
