package sward;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Brilliant James
 * @date 2020-03-31 03:03
 **/
public class Problem_052 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
