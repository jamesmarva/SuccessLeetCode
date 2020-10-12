package leet0601to0800.problem0679;

import javax.swing.plaf.InsetsUIResource;
import java.util.ArrayList;
import java.util.List;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-22 16:39
 **/
public class Game24_0679_v1 {

    private final static int TARGET = 24;

    private final static double PRECISION = 1e-6;

    private enum Op {
        add(0),
        multiplication(1),
        substract(2),
        divide(3);

        public final int val;
        Op(int val) {
            this.val = val;
        }
    }

    public boolean judgePoint24(int[] nums) {
        double[] doubles = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            doubles[i] = (double) nums[i];
        }
        return cal(doubles);
    }

    private boolean cal(double[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return Math.abs(nums[0] - TARGET) < PRECISION;
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    double[] tmpNums = new double[len - 1];
                    int index = 0;
                    for (int k = 0; k < len; k++) {
                        if (k != i && k != j) {
                            tmpNums[index++] = nums[k];
                        }
                    }
                    for (Op o : Op.values()) {
                        if (o.val < 2 && i > j) {
                            continue;
                        }
                        if (o == Op.add) {
                            tmpNums[index] = nums[i] + nums[j];
                        } else if (o == Op.multiplication) {
                            tmpNums[index] = nums[i] * nums[j];
                        } else if (o == Op.substract) {
                            tmpNums[index] = nums[i] - nums[j];
                        } else if (o == Op.divide) {
                            if (nums[j] < PRECISION) {
                                continue;
                            }
                            tmpNums[index] = nums[i] / nums[j];
                        }
                        if (cal(tmpNums)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
