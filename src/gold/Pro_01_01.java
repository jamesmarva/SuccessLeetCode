package gold;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/is-unique-lcci/
 *
 * @author Brilliant James
 * @date 2020-03-16 08:19
 **/
public class Pro_01_01 {

    /**
     * 排序，时间复杂度
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        char[] arr = astr.toCharArray();
        Arrays.sort(arr);
        for (int i = 0, len = arr.length; i <= len - 2; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Hash 思想
     * @param astr
     * @return
     */
    public boolean isUnique_01(String astr) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = astr.toCharArray();
        for (char item : arr) {
            int value = map.getOrDefault(item, 0);
            if (value >= 1){
                return false;
            }
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return true;
    }


    public boolean isUnique_02(String str) {
        long pre = 0L;
        long suf = 0L;
        for (char c : str.toCharArray()) {
            if ((int) c >= 64) {
                long t = suf & (long) (1 << (c - 64));
                if (t != 0) {
                    return false;
                } else {
                    suf |= (1 << (c - 64));
                }
            } else {
                long t = pre & ((long) 1 << (c));
                if (t != 0) {
                    return false;
                } else {
                    pre |= 1 << c;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        IntStream.rangeClosed(0, 255).forEach(o -> {
//            System.out.println(o + ": " + ((char) o));
//        });
        Pro_01_01 p = new Pro_01_01();
        System.out.println(p.isUnique_02("leetcode"));
    }
}
