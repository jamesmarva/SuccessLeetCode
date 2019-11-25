package leet0001to0200.problem0160;

import utils.ListNode;

import java.util.HashSet;

/**
 * @author James
 * @date 2019-11-25 00:27
 **/
public class IntersectionOfTwoLinkedLists_0160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                break;
            }
            headB = headB.next;
        }
        return headB;
    }



    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode indexA = headA;
        ListNode indexB = headB;
        boolean endA = false;
        boolean endB = false;
        while (indexB != indexA) {
            if (indexA == null && !endA) {
                indexA = headB;
                endA = true;
            } else {
                indexA = indexA.next;
            }
            if (indexB == null && !endB) {
                indexB = headA;
                endB = true;
            } else {
                indexB = indexB.next;
            }
        }
        return indexA;
    }
}
