package javacode.leetcodeTreeSet;

import javacode.entity.TreeNode;
import javacode.leetcodeUtil.TreeNodeUtil;

/**
 * @Author duhaojun
 * @Date 2022/6/21
 */
public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,null,null,4};
        TreeNode<Integer> integerTreeNode = TreeNodeUtil.array2Tree(nums);
        System.out.println(new MaximumDepthBinaryTree().maxDepth(integerTreeNode));
    }
}
