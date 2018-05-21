package java.leetcodeArraySet;

public class MergeSortedArray {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n){
		int index1 = m-1, index2 = n-1, totalIndex = m+n-1;
		while( index1>=0 && index2>=0 ){
			nums1[totalIndex--] = (nums1[index1]>=nums2[index2]) ? nums1[index1--] : nums2[index2--];
		}
		while(index2>=0){
			nums1[totalIndex--] = nums2[index2--];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
