package javacode.linkedlistSet;

import javacode.entity.ListNode;
import javacode.leetcodeUtil.ListNodeUtil;

import java.util.*;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 *
 	Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

	/**
	 * 空间复杂度+1
	 * @param head
	 * @return
	 */
	public static ListNode<Integer> reverseList(ListNode<Integer> head) {
		ListNode<Integer> newHead = new ListNode<>();
		ListNode<Integer> temp = newHead;
		List<Integer> list = new ArrayList<>();
		while(head != null){
			list.add(head.val);
			head = head.next;
		}
		int index = list.size()-1;
		while(index>=0){
			ListNode<Integer> node = new ListNode<>(list.get(index));
			temp.next = node;
			temp = temp.next;
			index--;
		}
        return newHead.next;
    }

	/**
	 * 空间复杂度优于上面那一种
	 *
	 * @param input
	 * @return
	 */
	public static ListNode<Integer> reverse(ListNode<Integer> input) {
		// 新链表头
		ListNode<Integer> newHead = null;
		// 旧链表头
		ListNode<Integer> oldHead = input;
		if (input != null) {
			if (input.next != null) {
				while (oldHead != null) {
					ListNode node = oldHead; //遍历的当前节点
					oldHead = oldHead.next; // 旧链表头后移
					node.next = newHead; // 当前节点指向新链表头
					newHead = node; // 当前节点作为新链表头
				}
				return newHead;
			} else {
				return input;
			}
		} else {
			return null;
		}
	}
	public static void main(String[] args) {
		Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
		ListNode<Integer> node = ListNodeUtil.arrayToListNode(nums);
		ListNodeUtil.printListNode(node);
		ListNodeUtil.printListNode(reverse(node));
	}
	
}

