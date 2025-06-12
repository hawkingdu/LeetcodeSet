package javacode.entity;

public class ListNode<T> {
	public T val;
	public ListNode<T> next;
	
	public ListNode(){
		
	}
	public ListNode(T val) {
		this.val = val;
	}

	@Override
	public String toString() {
		ListNode head = this;
		String s = null;
		while(head!=null){
			s = head.val +"->";
			head = head.next;
		}
		return "Linked List: " + s;
	}
}
