package leet0601to0800.problem0679;

import gold.Pro_08_11;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/24-game/
 *
 * 679. 24 点游戏
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-08-22 12:11
 **/
public class Game24_0679_v0 {

    private int TARGET = 24;

    private final double PRECISION = 1e-6;

    private enum Operator{
        add(0),
        multiply(1),
        subtract(2),
        divide(3);

        public final int val;

        Operator(int val) {
            this.val = val;
        }
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
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
        for (int i = 0, l = list.size(); i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i != j) {
                    List<Double> tmpList = new ArrayList<>();
                    for (int k = 0; k < l; k++) {
                        if (k != i && k != j) {
                            tmpList.add(list.get(k));
                        }
                    }

                    // 遍历+ - * / 四种操作
                    for (Operator item : Operator.values()) {
                        if (item.val < 2 && i > j) {
                            continue;
                        }
                        if (item == Operator.add) {
                            tmpList.add(list.get(i) + list.get(j));
                        } else if (item == Operator.multiply) {
                            tmpList.add(list.get(i) * list.get(j));
                        } else if (item == Operator.subtract) {
                            tmpList.add(list.get(i) - list.get(j));
                        } else if (item == Operator.divide) {
                            // 判断 list.get(j) 是否小于 0
                            if (Math.abs(list.get(j)) < PRECISION) {
                                continue;
                            } else {
                                tmpList.add(list.get(i) / list.get(j));
                            }
                        }
                        // 在当前的操作的情况下，继续进行下一步的遍历
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


    public static void main(String[] args) {
        int[] t = {4,1,8,7};
        Game24_0679_v0 v0 = new Game24_0679_v0();
        System.out.println(v0.judgePoint24(t));
    }


}
