package javacode.leetcodeTreeSet;

import javacode.entity.TreeNode;
import javacode.leetcodeUtil.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        if(root==null) return true;
        inOrderTraversal(root, list);
        for(int i=0, j=list.size()-1; i<=j; i++, j--){
            if(list.get(i)!=list.get(j)){
                return false;
            }
        }
        return true;
    }

    private void inOrderTraversal(TreeNode<Integer> node, List<Integer> result ){
        if (node.left!=null) {
            inOrderTraversal(node.left, result);
        }
            result.add(node.val);
        if (node.right!=null) {
            inOrderTraversal(node.right, result);
        }
    }

    public static void main(String[] args) {
        SymmetricTree st =new SymmetricTree();
        Integer[] nums2 = {1,2,3,3,null,2,null};
        TreeNode<Integer> node = TreeNodeUtil.array2Tree(nums2);
        List<Integer> result = new ArrayList<>();
        st.inOrderTraversal(node, result);
        System.out.println(result.toString());
        System.out.println(st.isSymmetric(node));
    }
}

class TreeNode2 {
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2(int x) { val = x; }
  }
