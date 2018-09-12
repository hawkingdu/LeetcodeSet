package javacode.leetcodeTreeSet;

import javacode.entity.TreeNode;
import javacode.leetcodeUtil.TreeNodeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class BinaryTreeLeverOrderTraversal2{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        List<Integer> subList;
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int levelNums = queue.size();
            subList = new LinkedList<>();
            for (int i = 0; i < levelNums; i++) {
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null)queue.offer(queue.peek().right);
                subList.add((Integer)queue.poll().val);
            }
            result.addFirst(subList);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLeverOrderTraversal2 traversal = new BinaryTreeLeverOrderTraversal2();
        Integer[] nums = {1,2,3, null,4,null,null,null,null,5,6};
        TreeNode<Integer> root = TreeNodeUtil.array2Tree(nums);
        List<List<Integer>> result = traversal.levelOrderBottom(root);
        System.out.println(result);
    }
}
