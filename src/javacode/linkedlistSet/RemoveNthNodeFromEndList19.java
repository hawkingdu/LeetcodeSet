package javacode.linkedlistSet;

import javacode.entity.ListNode;
import javacode.leetcodeUtil.ListNodeUtil;

import java.util.*;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 */
public class RemoveNthNodeFromEndList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null){
            return null;
        } if (head.next==null){
            return null;
        }
        List<ListNode> list =new ArrayList<>();
        int i = 1;
        list.add(null);
        while (head !=null){
            ListNode node = head;
            head = head.next;
            node.next = null;
            list.add(node);
            i++;
        }
        int delIdx = i - n;
        int j = 0;
        ListNode temp = null;
        if (delIdx==1){
            temp = list.get(2);
            j=3;
        } else {
            temp = list.get(1);
            j=2;
        }
        ListNode newHead = temp;
        for (; j < list.size(); j++) {
            if (delIdx == j) {
                continue;
            }
            temp.next = list.get(j);
            temp = temp.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndList19 solution = new RemoveNthNodeFromEndList19();
        ListNode<Integer> head = ListNodeUtil.arrayToListNode(new Integer[]{1});
        ListNode node = solution.removeNthFromEnd(head, 1);
        ListNodeUtil.printListNode(node);
    }
}
