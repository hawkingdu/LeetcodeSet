package javacode.leetcodeTreeSet;

import javacode.entity.TreeNode;

/**
 * 2025/6/8 灵感来自 labuladong 的算法笔记
 * 解释二叉树前中后序遍历
 * 前中后遍历不是节点遍历的顺序，节点遍历顺序永远是先左后右，或先右后左
 * 前中后遍历是指插入逻辑的不同位置
 */
public class BinaryTreeTraversal {
    public void traverse(TreeNode node) {
        if (node == null) {
            //递归终止条件
            return;
        }
        //前序遍历逻辑
        traverse(node.left);
        //中序遍历逻辑
        traverse(node.right);
        //后序遍历逻辑

        /**
         * 前中后 插入位置的不同可以实现不同的功能，即探究前中后序遍历的意义
         */
    }
}
