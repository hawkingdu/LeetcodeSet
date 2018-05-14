package entity;

public class TreeNode<T> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T value) {
		super();
		this.val = value;
	}

	public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
		super();
		this.val = value;
		this.left = left;
		this.right = right;
	}
	
}
