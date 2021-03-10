package javacode.searchalgorithm;

/**
 * 
 * 二分法查找
 * 
 *	EASY BUT IMPORTANT
 */
public class BinarySearchInSortArray {

    /**
     * 循环算法
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 递归
     * @param nums
     * @param target
     * @param begin
     * @param end
     * @return
     */
	public int searchInArray(int[] nums, int target, int begin, int end){
	    if(nums==null || nums.length==0 ) return -1;
        if (begin > end) {
            return -1;
        } else {
            int middle = (begin + end) / 2;
            if(target <nums[middle] ){
                return searchInArray(nums, target, begin, middle-1);
            } else if (target > nums[middle]) {
                return searchInArray(nums, target, middle+1, end);
            } else {
                return middle;
            }
        }
    }
	public static void main(String[] args) {
		BinarySearchInSortArray getResult = new BinarySearchInSortArray();
		int[] nums = {1,2,3,4};
		int target = -1;
		System.out.println(getResult.searchInArray(nums, target));
        System.out.println(getResult.searchInArray(nums,target, 0, nums.length-1));

	}

}
