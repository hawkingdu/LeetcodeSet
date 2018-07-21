package javacode.searchalgorithm;

/**
 * 35. Search Insert Position
 *	Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *	Input: [1,3,5,6], 5
	Output: 2
	
	Input: [1,3,5,6], 2
	Output: 1
 */
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		if(target<nums[0])return 0;
		if(target>nums[nums.length-1]) return nums.length;
		int l=0, r=nums.length-1, mid;
		while( l<r ){
			mid = (l+r)/2;
			if(nums[mid] == target){
				return mid;
			} else if( nums[mid] > target ){
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		if(r==l) {
			return nums[l]<target?l+1:l-1;
		}else{
			return r + 1;
		}
    }
	public static void main(String[] args) {
		SearchInsertPosition p = new SearchInsertPosition();
		int[] nums = {1,3,5,7,8};
		System.out.println(p.searchInsert(nums, 8));

	}

}
