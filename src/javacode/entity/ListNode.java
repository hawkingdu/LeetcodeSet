package javacode.entity;

public class ListNode<T> {
	public T val;
	public ListNode<T> next;
	
	public ListNode(){
		
	}
	public ListNode(T val) {
		this.val = val;
	}
}
