package leet0001to0200.problem0128;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 128. 最长连续序列
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-06-06 16:35
 **/
public class LongestConsecutiveSequence_0128 {

    Map<Integer, Integer> father = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 1;
        Map<Integer, Integer> tempFatherMap = father;
        for (int item : nums) {
            set.add(item);
            tempFatherMap.put(item, item);
            rank.put(item, 1);
        }
        for (int item : set) {
            Integer fatherNode = tempFatherMap.get(item - 1);
            if (fatherNode == null) {
                continue;
            }
            union(fatherNode, item);
        }
        for (int item : rank.values()) {
            ans = Math.max(ans, item);
        }
        return ans;
    }

    private int find(int target) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> tempFather = father;
        Integer fatherNode = tempFather.get(target);
        while (fatherNode != target) {
            stack.push(fatherNode);
            target = fatherNode;
            fatherNode = tempFather.get(target);
        }
        while (stack.size() > 0){
            Integer temp = stack.pop();
            tempFather.put(temp, target);
        }
        return target;
    }

    private void union(Integer fatherNode, Integer sonNode) {
        Integer a = find(fatherNode);
        Integer b = find(sonNode);
        father.put(b, a);
        rank.put(a, rank.get(a) + rank.get(b));
    }

    public  static  void binaryInsertingSort(int[] arr) {
        for (int i = 1, len = arr.length; i < len; i++) {
            int pivotValue = arr[i];
            int lo = 0, hi = i, mid = 0;
            while (lo < hi) {
                mid = lo + ((hi - lo) >>> 1) ;
                if (arr[mid] > pivotValue) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            // now right=left AND nums[left] is more than pivotValue.
            int dis = i - lo;
            System.arraycopy(arr, lo, arr, lo + 1, dis);
            arr[lo] = pivotValue;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 16};
//        int target = 4;
//        int lo = 0, hi = arr.length, mid = 0;
//
//        while (lo < hi) {
//            mid = (lo + (hi - lo) >> 1);
//            if (arr[mid] > target) {
//                hi = mid;
//            } else {
//                lo = mid + 1;
//            }
//        }
//        System.out.println("lo :" + lo);
//        System.out.println("hi :" + hi);
//        System.out.println("arr[lo]: " + arr[lo]);
//
//        lo = 0;
//        hi = arr.length;
//        mid = 0;
//
//        while (lo < hi) {
//            mid = (lo + (hi - lo) >> 1);
//            if (arr[mid] < target) {
//                lo = mid + 1;
//            } else {
//                hi = mid;
//            }
//        }
//        System.out.println("lo :" + lo);
//        System.out.println("hi :" + hi);
//        System.out.println("arr[lo]: " + arr[lo]);
//        int[] tt = {11, 2112, 123, 4, 2143, 15, 457, 548, 54, 8657, 8678, 96, 9};
//        binaryInsertingSort(tt);
//        System.out.println(Arrays.toString(tt));


//        [100, 4, 200, 1, 3, 2]
//        int[]  t1 = {100, 4, 200, 1, 3, 2};
        int[] t1 = {0,0,-1};
        LongestConsecutiveSequence_0128 ll = new LongestConsecutiveSequence_0128();
        ll.longestConsecutive(t1);

    }
}
