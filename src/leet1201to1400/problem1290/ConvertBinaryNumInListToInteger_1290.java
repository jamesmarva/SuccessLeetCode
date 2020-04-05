package leet1201to1400.problem1290;

import utils.ListNode;

/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * @author Brilliant James
 * @date 2020-04-05 05:42
 **/
public class ConvertBinaryNumInListToInteger_1290 {

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int ans = 0;
        ListNode index = head;
        while (index != null) {
            if (index.val == 1) {
               ans |= 1;
            }
            index = index.next;
            if (index != null) {
                ans <<= 1;
            }
        }
        return ans;
    }
}
