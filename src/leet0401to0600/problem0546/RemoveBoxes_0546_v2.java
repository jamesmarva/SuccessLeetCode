package leet0401to0600.problem0546;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author 王涵威
 * @date 2020/8/18 19:15
 */
public class RemoveBoxes_0546_v2 {

    private Map<String, Integer> memory = new HashMap<>();

    public int removeBoxes(int[] boxes) {
        return dfs(boxes, 0);
    }

    private int dfs(int[] boxes, int tmpRes) {
        int len = boxes.length;
        if (len == 0) {
            return tmpRes;
        }
        String tmpBoxesStr = Arrays.toString(boxes);
        Integer val = memory.get(tmpBoxesStr);
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
            int tmpDfsVal = dfs(tmpBoxes, tmpRes + k * k);
            if (res < tmpDfsVal) {
                res = tmpDfsVal;
            }
        }
        memory.put(tmpBoxesStr, res);
        return res;
    }


    public static void main(String[] args) {
        int[] t = {1,3,2,2,2,3,4,3,1};
        RemoveBoxes_0546_v2 r = new RemoveBoxes_0546_v2();
        System.out.println("---------------------");
        System.out.println(r.removeBoxes(t));
    }
}
