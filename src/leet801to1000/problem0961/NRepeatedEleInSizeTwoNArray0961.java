package leet801to1000.problem0961;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
 * @author: James
 * @create: 2019-09-13 08:40
 **/
public class NRepeatedEleInSizeTwoNArray0961 {

    public int repeatedNTimes(int[] A) {
        int length = A.length;
        int[] result = new int[A.length / 2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;

        for (int i = 0; i < length/2; i++) {
            int begin = A[i];
            int end = A[length-1 - i];
            if (map.containsKey(begin)) {
                int nowBegin = map.get(begin);
                nowBegin ++;
                map.put(begin, nowBegin);
                result[nowBegin] = begin;
            }else {
                map.put(begin, 0);
            }
            if (map.containsKey(end)) {
                int nowEnd = map.get(end);
                nowEnd ++;
                map.put(end, nowEnd);
                result[nowEnd] = end;
            }else {
                map.put(end, 0);
            }
        }
        return result[length / 2 -1];
    }
}
