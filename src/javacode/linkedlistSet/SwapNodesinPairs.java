package javacode.linkedlistSet;

import javacode.entity.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *Note:
	Your algorithm should use only constant extra space.
	You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesinPairs {

	public ListNode<Integer> swapPairs(ListNode<Integer> head) {
		if(head==null || head.next ==null) return head;
		ListNode<Integer> temp = null;
		if(head.next.next==null){
			temp = head.next;
			head.next =null;
			return temp;
		}
		ListNode<Integer> temp1 = head, temp2 = head.next;
		while(temp2!=null){
			temp = temp2.next;
			temp2.next = temp1;
			temp1.next = temp;
			temp1 = temp;
			temp2 = temp.next;
		}
        return head.next;
    }
	
	public static void main(String[] args) {
	}

}
