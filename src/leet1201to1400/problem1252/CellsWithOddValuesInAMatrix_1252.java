package leet1201to1400.problem1252;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 * @date 2019-11-11 12:31
 **/
public class CellsWithOddValuesInAMatrix_1252 {


    public int oddCells(int n, int m, int[][] indices) {
        if (n == 0 || m == 0 || indices == null || indices.length == 0) {
            return 0;
        }
        Map<Integer, Integer> rowMap  = new HashMap<>();
        Map<Integer, Integer> columnMap = new HashMap<>();
        for (int i = 0, len = indices.length; i < len; i++) {
            int row = indices[i][0];
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
            int column = indices[i][1];
            columnMap.put(column, columnMap.getOrDefault(column, 0) + 1);
        }
        int[][] origin = new int[n][m];
        for (Integer key : rowMap.keySet()) {
            for (int i = 0; i < m; ++i) {
                origin[key][i] += rowMap.get(key);
            }
        }

        for (Integer key : columnMap.keySet()) {
            for (int i = 0; i < n; ++i) {
                origin[i][key] += columnMap.get(key);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                if (origin[i][j] % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
