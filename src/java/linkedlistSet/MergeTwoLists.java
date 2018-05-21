package java.linkedlistSet;

import java.entity.ListNode;

public class MergeTwoLists {

	public static ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2){
		if(l1==null && l2==null) return null;
		ListNode newList = new ListNode(0);
		ListNode head = newList;
		while( l1!=null && l2!=null ){
			if( l1.val <= l2.val){
				newList.val = l1.val;
				l1 = l1.next;
			} else {
				newList.val = l2.val;
				l2 = l2.next;
			}
			if(l1!=null || l2!=null){
				newList.next = new ListNode(0);
				newList = newList.next;
			}
		}
		while (l1!= null){
			newList.val = l1.val;
			l1 = l1.next;
			if(l1!=null){
				newList.next = new ListNode(0);
				newList = newList.next;
			}
		}
		while (l2!= null){
			newList.val = l2.val;
			l2 = l2.next;
			if(l2!=null){
				newList.next = new ListNode(0);
				newList = newList.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
