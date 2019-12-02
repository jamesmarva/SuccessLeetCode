package leet0001to0200.problem0010;

/**
 * @author James
 * @date 2019-12-01 01:50
 **/
public class RegularExpressionMatching_0010 {

    public static void main(String[] args) {
        String s =  "";
        String p = ".*";
        RegularExpressionMatching_0010 rr = new RegularExpressionMatching_0010();
        rr.isMatch(s, p);
    }
    private int pLen = 0;
    private int sLen = 0;
    private boolean ans = false;
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        sLen = sChars.length;
        pLen = pChars.length;
        dfs(0, 0, sChars, pChars);
        return ans;
    }

    private void dfs(int sIndex, int pIndex, char[] sChars, char[] pChars ) {
        if (ans) {
            return;
        }
        if (pIndex >= pLen) {
            if (sIndex >= sLen) {
                ans = true;
            }
            return;
        }
        boolean isMatched = sIndex < sLen && (pChars[pIndex] == '.' || sChars[sIndex] == pChars[pIndex]);
        if (pIndex + 1 < pLen && pChars[pIndex + 1] == '*') {
            dfs(sIndex, pIndex+2, sChars, pChars);
            if (isMatched) {
                dfs(sIndex + 1, pIndex, sChars, pChars);
            }
        } else if (isMatched){
            dfs(sIndex+1, pIndex+1, sChars, pChars);
        }
    }

    public boolean isMatch1(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch1(text, pattern.substring(2)) ||
                    (first_match && isMatch1(text.substring(1), pattern)));
        } else {
            return first_match && isMatch1(text.substring(1), pattern.substring(1));
        }
    }


}
