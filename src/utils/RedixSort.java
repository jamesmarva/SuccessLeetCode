package utils;

import java.util.Arrays;

/**
 * @program: SuccessLeetCode
 * @description:
 * @author: James
 * @create: 2019-09-08 09:16
 **/
public class RedixSort {

    public void usage() {
        int[] test = {5, 6, 7, 1, 2, 3, 9, 4, 5, 8, 1, 2, 3};
        int max = test[0];
        for (int item : test) {
            max = Math.max(max, item);
        }
        radixSort(test, 10, (max+"").length());

    }
    public static void radixSort(int[] array, int radix, int d) {
        int len = array.length;
        int[] tempArray = new int[len];
        // count用于记录待排序元素的信息,用来表示该位是i的数的个数
        int[] count = new int[radix];

        int rate = 1;
        for (int i = 0; i < d; ++i) {
            //重置count数组，开始统计下一个关键字
            Arrays.fill(count, 0);
            System.arraycopy(array, 0, tempArray, 0, len);
            // 寻找每个位置上的数字的数量
            for (int item : tempArray) {
                int subKey = (item / rate) % radix;
                count[subKey] ++;
            }
            for (int j = 1; j < radix; ++j) {
                count[j] = count[j] + count[j - 1];
            }
            for (int m = len - 1; m >= 0; --m) {
                int subKey = (tempArray[m] / rate) % radix;
                array[-- count[subKey]] = tempArray[m];
            }
            rate *= radix;
        }
    }


    public static void radixSortNew(Integer []array, int radix, int d){
        // 临时数组
        Integer[] tempArray = new Integer[array.length];
        // count用于记录待排序元素的信息,用来表示该位是i的数的个数
        Integer[] count = new Integer[radix];

        int rate = 1;
        for (int i = 0; i < d; i++) {
            //重置count数组，开始统计下一个关键字
            Arrays.fill(count, 0);
            //将array中的元素完全复制到tempArray数组中
            System.arraycopy(array, 0, tempArray, 0, array.length);

            //计算每个待排序数据的子关键字
            for (int j = 0; j < array.length; j++) {
                int subKey = (tempArray[j] / rate) % radix;
                count[subKey]++;
            }
            //统计count数组的前j位（包含j）共有多少个数
            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }
            //按子关键字对指定的数据进行排序 ，因为开始是从前往后放，现在从后忘前读取，保证基数排序的稳定性
            for (int m = array.length - 1; m >= 0; m--) {
                int subKey = (tempArray[m] / rate) % radix;
                array[--count[subKey]] = tempArray[m]; //插入到第--count[subKey]位，因为数组下标从0开始
            }
            rate *= radix;//前进一位
            System.out.print("第" + (i+1) + "次：");
        }
    }

    public static void main(String[] args) {
        int[] test = {5, 6, 7, 1, 2, 3, 9, 4, 5, 8, 1, 2, 3};
        radixSort(test, 10, 1);
        System.out.println(Arrays.toString(test));
    }
}
