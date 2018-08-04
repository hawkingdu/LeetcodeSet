package javacode.linkedlistSet;

import javacode.entity.ListNode;
import javacode.leetcodeUtil.ListNodeUtil;

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
		ListNode<Integer> t1=head, t2=head.next;
		while(t1!=null && t2!=null){
			ListNode<Integer> tempNode = new ListNode<Integer>(t1.val);
			tempNode.next = t2.next;
			t1.val = t2.val;
			t1.next = tempNode;
			t1 = tempNode.next;
			if(t1!=null){
				t2 = t1.next;
			}
		}
        return head;
    }
	
	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5};
		SwapNodesinPairs swap = new SwapNodesinPairs();
		ListNode<Integer> list = ListNodeUtil.arrayToListNode(array);
		ListNodeUtil.printListNode(list);
		ListNode<Integer> newList = swap.swapPairs(list);
		ListNodeUtil.printListNode(newList);
		
	}

}
