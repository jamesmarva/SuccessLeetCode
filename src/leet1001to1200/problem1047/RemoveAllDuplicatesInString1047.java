package leet1001to1200.problem1047;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author James
 * @program SuccessLeetCode
 * @description https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * @date 2019-10-09 21:18
 **/
public class RemoveAllDuplicatesInString1047 {

    /**
     *  Accept
     */
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        char[] sChars = S.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (char item : sChars) {
            if (list.isEmpty() || !list.getLast().equals(item)) {
                list.add(item);
            } else if (list.getLast() == item) {
                list.removeLast();
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character item : list) {
            ans.append(item+"");
        }
        return ans.toString();
    }

    /**
     *  Accept
     * 这个简直了，最优的空间复杂度是答案的复杂度，然后这个时间复杂度依然是O（n）级别的。
     */
    public String removeDuplicatesBest(String S) {
        char[] arr = S.toCharArray();
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (len != 0 && arr[i] == arr[len - 1]) {
                len--;
            } else {
                arr[len++] = arr[i];
            }
        }
        char[] result = Arrays.copyOf(arr, len);
        return new String(result);
    }

    public static void main(String[] args) {
        Character[] test = {'1'};
        Character test1 = new Character('A');
        char test2 = 'A';
        System.out.println(test1 == test2);
        System.out.println(test1.equals(test2));

//        String test1 = new String(test);
        System.out.println(test[0] == '1');
    }
}
