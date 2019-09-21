package leet0001to0200.problem0118;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/pascals-triangle/
 * @author: James
 * @create: 2019-09-15 13:56
 **/
public class PascalTriangle0118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> tempList = new ArrayList<>();
            if (i == 0) {
                tempList.add(1);
                returnList.add(tempList);
                continue;
            }
            if (i == 1) {
                tempList.add(1);
                tempList.add(1);
                returnList.add(tempList);
                continue;
            }

            for (int j = 0; j < i + 1; j++) {
                if ((j-1 < 0) || (j == i)) {
                    tempList.add(1);
                    continue;
                }
                int first = returnList.get(i - 1).get(j - 1);
                int second = returnList.get(i - 1).get(j);
                tempList.add(first + second);
            }
            returnList.add(tempList);
        }
        return returnList;
    }
}
