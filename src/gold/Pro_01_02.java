package gold;

/**
 *
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 *
 * 面试题 01.02. 判定是否互为字符重排
 * @author Brilliant James
 * @date 2020-03-19 16:02
 **/
public class Pro_01_02 {

    public boolean CheckPermutation(String s1, String s2) {
        int [] arr = new int[128];
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (int i = 0, len = arr1.length; i < len; ++i) {
            arr[arr1[i]]++;
            arr[arr2[i]]--;
        }
        for (int item : arr) {
            if (item != 0) {
                return false;
            }
        }
        return true;
    }
}

