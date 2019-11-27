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
     * 马拉车算法 还没对
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

    /**
     * 动态规划思想
     * @param s
     * @return
     */
    public String longestPalindrome_1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] newArr = new StringBuilder(s).reverse().toString().toCharArray();
        char[] oldArr = s.toCharArray();
        int maxLen = 0;
        int endPosition = 0;
        for (int i = 0; i < len; ++i) {
            if (oldArr[i] == newArr[0]) {
                dp[i][0] = 1;
                maxLen = 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (oldArr[0] == newArr[i]) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < len; ++i) {
            for (int j = 1; j < len; j++) {
                if (oldArr[i] == newArr[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (maxLen < dp[i][j]) {
                    int before = len - 1 -j;
                    int oldI = before + dp[i][j] - 1;
                    if (oldI == i) {
                        maxLen = dp[i][j];
                        endPosition = i;
                    }
                }
            }
        }
        return s.substring(endPosition - maxLen + 1, endPosition + 1);
    }

    /**
     * 三种情况不能直接用镜像的结果
     *
     * 1. 超出了 R
     * 2. P [ i_mirror ] 遇到了原字符串的左边界
     * 3. i 等于了 R
     * @param s
     * @return
     */
    public String longestPalindrome_2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int center = 0;
        int rightSide = 0;
        String dealS = dealString(s);
        char[] newChars = dealS.toCharArray();
        int len = newChars.length;
        int[] maxLenArr = new int[len];
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            boolean needCalculate = true;
            int mirrorValue = 0;
            if (rightSide > i) {
                int mirrorIndex = center - (i - center);
                mirrorValue = maxLenArr[mirrorIndex];

                // 如果超过了右边界，进行调整
                if(i + mirrorValue > rightSide) {
                    mirrorValue = rightSide - i;
                }
                // 如果根据已知条件计算得出的最长回文小于右边界，则不需要扩展了
                if(i + mirrorValue < rightSide) {
                    // 直接推出结论
                    maxLenArr[i] = mirrorValue;
                }
            }

            if (needCalculate) {
                int newMirrorValue = mirrorValue;
                while(i - 1 - newMirrorValue >= 0 && i + 1 + newMirrorValue < len) {
                    if(newChars[i + 1 + newMirrorValue] == newChars[i - 1 - newMirrorValue]) {
                        newMirrorValue++;
                    } else {
                        break;
                    }
                }
                // 更新右边界及中心
                rightSide = i + newMirrorValue;
                center = i;
                if (maxLen < newMirrorValue) {
                    maxLen = newMirrorValue;
                    start = (i - maxLen) / 2;
                }
                maxLenArr[i] = newMirrorValue;
            }
        }
        return s.substring(start, start + maxLen);
    }



    /**
     * 三种情况不能直接用镜像的结果
     * 1. 超出了 R
     * 2. P[i_mirror] 遇到了原字符串的左边界
     * 3. i 等于了 R
     */
    public String longestPalindrome_3(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int center = 0;
        int rightSide = 0;
        String dealS = dealString(s);
        char[] newChars = dealS.toCharArray();
        int len = newChars.length;
        int[] maxLenArr = new int[len];
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            boolean needCalculate = false;
            int mirrorValue= 0;
            if (i >= rightSide) {
                needCalculate = true;
            }
            if (!needCalculate) {
                // 计算相对rightSideCenter的对称位置
                int mirrorIndex = center - (i - center);
                mirrorValue = maxLenArr[mirrorIndex];
                if (mirrorIndex - mirrorValue == 0 || i + mirrorValue > rightSide) {
                    needCalculate =true;
                    mirrorValue= rightSide - i;
                // 如果根据已知条件计算得出的最长回文小于右边界，则不需要扩展了
                } else {
                    maxLenArr[i] = mirrorValue;
                }
            }

            if (needCalculate) {
                int newMirrorValue = mirrorValue;
                while(i - 1 - newMirrorValue >= 0 && i + 1 + newMirrorValue < len) {
                    if(newChars[i + 1 + newMirrorValue] == newChars[i - 1 - newMirrorValue]) {
                        newMirrorValue++;
                    } else {
                        break;
                    }
                }
                // 更新右边界及中心
                rightSide = i + newMirrorValue;
                center = i;
                if (maxLen < newMirrorValue) {
                    maxLen = newMirrorValue;
                    start = (i - maxLen) / 2;
                }
                maxLenArr[i] = newMirrorValue;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
//        String test =
//        String[] testStrArr = new String[] {
//                "abcdcef",
//                "adaelele",
//                "cabadabae",
//                "aaaabcdefgfedcbaa",
//                "aaba",
//                "aaaaaaaaa"
//        };
//        LongestPalindromicSubstring_0005 longestPalindromicSubstring_0005 = new LongestPalindromicSubstring_0005();
//        for (String item : testStrArr) {
//            String test = longestPalindromicSubstring_0005.findLongestPalindromeString(item);
//            System.out.println(test);
//        }
//        System.out.println("abcdefg".substring(1, 4));
        String test = "bananas";
        LongestPalindromicSubstring_0005 longestPalindromicSubstring_0005 = new LongestPalindromicSubstring_0005();
        String test1 = longestPalindromicSubstring_0005.longestPalindrome_3(test);
        System.out.println(test1);
//        System.co
    }

}
