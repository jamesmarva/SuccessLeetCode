package leet0401to0600.problem0477;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/total-hamming-distance/
 * @author: James
 * @create: 2019-09-13 03:05
 **/
public class TotalHammingDistance0477 {

    /**
     * 一个普通的整型数字，长度为32，每个位置上的汉明距离是单独算的。
     * 0001 a
     * 0010 b
     * 0100 c
     * 1000 d
     * 每个位置上的汉明距离 就是 （0 的个数） * （1 的个数）
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for(int i = 0; i < 32; i++) {
            int distance = 0;
            for(int j = 0; j < nums.length; j++) {
                if((nums[j] & (1 << i - 1)) != 0) {
                    distance++;
                }
            }
            total += distance *(nums.length - distance);
        }
        return total;
    }
    public static int oneNums(int num) {
        int count = 0;
        while(num!=0){
            num = (num-1) & num;
            count++;
        }
        return count;
    }

    public int totalHammingDistance_01(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int oneNum = 0;
            int tmp = 1 << i;
            for (int item : nums) {
                if ((item & tmp) > 0) {
                    oneNum++;
                }
            }
            res += oneNum * (len - oneNum);
        }
        return res;
    }

}
