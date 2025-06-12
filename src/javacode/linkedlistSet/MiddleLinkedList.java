package javacode.linkedlistSet;

import javacode.entity.ListNode;

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 * 2025/6/10
 *
 * 快慢指针
 * 快的走2步 慢的走1步
 * 快的走到终点时 慢的刚好一半
 */
public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        };
        return slow;
    }
}
