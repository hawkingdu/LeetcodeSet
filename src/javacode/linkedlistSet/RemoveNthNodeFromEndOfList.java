package javacode.linkedlistSet;

import javacode.entity.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode p1 = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p2 = new ListNode();
        p2 = dummy;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rnn = new RemoveNthNodeFromEndOfList();

        ListNode node2 = new ListNode();
        node2.val = new Integer(2);
        ListNode head = new ListNode();
        head.val = new Integer(1);
        head.next = node2;
        ListNode listNode = rnn.removeNthFromEnd(head, 1);
        System.out.println(listNode.toString());
    }
}
