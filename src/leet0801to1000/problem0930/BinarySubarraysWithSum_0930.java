package leet0801to1000.problem0930;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * @author James
 * @date 2020-02-06 20:05
 **/
public class BinarySubarraysWithSum_0930 {


    public int numSubarraysWithSum(int[] arr, int tar) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        if (arr.length == 1 && arr[0] == tar) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int tempSum = arr[0];
        int ans = 0;
        while (true) {
            if (tempSum == tar) {
                ans++;
                if (right + 1 < len && arr[right + 1] == 0) {
                    ++right;
                } else if (left + 1 <= right) {
                    tempSum -= arr[left++];
                } else if (right + 1 < len) {
                    tempSum += arr[++right];
                }
            } else if (tempSum > tar) {
                tempSum -= arr[left++];
            } else if (tempSum < tar) {
                if (right + 1 < len) {
                    tempSum += arr[++right];
                } else {
                    break;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] a = {1,0,1,0,1};
        int[] a = {0,0,0,0,0};
        BinarySubarraysWithSum_0930 bb = new BinarySubarraysWithSum_0930();
        int res = bb.numSubarraysWithSum_1(a, 0);
        System.out.println(res);
    }

    public int numSubarraysWithSum_1(int[] arr, int tar) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        if (arr.length == 1 && arr[0] == tar) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int tempSum = arr[i];
            for (int j = i; j < len; j++) {
                if (i != j) {
                    tempSum += arr[j];
                    if (tempSum == tar) {
                        ans++;
                    }
                } else {
                    if (tempSum == tar) {
                        ans++;
                    }
                }

            }
        }
        return ans;
    }


    /**
     * 前缀和思想
     * @param arr array
     * @param target target
     * @return number of subarray  with sum.
     */
    public int numSubarraysWithSum_2(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        int ans = 0;
        int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int item : prefixSum) {
            // 这里可以优化  ans += countMap.getOrDefault(item - target, 0);
             if (countMap.containsKey(item - target)) {
                 ans += countMap.get(item - target);
             }
//            ans += countMap.getOrDefault(item - target, 0);
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);

        }
        return ans;
    }
}
