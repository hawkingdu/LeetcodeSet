package javacode.leetcodeTreeSet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javacode.entity.TreeNode;
import javacode.leetcodeUtil.TreeNodeUtil;

/**
 * Leetcode 94
 * Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {
	static List<Integer> nodeList = new ArrayList<Integer>();
	public static List<Integer> inorderTraversal(TreeNode<Integer> root) {
		if(root!=null){
			inorderTraversal(root.left);
			nodeList.add(root.val);
			inorderTraversal(root.right);
		} 
		return nodeList;
	}
	
	public static void main(String[] args) {
		Integer[] nums = {1,null,2,null,null,3};
		TreeNode<Integer> root =TreeNodeUtil.array2Tree(nums);
		System.out.println(inorderTraversal(root).toString());
	}

}
