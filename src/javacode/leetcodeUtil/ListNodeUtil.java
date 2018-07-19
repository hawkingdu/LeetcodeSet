package javacode.leetcodeUtil;

import javacode.entity.ListNode;

public class ListNodeUtil {

	public static <T> ListNode<T> arrayToListNode(T[] array){
		if(array.length==0){
			return new ListNode<>();
		}
		ListNode<T> head = new ListNode<>();
		ListNode<T> tempNode = head;
		for(int i = 0; i<array.length; i++){
			tempNode.next = new ListNode<>(array[i]);
			tempNode = tempNode.next;
		}
		
		return head.next;
	}
	public static void main(String[] args) {
		Integer[] nums = {1,2,3};
		ListNode<Integer> head = arrayToListNode(nums);
		while(head!=null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("");
	}
}
