package javacode.linkedlistSet;

import java.awt.List;
import java.lang.reflect.Array;

import javacode.entity.ListNode;
import javacode.leetcodeUtil.ListNodeUtil;

public class AddTwoNumbers {
	
	public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
		
		long base = 1;
		long result = 0;
		while(l1!=null && l2!=null){
			result += (l1.val+l2.val) * base;
			base *= 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1!=null){
			result += l1.val * base;
			base *= 10;
			l1 = l1.next;
		}
		while(l2!=null){
			result += l2.val * base;
			base *= 10;
			l2 = l2.next;
		}
		ListNode<Integer> head = new ListNode<>();
		ListNode<Integer> temp = head;
		if(result ==0) return new ListNode<>(0);
		while(result>0){
			temp.next = new ListNode<>((int)result%10);
			temp = temp.next;
			result /= 10;
		}
        return head.next;
    }
	public static void main(String[] args) {
		AddTwoNumbers addtwo = new AddTwoNumbers();
		Integer[] n1 = {9};
		Integer[] n2 = {1,9,9,9,9,9,9,9,9,9};
		ListNode<Integer> l1 = ListNodeUtil.arrayToListNode(n1);
		ListNode<Integer> l2 = ListNodeUtil.arrayToListNode(n2);
		ListNode<Integer> head = addtwo.addTwoNumbers(l1, l2);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
