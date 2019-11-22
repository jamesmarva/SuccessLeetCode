package leet0201to0400.problem0380;

import java.util.HashMap;
import java.util.Random;

/**
 *
 *
 * @author James
 * @date 2019-11-16 09:17
 **/
public class RandomizedSet_0380 {


    private HashMap<Integer, Integer> indexValue;

    private HashMap<Integer, Integer> valueIndex;

    private int size;

    private Random random;

    /**
     *
     * 两个HashMap
     * 关于复杂度
     * 1.1 时间复杂度为 O(1)
     * 1.2 空间负责度为 O(n)
     *
     *
     * 2.1 使用两个 HashMap（一个为 index-value，一个为 value-index）以及一个整数计数器count
     * 2.2 插入功能就是传统的插入到两个 HashMap 中
     *
     * 2.3 删除功能
     * 2.3.1 获取传入数所在索引
     * 2.3.2 用数组中最后一个值覆盖2.3.1上索引上的值
     * 2.3.3 移除最后一个元素以及更新计数器
     *
     * 作者：cartoon
     * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1/solution/dan-ge-hashsetmei-wan-quan-fu-he-ti-yi-yi-ji-liang/
     * 来源：力扣（LeetCode）
     *
     */
    public RandomizedSet_0380() {
        indexValue = new HashMap<>();
        valueIndex = new HashMap<>();
        size = 0;
        random = new Random();
    }

    /**
     *
     */
    public boolean insert(int val) {
        //
        if (valueIndex.containsKey(val)) {
            return false;
        }

        valueIndex.put(val, size);
        indexValue.put(size, val);
        size++;
        return true;
    }

    /**
     * 2.3 删除功能
     * 2.3.1 获取传入数所在索引
     * 2.3.2 用数组中最后一个值覆盖2.3.1上索引上的值
     * 2.3.3 移除最后一个元素以及更新计数器
     */
    public boolean remove(int val) {
        Integer idx = valueIndex.remove(val);
        if (idx == null) {
            return false;
        }
        indexValue.remove(idx);
        if (idx != size - 1) {
            int lastValue = indexValue.remove(size - 1);
            indexValue.put(idx, lastValue);
            valueIndex.put(lastValue, idx);
        }
        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (valueIndex.isEmpty()) {
            return 0;
        }
        int randomIndex = random.nextInt(size);
        return indexValue.get(randomIndex);
    }
}
