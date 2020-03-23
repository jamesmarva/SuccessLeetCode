package leet0201to0400.problem0398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Brilliant James
 * @date 2020-03-19 14:30
 **/
public class RandomPickIndex_0398 {

    private Map<Integer, ArrayList<Integer>> map;
    private Random ran = new Random();

    public RandomPickIndex_0398(int[] nums) {
        map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; ++i) {
//            ArrayList<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
//            list.add(i);
//            map.put(nums[i], list);
            final int temp = i;
            map.compute(nums[i], (integer, list) -> {
                if (list == null) {
                    return new ArrayList<>(){{
                        add(temp);
                    }};
                } else {
                    list.add(temp);
                }
                return list;
            });
        }
    }

    /** Returns a random node's value. */
    public int pick(int target) {
        ArrayList<Integer> list = map.get(target);
        if (list == null) {
            throw new IllegalArgumentException(" target not exist;");
        }
        int size = list.size();
        return list.get(ran.nextInt(size));
    }
}
