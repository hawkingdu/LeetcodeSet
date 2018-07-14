package javacode.linkedlistSet;

import javacode.entity.ListNode;
import java.util.*;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 *
 	Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

	public ListNode<Integer> reverseList(ListNode<Integer> head) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
