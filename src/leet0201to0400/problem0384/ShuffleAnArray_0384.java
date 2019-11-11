package leet0201to0400.problem0384;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/shuffle-an-array/
 * @author James
 * @date 2019-11-10 17:45
 **/
public class ShuffleAnArray_0384 {

    private int[] originArray;

    private int[] changeArray;

    private Random random;

    /**
     * Fisher-Yates 洗牌算法
     * Fisher-Yates 洗牌算法跟暴力算法很像。在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。
     * 接下来，将当前元素和随机选出的下标所指的元素互相交换 - 这一步模拟了每次从 “帽子” 里面摸一个元素的过程，
     * 其中选取下标范围的依据在于每个被摸出的元素都不可能再被摸出来了。
     */
    public ShuffleAnArray_0384(int[] nums) {
        originArray = nums.clone();
        changeArray = nums.clone();
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = this.changeArray.length;
        for (int i = 0; i < len - 1; i++) {
            int randomIndex = getRandomInRange(i, len) + i;
            swap(this.changeArray, i, randomIndex);
        }
        return this.changeArray;
    }

    private int getRandomInRange(int start, int end) {
        return this.random.nextInt(end -start);
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Random random1 = new Random();
        int max = 0;
        int min = 0;

        for (int i = 0; i < 1000; ++i) {
           max = Math.max(max, random1.nextInt(100));
           min = Math.min(min, random1.nextInt(100));
        }
        System.out.println(max);
        System.out.println(min);
    }
}
