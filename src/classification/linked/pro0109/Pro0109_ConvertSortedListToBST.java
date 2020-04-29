package classification.linked.pro0109;

import utils.ListNode;
import utils.TreeNode;

import java.util.HashMap;

/**
 * @author Brilliant James
 * @date 2020-04-25 06:53
 **/
public class Pro0109_ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = dummy;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);

        ListNode after = slow.next;
        slow.next = null;
        pre.next = null;

        root.left = sortedListToBST(dummy.next);
        root.right = sortedListToBST(after);
        return root;
    }

    public TreeNode dfs(ListNode l) {
        if (l.next != null) {
            return null;
        }

        ListNode fast = l.next;
        ListNode slow = l;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        ListNode after = slow.next;
        slow.next = null;
        root.left = dfs(l);
        root.right = dfs(after);
        return root;
    }


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
//        S
//        int num = 50 ;
//        num = num++ * 2 ;
//        System.out.println(num) ;
//        System.out.println(num) ;
//        long num = 100L ;
//        long x = num + 2 ; // 二者相加，会转化为更大的那个值。
//        System.out.println(x) ;
        float f = 100.0f;
        double d = 2.0;
        double ff = d + f;
        int num = 68 ;
        char c = (char) num ;
        System.out.println(c) ;
        boolean flag = 10%2 == 1 && 10 / 3 == 0 && 1 / 0 == 0 ;
        System.out.println(flag ? "mldn" : "yootk") ;
    }
}
