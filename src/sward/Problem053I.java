package sward;

/**
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * @author 王涵威
 * @date 20.10.26 9:22
 */
public class Problem053I {

    public int search(int[] nums, int target) {
        int l = findFirstIndex(nums, target);
        int r = findLastIndex(nums, target);
        if (l == -1 || r == -1) {
            return 0;
        }
        return r - l + 1;
    }

    private int findFirstIndex(int[] num, int target) {
        int len = num.length, l = 0, r = len - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (target == num[mid]) {
                if (mid == 0 || num[mid - 1] < target) {
                    return mid;
                } else if (num[mid - 1] == target) {
                    r = mid - 1;
                }
            } else if (num[mid] < target) {
                l = mid + 1;
            } else if (num[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    private int findLastIndex(int[] num, int target) {
        int len = num.length, l = 0, r = len - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (target == num[mid]) {
                if (mid == len - 1 || target < num[mid + 1]) {
                    return mid;
                } else if (num[mid + 1] == target) {
                    l = mid + 1;
                }
            } else if (num[mid] < target) {
                l = mid + 1;
            } else if (num[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] t = {5,7,7,8,8,10};
        int[] t = {2, 2};

        int tar = 2;
        Problem053I p = new Problem053I();
        System.out.println(p.search(t, tar));

    }

}
