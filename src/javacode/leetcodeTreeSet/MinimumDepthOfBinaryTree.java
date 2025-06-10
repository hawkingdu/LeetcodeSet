package javacode.leetcodeTreeSet;

import javacode.entity.TreeNode;
import javacode.leetcodeUtil.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
//        if(root==null || root.val==null) {
//            return 0;
//        }
//        if(root.left==null || root.right==null)
//            return minDepth(root.left) + minDepth(root.right) + 1;
//        else {
//            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
//        }
        return minDepthWithBFS(root);
    }

    public int minDepthWithBFS(TreeNode root) {
        int depth =0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
            depth++;
        }
        while (!queue.isEmpty()){
            int levelNums = queue.size();
            for (int i = 0; i < levelNums; i++) {
                if(queue.peek()!=null) {
                    if(queue.peek().left==null && queue.peek().right==null) return depth;
                    if(queue.peek().left!=null && queue.peek().left.val!=null) queue.offer(queue.peek().left);
                    if(queue.peek().right!=null && queue.peek().right.val!=null) queue.offer(queue.peek().right);
                }
                queue.poll();
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree minDepth = new MinimumDepthOfBinaryTree();
//        Integer[] nums = {3,9,20,null,null,15,7};
        Integer[] nums = {1,2,null,4,null,null,null,8};
        TreeNode node = TreeNodeUtil.array2Tree(nums);
        System.out.println(minDepth.minDepth(node));
    }
}
