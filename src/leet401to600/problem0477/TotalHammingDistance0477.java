package leet401to600.problem0477;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/total-hamming-distance/
 * @author: James
 * @create: 2019-09-13 03:05
 **/
public class TotalHammingDistance0477 {

    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for(int i = 0; i < 32; i++) {
            int distance = 0;
            for(int j = 0; j < nums.length; j++) {
                if((nums[j] & (1 << i - 1)) != 0)
                    distance++;
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
}
