package leet0201to0400.problem0300;

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

	/**
	 * 最简单的方法
	 *
	 */
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
	 * 主要的思想就是重新构造一个新的排序好的，从小到大的最长的子序列的数组。
	 * @param  nums 测试参数
	 * @return 最长的数组
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

	public int lengthOfLIS_1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] dp = new int[len];
		Arrays.fill(dp, 1);
		int ans = 1;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j <= i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

	public int  lengthOfLIS_2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] alreadySortArray = new int[len + 1];
		alreadySortArray[0] = nums[0];
		int ans = 0;
		for (int i = 1; i < len; i++) {
			int insertPosition = binaryFind_2(alreadySortArray, 0, ans, nums[i]);
			alreadySortArray[insertPosition] = nums[i];
			if (insertPosition == ans + 1) {
				ans++;
			}
		}
		return ans + 1;
	}

	private int binaryFind(int[] arr, int target) {
		int mid = 0;
		int low = 0;
		int high = arr.length;
		while (low < high) {
			mid = low + ((high - low) >> 1);
			if (arr[mid] < target) {
				low = mid;
			} else if (arr[mid] > target) {
				high = mid;
			} else if (arr[mid] == target) {
				return mid;
			}
		}
		return mid;
	}

	private static int binaryFind_1(int[] arr, int target) {
		int mid = 0;
		int low = 0;
		int high = arr.length;
		while (low < high) {
			mid = low + ((high - low) >> 1);
			if (arr[mid] < target) {
				low = mid + 1;
			} else if (arr[mid] > target) {
				high = mid;
			} else if (arr[mid] == target) {
				return mid;
			}
		}
		return low;
	}

	private static int binaryFind_2(int[] arr, int low, int high, int target) {
		if (target > arr[high]) {
			return high + 1;
		}
		int mid = 0;
		while (low < high) {
			mid = low + ((high - low) >> 1);
			if (arr[mid] < target) {
				low = mid + 1;
			} else if (arr[mid] > target) {
				high = mid;
			} else if (arr[mid] == target) {
				return mid;
			}
		}
		return high;
	}


	public static void main(String[] args) {
//		int[] test = {1, 3, 5, 7, 9};
//		int cursor = Arrays.binarySearch(test, 0, 6, 0);
//		int cursor1 = Arrays.binarySearch(test, 0, 6, 11);
//		int cursor2 = Arrays.binarySearch(test, 0, 6, 6);
//		System.out.println(cursor);
//		System.out.println(cursor1);
//		System.out.println(cursor2);
//		if (cursor < 0) {
//			cursor = -(cursor + 1);
//		}
//		System.out.println(cursor);

		int[] test = {1, 3, 5, 7, 9, 11, 13};
		int[] test1 = {10,9,2,5,3,7,101,18};
////		int position = binaryFind_1(test, 15);
//		int position = binaryFind_2(test, 0, 0, 15);
//		System.out.println(position);
//		int position1 = Arrays.binarySearch(test, 0, 1, -11);
//
//		System.out.println(position1);

		LongestIncreasingSub300 longestIncreasingSub300 = new LongestIncreasingSub300 ();
		longestIncreasingSub300.lengthOfLIS_2(test1);
	}
}
