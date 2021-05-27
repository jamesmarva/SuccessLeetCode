package mine.kmp;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 21.5.27 15:45
 */
public class KMP {


    public int[][] getDfa(String pat) {
        int l = pat.length();
        int[][] dfa = new int[l][256];
        int preState = 0;
        for (int state = 0; state < l; state++) {
            for (int i = 0; i < 256; i++) {
                dfa[state][i] = dfa[preState][i];
            }
            dfa[state][pat.charAt(state)] = state + 1;
            preState = dfa[preState][pat.charAt(state)];
        }
        return dfa;
    }


    public int indexOf(String src, String pat) {
        int[][] dfa = getDfa(pat);
        int j = 0, srcLen = src.length(), patLen = pat.length();
        int i = 0;
        for (; i < srcLen && j < patLen; i++) {
            j = dfa[j][src.charAt(i)];
        }
        if (j == patLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        KMP k = new KMP();
        System.out.println(k.indexOf("abcabcabc", "bc"));
    }



}
