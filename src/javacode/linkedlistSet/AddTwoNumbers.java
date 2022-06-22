package javacode.linkedlistSet;

import java.awt.List;
import java.lang.reflect.Array;

import javacode.entity.ListNode;
import javacode.leetcodeUtil.ListNodeUtil;

public class AddTwoNumbers {
	
	public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
		ListNode head = new ListNode();
		ListNode result = head;
		int carryBit = 0;
		while (l1!=null && l2!=null){
			ListNode node = new ListNode();
			int i = (l1.val + l2.val + carryBit) % 10;
			carryBit = (l1.val + l2.val + carryBit) / 10;
			node.val = i;
			l1 = l1.next;
			l2 = l2.next;
			head.next = node;
			head = head.next;
		}
		while (l1 != null) {
			ListNode node = new ListNode();
			int i = (l1.val + carryBit) % 10;
			carryBit = (l1.val + carryBit) / 10;
			node.val = i;
			l1 = l1.next;
			head.next = node;
			head = head.next;
		}
		while (l2 != null) {
			ListNode node = new ListNode();
			int i = (l2.val + carryBit) % 10;
			carryBit = (l2.val + carryBit) / 10;
			node.val = i;
			l2 = l2.next;
			head.next = node;
			head = head.next;
		}
		if (carryBit>0){
			ListNode node = new ListNode();
			node.val = carryBit;
			head.next = node;
		}

        return result.next;
    }
	public static void main(String[] args) {
		AddTwoNumbers addtwo = new AddTwoNumbers();
		Integer[] n1 = {9,9};
		Integer[] n2 = {9,9};
		ListNode<Integer> l1 = ListNodeUtil.arrayToListNode(n1);
		ListNode<Integer> l2 = ListNodeUtil.arrayToListNode(n2);
		ListNode<Integer> head = addtwo.addTwoNumbers(l1, l2);
		ListNodeUtil.printListNode(head);
	}

}
