package leetcodeTreeSet;

import entity.TreeNode;
import leetcodeUtil.TreeNodeUtil;

public class ValidateBST {
	public static boolean isValidBST(TreeNode<Integer> root) {
		if(root==null) return true;
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	public static boolean isValidBST(TreeNode<Integer> root, long min, long max) {
		if(root==null) return true;
		if(root.val>min && root.val<max){
			return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
		}else{
			return false;
		}
    }
	public static int prev = Integer.MIN_VALUE;
	public static boolean isValidBSTInOrder(TreeNode<Integer> root){
		if(root==null)return true;
		if(isValidBSTInOrder(root.left) == false){
			return false;
		}
		if(prev>=root.val){
			return false;
		}
		prev = root.val;
		if(isValidBSTInOrder(root.right) == false){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] array = {3,1,5,0,2,4,6};
		TreeNode<Integer> tree = TreeNodeUtil.array2Tree(array);
		System.out.println(isValidBST(tree));
		System.out.println(isValidBSTInOrder(tree));
	}

}
