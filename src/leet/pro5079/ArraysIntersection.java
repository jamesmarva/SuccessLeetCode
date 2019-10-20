package leet.pro5079;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-05 22:36
 **/
public class ArraysIntersection {


    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        if (arr1 == null || arr2 == null || arr3 == null || arr1.length == 0 || arr2.length == 0 || arr3.length == 0) {
            return null;
        }
        LinkedHashSet<Integer> arr1Set = new LinkedHashSet<>();
        for (int item : arr1) {
            arr1Set.add(item);
        }

        LinkedHashSet<Integer> arr2Set = new LinkedHashSet<>();
        for (int item : arr2) {
            if (arr1Set.contains(item)) {
                arr2Set.add(item);
            }
        }
        LinkedHashSet<Integer> arr3Set = new LinkedHashSet<>();
        for (int item : arr3) {
            if (arr2Set.contains(item)) {
                arr3Set.add(item);
            }
        }
        return new ArrayList<Integer>(arr3Set);
    }
}
