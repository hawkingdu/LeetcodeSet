package leetcodeTreeSet;

import entity.TreeNode;
import leetcodeUtil.TreeNodeUtil;

public class ValidateBST {
	public static boolean isValidBST(TreeNode<Integer> root) {
		boolean left=true, right=true;
		if(root!=null){
			if(root.left.val<root.val){
				left = isValidBST(root.left, root.val);
			} else {
				left = false;
			}
			if(root.right.val>root.val){
				right = isValidBST(root.right, root.val);
			} else {
				right = false;
			}
			return left && right ;
		} else {
			return true;
		}
        
    }
	public static boolean isValidBST(TreeNode<Integer> root, int rootVal) {
		boolean left=true, right=true;
		
		if(root.left!=null){
			if(root.left.val<root.val && root.val<rootVal){
				left = isValidBST(root.left, rootVal);
			} else {
                left = false;
            }			 
		}
		if(root.right!=null){
			if(root.right.val>root.val && root.val>rootVal){
				right = isValidBST(root.right, rootVal);
			} else {
                right = false;
            }
		}
        return left && right;
    }
	public static void main(String[] args) {
		Integer[] array = {3,1,5,0,2,4,6};
		TreeNode<Integer> tree = TreeNodeUtil.array2Tree(array);
		System.out.println(isValidBST(tree));
	}

}
