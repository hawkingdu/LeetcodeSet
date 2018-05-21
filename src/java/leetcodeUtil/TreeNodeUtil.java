package java.leetcodeUtil;

import java.entity.TreeNode;
import java.lang.reflect.Array;
import java.util.*;

public class TreeNodeUtil {

	public static <T> TreeNode<T> array2Tree(T[] array){
		if(array.length ==0) return null;
		List<TreeNode<T>> nodeList = new ArrayList<TreeNode<T>>();
		for(T t: array){
			nodeList.add(new TreeNode<T>(t));
		}
		if(nodeList.size()>1){
			for(int i=0; i<nodeList.size()/2-1; i++){
				nodeList.get(i).left = nodeList.get(i*2+1);
				nodeList.get(i).right = nodeList.get(i*2+2);
			}
			int lastIndex = nodeList.size()/2-1;
			nodeList.get(lastIndex).left = nodeList.get(lastIndex*2+1);
			if(nodeList.size()%2==1){
				nodeList.get(lastIndex).right = nodeList.get(lastIndex*2+2);
			}
		}  
		
		return nodeList.get(0);
	}
	
	public static <T> int treeNodesNumber(TreeNode<T> node){
		if( node == null ){
			return 0;
		}
		return treeNodesNumber(node.left) + treeNodesNumber(node.right) + 1;
	}
	
	public static <T> T[] tree2Array(TreeNode<T> root){
		int size = treeNodesNumber(root);
	    @SuppressWarnings("unchecked")
		T[] array = (T[])Array.newInstance(root.val.getClass(), size);
	    array2List(root, 0, array);
	    return array;
	}
	
	public static <T> void array2List(TreeNode<T> root, int deep, T[] BSTarray){
		if (root != null){
			BSTarray[deep] = root.val;
			array2List(root.left, deep*2+1, BSTarray);
			array2List(root.right, deep*2+2, BSTarray);
		}
	}
	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3,4,5};
		TreeNode<Integer> root = array2Tree(array);
		System.out.println(treeNodesNumber(root));
		for(Integer s : tree2Array(root)){
			System.out.println(s);
		}
	}

}
