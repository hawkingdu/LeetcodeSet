package entity;

public class TreeNode<T> {
	public T value;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T value) {
		super();
		this.value = value;
	}

	public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
}
