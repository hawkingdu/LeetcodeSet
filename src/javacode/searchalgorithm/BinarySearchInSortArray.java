package javacode.searchalgorithm;

/**
 * 
 * 
 * 
 *	EASY BUT IMPORTANT
 */
public class BinarySearchInSortArray {

	public int searchInArray(int[] nums, int target){
		int lo=0, hi=nums.length-1, mid;
		while(hi>=lo){
			mid = (lo+hi)/2;
			if(target == nums[mid]){
				return mid;
			} else if(target > nums[mid]){
				lo = mid+1;
			} else {
				hi = mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		BinarySearchInSortArray getResult = new BinarySearchInSortArray();
		int[] nums = {1};
		System.out.println(getResult.searchInArray(nums, 1));

	}

}
