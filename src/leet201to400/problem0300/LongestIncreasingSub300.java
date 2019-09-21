package leet201to400.problem0300;

import java.util.Arrays;

/**
 * @program: myleetcode
 * @description: https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author: James
 * @create: 2019-05-18 21:32
 **/
public class LongestIncreasingSub300 {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int res = 1;
		int[] dp = new int[len + 1];
		for (int i = 1; i < len; ++i) {
			dp[i] = 1;
		}
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}



	public int lengthOfLISBetter(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int res = 1;
		int[] dp = new int[len + 1];
		dp[0] = 1;
		for (int i = 0; i < len; ++i) {
			int maxval = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			dp[i] = maxval + 1;
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	/**
	 * 主要的思想就是重新构造一个新的排序好的，从小到大的子序列的数组。
	 *
	 * @param nums
	 * @return
	 */
	public int lengthOfLISBest(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int res = 0;
		int[] alreadySortArray = new int[len + 1];

		for (int item : nums) {
			int insertCursor = Arrays.binarySearch(alreadySortArray, 0, res, item);
			if (insertCursor < 0) {
				insertCursor = -(insertCursor + 1);
			}
			alreadySortArray[insertCursor] = item;
			if (insertCursor == res) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test = {1, 2};
		int cursor = Arrays.binarySearch(test, 0, 2, 0);
		if (cursor < 0) {
			cursor = -(cursor + 1);
		}
		System.out.println(cursor);
	}
}
