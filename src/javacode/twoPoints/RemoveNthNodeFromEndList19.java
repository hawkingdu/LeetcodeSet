package javacode.twoPoints;

import javacode.entity.ListNode;
import javacode.leetcodeUtil.ListNodeUtil;

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
    /**
     * 快慢指针法
     * 1. 右指针先向后移n+1个节点
     * 2. 左右指针同时后移
     * 3. 当右指针=null 时，左指针的下一个节点即为删除节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(); // 记录头结点
        dummy.next = head;
        ListNode  right=head;
        while (n > 0){
            //1. 右指针先向后移n+1个节点
            right = right.next;
            n--;
        }
        if (right ==null){
            return head.next;
        }
        right = right.next;
        while (right != null) {
            //2. 左右指针同时后移
            head = head.next;
            right = right.next;
        }
        //3. 当右指针=null 时，左指针的下一个节点即为删除节点
        head.next = head.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndList19 solution = new RemoveNthNodeFromEndList19();
        ListNode<Integer> head = ListNodeUtil.arrayToListNode(new Integer[]{1,2,3,4});
        ListNode node = solution.removeNthFromEnd(head, 3);
        ListNodeUtil.printListNode(node);
    }
}
