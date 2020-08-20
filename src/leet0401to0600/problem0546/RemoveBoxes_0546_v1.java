package leet0401to0600.problem0546;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-19 00:01
 **/
public class RemoveBoxes_0546_v1 {

    private Map<String, Integer> memory = new HashMap<>();

    public int removeBoxes(int[] boxes) {
        return dfs(boxes, 0);
    }

    private int dfs(int[] boxes, int tmpRes) {
        int len = boxes.length;
        if (len == 0) {
            return 0;
        }
        String boxesString = Arrays.toString(boxes);
        Integer val = memory.get(boxesString);
        if (val != null) {
            return val;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            int start = i;
            while (i < len - 1 && boxes[i] == boxes[i + 1]) {
                i++;
            }
            int end = i;
            int k = (end - start  + 1);
            int[] tmpBoxes = new int[len - k];
            for (int j = 0; j < start; j++) {
                tmpBoxes[j] = boxes[j];
            }
            for (int j = 0; j < len - 1 - end; j++) {
                tmpBoxes[start + j] = boxes[end + 1 + j];
            }
            int tmpDfsVal = dfs(tmpBoxes, tmpRes) + k * k;
            if (res < tmpDfsVal) {
                res = tmpDfsVal;
            }
        }
        memory.put(boxesString, res);
        return res;
    }

    public static void main(String[] args) {
        int[] t = {1,3,2,2,2,3,4,3,1};
        RemoveBoxes_0546_v1 v1 = new RemoveBoxes_0546_v1();
        System.out.println(v1.removeBoxes(t));
    }
}
