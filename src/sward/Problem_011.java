package sward;

/**
 *
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 面试题11. 旋转数组的最小数字
 *
 * @author Brilliant James
 * @date 2020-03-22 13:36
 **/
public class Problem_011 {
    /**
     *
     * @param num
     * @return
     */
    public int minArray(int[] num) {
        int left = 0;
        int len  = num.length;
        int right = num.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (mid + 1 < len && num[mid] > num[mid + 1]) {
                return num[mid + 1];
            } else if (num[mid] > num[right]) {
                left = mid + 1;
            } else if (num[mid] < num[left]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int minArray_01(int[] num) {
        return 0;
    }

}
