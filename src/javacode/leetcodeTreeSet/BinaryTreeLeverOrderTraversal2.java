package javacode.leetcodeTreeSet;

import javacode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 107. Binary Tree Level Order Traversal II
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLeverOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode<Integer> root) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root.val);
        level.push(0);
        while (!level.isEmpty()){
            if(root.left!=null || root.right!=null){

            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
