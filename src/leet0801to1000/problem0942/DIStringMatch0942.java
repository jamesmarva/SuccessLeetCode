package leet0801to1000.problem0942;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/di-string-match/
 * @author: James
 * @create: 2019-09-13 03:16
 **/
public class DIStringMatch0942 {

    public int[] diStringMatch(String S) {
        char[] array = S.toCharArray();
        int length = array.length;
        int[] result = new int[length + 1];
        List<Character> iChars = new ArrayList<>();
        List<Character> dChars = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char temp = array[i];
            if (temp == 'I') {
                result[i] = iChars.size();
                iChars.add(temp);
            }

            if (temp == 'D') {
                result[i] = length - dChars.size();
                dChars.add(temp);
            }
        }

        char last = array[length - 1];
        if (last == 'I') {
            result[length] = iChars.size();
        }

        if (last == 'D') {
            result[length] = length - dChars.size();
        }

        return result;
    }
}
