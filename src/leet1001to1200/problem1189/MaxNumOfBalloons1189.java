package leet1001to1200.problem1189;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-04 23:59
 **/
public class MaxNumOfBalloons1189 {

    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        int[] charsNum = new int[26];
        char[] textChar = text.toLowerCase().toCharArray();;
        for (char item : textChar) {
            charsNum[item - 'a'] += 1;
        }
        int ans = Integer.MAX_VALUE;
        for (char item : "balloon".toCharArray()) {
            if (item == 'l' || item == 'o') {
                ans = Math.min(ans, charsNum[item - 'a'] / 2);
            } else {
                ans = Math.min(ans, charsNum[item - 'a']);
            }

        }
        return ans;
    }
}
