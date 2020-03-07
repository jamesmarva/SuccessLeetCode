package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 * @date 2019-11-17 10:35
 **/
public class ShiftGrid_5263 {


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return ans;
        }
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        int moveX = k  % columnSize;
        int moveY = k / columnSize;
        int[][] ansBackUp = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                int newRowIndex = (i + (j + k) / columnSize) % rowSize;
                int newColumnIndex = (j + moveX) % columnSize;
                ansBackUp[newRowIndex][newColumnIndex] = grid[i][j];
            }
        }
        for (int i = 0; i < rowSize; i++) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < columnSize; j++) {
                tempList.add(ansBackUp[i][j]);
            }
            ans.add(tempList);
        }
        return ans;
    }
}
