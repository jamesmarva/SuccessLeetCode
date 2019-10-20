package leet.problem5205;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-07 14:32
 **/
public class UniNumOfOccurrences5205 {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int item : arr) {
            hashMap.put(item, hashMap.getOrDefault(item, 0) + 1);
        }
        for (Integer item : hashMap.values()) {
            if (!set.add(item)){
                return false;
            }
        }
        return true;
    }

}
