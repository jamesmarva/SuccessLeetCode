package leet0601to0800.problem0659;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * @date 2019-09-30 02:33
 **/
public class SplitArrayIntoConsecutiveSub0659 {

    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        HashMap<Integer, Integer> tails = new HashMap<>();
        for (int item : nums) {
            counter.put(item, counter.getOrDefault(item, 0) + 1);
        }
        for (int item : nums) {
            if (counter.get(item) <= 0) {
                continue;
            }
            // 如果有可以添加到已经存在的链的尾部，先添加到尾部。
            if (tails.getOrDefault(item, 0) > 0) {
                tails.put(item, tails.get(item) - 1);
                tails.put(item + 1, tails.getOrDefault(item + 1, 0) + 1);
//                如果没有可以添加到尾部的，那么就看看能不能组成一个链？
            } else if (counter.getOrDefault(item + 1, 0) > 0 && counter.getOrDefault(item + 2, 0) > 0) {
                counter.put(item + 1, counter.get(item + 1) - 1);
                counter.put(item + 2, counter.get(item + 2) - 1);
                tails.put(item + 3, tails.getOrDefault(item + 3, 0) + 1);
//                如果既不能成为尾部，也不能成为链，那就返回false
            } else {
                return false;
            }
            counter.put(item, counter.get(item) - 1);
        }
        return true;
    }
}
