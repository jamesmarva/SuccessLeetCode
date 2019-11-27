package leet0001to0200.problem0005;

import java.util.Arrays;

/**
 * @author James
 * @date 2019-11-27 01:28
 **/
public class LongestPalindromicSubstring_0005 {

    public String longestPalindrome(String s) {
        char[] oldChars = s.toCharArray();
        int oldLen = oldChars.length;
        int newLen = oldLen * 2 + 1;
        char[] newChars = new char[oldLen * 2 + 1];
        getNewChars(oldChars, newChars);
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < newLen; i++) {
            int currentMaxLen = getMaxLen(newChars, i, newLen);
            if (currentMaxLen > maxLen) {
                maxLen = currentMaxLen;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int getMaxLen(char[] arr, int index, int len) {
        int ans = 0;
        int leftIndex = index - ans;
        int rightIndex = index + ans;
        while (leftIndex >= 0 && rightIndex < len && arr[leftIndex] == arr[rightIndex]) {
            ans++;
            leftIndex = index - ans;
            rightIndex = index + ans;
        }
        return ans;
    }


    /**
     * 马拉车算法
     */
    public String findLongestPalindromeString(String s) {

        String str = dealString(s);
        char[] strChars = str.toCharArray();
        int len = str.length();
        // 右边界的记录值
        int rightSide = 0;

        int rightSideCenter =0;

        int[] halfLenArr = new int[len];

        int center = 0;

        int longestHalf = 0;

        for (int i = 0; i < len; i++) {
            boolean needCalc = true;
            if (rightSide > i) {

                int leftCenter = 2 * rightSideCenter - i;

                halfLenArr[i] = halfLenArr[leftCenter];

                if (i + halfLenArr[i] > rightSide) {
                    halfLenArr[i] = rightSide -i;
                }

                if (i + halfLenArr[leftCenter] < rightSide) {
                    needCalc = false;
                }
            }

            if (needCalc) {
                while (i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < len) {
                    if (strChars[i + 1 + halfLenArr[i]] == strChars[i - 1 + halfLenArr[i]]) {
                        halfLenArr[i]++;
                    } else {
                        break;
                    }
                }

                rightSide = i + halfLenArr[i];
                rightSideCenter = i;

                if (halfLenArr[i] > longestHalf) {
                    center = i;
                    longestHalf = halfLenArr[i];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
            sb.append(strChars[i]);
        }
        return sb.toString();
    }


    private String dealString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        int len = s.length();
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    private void getNewChars(char[] src, char[] dest) {
        int len = src.length;
        Arrays.fill(dest, '#');
        for (int i = 0; i < len; i++) {
            dest[2 * i + 1] = src[i];
        }
    }

    public static void main(String[] args) {
//        String test =
        String[] testStrArr = new String[] {
                "abcdcef",
                "adaelele",
                "cabadabae",
                "aaaabcdefgfedcbaa",
                "aaba",
                "aaaaaaaaa"
        };
        LongestPalindromicSubstring_0005 longestPalindromicSubstring_0005 = new LongestPalindromicSubstring_0005();
        for (String item : testStrArr) {
            String test = longestPalindromicSubstring_0005.findLongestPalindromeString(item);
            System.out.println(test);
        }


//        System.co
    }

}
