package leet1001to1200.problem1072;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 *
 * @author Brilliant James
 * @date 2020-03-12 13:53
 **/
public class FlipColumnsForMaxNumOfEqualRows_1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        boolean firstZero = false;
        for (int i = 0, len = matrix.length; i < len; i++) {
            if (matrix[i][0] == 0) {
                firstZero = true;
            } else {
                firstZero = false;
            }
            StringBuilder temp = new StringBuilder();
            for (int j = 0, colLen = matrix[i].length; j < colLen; j++) {
                if (firstZero) {
                    temp.append(matrix[i][j]);
                } else {
                    temp.append(matrix[i][j] ^ 1);
                }
            }
            String tempStr = temp.toString();
            map.put(tempStr, map.getOrDefault(tempStr, 0) + 1);
        }
        int res = 0;
        for (String item : map.keySet()) {
            res = Math.max(res, map.get(item));
        }
        return res;
    }


    void swap(int a,int b){
        a=a^b;
        b=b^a;
        a=a^b;
    }

    public static void main(String[] args) {
        int[][] test = {{0,1},{1,0}};
//        FlipColumnsForMaxNumOfEqualRows_1072 ff = new FlipColumnsForMaxNumOfEqualRows_1072();
//        ff.maxEqualRowsAfterFlips(test);
        int a = 11;
        int b = 14;
        int c = a ^ b;
        System.out.println(c);
        System.out.println(a ^ c);
        System.out.println(b ^ c);
    }
}
