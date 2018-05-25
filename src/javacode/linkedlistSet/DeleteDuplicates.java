package javacode.linkedlistSet;

import javacode.entity.ListNode;

public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode newList = head;
		if (head==null || head.next==null) return head;
		while( head!=null && head.next!=null){
			if(head.val == head.next.val && head.next.next !=null){
				head.next.val = head.next.next.val;
				head.next.next = head.next.next.next;
			} else if (head.val == head.next.val) {
				head.next = null;
			} else {
				head = head.next;
			}
		}
        return newList;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
