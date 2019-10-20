package leet.pro5081;

import java.util.*;

/**
 * @author James
 * @program SuccessLeetCode
 * @description
 * @date 2019-10-05 23:01
 **/
public class CountSteppingNumbers {

    public List<Integer> countSteppingNumbers(int low, int high) {
        if (low > high) {
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (low == 0) {
            ans.add(0);
        }
        int max = Integer.MAX_VALUE / 10;
        for (int i = 1; i <= 9; ++i){
            queue.add(i);
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                if (temp >= low && temp <= high) {
                    ans.add(temp);
                }
                if (temp > high || temp > max) {
                    continue;
                }
                int lastDigit = temp % 10;
                if (lastDigit == 0) {
                    queue.offer(temp * 10 + 1);
                } else if (lastDigit == 9) {
                    queue.offer(temp * 10 + 8);
                } else if (lastDigit > 0 && lastDigit < 9) {
                    queue.offer(temp * 10 + lastDigit - 1);
                    queue.offer(temp * 10 + lastDigit + 1);
                }

            }
        }
        Collections.sort(ans);
        return ans;

    }

    public List<Integer> countSteppingNumbersNew(int low, int high) {
        if (low > high) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        while (low <= high) {
            if (checkIsAdd(low)) {
               list.add(low);
                if (checkIsAdd(low + 2)) {
                    list.add(low + 2);
                    low = low + 20;
                }
            }
            low++;
        }
        return list;
    }

    private boolean checkIsAdd(int num) {
        String numString = num + "";
        char[] chars = numString.toCharArray();
        for (int i = 0, len = chars.length; i < len - 1; ++i) {
            if (Math.abs(chars[i] - chars[i + 1]) != 1) {
                return false;
            }
        }
        return true;
    }
}
