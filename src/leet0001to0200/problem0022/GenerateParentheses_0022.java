package leet0001to0200.problem0022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brilliant James
 * @date 2020-04-09 03:36
 **/
public class GenerateParentheses_0022 {

    private ArrayList<String> ans = new ArrayList<>();

    private int len = 0;

    public List<String> generateParenthesis(int n) {
        len = 2 * n;
        dfs("", 0, n);
        return ans;
    }

    private void dfs(String temp, int numInLeft, int remain) {
        if (temp.length() == len) {
            ans.add(temp);
            return;
        }
        if (numInLeft == 0 && remain > 0) {
            dfs(temp + "(", 1, remain - 1);
        } else if (numInLeft > 0) {
            if (remain > 0) {
                dfs(temp + "(", numInLeft + 1, remain - 1);
            }
            dfs(temp + ")", numInLeft - 1, remain);
        }
    }


}
