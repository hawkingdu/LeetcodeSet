package javacode.linkedlistSet;

import javacode.entity.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoLists {

	public static ListNode mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2){
		ListNode<Integer> dummy = new ListNode<>(), p = dummy; //虚拟头节点 利于处理
		ListNode<Integer> p1 = list1, p2 = list2; //双指针
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				dummy.next = p2;
				p2 = p2.next;
			}
			dummy = dummy.next;
		}
		while (p1 != null) {
			dummy.next=p1;
			p1 = p1.next;
			dummy = dummy.next;
		}
		while (p2 != null) {
			dummy.next=p2;
			p2 = p2.next;
			dummy = dummy.next;
		}
		return p.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
