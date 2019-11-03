package leet1201to1400.problem1232;

/**
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-11-01 23:25
 **/
public class CheckIfItIsStraightLine1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length == 0 || coordinates[0].length == 0) {
            return false;
        }
        if (coordinates.length < 2) {
            return true;
        }
        int[] coordinate0 = coordinates[0];
        int[] coordinate1 = coordinates[1];
        for (int i = 2, len = coordinates.length; i < len; ++i) {
            if ( (coordinate1[1] - coordinate0[1]) * (coordinates[i][0] - coordinate0[0])
                    != (coordinates[i][1]- coordinate0[1]) * (coordinate1[0] - coordinate0[0])) {
                return false;
            }
        }
        return true;
    }
}
