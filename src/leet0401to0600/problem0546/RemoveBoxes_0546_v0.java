package leet0401to0600.problem0546;

/**
 * 超出时间限制
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-19 00:01
 **/
public class RemoveBoxes_0546_v0 {

    public int removeBoxes(int[] boxes) {
        return dfs(boxes, 0);
    }


    private int dfs(int[] boxes, int tmpRes) {
        int len = boxes.length;
        if (len == 0) {
            return tmpRes;
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
        return res;
    }

}
