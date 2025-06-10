package javacode.linkedlistSet;

import javacode.entity.ListNode;

/**
 * 141. Linked List Cycle
 *
 */
public class HasCycle {

	public static boolean hasCycle(ListNode head){
		if(head == null || head.next==null) return false;
		ListNode slow = head, fast = head;

		while(fast !=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
