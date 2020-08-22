package leet0601to0800.problem0679;

import java.util.ArrayList;
import java.util.List;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-22 16:12
 **/
public class Game24_0679_v0_back {

    private final static int TARGET = 24;

    private final static double PRECISION = 1e-6;

    private enum Op {
        add(0),
        multiplication(1),
        substract(2),
        divide(3);
        public final int val;
        private Op(int val) {
            this.val = val;
        }
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return cal(list);
    }

    private boolean cal(List<Double> list) {
        if (list.isEmpty()) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < PRECISION;
        }
        for (int i = 0, len = list.size(); i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    List<Double> tmpList = new ArrayList<>();
                    for (int k = 0; k < len; k++) {
                        if (k != i && k != j) {
                            tmpList.add(list.get(k));
                        }
                    }

                    for (Op item : Op.values()) {
                        if (item.val < 2 && i > j) {
                            continue;
                        }
                        if (item == Op.add) {
                            tmpList.add(list.get(i) + list.get(j));
                        } else if (item == Op.multiplication) {
                            tmpList.add(list.get(i) * list.get(j));
                        } else if (item == Op.substract) {
                            tmpList.add(list.get(i) - list.get(j));
                        } else if (item == Op.divide) {
                            if (list.get(j) < PRECISION) {
                                continue;
                            }
                            tmpList.add(list.get(i) / list.get(j));
                        }
                        if (cal(tmpList)) {
                            return true;
                        }
                        tmpList.remove(tmpList.size() - 1);
                    }
                }
            }
        }
        return false;
    }

}
