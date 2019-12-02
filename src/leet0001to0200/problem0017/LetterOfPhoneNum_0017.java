package leet0001to0200.problem0017;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 * @date 2019-12-01 01:14
 **/
public class LetterOfPhoneNum_0017 {


    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        char[] arr = digits.toCharArray();
        char[][] phone = {{'a','b','c'},
                        {'d','e','f'},
                        {'g','h','i'},
                        {'j','k','l'},
                        {'m','n','o'},
                        {'p','q','r', 's'},
                        {'t','u','v'},
                        {'w','x','y', 'z'}
                        };
        dfs(0, "", phone, arr, arr.length, ans);
        return ans;
    }


    private void dfs(int index, String temp, char[][] phone, char[] arr, int len, ArrayList<String> ans) {
        if (index == len) {
            ans.add(temp);
            return;
        }
        char indexChar = arr[index];
        char[] letters = phone[indexChar - '2'];
        for (char item : letters) {
            dfs(index+1, temp + item, phone, arr, len, ans);
        }
    }

}
