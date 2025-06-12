package javacode.linkedlistSet;

import javacode.entity.ListNode;
import javacode.leetcodeUtil.ListNodeUtil;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates {

	/**
	 * 快慢双指针解法
	 *
	 * 快指针正常往前移动
	 * 如果值相等慢指针不动，直到遇到快慢不等时，慢指针跳过（减掉）相同值
	 *
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		while (fast != null) {
			//如果值相等慢指针不动
			if (fast.val != slow.val) { //直到遇到快慢不等时 慢指针跳过（减掉）相同值
				slow.next = fast;
				slow = slow.next;
			}
			fast = fast.next; //快指针正常往前移动
		}
		slow.next = null;

        return head;
    }
	
	public static void main(String[] args) {
		DeleteDuplicates dd = new DeleteDuplicates();
		ListNode<Integer> head = ListNodeUtil.arrayToListNode(new Integer[]{1, 1, 2});
		ListNodeUtil.printListNode(head);
		dd.deleteDuplicates(head);
		ListNodeUtil.printListNode(head);
	}

}
