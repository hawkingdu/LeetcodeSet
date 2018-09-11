package javacode.leetcodeTreeSet;

import javacode.entity.TreeNode;
import javacode.leetcodeUtil.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  101. Symmetric Tree
        * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
        *
        * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
        *     1
        *    / \
        *   2   2
        *  / \ / \
        * 3  4 4  3
        */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
//        if(root!=null && (root.left!=null || root.right!=null)) {
//            return isSymmetric(root.left, root.right);
//        }
//        return true;

        return isSymmetricWithQueue(root);
    }

    /**
     * recursive algorithm
     * Symmetrical conditions are left.left == right.right && left.right == right.left
     */
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null) {
                return true;
        } else {
            if(left ==null || right == null){
                return false;
            }
        }
        if(left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetricWithQueue(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        if(node!=null){
            if(node.left==null && node.right==null){
                return true;
            } else if(node.left != null && node.right!=null){
                queue.offer(node.right);
                queue.offer(node.left);
            } else
                return false;
        }
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null && right==null) continue;
            if(left==null || right==null) return false;
            if(left.val!=right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);

        }
        return true;
    }


    public static void main(String[] args) {
        SymmetricTree st =new SymmetricTree();
        Integer[] nums2 = {1,2,2};
        TreeNode<Integer> node = TreeNodeUtil.array2Tree(nums2);
        System.out.println(st.isSymmetric(node));
    }
}
