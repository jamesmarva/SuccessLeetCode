package leet0401to0600.problem0461;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/hamming-distance/
 * @author: James
 * @create: 2019-09-13 03:03
 **/
public class HammingDistance0461 {


    public int hammingDistance(int x, int y) {
        int[] first = new int[31];
        int[] second = new int[31];
        int result = 0;

        for (int i = x, firstIndex = 0; i >= 1; i = i / 2) {
            if (i % 2 == 0) {
                first[firstIndex] = 0;
                firstIndex++;
            } else {
                first[firstIndex] = 1;
                firstIndex++;
            }
        }

        for (int i = y, secondIndex = 0; i >= 1; i = i / 2) {
            if (i % 2 == 0) {
                second[secondIndex] = 0;
                secondIndex++;
            } else {
                second[secondIndex] = 1;
                secondIndex++;
            }
        }

        for (int i = 0; i < 31; i++) {
            if (first[i] != second[i]) {
                result++;
            }
        }
        return result;
    }

    public int good_hammingDistance(int x, int y) {
        return Integer.bitCount (x^y);
    }

    public int good1_hammingDistance(int x, int y) {
        int count = 0;
        x = x^y;
        for (int i = 0; i < Integer.toBinaryString(x).length(); i++) {
            if (Integer.toBinaryString(x).charAt(i)=='1') {
                count++;
            }
        }
        return count;
    }
}
