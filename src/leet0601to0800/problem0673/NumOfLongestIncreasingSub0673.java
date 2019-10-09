package leet0601to0800.problem0673;

import java.util.Arrays;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * @date 2019-10-08 22:54
 **/
public class NumOfLongestIncreasingSub0673 {

    public  static  int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length, ans = 0, max = 1;
//        max length to tail I
        int[] maxLengthDP = new int[len];
        // have i to tail count
        int[] numOfTheTailIsI = new int[len];
        Arrays.fill(maxLengthDP, 1);
        Arrays.fill(numOfTheTailIsI, 1);
//        这里其实可以简化的
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (nums[j] > nums[i]) {
                    maxLengthDP[j] = maxLengthDP[i] + 1;
                    max = Math.max(max, maxLengthDP[j]);
                    if (maxLengthDP[j] > maxLengthDP[i] + 1) {
                        numOfTheTailIsI[j] = numOfTheTailIsI[i];
                    } else {
                        numOfTheTailIsI[j] += numOfTheTailIsI[i];
                    }
                }
            }
        }
        for (int i = 0; i < len; ++i) {
            if (max == maxLengthDP[i]) {
                ans += numOfTheTailIsI[i];
            }
        }

        return ans;
    }
    public static int findNumberOfLISMine(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length, ans = 0, max = 1;
        //        max length to tail I
        int[] maxLengthDP = new int[len];
        // have i to tail count
        int[] numOfTheTailIsI = new int[len];
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
//                j is max len
                if (nums[i] > nums[j] &&  maxLengthDP[j] + 1 > maxLengthDP[i]) {
                    maxLengthDP[i] = maxLengthDP[j] + 1;
                    numOfTheTailIsI[i] = numOfTheTailIsI[j];
//                    j = is second ma
                } else if (nums[i] > nums[j] && maxLengthDP[j] + 1 == maxLengthDP[i]) {
                    numOfTheTailIsI[i] += numOfTheTailIsI[j];
                }
            }
            max = Math.max(max, maxLengthDP[i]);
        }
        for (int i = 0; i < len;++i) {
            if (max == maxLengthDP[i]) {
                ans += numOfTheTailIsI[i];
            }
        }
        return ans;
    }

    public static int findNumberOfLISNew(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], count = new int[n];
        for(int i = 0; i < n; i++){
            len[i] = count[i] = 1;
            for(int j = 0; j < i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1) {
                        count[i] += count[j];
                    }
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (max_len == len[i]) {
                res += count[i];
            }
            if (max_len < len[i]){
                max_len = len[i];
                res = count[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,3,5,4,7,6};
        System.out.println(findNumberOfLIS(test) );
    }
}
