package javacode.leetcodeArraySet;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicates {
    /**
     * 快慢双指针解法
     *
     * 快指针正常往前移动
     * 如果值相等慢指针不动，直到遇到快慢不等时，慢指针跳过（减掉）相同值
     *
     */
    public int removeDuplicates(int[] nums) {
        int fast =0, slow =0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();

    }
}
