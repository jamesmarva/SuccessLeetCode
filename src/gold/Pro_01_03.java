package gold;

import java.util.Properties;

/**
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2021-05-23 01:12
 **/
public class Pro_01_03 {

    public String replaceSpaces(String s, int length) {
        if (s == null) {
            return "";
        }
        char[] arr = s.toCharArray();
        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char t = arr[i];
            if (t == ' ') {
                rst.append("%20");
            } else {
                rst.append(t);
            }
        }
        return rst.toString();
    }


    public String replaceSpaces_0(String s, int length) {
        if (s == null) {
            return "";
        }
        char[] arr = s.toCharArray();
        int idx = arr.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            char c = arr[i];
            if (c == ' ') {
                arr[idx] = '0';
                arr[idx - 1] = '2';
                arr[idx - 2] = '%';
                idx -= 3;
            } else {
                arr[idx] = c;
                idx--;
            }
        }
        return new String(arr, idx + 1, arr.length - 1 - idx);
    }



    public static void main(String[] args) {
//        String s = "Mr John Smith    ";
//        int len = 13;

        String s = "ds sdfs afs sdfa dfssf asdf             ";
        int l = 27;
        System.out.println(s.substring(0, 27));
        Pro_01_03 p = new Pro_01_03();
        System.out.println(p.replaceSpaces_0(s, l));
//        System.out.println(s.length());
    }
}
