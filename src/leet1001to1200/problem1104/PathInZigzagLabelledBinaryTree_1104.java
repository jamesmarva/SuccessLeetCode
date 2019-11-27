package leet1001to1200.problem1104;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author James
 * @date 2019-11-26 15:50
 **/
public class PathInZigzagLabelledBinaryTree_1104 {


    /**
     * 根据计算所得的数字
     * 如果没有“之”字型的排序，根据正确的私自
     *
     * min 1; max 1
     * min 2; max 3
     * min 4; max 7
     * min 8; max 15
     * min = min * 2;
     * max = max * 2 + 1;
     *         1
     *    2          3
     *  4   5     6     7
     * 8 9 10 11 12 13 14 15
     * label = max - (label / 2 - min);
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        int layer = 1;
        int min = 1;
        int max = 1;
        while (label > max) {
            min = min * 2;
            max = max * 2 + 1;
            layer++;
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(label);
        while (layer > 1) {
            min = min / 2;
            max = max / 2;
            label = max - (label / 2 - min);
            list.addFirst(label);
            layer--;
        }
        return list;
    }
}
