package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Brilliant James
 * @date 2020-03-15 20:39
 **/
public class LuckyNumInAMatrix_5356 {


    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        HashMap<Integer, ColumnAndValue> minInRowMap = new HashMap<>();
        HashMap<Integer, Integer> maxInColMap = new HashMap<>();
        for (int i = 0; i < rowLen; ++i) {
            int value = matrix[i][0];
            int index = 0;
            for (int j = 0; j < colLen; ++j) {
                if (value > matrix[i][j]) {
                    value = matrix[i][j];
                    index = j;
                }
            }
            ColumnAndValue temp = new ColumnAndValue(value, index);
            minInRowMap.put(i, temp);
        }

        for (int i = 0; i < colLen; ++i){
            int value = matrix[0][i];

            for (int j = 0; j < rowLen; ++j) {
                value = Math.max(value, matrix[j][i]);
            }
            maxInColMap.put(i, value);
        }
        for (int item : minInRowMap.keySet()) {
            ColumnAndValue columnAndValue = minInRowMap.get(item);
            if (maxInColMap.get(columnAndValue.column) == columnAndValue.value) {
                list.add(columnAndValue.value);
            }
        }
        return list;
    }

    private class ColumnAndValue {
        int column;
        int value;
        ColumnAndValue(int col, int val) {
            this.column = col;
            this.value = val;
        }
    }
}
