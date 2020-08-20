package leet0401to0600.problem0546;

import java.util.Arrays;

/**
 * 超出时间限制
 *
 * @author 王涵威
 * @date 2020/8/18 18:12
 */

public class RemoveBoxes_0546 {

    public int removeBoxes(int[] boxes) {
        return dfs(boxes, 0);
    }

    private int dfs(int[] boxes, int tmpRes) {
        int len = boxes.length;
        if (len == 0) {
            return tmpRes;
        }
        System.out.println(Arrays.toString(boxes));
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
        return res;
    }


    public static void main(String[] args) {
        int[] t = {1,3,2,2,2,3,4,3,1};
        RemoveBoxes_0546 removeBoxes0546 = new RemoveBoxes_0546();
        removeBoxes0546.removeBoxes(t);
    }
}
