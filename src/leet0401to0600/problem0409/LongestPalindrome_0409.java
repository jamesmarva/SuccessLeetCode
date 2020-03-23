package leet0401to0600.problem0409;

/**
 * @author Brilliant James
 * @date 2020-03-19 03:44
 **/
public class LongestPalindrome_0409 {

    public int longestPalindrome(String s) {
        char[] arr =  s.toCharArray();
        int[] map = new int[128];
        for (char item : arr) {
           if ('a' <= item && item <= 'z') {
               map[item - 'a']++;
           }
           if ('A' <= item && item <='Z') {
                map[item - 'A' + 26] ++;
           }
        }
        int sum = 0;
        boolean addOne = false;
        for (int item : map) {
            if (item % 2 == 0) {
                sum += item;
            } else {
                addOne = true;
                sum += (item - 1);
            }
        }
        if (addOne) {
            return sum + 1;
        } else {
            return sum;
        }
    }
}
