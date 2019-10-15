package leet1001to1200.problem1200;

import java.util.*;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/minimum-absolute-difference/
 * @date 2019-10-14 02:07
 **/
public class MinAbsoluteDifference1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0, len = arr.length; i < len - 1; ++i) {
            if (min > Math.abs(arr[i] - arr[i + 1])) {
                min = Math.abs(arr[i] - arr[i + 1]);
                List<List<Integer>> temp = map.getOrDefault(min, new ArrayList<>());
                final int tempI = i;
                temp.add(new ArrayList<Integer>(){{
                    add(arr[tempI]);
                    add(arr[tempI + 1]);
                }});
                map.put(min, temp);
            }

        }
        return map.get(min);

    }
}
