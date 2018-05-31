package javacode.searchalgorithm;

/**
 * 
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4
 *
 */
public class SearchInRotatedSortedArray {

	/**
	 * 循环有序数组，必定是有一半为有序数组，所以每一次二分后至少有一个半仍然是有序数组
	 * 通过每次二分‘对折’把目标缩在一个有序数组里，再用正常二分法查找目标数字
	 * 
	 */
	public int search(int[] nums, int target) {
		int lo=0, hi=nums.length-1, mid;
		while(lo<=hi){
			mid = (lo+hi)/2;
			if(nums[mid] == target) return mid;
			// adjust if left array is ordered 
			if(nums[lo] <= nums[mid]){
				if(target<nums[mid] && target>=nums[lo]){
					hi = mid -1;
				} else {
					lo = mid + 1;
				}
			} else {
				if(target>nums[mid] && target<=nums[hi]){
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		SearchInRotatedSortedArray getResult = new SearchInRotatedSortedArray();
		int[] nums = {6,7,0,1,2,3,4,5};
		System.out.println(getResult.search(nums, 7));

	}

}
