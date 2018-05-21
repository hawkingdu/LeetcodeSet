package java.linkedlistSet;

import java.entity.ListNode;

public class HasCycle {

	public static boolean hasCycle(ListNode head){
		if(head == null || head.next==null || head.next.next==null) return false;
		ListNode p1 = head;
		ListNode p2 = head.next.next;
		while(p1!=null && p2 !=null && p2.next !=null){
			if(p1==p2){
				return true;
			}
			p1 = p1.next;
			p2 = p2.next.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
