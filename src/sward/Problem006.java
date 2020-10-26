package sward;

import utils.ListNode;

import java.util.Stack;

/**
 *
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author Brilliant James
 * @date 2020-03-07 01:46
 **/
public class Problem006 {


    /**
     * 栈的思想
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index] = stack.pop();
            index++;
        }
        return res;
    }
}
