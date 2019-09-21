package leet0201to0400.problem0349;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @author: James
 * @create: 2019-09-13 03:06
 **/
public class IntersectionOfTwoArrays0349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        int lengthFirst = nums1.length;
        int lengthSecond = nums2.length;
        Set<Integer> firstSet = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();
        for (int i = 0; i < lengthFirst; i++) {
            firstSet.add(nums1[i]);
        }
        for (int i = 0; i < lengthSecond; i++) {
            if (firstSet.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] resultArray = new int[resultSet.size()];
        Iterator<Integer> iterable = resultSet.iterator();
        int index = 0;
        while(iterable.hasNext()) {
            resultArray[index] = iterable.next();
            index++;
        }
        return resultArray;
    }
}
