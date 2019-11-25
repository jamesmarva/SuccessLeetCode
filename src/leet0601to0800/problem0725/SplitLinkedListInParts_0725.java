package leet0601to0800.problem0725;

import utils.ListNode;

/**
 * @author James
 * @date 2019-11-23 23:41
 **/
public class SplitLinkedListInParts_0725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        if (root  == null) {
            return ans;
        }
        if (root.next == null) {
            ans[0] = root;
            return ans;
        }
        ListNode index = root;
        int count = 0;
        while (index != null) {
            index = index.next;
            count++;
        }
        int leave = count % k;
        int basis = count / k;
        ListNode pre = root;
        for (int i = 0; i < k; ++i) {
            ans[i] = pre;
            int newBasis = basis;
            if (leave > 0) {
                newBasis ++;
                leave--;
            }
            if (pre != null) {
                while (pre != null && newBasis > 1) {
                    pre = pre.next;
                    newBasis--;
                }
                if (pre != null) {
                    ListNode temp = pre.next;
                    pre.next = null;
                    pre = temp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        ListNode root = new ListNode(1);
//        root.next = new ListNode(2);
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        for (int i = 1; i < 11; i++) {
            index.next = new ListNode(i);
            index = index.next;
        }
        System.out.println(index.val);
        SplitLinkedListInParts_0725 splitLinkedListInParts_0725 = new SplitLinkedListInParts_0725();
        splitLinkedListInParts_0725.splitListToParts(dummy.next, 3);

    }
}
