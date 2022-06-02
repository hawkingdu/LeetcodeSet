package javacode.linkedlistSet;

import javacode.entity.ListNode;
import javacode.leetcodeUtil.ListNodeUtil;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Linked List Cycle II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @Date 2022/5/31
 */
public class LinkedListCycle2 {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head.next!=null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
