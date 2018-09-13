package javacode.leetcodeTreeSet;

import javacode.entity.TreeNode;
import javacode.leetcodeUtil.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *  102. Binary Tree Level Order Traversal
 *  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList;
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int levelNums = queue.size();
            subList = new ArrayList<>();
            for (int i = 0; i < levelNums; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null && node.left.val!=null) queue.offer(node.left);
                if(node.right!=null && node.right.val!=null) queue.offer(node.right);
                subList.add((Integer)node.val);
            }
            result.add(subList);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal levelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode<Integer> node = TreeNodeUtil.array2Tree(nums);
        System.out.println(levelOrderTraversal.levelOrder(node));
    }
}
