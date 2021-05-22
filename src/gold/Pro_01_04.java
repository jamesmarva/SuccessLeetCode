package gold;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 * @author Brilliant James
 * @date 2020-03-16 08:03
 **/
public class Pro_01_04 {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char item : arr) {
            if (dic.get(item) == null || dic.get(item) == 0) {
                dic.put(item, 1);
            } else {
                dic.put(item, 0);
            }
        }
        int res = 0;
        for (Integer item : dic.values()) {
            res += item;
            if (res > 1) {
                return false;
            }
        }
        return true;
    }
}
