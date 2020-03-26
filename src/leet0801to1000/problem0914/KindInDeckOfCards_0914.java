package leet0801to1000.problem0914;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brilliant James
 * @date 2020-03-27 03:03
 **/
public class KindInDeckOfCards_0914 {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
//        ArrayList<Integer> list = new ArrayList<>(map.keySet());
//        int ans = map.get(list.get(0));
//        for (int i = 1, size = list.size(); i < size; i++) {
//            int temp = map.get(list.get(i));
//            if (ans > temp){
//                ans = gcd(ans, temp);
//            } else {
//                ans = gcd(temp, ans);
//            }
//        }

        int count = 0;
        int ans = 0;
        for (Integer i : map.keySet()) {
            if (count == 0) {
                ans = map.get(i);
                count++;
            } else {
                int temp = map.get(i);
                if (ans > temp){
                    ans = gcd(ans, temp);
                } else {
                    ans = gcd(temp, ans);
                }
            }
        }
        return ans >= 2;

    }
    private int gcd(int big, int small) {
        while (small != 0) {
            int temp = big % small;
            big = small;
            small = temp;
        }
        return big;
    }

    public static void main(String[] args) {
        int big = 10;
        int small = 8;

        while (small != 0) {
            int temp = big % small;
            big = small;
            small = temp;
        }
        System.out.println(big);
    }
}
