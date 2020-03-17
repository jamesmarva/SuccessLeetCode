package gold;

/**
 * @author Brilliant James
 * @date 2020-03-16 07:53
 **/
public class Pro_01_06 {

    public String compressString(String S) {
        char[] arr = S.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0, len = arr.length; i < len;) {
            char temp = arr[i];
            int count = 0;
            while (i < len && temp == arr[i]) {
                count++;
                i++;
            }
            res.append(temp + count);
        }
        if (res.toString().length() > S.length()) {
            return S;
        } else {
            return res.toString();
        }
    }
}
