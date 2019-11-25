package leet0601to0800.problem0707;

/**
 * @author James
 * @date 2019-11-24 00:56
 **/
public class MyLinkedList {

    private Node dummy;

    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        dummy = new Node(-1);
    }

    /** Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node ans = findNodeByIndex(index);
        return ans.next.value;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        size++;
        Node node = new Node(val, dummy.next);
        dummy.next = node;
    }

    /** Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        size ++;
        Node cursor = dummy;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = new Node(val);
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        size++;
        Node cursor = findNodeByIndex(index);
        Node node = new Node(val, cursor.next);
        cursor.next = node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        if (dummy.next == null) {
            return;
        }
        Node cursor = findNodeByIndex(index);
        Node deleted = cursor.next;
        if (deleted.next != null) {
            cursor.next = deleted.next;
            deleted.next = null;
        } else {
            cursor.next = null;
        }
        size--;
    }

    private Node findNodeByIndex(int index) {
        Node cursor = dummy;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }


    class Node {
        int value;
        Node next;

        public Node(int val) {
            this.value = val;
            this.next = null;
        }

        public Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */